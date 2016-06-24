/**
 * @Title: ClientsVO.java
 * @Package com.autostreets.model.report
 * @Description: 客户委托报表
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014年10月28日 上午11:25:43
 * @version V1.0
 * @Copyright: 2014 www.autostreets.com Inc. All rights reserved.
 * 本内容仅限于汽车街(AUTOSTREETS)内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.autostreets.biz.auction.domain;

import java.io.Serializable;
import java.util.Date;

import com.autostreets.framework.common.dal.Pagination;

/**
 * @ClassName: ClientsVO
 * @Description: 客户委托报表
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014年10月28日 上午11:25:43
 * @version V1.0
 */
public class ClientsVO implements Serializable {
    private static final long serialVersionUID = 2166949033860493736L;

    private String sid;

    private String code;

    private Short customerType;

    private String customerName;

    private String customerGender;

    private String customerTelephone;

    private String customerAddress;

    private String existingVehicleDesc;

    private String vehicleLocationProvince;

    private String vehicleLocationCity;

    private String vehicleLicense;

    private String needsVehicleDesc;

    private Date registerDatetime;

    private Short appointmentType;

    private Short assessmentStatus;

    private Date appointmentDatetime;

    private Integer appointStoreSid;

    private String appointStore;

    private Date appointDatetime;

    private String operatorName; //业务操作人

    private String remark;

    private Date startTimestamp;// 查询条件开始时间

    private Date endTimestamp;

    private Pagination pagination;
    
/*    private String customerTypeValue; //客户类型
    
    private String appointmentTypeValue; //预约类型
    
    private String assessmentStatusValue; //评估状态
*/    

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

    public Pagination getPagination() {
	return pagination;
    }

    public void setPagination(Pagination pagination) {
	this.pagination = pagination;
    }

    public String getSid() {
	return sid;
    }

    public void setSid(String sid) {
	this.sid = sid;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public Short getCustomerType() {
	return customerType;
    }

    public void setCustomerType(Short customerType) {
	this.customerType = customerType;
    }

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    public String getCustomerGender() {
	return customerGender;
    }

    public void setCustomerGender(String customerGender) {
	this.customerGender = customerGender;
    }

    public String getCustomerTelephone() {
	return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
	this.customerTelephone = customerTelephone;
    }

    public String getCustomerAddress() {
	return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
    }

    public String getExistingVehicleDesc() {
	return existingVehicleDesc;
    }

    public void setExistingVehicleDesc(String existingVehicleDesc) {
	this.existingVehicleDesc = existingVehicleDesc;
    }

    public String getVehicleLocationProvince() {
	return vehicleLocationProvince;
    }

    public void setVehicleLocationProvince(String vehicleLocationProvince) {
	this.vehicleLocationProvince = vehicleLocationProvince;
    }

    public String getVehicleLocationCity() {
	return vehicleLocationCity;
    }

    public void setVehicleLocationCity(String vehicleLocationCity) {
	this.vehicleLocationCity = vehicleLocationCity;
    }

    public String getVehicleLicense() {
	return vehicleLicense;
    }

    public void setVehicleLicense(String vehicleLicense) {
	this.vehicleLicense = vehicleLicense;
    }

    public String getNeedsVehicleDesc() {
	return needsVehicleDesc;
    }

    public void setNeedsVehicleDesc(String needsVehicleDesc) {
	this.needsVehicleDesc = needsVehicleDesc;
    }

    public Date getRegisterDatetime() {
	return registerDatetime;
    }

    public void setRegisterDatetime(Date registerDatetime) {
	this.registerDatetime = registerDatetime;
    }

    public Short getAppointmentType() {
	return appointmentType;
    }

    public void setAppointmentType(Short appointmentType) {
	this.appointmentType = appointmentType;
    }

    public Short getAssessmentStatus() {
	return assessmentStatus;
    }

    public void setAssessmentStatus(Short assessmentStatus) {
	this.assessmentStatus = assessmentStatus;
    }

    public Date getAppointmentDatetime() {
	return appointmentDatetime;
    }

    public void setAppointmentDatetime(Date appointmentDatetime) {
	this.appointmentDatetime = appointmentDatetime;
    }

    public Integer getAppointStoreSid() {
	return appointStoreSid;
    }

    public void setAppointStoreSid(Integer appointStoreSid) {
	this.appointStoreSid = appointStoreSid;
    }

    public String getAppointStore() {
	return appointStore;
    }

    public void setAppointStore(String appointStore) {
	this.appointStore = appointStore;
    }

    public Date getAppointDatetime() {
	return appointDatetime;
    }

    public void setAppointDatetime(Date appointDatetime) {
	this.appointDatetime = appointDatetime;
    }

    public String getOperatorName() {
	return operatorName;
    }

    public void setOperatorName(String operatorName) {
	this.operatorName = operatorName;
    }

    public String getRemark() {
	return remark;
    }

    public void setRemark(String remark) {
	this.remark = remark;
    }

}
