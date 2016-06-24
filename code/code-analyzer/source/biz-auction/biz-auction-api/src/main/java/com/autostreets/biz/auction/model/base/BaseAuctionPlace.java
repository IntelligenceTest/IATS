package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAuctionPlace implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 849382712130371958L;

	private Integer id;

    private String name;

    private String province;

    private String city;

    private String addr;

    private String telephone;

    private String period;

    private String picUrl;

    private String banner1Url;

    private String banner2Url;

    private String banner3Url;

    private String remark;

    private Date createdTime;

    private Date modifyTime;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getBanner1Url() {
        return banner1Url;
    }

    public void setBanner1Url(String banner1Url) {
        this.banner1Url = banner1Url == null ? null : banner1Url.trim();
    }

    public String getBanner2Url() {
        return banner2Url;
    }

    public void setBanner2Url(String banner2Url) {
        this.banner2Url = banner2Url == null ? null : banner2Url.trim();
    }

    public String getBanner3Url() {
        return banner3Url;
    }

    public void setBanner3Url(String banner3Url) {
        this.banner3Url = banner3Url == null ? null : banner3Url.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}