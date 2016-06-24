package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseAuctionDataUpload implements Serializable {

    private static final long serialVersionUID = 218088969971867501L;

    private Integer id;

    private Integer auctionId;

    private Integer auctionVehicleId;

    private Integer auctionNumber;

    private Integer auctionVehicleOrder;

    private Date dealTime;

    private BigDecimal dealPrice;

    private Date createTime;

    private Integer createdBy;

    private Boolean delFlag;

    public BaseAuctionDataUpload(Integer id, Integer auctionId, Integer auctionVehicleId, Integer auctionNumber, Integer auctionVehicleOrder, Date dealTime, BigDecimal dealPrice, Date createTime, Integer createdBy, Boolean delFlag) {
        this.id = id;
        this.auctionId = auctionId;
        this.auctionVehicleId = auctionVehicleId;
        this.auctionNumber = auctionNumber;
        this.auctionVehicleOrder = auctionVehicleOrder;
        this.dealTime = dealTime;
        this.dealPrice = dealPrice;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.delFlag = delFlag;
    }

    public BaseAuctionDataUpload() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getAuctionVehicleId() {
        return auctionVehicleId;
    }

    public void setAuctionVehicleId(Integer auctionVehicleId) {
        this.auctionVehicleId = auctionVehicleId;
    }

    public Integer getAuctionNumber() {
        return auctionNumber;
    }

    public void setAuctionNumber(Integer auctionNumber) {
        this.auctionNumber = auctionNumber;
    }

    public Integer getAuctionVehicleOrder() {
        return auctionVehicleOrder;
    }

    public void setAuctionVehicleOrder(Integer auctionVehicleOrder) {
        this.auctionVehicleOrder = auctionVehicleOrder;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}