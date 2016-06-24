package com.autostreets.biz.auction.model;

import java.util.List;

import com.autostreets.biz.auction.model.base.BaseAuction;

public class Auction extends BaseAuction {

    /**
     */
    private static final long serialVersionUID = 2380602646013786575L;

    private List<Integer> orgIds;

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
    private String placeCity;

    public String getPlaceCity() {
        return placeCity;
    }

    public void setPlaceCity(String placeCity) {
        this.placeCity = placeCity;
    }

}
