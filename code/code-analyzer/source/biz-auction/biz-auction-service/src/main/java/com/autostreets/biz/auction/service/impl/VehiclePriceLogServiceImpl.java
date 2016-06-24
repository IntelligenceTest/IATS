package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.autostreets.biz.auction.mapper.VehicleMapper;
import com.autostreets.biz.auction.mapper.VehiclePriceLogMapper;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.VehiclePriceLog;
import com.autostreets.biz.auction.model.VehiclePriceLogExample;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.VehiclePriceLogService;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.service.vehicle.VehicleService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("vehiclePriceLogService")
public class VehiclePriceLogServiceImpl extends GenericServiceImpl<VehiclePriceLog, VehiclePriceLogExample, Integer>
        implements VehiclePriceLogService {

    @Autowired
    private VehiclePriceLogMapper vehiclePriceLogMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private VehicleService vehicleInfoService;

    @Override
    protected GenericMapper<VehiclePriceLog, VehiclePriceLogExample, Integer> getGenericMapper() {
        return vehiclePriceLogMapper;
    }

    @Override
    public List<VehiclePriceLog> selectLogList(VehiclePriceLog log) {
        VehiclePriceLogExample example = new VehiclePriceLogExample();
        VehiclePriceLogExample.Criteria criteria = example.createCriteria();
        if (null != log.getVehicleId()) {
            criteria.andVehicleIdEqualTo(log.getVehicleId());
        }
        example.setOrderByClause("created_timestamp desc");
        List<VehiclePriceLog> logList = selectByExample(example);
        if (!CollectionUtils.isEmpty(logList)) {
            int size = logList.size();
            for (int i = size - 1; i >= 0; i--) {
                logList.get(i).setCreateUserName(userService.getNameById(logList.get(i).getCreateUser()));
                if (i <= size - 2) {
                    logList.get(i).setOldStartPrice(logList.get(i + 1).getStartPrice());
                    logList.get(i).setOldReservePrice(logList.get(i + 1).getReservePrice());
                    logList.get(i).setOldFpPrice(logList.get(i + 1).getFpPrice());
                    logList.get(i).setOldNewVehicleSuggestionPrice(logList.get(i + 1).getNewVehicleSuggestionPrice());
                    logList.get(i).setOldHasTaxBuy(logList.get(i + 1).getHasTaxBuy());
                    logList.get(i).setOldTaxBuy(logList.get(i + 1).getTaxBuy());
                    logList.get(i).setOldRequirementType(logList.get(i + 1).getRequirementType());

                }
            }
        }
        return logList;
    }

    @Override
    public List<VehiclePriceLog> selectLogListByPurchasId(VehiclePriceLog log) {
        VehiclePriceLogExample example = new VehiclePriceLogExample();
        VehiclePriceLogExample.Criteria criteria = example.createCriteria();
        if (null != log.getPurchaseId()) {
            criteria.andPurchaseIdEqualTo(log.getPurchaseId());
        } else {
            return null;
        }
        example.setOrderByClause("created_timestamp desc");
        List<VehiclePriceLog> logList = selectByExample(example);

        return logList;
    }

    @Override
    public List<VehiclePriceLog> selectLogByVehicleId(Integer vehicleId) {
        VehiclePriceLogExample example = new VehiclePriceLogExample();
        VehiclePriceLogExample.Criteria criteria = example.createCriteria();
        if (null != vehicleId) {
            criteria.andVehicleIdEqualTo(vehicleId);
        }
        example.setOrderByClause("created_timestamp desc");
        return selectByExample(example);
    }

    @Override
    public VehiclePriceLog selectLastLogByVehicleId(Integer vehicleId, Integer requirementType) {
        VehiclePriceLogExample example = new VehiclePriceLogExample();
        example.setPagination(new Pagination(1, 1));
        VehiclePriceLogExample.Criteria criteria = example.createCriteria();
        if (null != vehicleId) {
            criteria.andVehicleIdEqualTo(vehicleId);
        }
        if (null != requirementType) {
            criteria.andRequirementTypeEqualTo(requirementType);
        }
        example.setOrderByClause("id desc");
        List<VehiclePriceLog> list = vehiclePriceLogMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            if (null != requirementType && Integer.valueOf(0).equals(requirementType)) {
                AuctionVehicleExample auctionVehicleExample = new AuctionVehicleExample();
                com.autostreets.biz.auction.model.base.BaseAuctionVehicleExample.Criteria criteria2 = auctionVehicleExample
                        .createCriteria();
                criteria2.andLatestEqualTo(true);
                criteria2.andVehicleIdEqualTo(vehicleId);
                List<AuctionVehicle> auctionVehicles = auctionVehicleService.selectByExample(auctionVehicleExample);
                if (auctionVehicles != null && auctionVehicles.size() > 0) {
                    AuctionVehicle auctionVehicle = auctionVehicles.get(0);
                    VehiclePriceLog log = new VehiclePriceLog();
                    log.setStartPrice(auctionVehicle.getStartPrice());
                    log.setReservePrice(auctionVehicle.getReservePrice());
                    return log;
                } else {
                    Vehicle vehicle = vehicleMapper.selectByPrimaryKey(vehicleId);
                    VehiclePriceLog log = new VehiclePriceLog();
                    if (vehicle != null) {
                        log.setStartPrice(vehicle.getStartBidPrice());
                        log.setReservePrice(vehicle.getReservePrice());
                        return log;
                    }
                }
            }
            if (Integer.valueOf(1).equals(requirementType)) {
                FixedPriceExample fpE = new FixedPriceExample();
                FixedPriceExample.Criteria cri = fpE.createCriteria();
                cri.andLatestEqualTo(true);
                cri.andVehicleIdEqualTo(vehicleId);
                List<FixedPrice> fps = fixedPriceService.selectByExample(fpE);
                VehicleInfo vehicle = vehicleInfoService.selectVehicleById(vehicleId);
                VehiclePriceLog log = new VehiclePriceLog();
                if (fps != null && fps.size() > 0) {
                    FixedPrice fp = fps.get(0);
                    log.setFpPrice(fp.getPrice());
                    log.setHasTaxBuy(fp.getHasTaxBuy());
                    log.setTaxBuy(fp.getTaxBuy());
                }
                if (vehicle != null) {
                    if (log.getFpPrice() == null) {
                        log.setFpPrice(vehicle.getSalePrice());
                    }
                    log.setNewVehicleSuggestionPrice(vehicle.getNewVehicleSuggestionPrice());
                }
                return log;
            }
        }
        return null;
    }

    @Override
    public List<VehiclePriceLog> getLogByVehicleId(Integer vehicleId, Integer requirementType) {
        VehiclePriceLogExample example = new VehiclePriceLogExample();
        VehiclePriceLogExample.Criteria criteria = example.createCriteria();
        if (null != vehicleId) {
            criteria.andVehicleIdEqualTo(vehicleId);
            criteria.andRequirementTypeEqualTo(requirementType);
        }
        example.setOrderByClause("created_timestamp desc");
        return selectByExample(example);
    }
}
