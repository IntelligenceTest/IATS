package com.autostreets.biz.auction.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.autostreets.biz.auction.model.base.BaseAuctionVehicle;
import com.autostreets.framework.common.dal.Pagination;

public class AuctionVehicle extends BaseAuctionVehicle {

    /**
     */
    private static final long serialVersionUID = -9200227617842574512L;
    private Vehicle vehicle;

    private String code; // 车辆编号
    private String photoName; // 车辆照片
    private String photoDesc; // 照片描述
    private String photoUrl; // 照片路径
    private String brand; // 车辆品牌
    private String vehicleModel; // 车辆系
    private String selledName; // 销售名
    private String vechileName;
    private String type; // 拍卖类型
    private String saleStatus; // 车辆销售状态
    private Date startTimestamp; // 查询条件开始时间
    private Date endTimestamp; // 查询条件结束时间
    private String bidderName; // 竞得人
    private BigDecimal finalPrice; // 成交价
    private BigDecimal maxPrice; // 最高出价
    private String vinCode; // 车辆识别码
    private String licenseCode; // 车牌号
    private String sweptVolume; // 排量
    private String sweptVolumeType; // 排量类型
    private String sweptVolumeStandard; // 排量标准
    private String bodyColor; // 车身颜色
    private String registerLicenseYears; // 上牌时间
    private Date inGarageTimestamp; // 入库时间
    private String vehicleAppraiser; // 评估师
    private String evaluationDept; // 评估部门
    private String orderId; // 订单编号
    private String bidderSid; // 竞价人编号
    private String orderItemSid; // 订单明细编号
    private String allSids; // 拍品关联标识（逗号）车辆标识||
    private String cashAllSids; // 费用批量设置标识组
    private String seeCarAllSids; // 看车批量设置
    private String onlineSids; // 在线拍
    private String onceBidSids; // 即时拍
    private Pagination pagination; // 分页
    private String orderByClause; // 排序
    private String auctionCode; // 拍卖会编号
    private String requirementType; // 客户需求
    private String vehicleType; // 车辆类型
    private String memberName; // 委托方
    private String registerProvince; // 上牌省份
    private String registerCity; // 上牌城市
    private String currentProvince; // 所在省份
    private String currentCity; // 所在城市
    private String source; // 车辆
    private String msgError;
    private BigDecimal proceeds; // 收益
    private Date evalStartTimestamp; // 查询条件评估日期开始时间
    private Date evalEndTimestamp; // 查询条件评估日期结束时间
    private String displayMileage; // 表显里程
    private String firstPhotoUrl;// 车辆45度照片
    private BigDecimal curBidPrice;
    private Integer vehicleSrcType;
    private Integer vehicleSrcId;
    private boolean isDealer;
    private Integer commission;// 佣金
    private Date nextAnnualExamination;// 年审有效期
    private Date nextCompulsoryInsurance;// 交强险有效期

    private List<Integer> orgIds;// 权限参数
    private String orgName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getSelledName() {
        return selledName;
    }

    public void setSelledName(String selledName) {
        this.selledName = selledName;
    }

    public String getVechileName() {
        return vechileName;
    }

