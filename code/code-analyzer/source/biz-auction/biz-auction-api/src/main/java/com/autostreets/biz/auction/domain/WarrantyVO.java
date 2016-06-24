/**  
* @Title: WarrantyVO.java
* @Package com.autostreets.model.report
* @Description: 质保申请报表
* @author yanqing.luo （roceys#gmail.com）
* @date 2014年10月27日 上午10:53:16
* @version V1.0 
* @Copyright: 2014 www.autostreets.com Inc. All rights reserved.  
* 本内容仅限于汽车街(AUTOSTREETS)内部传阅，禁止外泄以及用于其他的商业目的 
*/ 
package com.autostreets.biz.auction.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.autostreets.framework.common.dal.Pagination;

/**
 * @ClassName: WarrantyVO
 * @Description: 质保申请报表
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014年10月27日 上午10:53:16
 * @version V1.0
 */
public class WarrantyVO implements Serializable {
    private static final long serialVersionUID = -2831704239840215182L;

    private Integer sid;

    private Integer status;

    private String name;

    private Integer gender;

    private String cellphone;

    private String city;

    private String brand;

    private String vehicleModel;

    private String mileage;

    private String enginePower;

    private Date buyTime;

    private Integer warrantyPeriod;

    private BigDecimal warrantyMileage;

    private BigDecimal salePrice;

    private Date applyTime;

    private String remark;

    private Date createdTime;
    
    private Date startTimestamp;// 查询条件开始时间
    
    private Date endTimestamp;
    
    private Pagination pagination;
    
    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Integer getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public BigDecimal getWarrantyMileage() {
        return warrantyMileage;
    }

    public void setWarrantyMileage(BigDecimal warrantyMileage) {
        this.warrantyMileage = warrantyMileage;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
    
}
