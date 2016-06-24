package com.autostreets.biz.auction.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.VehicleSalesMapper;
import com.autostreets.biz.auction.model.VehicleSales;
import com.autostreets.biz.auction.model.VehicleSalesExample;
import com.autostreets.biz.auction.service.VehicleSalesService;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("vehicleSalesService")
public class VehicleSalesServiceImpl extends
		GenericServiceImpl<VehicleSales, VehicleSalesExample, Integer>implements VehicleSalesService {

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleSalesServiceImpl.class);

	@Autowired
	private VehicleSalesMapper vehicleSalesMapper;

	@Override
	protected VehicleSalesMapper getGenericMapper() {
		return vehicleSalesMapper;
	}

    @Override
    public boolean insertOrUpdate(VehicleSales vehicleSales) {
        LOGGER.debug("更新车辆销售信息");
        VehicleSales tempVehicleSales = vehicleSalesMapper.selectByPrimaryKey(vehicleSales.getId());
        int rs;
        if (tempVehicleSales == null) {
            vehicleSales.setCreateTime(new Date());
            rs = vehicleSalesMapper.insertSelective(vehicleSales);
        } else {
            rs = vehicleSalesMapper.updateByPrimaryKeySelective(vehicleSales);
        }
        if (rs == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Integer> selectIdsByCondition(VehicleSales vehicleSales) {
        if (vehicleSales != null) {
            return vehicleSalesMapper.selectIdsByCondition(vehicleSales);
        }
        return null;
    }

    @Override
    public Integer getRequirementType(Integer vehicleId) {
        if (vehicleId != null) {
            VehicleSales vehicleSales = selectByPrimaryKey(vehicleId);
            if (vehicleSales != null) {
                return vehicleSales.getRequirementType();
            }
        }
        return -1;
    }

    @Override
    public boolean isAuction(Integer vehicleId) {
        Integer requirementType = getRequirementType(vehicleId);
        if (requirementType == 0) {
            return true;
        }
        return false;
    }
}