    public void setVechileName(String vechileName) {
        this.vechileName = vechileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getSweptVolume() {
        return sweptVolume;
    }

    public void setSweptVolume(String sweptVolume) {
        this.sweptVolume = sweptVolume;
    }

    public String getSweptVolumeType() {
        return sweptVolumeType;
    }

    public void setSweptVolumeType(String sweptVolumeType) {
        this.sweptVolumeType = sweptVolumeType;
    }

    public String getSweptVolumeStandard() {
        return sweptVolumeStandard;
    }

    public void setSweptVolumeStandard(String sweptVolumeStandard) {
        this.sweptVolumeStandard = sweptVolumeStandard;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public Date getInGarageTimestamp() {
        return inGarageTimestamp;
    }

    public void setInGarageTimestamp(Date inGarageTimestamp) {
        this.inGarageTimestamp = inGarageTimestamp;
    }

    public String getVehicleAppraiser() {
        return vehicleAppraiser;
    }

    public void setVehicleAppraiser(String vehicleAppraiser) {
        this.vehicleAppraiser = vehicleAppraiser;
    }

    public String getEvaluationDept() {
        return evaluationDept;
    }

    public void setEvaluationDept(String evaluationDept) {
        this.evaluationDept = evaluationDept;
    }

    public String getBidderSid() {
        return bidderSid;
    }

    public void setBidderSid(String bidderSid) {
        this.bidderSid = bidderSid;
    }

    public String getOrderItemSid() {
        return orderItemSid;
    }

    public void setOrderItemSid(String orderItemSid) {
        this.orderItemSid = orderItemSid;
    }

    public String getAllSids() {
        return allSids;
    }

    public void setAllSids(String allSids) {
        this.allSids = allSids;
    }

    public String getCashAllSids() {
        return cashAllSids;
    }

    public void setCashAllSids(String cashAllSids) {
        this.cashAllSids = cashAllSids;
    }

    public String getSeeCarAllSids() {
        return seeCarAllSids;
    }

    public void setSeeCarAllSids(String seeCarAllSids) {
        this.seeCarAllSids = seeCarAllSids;
    }

    public String getOnlineSids() {
        return onlineSids;
    }

    public void setOnlineSids(String onlineSids) {
        this.onlineSids = onlineSids;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getAuctionCode() {
        return auctionCode;
    }

    public void setAuctionCode(String auctionCode) {
        this.auctionCode = auctionCode;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRegisterProvince() {
        return registerProvince;
    }

    public void setRegisterProvince(String registerProvince) {
        this.registerProvince = registerProvince;
    }

    public String getRegisterCity() {
        return registerCity;
    }

    public void setRegisterCity(String registerCity) {
        this.registerCity = registerCity;
    }

    public String getCurrentProvince() {
        return currentProvince;
    }

    public void setCurrentProvince(String currentProvince) {
        this.currentProvince = currentProvince;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public BigDecimal getProceeds() {
        return proceeds;
    }

    public void setProceeds(BigDecimal proceeds) {
        this.proceeds = proceeds;
    }

    public Date getEvalStartTimestamp() {
        return evalStartTimestamp;
    }

    public void setEvalStartTimestamp(Date evalStartTimestamp) {
        this.evalStartTimestamp = evalStartTimestamp;
    }

    public Date getEvalEndTimestamp() {
        return evalEndTimestamp;
    }

    public void setEvalEndTimestamp(Date evalEndTimestamp) {
        this.evalEndTimestamp = evalEndTimestamp;
    }

    public String getDisplayMileage() {
        return displayMileage;
    }

    public void setDisplayMileage(String displayMileage) {
        this.displayMileage = displayMileage;
    }

    public String getFirstPhotoUrl() {
        return firstPhotoUrl;
    }

    public void setFirstPhotoUrl(String firstPhotoUrl) {
        this.firstPhotoUrl = firstPhotoUrl;
    }

    public String getOnceBidSids() {
        return onceBidSids;
    }

    public void setOnceBidSids(String onceBidSids) {
        this.onceBidSids = onceBidSids;
    }

    public BigDecimal getCurBidPrice() {
        return curBidPrice;
    }

    public void setCurBidPrice(BigDecimal curBidPrice) {
        this.curBidPrice = curBidPrice;
    }

    /**
     * @return the registerLicenseYears
     */
    public String getRegisterLicenseYears() {
        return registerLicenseYears;
    }

    /**
     * @param registerLicenseYears
     *            the registerLicenseYears to set
     */
    public void setRegisterLicenseYears(String registerLicenseYears) {
        this.registerLicenseYears = registerLicenseYears;
    }

    public Integer getVehicleSrcType() {
        return vehicleSrcType;
    }

    public void setVehicleSrcType(Integer vehicleSrcType) {
        this.vehicleSrcType = vehicleSrcType;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean isDealer) {
        this.isDealer = isDealer;
    }

    /**
     * @return the commission
     */
    public Integer getCommission() {
        return commission;
    }

    /**
     * @param commission
     *            the commission to set
     */
    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    /**
     * @return the orgIds
     */
    public List<Integer> getOrgIds() {
        return orgIds;
    }

    /**
     * @param orgIds
     *            the orgIds to set
     */
    public void setOrgIds(List<Integer> orgIds) {
        this.orgIds = orgIds;
    }

    /**
     * @return the vehicleSrcId
     */
    public Integer getVehicleSrcId() {
        return vehicleSrcId;
    }

    /**
     * @param vehicleSrcId
     *            the vehicleSrcId to set
     */
    public void setVehicleSrcId(Integer vehicleSrcId) {
        this.vehicleSrcId = vehicleSrcId;
    }

    /**
     * @return the nextAnnualExamination
     */
    public Date getNextAnnualExamination() {
        return nextAnnualExamination;
    }

    /**
     * @param nextAnnualExamination
     *            the nextAnnualExamination to set
     */
    public void setNextAnnualExamination(Date nextAnnualExamination) {
        this.nextAnnualExamination = nextAnnualExamination;
    }

    /**
     * @return the nextCompulsoryInsurance
     */
    public Date getNextCompulsoryInsurance() {
        return nextCompulsoryInsurance;
    }

    /**
     * @param nextCompulsoryInsurance
     *            the nextCompulsoryInsurance to set
     */
    public void setNextCompulsoryInsurance(Date nextCompulsoryInsurance) {
        this.nextCompulsoryInsurance = nextCompulsoryInsurance;
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     *            the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

}