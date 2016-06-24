package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseFixedPrice implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2947435417451933569L;

    // 主键
    private Integer id;

    // 展品编号
    private String code;

    // 车辆id
    private Integer vehicleId;

    // 预订定金
    private BigDecimal deposit;

    // 展销价格
    private BigDecimal price;

    // 集团限价
    private BigDecimal lowPriceGroup;

    // 是否有购置税价格：0-无、1-有
    private Boolean hasTaxBuy;

    // 购置税价格
    private BigDecimal taxBuy;

    // 展厅区域：省份
    private String province;

    // 展厅区域：城市
    private String city;

    // 车辆所在门店
    private String whereStore;

    // 车辆所在门店详细地址
    private String addressDetailStore;

    // 服务时间
    private String serviceTime;

    // 展品状态：0-上架申请、1-已下架、2-已出售、3-已上架、4-已预订、5-已付定金、6-已付全款、7-上架失败
    private Integer status;

    // 1-隐藏、0-显示
    private Boolean hidden;

    // 1-最新拍品、0-已参加过拍卖
    private Boolean latest;

    // 上架申请时间
    private Date applyShelvesTime;

    // 上架时间
    private Date sellTime;

    // 下架时间
    private Date offShelvesTime;

    // 下架原因
    private String offShelvesRemark;

    // 创建时间
    private Date createTime;

    // 最后更新时间
    private Date updateTime;

    // 是否有效标志：0-无效、1-有效
    private Boolean enabled;

    // 最后操作人
    private Integer updateUser;

    // 创建者
    private Integer createUser;

    // 车辆描述：与车辆vehicle中描述不一样
    private String memo;

    // 收藏人数
    private Integer favCount;

    // 点击数量
    private Integer clickCount;

    // 联系电话
    private String phone;

    //新车指导价
    private BigDecimal newVehicleSuggestionPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getLowPriceGroup() {
        return lowPriceGroup;
    }

    public void setLowPriceGroup(BigDecimal lowPriceGroup) {
        this.lowPriceGroup = lowPriceGroup;
    }

    public Boolean getHasTaxBuy() {
        return hasTaxBuy;
    }

    public void setHasTaxBuy(Boolean hasTaxBuy) {
        this.hasTaxBuy = hasTaxBuy;
    }

    public BigDecimal getTaxBuy() {
        return taxBuy;
    }

    public void setTaxBuy(BigDecimal taxBuy) {
        this.taxBuy = taxBuy;
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

    public String getWhereStore() {
        return whereStore;
    }

    public void setWhereStore(String whereStore) {
        this.whereStore = whereStore == null ? null : whereStore.trim();
    }

    public String getAddressDetailStore() {
        return addressDetailStore;
    }

    public void setAddressDetailStore(String addressDetailStore) {
        this.addressDetailStore = addressDetailStore == null ? null : addressDetailStore.trim();
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime == null ? null : serviceTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getLatest() {
        return latest;
    }

    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    public Date getApplyShelvesTime() {
        return applyShelvesTime;
    }

    public void setApplyShelvesTime(Date applyShelvesTime) {
        this.applyShelvesTime = applyShelvesTime;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public Date getOffShelvesTime() {
        return offShelvesTime;
    }

    public void setOffShelvesTime(Date offShelvesTime) {
        this.offShelvesTime = offShelvesTime;
    }

    public String getOffShelvesRemark() {
        return offShelvesRemark;
    }

    public void setOffShelvesRemark(String offShelvesRemark) {
        this.offShelvesRemark = offShelvesRemark == null ? null : offShelvesRemark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public BigDecimal getNewVehicleSuggestionPrice() {
        return newVehicleSuggestionPrice;
    }

    public void setNewVehicleSuggestionPrice(BigDecimal newVehicleSuggestionPrice) {
        this.newVehicleSuggestionPrice = newVehicleSuggestionPrice;
    }
}