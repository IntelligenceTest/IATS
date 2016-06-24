/**
 * @Title: AuctionVehicleVO.java
 * @Package com.autostreets.model.report
 * @Description:
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014-10-13 16:07:03
 * @version V1.0
 * @Copyright: 2014 www.autostreets.com Inc. All rights reserved.
 * 本内容仅限于汽车街(AUTOSTREETS)内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.autostreets.biz.auction.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

/**
 * @ClassName: AuctionVehicleVO
 * @Description: 拍卖统计报表VO
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014年9月26日 下午3:39:15
 * @version V2.3
 */
public class AuctionVehicleVO implements Serializable {

    private static final long serialVersionUID = -5714136441346385403L;
    private String code;// 车辆编号
    private String brand;// 车辆品牌
    private String vehicleModel;// 车辆系
    private String selledName; // 销售名
    private String vechileName;// 品牌车型
    private String type;// 类型参数
    private String auctionType;// 拍卖类型
    private String saleStatus;// 车辆销售状态
    private String status;// 拍品状态
    private Date startTimestamp;// 查询条件开始时间
    private Date endTimestamp;
    private Date planStartTime;// 竞拍时间
    private Date planEndTime;
    private String bidderName;// 竞得人
    private BigDecimal finalPrice;// 成交价
    private BigDecimal maxPrice;// 最高出价
    private BigDecimal reservePrice;
    private BigDecimal startPrice;
    private BigDecimal plusRange;
    private BigDecimal frameScore;// 车架评分
    private String vinCode;// 车辆识别码
    private String licenseCode;// 车牌号
    private String registerLicenseYears;// 上牌时间
    private Date inGarageTimestamp;// 入库时间
    private String vehicleAppraiser;// 评估师
    private String evaluationDept;// 评估部门
    private Pagination pagination;// 分页
    private String province;// 竞拍区域
    private String city;
    private String memberName;// 委托方
    private String registerProvince;// 上牌省份
    private String registerCity;// 上牌城市
    private String currentProvince;// 所在省份
    private String currentCity;// 所在城市
    private BigDecimal proceeds;// 收益
    private Integer counts;// 竞拍次数
    // 2014年11月3日 11:31:53 add
    private Integer bidderNum;// 竞拍人数
    private String level;// 评估等级
    private String id;
    // 2014年10月30日 14:52:04 add
    private String bidderType;// 竞价人类型：0-客户、1-内部人员
    private List<String> insiders = new ArrayList<>(); // 内部人员账户名单
    private String dataQueryPattern;// 数据筛选方式
    // 2014年11月6日 15:33:09 add
    private String maxBidderName; // 最高出价人
    private String avType; // 拍品种类 只有在线拍中有效
    private Integer evalOrgId;// 评估部门id
    private Integer appraiserId;// 评估师id
    // 2015年12月22日 add by zxf
    private String creatorName;// 发拍人
    private Integer creatorId;// 发拍人Id
    private Boolean recommend;// 热门推荐
    private String recommendText;// 热门推荐，1：是，0：否
    private List<Integer> orgIds;

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getMaxBidderName() {
        return maxBidderName;
    }

    public void setMaxBidderName(String maxBidderName) {
        this.maxBidderName = maxBidderName;
    }

    public Integer getBidderNum() {
        return bidderNum;
    }

    public void setBidderNum(Integer bidderNum) {
        this.bidderNum = bidderNum;
    }

    public String getDataQueryPattern() {
        return dataQueryPattern;
    }

    public void setDataQueryPattern(String dataQueryPattern) {
        this.dataQueryPattern = dataQueryPattern;
    }

    public String getBidderType() {
        return bidderType;
    }

    public void setBidderType(String bidderType) {
        this.bidderType = bidderType;
    }

    public List<String> getInsiders() {
        return insiders;
    }

    public void setInsiders(List<String> insiders) {
        this.insiders = insiders;
    }

    public BigDecimal getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(BigDecimal frameScore) {
        this.frameScore = frameScore;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public BigDecimal getPlusRange() {
        return plusRange;
    }

    public void setPlusRange(BigDecimal plusRange) {
        this.plusRange = plusRange;
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

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public BigDecimal getProceeds() {
        return proceeds;
    }

    public void setProceeds(BigDecimal proceeds) {
        this.proceeds = proceeds;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvType() {
        return avType;
    }

    public void setAvType(String avType) {
        this.avType = avType;
    }

    /**
     * @return the evalOrgId
     */
    public Integer getEvalOrgId() {
        return evalOrgId;
    }

    /**
     * @param evalOrgId
     *            the evalOrgId to set
     */
    public void setEvalOrgId(Integer evalOrgId) {
        this.evalOrgId = evalOrgId;
    }

    /**
     * @return the appraiserId
     */
    public Integer getAppraiserId() {
        return appraiserId;
    }

    /**
     * @param appraiserId
     *            the appraiserId to set
     */
    public void setAppraiserId(Integer appraiserId) {
        this.appraiserId = appraiserId;
    }

    public String getRegisterLicenseYears() {
        return registerLicenseYears;
    }

    public void setRegisterLicenseYears(String registerLicenseYears) {
        this.registerLicenseYears = registerLicenseYears;
    }

    /**
     * @return the recommend
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     *            the recommend to set
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * @return the recommendText
     */
    public String getRecommendText() {
        return recommendText;
    }

    /**
     * @param recommendText
     *            the recommendText to set
     */
    public void setRecommendText(String recommendText) {
        this.recommendText = recommendText;
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
}