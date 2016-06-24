package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseDealerEmployeeTarget implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2622172514736724537L;

    //主键
    private Integer id;

    //门店id
    private Integer orgId;

    //员工号
    private Integer employeeId;

    //团队号
    private Integer groupId;

    //指标的年
    private Integer year;

    //指标的月份
    private Integer month;

    //目标数量
    private Integer targetNumber;

    //目标利润
    private BigDecimal targetProfit;

    //创建时间
    private Date createTime;

    //更新时间
    private Date modifyTime;

    //创建人
    private Integer createdBy;

    //删除标记（0、未删除 1、删除）
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(Integer targetNumber) {
        this.targetNumber = targetNumber;
    }

    public BigDecimal getTargetProfit() {
        return targetProfit;
    }

    public void setTargetProfit(BigDecimal targetProfit) {
        this.targetProfit = targetProfit;
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