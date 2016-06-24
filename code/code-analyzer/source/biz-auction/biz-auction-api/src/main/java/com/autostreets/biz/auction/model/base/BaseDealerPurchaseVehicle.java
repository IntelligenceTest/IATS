package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseDealerPurchaseVehicle implements Serializable {
    //主键

    /**
     */
    private static final long serialVersionUID = -290595676325886968L;

    // 主键
    private Integer id;

    //vin码
    private String vinCode;

    //客户姓名
    private String custName;

    //客户联系电话
    private String custPhone;

    //品牌
    private String brand;

    //车系
    private String series;

    //车型
    private String model;

    //车牌号
    private String licenseCode;

    //表显里程
    private BigDecimal displayMileage;

    //生产年月
    private String producedYears;

    //上牌年月
    private String registerLicenseYears;

    //评估师
    private String vehicleAppraiser;

    //推荐人
    private String recommender;

    //车辆性质：0 营运 1 非营运
    private Integer vehiclePpe;

    //用户性质：0 置换 1 收购
    private Integer userPpe;

    //客户意向
    private Integer custIntention;

    //初步报价
    private BigDecimal firstPrice;

    //最终报价
    private BigDecimal finalPrice;

    //来访时间
    private Date visitTime;

    //车辆id
    private Integer vehicleId;

    //门店
    private Integer orgId;

    //车辆登记图片
    private String picUrl;

    //备注
    private String remark;

    //签约时间
    private Date contractTime;

    //创建时间
    private Date createTime;

    //更新时间
    private Date modifyTime;

    //删除标记（0、未删除 1、删除）
    private Boolean delFlag;

    //销售方式：0 批售 1 零售
    private Integer saleType;

    //销售渠道：0 汽车街 1 自有渠道 2 第三方
    private Integer saleChannel;

    //销售渠道备注
    private String channelRemark;

    //拍品类型：0-有底价 1-无底价拍卖
    private Integer avType;

    //起拍价
    private BigDecimal startPrice;

    //保留价
    private BigDecimal reservePrice;

    //展售价
    private BigDecimal fixedPrice;

    //是否需要审批
    private Boolean needApprove;

    //销售状态：0 待售 1 在售 2 已售
    private Integer saleStatus;

    //最终售价
    private BigDecimal finalSalePrice;

    //收购方id
    private Integer dealerMemberId;

    //成交时间
    private Date dealTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode == null ? null : vinCode.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode == null ? null : licenseCode.trim();
    }

    public BigDecimal getDisplayMileage() {
        return displayMileage;
    }

    public void setDisplayMileage(BigDecimal displayMileage) {
        this.displayMileage = displayMileage;
    }

    public String getProducedYears() {
        return producedYears;
    }

    public void setProducedYears(String producedYears) {
        this.producedYears = producedYears == null ? null : producedYears.trim();
    }

    public String getRegisterLicenseYears() {
        return registerLicenseYears;
    }

    public void setRegisterLicenseYears(String registerLicenseYears) {
        this.registerLicenseYears = registerLicenseYears == null ? null : registerLicenseYears.trim();
    }

    public String getVehicleAppraiser() {
        return vehicleAppraiser;
    }

    public void setVehicleAppraiser(String vehicleAppraiser) {
        this.vehicleAppraiser = vehicleAppraiser == null ? null : vehicleAppraiser.trim();
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender == null ? null : recommender.trim();
    }

    public Integer getVehiclePpe() {
        return vehiclePpe;
    }

    public void setVehiclePpe(Integer vehiclePpe) {
        this.vehiclePpe = vehiclePpe;
    }

    public Integer getUserPpe() {
        return userPpe;
    }

    public void setUserPpe(Integer userPpe) {
        this.userPpe = userPpe;
    }

    public Integer getCustIntention() {
        return custIntention;
    }

    public void setCustIntention(Integer custIntention) {
        this.custIntention = custIntention;
    }

    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
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

    public Integer getAvType() {
        return avType;
    }

    public void setAvType(Integer avType) {
        this.avType = avType;
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

    public BigDecimal getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(BigDecimal fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public Boolean getNeedApprove() {
        return needApprove;
    }

    public void setNeedApprove(Boolean needApprove) {
        this.needApprove = needApprove;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public BigDecimal getFinalSalePrice() {
        return finalSalePrice;
    }

    public void setFinalSalePrice(BigDecimal finalSalePrice) {
        this.finalSalePrice = finalSalePrice;
    }

    public Integer getDealerMemberId() {
        return dealerMemberId;
    }

    public void setDealerMemberId(Integer dealerMemberId) {
        this.dealerMemberId = dealerMemberId;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}