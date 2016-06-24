package com.autostreets.biz.auction.model;

import java.util.List;

import com.autostreets.biz.auction.model.base.BaseDealerUsedVehicle;

public class DealerUsedVehicle extends BaseDealerUsedVehicle {

    private static final long serialVersionUID = 6543640084482898760L;

    private String searchBrandId;

    private String searchLicenseCode;

    private String searchVehiclePpe;

    private Boolean searchRetire;

    private Integer searchSaleStatus;

    private Integer searchOrgId;

    private List<Integer> orgScopeList;

    private String orgName;

    public String getSearchBrandId() {
        return searchBrandId;
    }

    public void setSearchBrandId(String searchBrandId) {
        this.searchBrandId = searchBrandId;
    }

    public String getSearchLicenseCode() {
        return searchLicenseCode;
    }

    public void setSearchLicenseCode(String searchLicenseCode) {
        this.searchLicenseCode = searchLicenseCode;
    }

    public String getSearchVehiclePpe() {
        return searchVehiclePpe;
    }

    public void setSearchVehiclePpe(String searchVehiclePpe) {
        this.searchVehiclePpe = searchVehiclePpe;
    }

    public Integer getSearchSaleStatus() {
        return searchSaleStatus;
    }

    public void setSearchSaleStatus(Integer searchSaleStatus) {
        this.searchSaleStatus = searchSaleStatus;
    }

    public Boolean getSearchRetire() {
        return searchRetire;
    }

    public void setSearchRetire(Boolean searchRetire) {
        this.searchRetire = searchRetire;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<Integer> getOrgScopeList() {
        return orgScopeList;
    }

    public void setOrgScopeList(List<Integer> orgScopeList) {
        this.orgScopeList = orgScopeList;
    }

    public Integer getSearchOrgId() {
        return searchOrgId;
    }

    public void setSearchOrgId(Integer searchOrgId) {
        this.searchOrgId = searchOrgId;
    }
}