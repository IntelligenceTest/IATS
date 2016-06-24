package com.autostreets.biz.auction.model;

import java.util.Date;
import java.util.List;

import com.autostreets.biz.auction.model.base.BaseDealerPurchaseVehicle;
import com.autostreets.framework.common.dal.Pagination;
import com.ibm.icu.math.BigDecimal;

public class DealerPurchaseVehicle extends BaseDealerPurchaseVehicle {

    /**
     */
    private static final long serialVersionUID = -3310652361197688263L;

    private Pagination pagination;

    private Date startCreateTime;

    private Date endCreateTime;

    private List<Integer> orgIds;

    private Date startContractTime;

    private Date endContractTime;
    
    private Date startDealTime;

    private Date endDealTime;

    private Integer dealerPurchasevehicleId;
    private String purchaseRecommender;
    private Integer contractCount;
    private Integer PurchaseAppraiser;
    private Integer recommendVehicleCount;
    private String purchaseBrand;
    private String purchaseService;
    private Date startTime;
    private Date endTime;
    private String orderByClause;

    private Integer contractRecommenderCount;
    private Integer recommendRecCount;
    private Integer contractSum;

    private String processInstanceId;

    private Integer processStatus;

    private Double totalPrice;
    private String dealerName;
    private String dealerPhone;
    private String orgName;

  

    public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Integer getContractRecommenderCount() {
        return contractRecommenderCount;
    }

    public void setContractRecommenderCount(Integer contractRecommenderCount) {
        this.contractRecommenderCount = contractRecommenderCount;
    }

    public Integer getRecommendRecCount() {
        return recommendRecCount;
    }

    public void setRecommendRecCount(Integer recommendRecCount) {
        this.recommendRecCount = recommendRecCount;
    }

    public Integer getContractSum() {
        return contractSum;
    }

    public void setContractSum(Integer contractSum) {
        this.contractSum = contractSum;
    }

    public Integer getRecommendVehicleSum() {
        return recommendVehicleSum;
    }

    public void setRecommendVehicleSum(Integer recommendVehicleSum) {
        this.recommendVehicleSum = recommendVehicleSum;
    }

    private Integer recommendVehicleSum;

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDealerPurchasevehicleId() {
        return dealerPurchasevehicleId;
    }

    public void setDealerPurchasevehicleId(Integer dealerPurchasevehicleId) {
        this.dealerPurchasevehicleId = dealerPurchasevehicleId;
    }

    public String getPurchaseRecommender() {
        return purchaseRecommender;
    }

    public void setPurchaseRecommender(String purchaseRecommender) {
        this.purchaseRecommender = purchaseRecommender;
    }

    public Integer getContractCount() {
        return contractCount;
    }

    public void setContractCount(Integer contractCount) {
        this.contractCount = contractCount;
    }

    public Integer getPurchaseAppraiser() {
        return PurchaseAppraiser;
    }

    public void setPurchaseAppraiser(Integer purchaseAppraiser) {
        PurchaseAppraiser = purchaseAppraiser;
    }

    public Integer getRecommendVehicleCount() {
        return recommendVehicleCount;
    }

    public void setRecommendVehicleCount(Integer recommendVehicleCount) {
        this.recommendVehicleCount = recommendVehicleCount;
    }

    public String getPurchaseBrand() {
        return purchaseBrand;
    }

    public void setPurchaseBrand(String purchaseBrand) {
        this.purchaseBrand = purchaseBrand;
    }

    public String getPurchaseService() {
        return purchaseService;
    }

    public void setPurchaseService(String purchaseService) {
        this.purchaseService = purchaseService;
    }

    public Date getStartContractTime() {
        return startContractTime;
    }

    public void setStartContractTime(Date startContractTime) {
        this.startContractTime = startContractTime;
    }

    public Date getEndContractTime() {
        return endContractTime;
    }

    public void setEndContractTime(Date endContractTime) {
        this.endContractTime = endContractTime;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public List<Integer> getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(List<Integer> orgIds) {
        this.orgIds = orgIds;
    }

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerPhone() {
		return dealerPhone;
	}

	public void setDealerPhone(String dealerPhone) {
		this.dealerPhone = dealerPhone;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Date getStartDealTime() {
		return startDealTime;
	}

	public void setStartDealTime(Date startDealTime) {
		this.startDealTime = startDealTime;
	}

	public Date getEndDealTime() {
		return endDealTime;
	}

	public void setEndDealTime(Date endDealTime) {
		this.endDealTime = endDealTime;
	}

}
