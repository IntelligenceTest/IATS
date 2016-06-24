package com.autostreets.biz.auction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerVehicleLogMapper;
import com.autostreets.biz.auction.model.DealerVehicleLog;
import com.autostreets.biz.auction.model.DealerVehicleLogExample;
import com.autostreets.biz.auction.service.DealerVehicleLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("dealerVehicleLogService")
public class DealerVehicleLogServiceImpl extends GenericServiceImpl<DealerVehicleLog, DealerVehicleLogExample, Integer>implements DealerVehicleLogService {

    @Autowired
    private DealerVehicleLogMapper dealerVehicleLogMapper; 
    @Override
    protected GenericMapper<DealerVehicleLog, DealerVehicleLogExample, Integer> getGenericMapper() {
        return dealerVehicleLogMapper;
    }

}
