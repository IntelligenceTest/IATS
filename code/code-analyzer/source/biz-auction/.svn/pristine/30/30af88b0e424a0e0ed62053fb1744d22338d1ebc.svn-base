package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AuctionServiceTrackMapper;
import com.autostreets.biz.auction.model.AuctionServiceTrack;
import com.autostreets.biz.auction.model.AuctionServiceTrackExample;
import com.autostreets.biz.auction.service.AuctionServiceTrackService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("auctionServiceTrackService")
public class AuctionServiceTrackServiceImpl extends
        GenericServiceImpl<AuctionServiceTrack, AuctionServiceTrackExample, Integer> implements
        AuctionServiceTrackService {

    @Autowired
    private AuctionServiceTrackMapper auctionServiceTrackMapper;

    @Override
    protected GenericMapper<AuctionServiceTrack, AuctionServiceTrackExample, Integer> getGenericMapper() {
        return auctionServiceTrackMapper;
    }

    @Override
    public List<AuctionServiceTrack> selectByAuctionVehicleId(Integer auctionVehicleId) {
        AuctionServiceTrackExample example = new AuctionServiceTrackExample();
        example.createCriteria().andAuctionVehicleIdEqualTo(auctionVehicleId);
        return selectByExample(example);
    }

}
