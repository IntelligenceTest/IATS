package com.autostreets.biz.auction.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.UsedcarShopExtMapper;
import com.autostreets.biz.auction.model.UsedcarShopExt;
import com.autostreets.biz.auction.model.UsedcarShopExtExample;
import com.autostreets.biz.auction.model.base.BaseUsedcarShopExtExample.Criteria;
import com.autostreets.biz.auction.service.UsedcarShopExtService;
import com.autostreets.biz.common.service.DfsService;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("usedcarShopExtService")
public class UsedcarShopExtServiceImpl extends GenericServiceImpl<UsedcarShopExt, UsedcarShopExtExample, Integer>
        implements UsedcarShopExtService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UsedcarShopExtServiceImpl.class);

    @Autowired
    private UsedcarShopExtMapper usedcarShopExtMapper;

    @Autowired
    private DfsService dfsService;

    @Override
    protected UsedcarShopExtMapper getGenericMapper() {
        return usedcarShopExtMapper;
    }

    @Override
    public UsedcarShopExt getByShopId(Integer shopId) {
        return usedcarShopExtMapper.getByShopId(shopId);
    }

    @Override
    public boolean isChanged(String usedBannerPicUrl, String usedBannerTemplateName, String usedBannerLinkUrl,
            UsedcarShopExt usedcarShopExt) {
        if (!(StringUtils.isBlank(usedBannerPicUrl) && StringUtils.isBlank(usedcarShopExt.getBannerPicUrl()))) {
            if (!StringUtils.equals(usedBannerPicUrl, usedcarShopExt.getBannerPicUrl())) {
                return true;
            }
        }
        if (!(StringUtils.isBlank(usedBannerTemplateName) && StringUtils
                .isBlank(usedcarShopExt.getBannerTemplateName()))) {
            if (!StringUtils.equals(usedBannerTemplateName, usedcarShopExt.getBannerTemplateName())) {
                return true;
            }
        }
        if (!(StringUtils.isBlank(usedBannerLinkUrl) && StringUtils.isBlank(usedcarShopExt.getBannerLinkUrl()))) {
            if (!StringUtils.equals(usedBannerLinkUrl, usedcarShopExt.getBannerLinkUrl())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteShopPic(Integer id, Integer orgSid, String picUrl) {
        UsedcarShopExtExample usedcarShopExtExample = new UsedcarShopExtExample();
        Criteria criteria = usedcarShopExtExample.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andOrgSidEqualTo(orgSid);
        List<UsedcarShopExt> usedcarShopExts = usedcarShopExtMapper.selectByExample(usedcarShopExtExample);
        if (null == usedcarShopExts || usedcarShopExts.size() == 0) {
            return true;
        }
        removeShopPicOnDfs(usedcarShopExts, picUrl);
        return true;
    }

    private void removeShopPicOnDfs(List<UsedcarShopExt> usedcarShopExtsr, String picUrl) {
        if (usedcarShopExtsr != null && usedcarShopExtsr.size() == 1) {
            List<String> allImgUrl = new ArrayList<String>();
            List<String> picUrlList = Arrays.asList(picUrl);
            String bannerPicUrl = usedcarShopExtsr.get(0).getBannerPicUrl();
            if (!picUrlList.contains(bannerPicUrl)) {
                allImgUrl.add(bannerPicUrl);
            }
            removeImagesOnDfs(allImgUrl);
        }
    }

    private void removeImagesOnDfs(List<String> srcFileIds) {
        List<String> allImgUrl = new ArrayList<String>();
        for (String src : srcFileIds) {
            String[] imgUrls = src.split(",");
            for (String imgUrl : imgUrls) {
                allImgUrl.add(imgUrl.substring(imgUrl.indexOf("_") + 1).trim());
            }
        }
        try {
            dfsService.dropFile(allImgUrl);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}