package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseVehicleSyncFailLog implements Serializable {

    /**
     */
    private static final long serialVersionUID = 560467625435844117L;

    // 主键
    private Integer id;

    // 车辆id
    private Integer vehicleId;

    // 拍品id
    private Integer auctionVehicleId;

    // 车辆更新前状态
    private Integer oldStatus;

    // 车辆更新后状态
    private Integer newStatus;

    // 创建时间
    private Date createdTime;

    // 删除标记(0、未删除 1、删除)
    private Boolean delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getAuctionVehicleId() {
        return auctionVehicleId;
    }

    public void setAuctionVehicleId(Integer auctionVehicleId) {
        this.auctionVehicleId = auctionVehicleId;
    }

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}