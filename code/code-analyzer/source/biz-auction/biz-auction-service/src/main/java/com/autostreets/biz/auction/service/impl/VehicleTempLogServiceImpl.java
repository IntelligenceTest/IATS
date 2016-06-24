package com.autostreets.biz.auction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.model.VehicleTempLog;
import com.autostreets.biz.auction.model.VehicleTempLogExample;
import com.autostreets.biz.auction.service.VehicleTempLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("vehicleTempLogService")
public class VehicleTempLogServiceImpl extends GenericServiceImpl<VehicleTempLog, VehicleTempLogExample, Integer>
        implements VehicleTempLogService {

    @Autowired
    private GenericMapper<VehicleTempLog, VehicleTempLogExample, Integer> vehicleTempLogMapper;

    @Override
    protected GenericMapper<VehicleTempLog, VehicleTempLogExample, Integer> getGenericMapper() {
        return vehicleTempLogMapper;
    }

}
