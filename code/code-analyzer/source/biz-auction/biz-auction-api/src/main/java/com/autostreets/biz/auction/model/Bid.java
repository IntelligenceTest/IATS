package com.autostreets.biz.auction.model;

import java.util.ArrayList;
import java.util.List;

import com.autostreets.biz.auction.model.base.BaseBid;
import com.autostreets.framework.common.dal.Pagination;

public class Bid extends BaseBid {

    /**
     */
    private static final long serialVersionUID = -7003615641469271343L;

    private String brand;

    private String type;

    private String startTimestamp;

    private String endTimestamp;

    private Integer status;

    private String license_code;

    private String evaluation_dept;

    private ArrayList<String> statusList;

    private String code;

    private String city;

    private String avType;

    private String source;

    private Pagination pagination;

    private List<Integer> vehicleSrcIds;

    private Integer vehicleSrcId;

    private String creatorName;// 发拍人

    private Integer creatorId;// 发拍人Id

    private List<Integer> orgIds;

    private Boolean isSingle;

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand
     *            the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the startTimestamp
     */
    public String getStartTimestamp() {
        return startTimestamp;
    }

    /**
     * @param startTimestamp
     *            the startTimestamp to set
     */
    public void setStartTimestamp(String startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    /**
     * @return the endTimestamp
     */
    public String getEndTimestamp() {
        return endTimestamp;
    }

    /**
     * @param endTimestamp
     *            the endTimestamp to set
     */
    public void setEndTimestamp(String endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the license_code
     */
    public String getLicense_code() {
        return license_code;
    }

    /**
     * @param license_code
     *            the license_code to set
     */
    public void setLicense_code(String license_code) {
        this.license_code = license_code;
    }

    /**
     * @return the evaluation_dept
     */
    public String getEvaluation_dept() {
        return evaluation_dept;
    }

    /**
     * @param evaluation_dept
     *            the evaluation_dept to set
     */
    public void setEvaluation_dept(String evaluation_dept) {
        this.evaluation_dept = evaluation_dept;
    }

    /**
     * @return the statusList
     */
    public ArrayList<String> getStatusList() {
        return statusList;
    }

    /**
     * @param statusList
     *            the statusList to set
     */
    public void setStatusList(ArrayList<String> statusList) {
        this.statusList = statusList;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the avType
     */
    public String getAvType() {
        return avType;
    }

    /**
     * @param avType
     *            the avType to set
     */
    public void setAvType(String avType) {
        this.avType = avType;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     *            the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * @param pagination
     *            the pagination to set
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Integer> getVehicleSrcIds() {
        return vehicleSrcIds;
    }

    public void setVehicleSrcIds(List<Integer> vehicleSrcIds) {
        this.vehicleSrcIds = vehicleSrcIds;
    }

    public Integer getVehicleSrcId() {
        return vehicleSrcId;
    }

    public void setVehicleSrcId(Integer vehicleSrcId) {
        this.vehicleSrcId = vehicleSrcId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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

    /**
     * @return the isSingle
     */
    public Boolean getIsSingle() {
        return isSingle;
    }

    /**
     * @param isSingle
     *            the isSingle to set
     */
    public void setIsSingle(Boolean isSingle) {
        this.isSingle = isSingle;
    }

}
