package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseOrderItem implements Serializable {
    /**
     */
    private static final long serialVersionUID = 239138471273647046L;

    //主键
    private Integer id;

    //订单主表sid
    private Integer orderId;

    //佣金
    private BigDecimal commission;

    //办证费
    private BigDecimal licenseFee;

    //办证费类型: 1 汽车街代办 2 买家自理
    private Integer licenseFeeType;

    //出库费
    private BigDecimal exWarehouseFee;

    //停车费
    private BigDecimal parkingFee;

    //运输费
    private BigDecimal trafficFee;

    //违章费用
    private BigDecimal trafficViolationFee;

    //竞拍sid
    private Integer bidId;

    //车辆sid
    private Integer vehicleId;

    //拍品车辆关联ID
    private Integer auctionVehicleId;

    //延保sid
    private String guaranteeSid;

    //整备sid
    private String reconditionSid;

    //输入时间
    private Date createdTimestamp;

    //成交价
    private BigDecimal finalPrice;

    //结算价格
    private BigDecimal settlePrice;

    //优惠金额
    private BigDecimal discountPrice;

    //同步拍成交类型 默认0线上成交 1 线下成交
    private Integer dealType;

    //销售方式：0、一口价；1、同步拍；2、在线拍；3、即时拍
    private Integer saleType;

    //委托人佣金
    private BigDecimal clientCommissionFee;

    //买方佣金
    private BigDecimal buyerCommissionFee;

    //订单子项状态：0-已创建(未支付),1-后台业务取消,2-用户取消,3-超时未支付取消,4-已支付订金,5-已支付全款,6-已退订金,7-已退全款,8-交易成功,9-协商退款 10、退款失败 11、收款确认 12、支付确认 13、付款已拒绝
    private Integer status;

    //订单生成方式：1.系统自动生成，2.前台引导，3.后台拍卖师协商，4.后台补偿
    private Integer orderType;

    //定金
    private BigDecimal prePrice;

    //财务审核状态：0-未审核, 1-已审核
    private Integer finAudit;

    //有效标志：1-有效 0-无效
    private Boolean enabled;

    //收款方，参见字典表
    private Integer collectionParty;

    //收款方式，参见字典表
    private Integer collectionModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getLicenseFee() {
        return licenseFee;
    }

    public void setLicenseFee(BigDecimal licenseFee) {
        this.licenseFee = licenseFee;
    }

    public Integer getLicenseFeeType() {
        return licenseFeeType;
    }

    public void setLicenseFeeType(Integer licenseFeeType) {
        this.licenseFeeType = licenseFeeType;
    }

    public BigDecimal getExWarehouseFee() {
        return exWarehouseFee;
    }

    public void setExWarehouseFee(BigDecimal exWarehouseFee) {
        this.exWarehouseFee = exWarehouseFee;
    }

    public BigDecimal getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(BigDecimal parkingFee) {
        this.parkingFee = parkingFee;
    }

    public BigDecimal getTrafficFee() {
        return trafficFee;
    }

    public void setTrafficFee(BigDecimal trafficFee) {
        this.trafficFee = trafficFee;
    }

    public BigDecimal getTrafficViolationFee() {
        return trafficViolationFee;
    }

    public void setTrafficViolationFee(BigDecimal trafficViolationFee) {
        this.trafficViolationFee = trafficViolationFee;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
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

    public String getGuaranteeSid() {
        return guaranteeSid;
    }

    public void setGuaranteeSid(String guaranteeSid) {
        this.guaranteeSid = guaranteeSid == null ? null : guaranteeSid.trim();
    }

    public String getReconditionSid() {
        return reconditionSid;
    }

    public void setReconditionSid(String reconditionSid) {
        this.reconditionSid = reconditionSid == null ? null : reconditionSid.trim();
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public BigDecimal getClientCommissionFee() {
        return clientCommissionFee;
    }

    public void setClientCommissionFee(BigDecimal clientCommissionFee) {
        this.clientCommissionFee = clientCommissionFee;
    }

    public BigDecimal getBuyerCommissionFee() {
        return buyerCommissionFee;
    }

    public void setBuyerCommissionFee(BigDecimal buyerCommissionFee) {
        this.buyerCommissionFee = buyerCommissionFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(BigDecimal prePrice) {
        this.prePrice = prePrice;
    }

    public Integer getFinAudit() {
        return finAudit;
    }

    public void setFinAudit(Integer finAudit) {
        this.finAudit = finAudit;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getCollectionParty() {
        return collectionParty;
    }

    public void setCollectionParty(Integer collectionParty) {
        this.collectionParty = collectionParty;
    }

    public Integer getCollectionModel() {
        return collectionModel;
    }

    public void setCollectionModel(Integer collectionModel) {
        this.collectionModel = collectionModel;
    }
}