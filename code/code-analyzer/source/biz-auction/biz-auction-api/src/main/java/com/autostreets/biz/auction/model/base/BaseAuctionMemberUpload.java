package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAuctionMemberUpload implements Serializable {

    private static final long serialVersionUID = 1385899376899181854L;

    private Integer id;

    private Integer auctionId;

    private String name;

    private String idCardNum;

    private String cellphone;

    private Integer auctionNumber;

    private String wechat;

    private String province;

    private String city;

    private Date registerTime;

    private Date createTime;

    private Integer createdBy;

    private Boolean delFlag;

    public BaseAuctionMemberUpload(Integer id, Integer auctionId, String name, String idCardNum, String cellphone, Integer auctionNumber, String wechat, String province, String city, Date registerTime, Date createTime, Integer createdBy, Boolean delFlag) {
        this.id = id;
        this.auctionId = auctionId;
        this.name = name;
        this.idCardNum = idCardNum;
        this.cellphone = cellphone;
        this.auctionNumber = auctionNumber;
        this.wechat = wechat;
        this.province = province;
        this.city = city;
        this.registerTime = registerTime;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.delFlag = delFlag;
    }

    public BaseAuctionMemberUpload() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum == null ? null : idCardNum.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public Integer getAuctionNumber() {
        return auctionNumber;
    }

    public void setAuctionNumber(Integer auctionNumber) {
        this.auctionNumber = auctionNumber;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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