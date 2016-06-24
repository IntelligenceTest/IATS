package com.autostreets.biz.auction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AvStatusLogMapper;
import com.autostreets.biz.auction.model.AvStatusLog;
import com.autostreets.biz.auction.model.AvStatusLogExample;
import com.autostreets.biz.auction.service.AvStatusLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("avStatusLogService")
public class AvStatusLogServiceImpl extends GenericServiceImpl<AvStatusLog, AvStatusLogExample, Integer> implements
        AvStatusLogService {

    @Autowired
    private AvStatusLogMapper avStatusLogMapper;

    @Override
    protected GenericMapper<AvStatusLog, AvStatusLogExample, Integer> getGenericMapper() {
        return avStatusLogMapper;
    }

}
