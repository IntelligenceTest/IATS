package com.autostreets.biz.auction.service;

import com.autostreets.biz.auction.model.UsedcarShopExt;
import com.autostreets.biz.auction.model.UsedcarShopExtExample;
import com.autostreets.framework.common.dal.GenericService;

public interface UsedcarShopExtService extends GenericService<UsedcarShopExt, UsedcarShopExtExample, Integer> {

    /**
     * 根据shopId查询
     * 
     * @param shopId
     * @return
     * @Date: 2015年3月24日 上午10:52:04
     * @author haoju.li
     */
    UsedcarShopExt getByShopId(Integer shopId);

    /**
     * 判断信息是否改变
     * 
     * @param usedBannerPicUrl
     * @param usedBannerTemplateName
     * @param usedBannerLinkUrl
     * @param usedcarShopExt
     * @return
     * @Date: 2015年4月22日 下午4:30:45
     * @author haoju.li
     */
    boolean isChanged(String usedBannerPicUrl, String usedBannerTemplateName, String usedBannerLinkUrl,
            UsedcarShopExt usedcarShopExt);

    /**
     * 从服务器上删除照片
     * 
     * @param id
     * @param orgSid
     * @param picUrl
     * @return
     * @Date: 2015年4月22日 下午4:34:01
     * @author haoju.li
     */
    boolean deleteShopPic(Integer id, Integer orgSid, String picUrl);
}
