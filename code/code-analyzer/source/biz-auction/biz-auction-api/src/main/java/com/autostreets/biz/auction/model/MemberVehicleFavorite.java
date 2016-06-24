package com.autostreets.biz.auction.model;

import com.autostreets.biz.auction.model.base.BaseMemberVehicleFavorite;
import com.autostreets.framework.common.dal.Pagination;

public class MemberVehicleFavorite extends BaseMemberVehicleFavorite {

    private static final long serialVersionUID = -7914144536985515548L;

    private Pagination pagination;

    private AuctionVehicle auctionVehicle;

    private FixedPrice fixPrice;

    private Vehicle vehicle;

    public FixedPrice getFixPrice() {
        return fixPrice;
    }

    public void setFixPrice(FixedPrice fixPrice) {
        this.fixPrice = fixPrice;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public AuctionVehicle getAuctionVehicle() {
        return auctionVehicle;
    }

    public void setAuctionVehicle(AuctionVehicle auctionVehicle) {
        this.auctionVehicle = auctionVehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}