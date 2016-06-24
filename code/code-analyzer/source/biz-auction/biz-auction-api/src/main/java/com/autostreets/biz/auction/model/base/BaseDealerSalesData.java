package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseDealerSalesData implements Serializable {
    /**
     */
    private static final long serialVersionUID = -6134324773856228218L;

    private Integer id;

    private Integer orgId;

    private Date saleDate;

    private Integer inStoreAmt;

    private Integer newSaleAmt;

    private Integer replaceAmt;

    private Integer userId;

    private Date createTime;

    private Date modifyTime;

    private Boolean delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getInStoreAmt() {
        return inStoreAmt;
    }

    public void setInStoreAmt(Integer inStoreAmt) {
        this.inStoreAmt = inStoreAmt;
    }

    public Integer getNewSaleAmt() {
        return newSaleAmt;
    }

    public void setNewSaleAmt(Integer newSaleAmt) {
        this.newSaleAmt = newSaleAmt;
    }

    public Integer getReplaceAmt() {
        return replaceAmt;
    }

    public void setReplaceAmt(Integer replaceAmt) {
        this.replaceAmt = replaceAmt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}