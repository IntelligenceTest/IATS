package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.VehiclePriceLog;
import com.autostreets.biz.auction.model.VehiclePriceLogExample;
import com.autostreets.framework.common.dal.GenericService;

public interface VehiclePriceLogService extends GenericService<VehiclePriceLog, VehiclePriceLogExample, Integer> {

    List<VehiclePriceLog> selectLogList(VehiclePriceLog log);

    List<VehiclePriceLog> selectLogByVehicleId(Integer vehicleId);

    List<VehiclePriceLog> getLogByVehicleId(Integer vehicleId, Integer requirementType);

    /**
     * 查询最后一次定价记录
     * 
     * @param vehicleId
     * @param requirementType
     * @return
     */
    VehiclePriceLog selectLastLogByVehicleId(Integer vehicleId, Integer requirementType);

    /**
     * 
     * 功能描述: <br>
     * 〈查询定价记录〉
     *
     * @param log
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<VehiclePriceLog> selectLogListByPurchasId(VehiclePriceLog log);
}
