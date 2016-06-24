package com.autostreets.biz.auction.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.mapper.AuctionDictionaryMapper;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionDictionaryExample;
import com.autostreets.biz.auction.model.base.BaseAuctionDictionaryExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.cache.CacheService;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.utils.DFSUtils;
import com.google.common.base.Strings;

@Service("auctionDictionaryService")
public class AuctionDictionaryServiceImpl extends
        GenericServiceImpl<AuctionDictionary, AuctionDictionaryExample, Integer>implements AuctionDictionaryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionDictionaryServiceImpl.class);

    @Autowired
    private AuctionDictionaryMapper auctionDictionaryMapper;

    @Autowired
    private CacheService cacheService;

    @Override
    protected AuctionDictionaryMapper getGenericMapper() {
        return auctionDictionaryMapper;
    }

    @Override
    public List<AuctionDictionary> selectResource(String category) {
        return selectResourceOrderBy(category, null);
    }

    @Override
    public String getValueByCategoryName(String category, String name) {
        AuctionDictionaryExample dictionaryExample = new AuctionDictionaryExample();
        AuctionDictionaryExample.Criteria criteria = dictionaryExample.createCriteria();
        criteria.andCategoryEqualTo(category);
        criteria.andNameEqualTo(name);
        List<AuctionDictionary> dicList = auctionDictionaryMapper.selectByExample(dictionaryExample);
        if (dicList == null || dicList.size() == 0) {
            return null;
        }
        return dicList.get(0).getValue();
    }

    @Override
    public String getNameByCategoryValue(String category, String value) {
        if (category == null || value == null) {
            return "";
        }
        AuctionDictionaryExample example = new AuctionDictionaryExample();
        AuctionDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        criteria.andValueEqualTo(value);
        List<AuctionDictionary> dicList = auctionDictionaryMapper.selectByExample(example);
        if (dicList == null || dicList.size() == 0) {
            return null;
        }
        return dicList.get(0).getName();
    }

    @Override
    public String selectNoHagglePreprice() {
        List<AuctionDictionary> preList = selectResourceOrderBy("nohaggle_pre_price", null);
        String retVal = "0";
        try {
            if (preList != null && preList.size() > 0) {
                retVal = preList.get(0).getValue();
            } else {
                retVal = "0";
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            retVal = "0";
        }
        return retVal;
    }

    @Override
    public String selectPopSwitch() {
        List<AuctionDictionary> popList = selectResourceOrderBy("pop_on", null);
        if ((popList != null) && (popList.size() > 0)) {
            return popList.get(0).getValue();
        }
        return "";
    }

    /**
     * order为null则默认排序，否则降序
     * 
     * @Title: selectResourceOrderBy
     * @Description: 排序加载字典数据
     * @param category
     *            类型
     * @param order
     *            排序方式
     * @return List<Dictionary>
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年9月28日 下午3:34:39
     */
    @Override
    public List<AuctionDictionary> selectResourceOrderBy(String category, String order) {
        AuctionDictionaryExample ex = new AuctionDictionaryExample();
        ex.createCriteria().andCategoryEqualTo(category).andDelFlagEqualTo(false);
        String orderBy = "item_order";

        if (org.apache.commons.lang.StringUtils.isNotBlank(order))
            orderBy += " desc";

        ex.setOrderByClause(orderBy);
        String cacheKey = "auct_" + category;
        Object obj = cacheService.get(cacheKey);
        if (obj == null) {
            List<AuctionDictionary> auctionDictionaries = this.auctionDictionaryMapper.selectByExample(ex);
            cacheService.set(cacheKey, JSON.toJSONString(auctionDictionaries), new Date(365 * 24 * 60 * 60 * 1000));
            return auctionDictionaries;
        }
        return JSON.parseArray(obj.toString(), AuctionDictionary.class);
    }

    @Override
    public List<AuctionDictionary> selectCommissionFeeRange() {
        return this.selectResource("commission_fee_range");
    }

    @Override
    public String choiceImgUrl(String spec, String urlColValue) {
        return DFSUtils.choiceImgUrl(spec, urlColValue);
    }

    @Override
    // @Cacheable(value="defaultCache#86400", key="'online_'")
    public Integer selectPriceDiff() {
        List<AuctionDictionary> priceList = selectResourceOrderBy("online_price_diff", null);
        Integer retVal = 0;
        try {
            if ((priceList != null) && (priceList.size() > 0)) {
                retVal = Integer.parseInt(priceList.get(0).getValue());
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            retVal = 0;
        }
        return retVal;
    }

    @Override
    public Integer selectTimeDiff() {
        List<AuctionDictionary> priceList = selectResourceOrderBy("online_time_diff", null);
        Integer retVal = 0;
        try {
            if ((priceList != null) && (priceList.size() > 0)) {
                retVal = Integer.parseInt(priceList.get(0).getValue());
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            retVal = 0;
        }
        return retVal;
    }

    @Override
    public List<String> getInsidersAccount() {
        // 内部人员账号
        List<AuctionDictionary> dics = selectResourceOrderBy("auction_insider", null);
        List<String> insiders = new ArrayList<>();

        if (!CollectionUtils.isEmpty(dics)) {
            LOGGER.info("***************内部人员顶价账号" + dics.size() + "个******************");
            String value;
            for (AuctionDictionary d : dics) {
                value = d.getValue();
                if (org.apache.commons.lang.StringUtils.isNotBlank(value))
                    insiders.add(value);
            }
        }
        return insiders;
    }

    @Override
    public Integer selectStatusChangeTime_R() {
        List<AuctionDictionary> priceList = this.selectResource("online_deadtime");
        Integer retVal = 0;
        try {
            retVal = Integer.parseInt(priceList.get(0).getValue());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            retVal = 0;
        }
        return retVal;
    }

    @Override
    public Integer selectStatusChangeTime_NR() {
        List<AuctionDictionary> priceList = this.selectResource("online_NR_deadtime");
        Integer retVal = 0;
        try {
            retVal = Integer.parseInt(priceList.get(0).getValue());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            retVal = 0;
        }
        return retVal;
    }

    @Override
    public Integer selectPayTime() {
        List<AuctionDictionary> timeList = this.selectResource("nohaggle_paytime");
        Integer retVal = 0;
        try {
            retVal = Integer.parseInt(timeList.get(0).getValue());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            retVal = 0;
        }
        return retVal;
    }

    @Override
    public Map<String, String> selectAssessmentStatusByCustomerList() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("0", "待联系");
        map.put("1", "待再联系");
        map.put("2", "已处理");
        map.put("3", "已分派门店");
        map.put("4", "待评估");
        map.put("5", "已评估");
        return map;
    }

    @Override
    public List<AuctionDictionary> selectAuctionType() {
        return this.selectResource("auction_type");
    }

    @Override
    public List<AuctionDictionary> selectStatusOfAuction() {
        return this.selectResource("auction_vehicle_status");
    }

    @Override
    public List<AuctionDictionary> selectAuctionModel() {
        return this.selectResource("auction_model");
    }

    @Override
    public Integer selectDealerOnlinePlusRange() {
        List<AuctionDictionary> auctionDictionaries = this.selectResource("dealer_online_plus_range");
        if (auctionDictionaries != null && auctionDictionaries.size() > 0) {
            return Integer.parseInt(auctionDictionaries.get(0).getValue());
        }
        return null;
    }

    @Override
    public Pagination selectDictionaryByPage(Pagination pagination, AuctionDictionary auctionDictionary) {
        AuctionDictionaryExample ex = new AuctionDictionaryExample();
        BaseAuctionDictionaryExample.Criteria criteria = ex.createCriteria();
        if (!Strings.isNullOrEmpty(auctionDictionary.getName())) {
            criteria.andNameLike("%" + auctionDictionary.getName() + "%");
        }
        if (!Strings.isNullOrEmpty(auctionDictionary.getCategory())) {
            criteria.andCategoryLike("%" + auctionDictionary.getCategory() + "%");
        }
        if (!Strings.isNullOrEmpty(auctionDictionary.getCategoryDesc())) {
            criteria.andCategoryDescLike("%" + auctionDictionary.getCategoryDesc() + "%");
        }
        criteria.andDelFlagEqualTo(false);
        // 计算总数
        int count = auctionDictionaryMapper.countByExample(ex);
        pagination.setCount(count);
        // 查询分页数据
        ex.setPagination(pagination);
        ex.setOrderByClause(" modify_time desc ");
        List<AuctionDictionary> list = auctionDictionaryMapper.selectByExample(ex);
        pagination.setDataList(list);
        return pagination;
    }
}