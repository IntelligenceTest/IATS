package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseMemberVehicleBatch implements Serializable {

    /**
     */
    private static final long serialVersionUID = -3774767021069584459L;

    private Integer id;

    private String memberSid;

    private Integer avId;

    private Integer vehicleId;

    private BigDecimal latestPrice;

    private Boolean status;

    private Date createdTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(String memberSid) {
        this.memberSid = memberSid == null ? null : memberSid.trim();
    }

    public Integer getAvId() {
        return avId;
    }

    public void setAvId(Integer avId) {
        this.avId = avId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public BigDecimal getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(BigDecimal latestPrice) {
        this.latestPrice = latestPrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}