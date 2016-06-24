package com.autostreets.biz.auction.service.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.pagination.Pagination1;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.HomepageRecommendService;
import com.autostreets.biz.auction.test.BaseDubboTest;
import com.google.common.collect.Maps;

public class serviceTest extends BaseDubboTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(serviceTest.class);

    @Autowired
    private HomepageRecommendService homepageRecommendService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Test
    public void selectRecommendUsedcar() {
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", 0);
        params.put("limit", 4);
        List<Vehicle> recomdList = homepageRecommendService.selectRecommendUsedcar(params);
        String json = JSON.toJSONString(recomdList);
        LOGGER.info(json);
    }

    @Test
    public void selectOnlinePage() {
        Pagination1<AuctionVehicle> page = auctionVehicleService.selectOnlinePage(null, 0, null, null, true, null,
                null, 1, 10);
        String json = JSON.toJSONString(page);
        LOGGER.info(json);
    }
}
