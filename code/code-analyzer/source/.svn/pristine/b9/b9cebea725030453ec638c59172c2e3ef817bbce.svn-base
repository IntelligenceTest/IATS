package com.autostreets.biz.auction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.OnlineAuctionLogMapper;
import com.autostreets.biz.auction.model.OnlineAuctionLog;
import com.autostreets.biz.auction.model.OnlineAuctionLogExample;
import com.autostreets.biz.auction.service.OnlineAuctionLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("onlineAuctionLogService")
public class OnlineAuctionLogServiceImpl extends GenericServiceImpl<OnlineAuctionLog, OnlineAuctionLogExample, Integer>
        implements OnlineAuctionLogService {

    @Autowired
    private OnlineAuctionLogMapper onlineAuctionLogMapper;

    @Override
    protected GenericMapper<OnlineAuctionLog, OnlineAuctionLogExample, Integer> getGenericMapper() {
        return onlineAuctionLogMapper;
    }

    @Override
    public boolean insertOnlineLog(OnlineAuctionLog onlineAuctionLog){
        OnlineAuctionLog onlinelog = insertSelective((onlineAuctionLog));
        if(null == onlinelog){
            return false;
        }
        return true;
    }

}
