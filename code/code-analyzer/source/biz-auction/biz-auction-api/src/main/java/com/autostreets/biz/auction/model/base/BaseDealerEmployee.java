package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseDealerEmployee implements Serializable {
    /**
     */
    private static final long serialVersionUID = 4325920137419650409L;

    //主键
    private Integer id;

    //门店id
    private Integer orgId;

    //姓名
    private String name;

    //员工号
    private Integer employeeNo;

    //团队号
    private Integer groupId;


    //团队类型：1推荐人 2评估师
    private Integer type;


    //是否启用（0、停用 1、启用）
    private Boolean enable;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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