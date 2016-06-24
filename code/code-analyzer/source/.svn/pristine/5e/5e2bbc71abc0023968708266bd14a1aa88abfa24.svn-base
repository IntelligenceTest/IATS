package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseAuctionVehicle implements Serializable {

    private static final long serialVersionUID = 6416569308615141412L;

    // 主键
    private Integer id;

    // 拍品编码
    private String avNo;

    // 拍卖会id
    private Integer auctionId;

    // 车辆id
    private Integer vehicleId;

    // 保留价
    private BigDecimal reservePrice;

    // 起拍价
    private BigDecimal startPrice;

    // 加价幅度
    private Integer plusRange;

    // 显示保留价(0:否,1:是)
    private Boolean displayReservePrice;

    // 状态：0:待拍卖、1:已上架、2:拍卖成功、3:流拍确认、4:流拍、5:拍卖中、6:暂停、7:订单取消
    private Integer status;

    // 是否成交，0：否，1：是
    private Boolean done;

    // 创建人
    private Integer createdBy;

    // 创建时间
    private Date createdTimestamp;

    // 出价次数
    private Integer bidQuantity;

    // 佣金百分比
    private BigDecimal commissionPercent;

    // 办证费
    private BigDecimal licenseFee;

    // 出库费
    private BigDecimal exWarehouseFee;

    // 停车费
    private BigDecimal parkingFee;

    // 运输费
    private BigDecimal trafficFee;

    // 违章费用
    private BigDecimal trafficViolationFee;

    // 委托方佣金比例
    private BigDecimal clientCommissionRate;

    // 委托方固定佣金
    private BigDecimal clientFixedCommission;

    // 买家佣金比例
    private BigDecimal buyerCommissionRate;

    // 买家固定佣金
    private BigDecimal buyerFixedCommission;

    // 看车时间
    private String seeCarTime;

    // 看车地点
    private String seeCarAddr;

    // 计划开始时间
    private Date planStartTime;

    // 计划结束时间
    private Date planEndTime;

    // 委托方:不使用
    private String client;

    // 拍卖类型：0-同步拍，1-在线拍
    private Integer auctionType;

    // 车辆拍卖顺序编号
    private Integer auctionVehicleOrder;

    // 是否删除：0:删除,1:未删除
    private Boolean enable;

    // 拍卖车型描述
    private String modelDesc;

    // 拍卖车辆描述
    private String vehicleDesc;

    // 拍卖方式：0-明拍、1-暗拍
    private Integer auctionModel;

    // 所在省份
    private String province;

    // 所在城市
    private String city;

    // 最大出价
    private BigDecimal maxBidPrice;

    // 线上结束时间
    private Date onlineEndTime;

    // 结束时间
    private Date endTime;

    // 开始时间
    private Date startTime;

    // 1-最新拍品、0-已参加过拍卖
    private Boolean latest;

    // 在线拍代理价
    private Integer agentPrice;

    // 拍品类型：0-有底价 1-无底价拍卖
    private Integer avType;

    // 是否热门推荐(0-否、1-是)
    private Boolean recommend;

    // 是否活动拍品
    private Boolean activity;

    // 活动拍品title
    private String activityTitle;

    // 协商后，会员追加出价 0不可以追加， 1可以追加 2 已追加
    private Integer finalBidStatus;

    // 协商后，会员追加的出价
    private BigDecimal finalBidPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvNo() {
        return avNo;
    }

    public void setAvNo(String avNo) {
        this.avNo = avNo == null ? null : avNo.trim();
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getPlusRange() {
        return plusRange;
    }

    public void setPlusRange(Integer plusRange) {
        this.plusRange = plusRange;
    }

    public Boolean getDisplayReservePrice() {
        return displayReservePrice;
    }

    public void setDisplayReservePrice(Boolean displayReservePrice) {
        this.displayReservePrice = displayReservePrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Integer getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(Integer bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public BigDecimal getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(BigDecimal commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public BigDecimal getLicenseFee() {
        return licenseFee;
    }

    public void setLicenseFee(BigDecimal licenseFee) {
        this.licenseFee = licenseFee;
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

    public BigDecimal getClientCommissionRate() {
        return clientCommissionRate;
    }

    public void setClientCommissionRate(BigDecimal clientCommissionRate) {
        this.clientCommissionRate = clientCommissionRate;
    }

    public BigDecimal getClientFixedCommission() {
        return clientFixedCommission;
    }

    public void setClientFixedCommission(BigDecimal clientFixedCommission) {
        this.clientFixedCommission = clientFixedCommission;
    }

    public BigDecimal getBuyerCommissionRate() {
        return buyerCommissionRate;
    }

    public void setBuyerCommissionRate(BigDecimal buyerCommissionRate) {
        this.buyerCommissionRate = buyerCommissionRate;
    }

    public BigDecimal getBuyerFixedCommission() {
        return buyerFixedCommission;
    }

    public void setBuyerFixedCommission(BigDecimal buyerFixedCommission) {
        this.buyerFixedCommission = buyerFixedCommission;
    }

    public String getSeeCarTime() {
        return seeCarTime;
    }

    public void setSeeCarTime(String seeCarTime) {
        this.seeCarTime = seeCarTime == null ? null : seeCarTime.trim();
    }

    public String getSeeCarAddr() {
        return seeCarAddr;
    }

    public void setSeeCarAddr(String seeCarAddr) {
        this.seeCarAddr = seeCarAddr == null ? null : seeCarAddr.trim();
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public Integer getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(Integer auctionType) {
        this.auctionType = auctionType;
    }

    public Integer getAuctionVehicleOrder() {
        return auctionVehicleOrder;
    }

    public void setAuctionVehicleOrder(Integer auctionVehicleOrder) {
        this.auctionVehicleOrder = auctionVehicleOrder;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc == null ? null : modelDesc.trim();
    }

    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc == null ? null : vehicleDesc.trim();
    }

    public Integer getAuctionModel() {
        return auctionModel;
    }

    public void setAuctionModel(Integer auctionModel) {
        this.auctionModel = auctionModel;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public BigDecimal getMaxBidPrice() {
        return maxBidPrice;
    }

    public void setMaxBidPrice(BigDecimal maxBidPrice) {
        this.maxBidPrice = maxBidPrice;
    }

    public Date getOnlineEndTime() {
        return onlineEndTime;
    }

    public void setOnlineEndTime(Date onlineEndTime) {
        this.onlineEndTime = onlineEndTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Boolean getLatest() {
        return latest;
    }

    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    public Integer getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(Integer agentPrice) {
        this.agentPrice = agentPrice;
    }

    public Integer getAvType() {
        return avType;
    }

    public void setAvType(Integer avType) {
        this.avType = avType;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
    }

    public Integer getFinalBidStatus() {
        return finalBidStatus;
    }

    public void setFinalBidStatus(Integer finalBidStatus) {
        this.finalBidStatus = finalBidStatus;
    }

    public BigDecimal getFinalBidPrice() {
        return finalBidPrice;
    }

    public void setFinalBidPrice(BigDecimal finalBidPrice) {
        this.finalBidPrice = finalBidPrice;
    }
}