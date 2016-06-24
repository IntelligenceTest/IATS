package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseVehicle implements Serializable {
    /**
     */
    private static final long serialVersionUID = 6588347869737283182L;

    //主键
    private Integer id;

    //vin码
    private String vinCode;

    //品牌
    private String brand;

    //编号，格式：年月日时分+两位随机数，例如：20140627093601
    private String code;

    //车系:途安
    private String brandSeries;

    //销售名称
    private String selledName;

    //车型:途安
    private String vehicleModel;

    //年款
    private String modelYear;

    //上牌日期
    private String registerLicenseYears;

    //排量
    private BigDecimal sweptVolume;

    //排量类型（L、T）
    private String sweptVolumeType;

    //排量标准/环保标准
    private String sweptVolumeStandard;

    //上牌省份
    private String registerProvince;

    //上牌城市
    private String registerCity;

    //车辆所在省份
    private String currentProvince;

    //车辆所在城市
    private String currentCity;

    //车牌号
    private String licenseCode;

    //车辆颜色
    private String bodyColor;

    //表显里程 单位：公里
    private BigDecimal displayMileage;

    //车型分类：轿车、SUV、MPV、跑车、商务车
    private String vehicleType;

    //起拍价
    private BigDecimal startBidPrice;

    //保留价
    private BigDecimal reservePrice;

    //新车指导价
    private BigDecimal newVehicleSuggestionPrice;

    //0拍卖 1 展厅
    private Integer requirementType;

    //来源：电脑，ipad,av(临时拍品)
    private String source;

    //销售状态：0、待售；1、 出售中；2、已出售
    private Short saleStatus;

    //车辆性质：评估、置换、退役试驾车、收购、退役公务车
    private String vehiclePpe;

    //评估师ID
    private Integer appraiserId;

    //评估师
    private String vehicleAppraiser;

    //评估部门ID
    private Integer evalOrgId;

    //评估部门
    private String evaluationDept;

    //车辆45度照片
    private String firstPhotoUrl;

    //车辆描述
    private String vehicleDesc;

    //车辆来源类型：1集团客户 2大客户 3 个人
    private Short vehicleSrcType;

    //membersid或organizationsid，根据vehicle_src_type的值区分，集团客户为organizationsid，大客户和个人为membersid
    private Integer vehicleSrcId;

    //是否认证二手车
    private Boolean certified;

    //是否质保二手车
    private Boolean guaranteed;

    //更新时间
    private Date modifyTime;

    //创建时间
    private Date createdTime;

    //审核标示，0 普通审核, 1 复审商家审核
    private Integer auditFlag;

    //商家是否定价，0 未定价, 1 已定价
    private Boolean pricing;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getBrandSeries() {
        return brandSeries;
    }

    public void setBrandSeries(String brandSeries) {
        this.brandSeries = brandSeries == null ? null : brandSeries.trim();
    }

    public String getSelledName() {
        return selledName;
    }

    public void setSelledName(String selledName) {
        this.selledName = selledName == null ? null : selledName.trim();
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel == null ? null : vehicleModel.trim();
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear == null ? null : modelYear.trim();
    }

    public String getRegisterLicenseYears() {
        return registerLicenseYears;
    }

    public void setRegisterLicenseYears(String registerLicenseYears) {
        this.registerLicenseYears = registerLicenseYears == null ? null : registerLicenseYears.trim();
    }

    public BigDecimal getSweptVolume() {
        return sweptVolume;
    }

    public void setSweptVolume(BigDecimal sweptVolume) {
        this.sweptVolume = sweptVolume;
    }

    public String getSweptVolumeType() {
        return sweptVolumeType;
    }

    public void setSweptVolumeType(String sweptVolumeType) {
        this.sweptVolumeType = sweptVolumeType == null ? null : sweptVolumeType.trim();
    }

    public String getSweptVolumeStandard() {
        return sweptVolumeStandard;
    }

    public void setSweptVolumeStandard(String sweptVolumeStandard) {
        this.sweptVolumeStandard = sweptVolumeStandard == null ? null : sweptVolumeStandard.trim();
    }

    public String getRegisterProvince() {
        return registerProvince;
    }

    public void setRegisterProvince(String registerProvince) {
        this.registerProvince = registerProvince == null ? null : registerProvince.trim();
    }

    public String getRegisterCity() {
        return registerCity;
    }

    public void setRegisterCity(String registerCity) {
        this.registerCity = registerCity == null ? null : registerCity.trim();
    }

    public String getCurrentProvince() {
        return currentProvince;
    }

    public void setCurrentProvince(String currentProvince) {
        this.currentProvince = currentProvince == null ? null : currentProvince.trim();
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity == null ? null : currentCity.trim();
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode == null ? null : licenseCode.trim();
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor == null ? null : bodyColor.trim();
    }

    public BigDecimal getDisplayMileage() {
        return displayMileage;
    }

    public void setDisplayMileage(BigDecimal displayMileage) {
        this.displayMileage = displayMileage;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public BigDecimal getStartBidPrice() {
        return startBidPrice;
    }

    public void setStartBidPrice(BigDecimal startBidPrice) {
        this.startBidPrice = startBidPrice;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public BigDecimal getNewVehicleSuggestionPrice() {
        return newVehicleSuggestionPrice;
    }

    public void setNewVehicleSuggestionPrice(BigDecimal newVehicleSuggestionPrice) {
        this.newVehicleSuggestionPrice = newVehicleSuggestionPrice;
    }

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Short getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Short saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getVehiclePpe() {
        return vehiclePpe;
    }

    public void setVehiclePpe(String vehiclePpe) {
        this.vehiclePpe = vehiclePpe == null ? null : vehiclePpe.trim();
    }

    public Integer getAppraiserId() {
        return appraiserId;
    }

    public void setAppraiserId(Integer appraiserId) {
        this.appraiserId = appraiserId;
    }

    public String getVehicleAppraiser() {
        return vehicleAppraiser;
    }

    public void setVehicleAppraiser(String vehicleAppraiser) {
        this.vehicleAppraiser = vehicleAppraiser == null ? null : vehicleAppraiser.trim();
    }

    public Integer getEvalOrgId() {
        return evalOrgId;
    }

    public void setEvalOrgId(Integer evalOrgId) {
        this.evalOrgId = evalOrgId;
    }

    public String getEvaluationDept() {
        return evaluationDept;
    }

    public void setEvaluationDept(String evaluationDept) {
        this.evaluationDept = evaluationDept == null ? null : evaluationDept.trim();
    }

    public String getFirstPhotoUrl() {
        return firstPhotoUrl;
    }

    public void setFirstPhotoUrl(String firstPhotoUrl) {
        this.firstPhotoUrl = firstPhotoUrl == null ? null : firstPhotoUrl.trim();
    }

    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc == null ? null : vehicleDesc.trim();
    }

    public Short getVehicleSrcType() {
        return vehicleSrcType;
    }

    public void setVehicleSrcType(Short vehicleSrcType) {
        this.vehicleSrcType = vehicleSrcType;
    }

    public Integer getVehicleSrcId() {
        return vehicleSrcId;
    }

    public void setVehicleSrcId(Integer vehicleSrcId) {
        this.vehicleSrcId = vehicleSrcId;
    }

    public Boolean getCertified() {
        return certified;
    }

    public void setCertified(Boolean certified) {
        this.certified = certified;
    }

    public Boolean getGuaranteed() {
        return guaranteed;
    }

    public void setGuaranteed(Boolean guaranteed) {
        this.guaranteed = guaranteed;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Boolean getPricing() {
        return pricing;
    }

    public void setPricing(Boolean pricing) {
        this.pricing = pricing;
    }
}