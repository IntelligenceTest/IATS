package com.autostreets.biz.auction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AuctionVehicleLogMapper;
import com.autostreets.biz.auction.model.AuctionVehicleLog;
import com.autostreets.biz.auction.model.AuctionVehicleLogExample;
import com.autostreets.biz.auction.service.AuctionVehicleLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("auctionVehicleLogService")
public class AuctionVehicleLogServiceImpl extends GenericServiceImpl<AuctionVehicleLog, AuctionVehicleLogExample, Integer>
        implements AuctionVehicleLogService {

    @Autowired
    private AuctionVehicleLogMapper auctionVehicleLogMapper;

    @Override
    protected GenericMapper<AuctionVehicleLog, AuctionVehicleLogExample, Integer> getGenericMapper() {
        return auctionVehicleLogMapper;
    }
}
