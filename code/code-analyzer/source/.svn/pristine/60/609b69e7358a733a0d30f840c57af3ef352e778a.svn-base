package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseVehiclePriceLog implements Serializable {

    /**
     */
    private static final long serialVersionUID = 8481325197105356420L;

    // 主键
    private Integer id;

    // 车辆id
    private Integer vehicleId;

    // 起拍价
    private BigDecimal startPrice;

    // 保留价
    private BigDecimal reservePrice;

    // 0拍卖 1 展厅
    private Integer requirementType;

    // 操作人【用户标识】
    private Integer createUser;

    // 创建时间
    private Date createdTimestamp;

    // 展销价格
    private BigDecimal fpPrice;

    // 新车指导价（万元）
    private BigDecimal newVehicleSuggestionPrice;

    // 是否有购置税价格：0-无、1-有
    private Boolean hasTaxBuy;

    // 购置税价格
    private BigDecimal taxBuy;

    // 车辆登记id
    private Integer purchaseId;

    // 销售渠道：0 汽车街 1 自有渠道 2 第三方
    private Integer saleChannel;

    // 销售渠道备注
    private String channelRemark;

    // 销售方式：0 批售 1 零售
    private Integer saleType;

    // 是否需要审批
    private Boolean needApprove;

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

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public BigDecimal getFpPrice() {
        return fpPrice;
    }

    public void setFpPrice(BigDecimal fpPrice) {
        this.fpPrice = fpPrice;
    }

    public BigDecimal getNewVehicleSuggestionPrice() {
        return newVehicleSuggestionPrice;
    }

    public void setNewVehicleSuggestionPrice(BigDecimal newVehicleSuggestionPrice) {
        this.newVehicleSuggestionPrice = newVehicleSuggestionPrice;
    }

    public Boolean getHasTaxBuy() {
        return hasTaxBuy;
    }

    public void setHasTaxBuy(Boolean hasTaxBuy) {
        this.hasTaxBuy = hasTaxBuy;
    }

    public BigDecimal getTaxBuy() {
        return taxBuy;
    }

    public void setTaxBuy(BigDecimal taxBuy) {
        this.taxBuy = taxBuy;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getSaleChannel() {
        return saleChannel;
    }

    public void setSaleChannel(Integer saleChannel) {
        this.saleChannel = saleChannel;
    }

    public String getChannelRemark() {
        return channelRemark;
    }

    public void setChannelRemark(String channelRemark) {
        this.channelRemark = channelRemark == null ? null : channelRemark.trim();
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public Boolean getNeedApprove() {
        return needApprove;
    }

    public void setNeedApprove(Boolean needApprove) {
        this.needApprove = needApprove;
    }
}