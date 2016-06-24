package com.autostreets.biz.auction.service;

import java.math.BigDecimal;

import com.autostreets.biz.auction.model.MemberVehicleBatch;
import com.autostreets.biz.auction.model.MemberVehicleBatchExample;
import com.autostreets.framework.common.dal.GenericService;

public interface MemberVehicleBatchService extends
        GenericService<MemberVehicleBatch, MemberVehicleBatchExample, Integer> {

    public int checkBidedByVehicleAndUser(String userId, Integer vehicleSid);

    public BigDecimal getMaxBidPriceByAV(Integer avId);

    public BigDecimal getMaxBidPriceByAVandUser(Integer avId, String userId);
}
