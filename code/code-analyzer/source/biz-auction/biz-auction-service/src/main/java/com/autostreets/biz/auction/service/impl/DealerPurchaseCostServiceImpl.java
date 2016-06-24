package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerPurchaseCostMapper;
import com.autostreets.biz.auction.model.DealerPurchaseCost;
import com.autostreets.biz.auction.model.DealerPurchaseCostExample;
import com.autostreets.biz.auction.model.base.BaseDealerPurchaseCostExample.Criteria;
import com.autostreets.biz.auction.service.DealerPurchaseCostService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("dealerPurchaseCostService")
public class DealerPurchaseCostServiceImpl extends
        GenericServiceImpl<DealerPurchaseCost, DealerPurchaseCostExample, Integer>implements DealerPurchaseCostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealerPurchaseCostServiceImpl.class);

    @Autowired
    private DealerPurchaseCostMapper dealerPurchaseCostMapper;

    @Override
    protected GenericMapper<DealerPurchaseCost, DealerPurchaseCostExample, Integer> getGenericMapper() {
        return dealerPurchaseCostMapper;
    }

    @Override
    public List<DealerPurchaseCost> selectFeeByPurchasId(Integer purchasId) {
        DealerPurchaseCostExample example = new DealerPurchaseCostExample();
        Criteria criteria = example.createCriteria();

        if (purchasId != null) {
            criteria.andPurchaseIdEqualTo(purchasId);
        }
        criteria.andDelFlagEqualTo(false);
        List<DealerPurchaseCost> cost = dealerPurchaseCostMapper.selectByExample(example);
        if (cost.size() > 0) {
            return cost;
        }
        return null;

    }
}
