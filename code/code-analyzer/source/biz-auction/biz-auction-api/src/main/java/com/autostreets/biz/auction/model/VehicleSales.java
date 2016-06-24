package com.autostreets.biz.auction.model;

import com.autostreets.biz.auction.model.base.BaseVehicleSales;

public class VehicleSales extends BaseVehicleSales {

    private static final long serialVersionUID = -3288951306174555074L;

    /**
     * 车辆编号
     */
    public String vehicleCode;

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

}