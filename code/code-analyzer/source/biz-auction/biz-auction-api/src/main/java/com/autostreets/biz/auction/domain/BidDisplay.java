package com.autostreets.biz.auction.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hongwei.deng 出价显示的domain
 */
public class BidDisplay implements Serializable {

    private static final long serialVersionUID = -5983646885180502540L;
    /**
     * select av.status,a.type, v.current_city,v.brand, v.swept_volume,
     * v.vehicle_model,v.swept_volume_standard,v.selled_name,
     * av.start_price,av.reserve_price,av.plus_range,
     * av.bid_quantity,b.bid_timestamp,b.price,b.bidder_name,b.ip
     */

    private Integer id; // av_sid
    private String bidder_sid;
    private String auction_id;
    private String vehicle_id;
    private String type;
    private String current_city;
    private String brand;
    private String swept_volume;
    private String vehicle_model;
    private String swept_volume_standard;
    private String selled_name;
    private BigDecimal start_price;
    private BigDecimal reserve_price;
    private String plus_range;
    private String bid_quantity;
    private String license_code;
    private Date bid_timestamp;
    private String bidder_name;
    private String ip;
    private String status;
    private String code;
    private List<BidDisplay> bidList;
    private BigDecimal price;
    private BigDecimal maxPrice;
    private String maxPriceName;
    private String swept_volume_type;
    private String auction_type;
    private String brand_series;
    private String city;
    private String avType;
    private String source;
    private Integer avCreatedBy;
    private Integer vehicleSrcId;
    private Integer finalBidStatus;
    private String cellphone;

    public Integer getFinalBidStatus() {
        return finalBidStatus;
    }

    public void setFinalBidStatus(Integer finalBidStatus) {
        this.finalBidStatus = finalBidStatus;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrand_series() {
        return brand_series;
    }

    public void setBrand_series(String brand_series) {
        this.brand_series = brand_series;
    }

    public String getBidder_sid() {
        return bidder_sid;
    }

    public void setBidder_sid(String bidder_sid) {
        this.bidder_sid = bidder_sid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrent_city() {
        return current_city;
    }

    public void setCurrent_city(String current_city) {
        this.current_city = current_city;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSwept_volume() {
        return swept_volume;
    }

    public void setSwept_volume(String swept_volume) {
        this.swept_volume = swept_volume;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getSwept_volume_standard() {
        return swept_volume_standard;
    }

    public void setSwept_volume_standard(String swept_volume_standard) {
        this.swept_volume_standard = swept_volume_standard;
    }

    public String getSelled_name() {
        return selled_name;
    }

    public void setSelled_name(String selled_name) {
        this.selled_name = selled_name;
    }

    public BigDecimal getStart_price() {
        return start_price;
    }

    public void setStart_price(BigDecimal start_price) {
        this.start_price = start_price;
    }

    public BigDecimal getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(BigDecimal reserve_price) {
        this.reserve_price = reserve_price;
    }

    public String getPlus_range() {
        return plus_range;
    }

    public void setPlus_range(String plus_range) {
        this.plus_range = plus_range;
    }

    public String getBid_quantity() {
        return bid_quantity;
    }

    public void setBid_quantity(String bid_quantity) {
        this.bid_quantity = bid_quantity;
    }

    public String getLicense_code() {
        return license_code;
    }

    public void setLicense_code(String license_code) {
        this.license_code = license_code;
    }

    public Date getBid_timestamp() {
        return bid_timestamp;
    }

    public void setBid_timestamp(Date bid_timestamp) {
        this.bid_timestamp = bid_timestamp;
    }

    public String getBidder_name() {
        return bidder_name;
    }

    public void setBidder_name(String bidder_name) {
        this.bidder_name = bidder_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BidDisplay> getBidList() {
        return bidList;
    }

    public void setBidList(List<BidDisplay> bidList) {
        this.bidList = bidList;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMaxPriceName() {
        return maxPriceName;
    }

    public void setMaxPriceName(String maxPriceName) {
        this.maxPriceName = maxPriceName;
    }

    public String getSwept_volume_type() {
        return swept_volume_type;
    }

    public void setSwept_volume_type(String swept_volume_type) {
        this.swept_volume_type = swept_volume_type;
    }

    public String getAuction_type() {
        return auction_type;
    }

    public void setAuction_type(String auction_type) {
        this.auction_type = auction_type;
    }

    public String getAvType() {
        return avType;
    }

    public void setAvType(String avType) {
        this.avType = avType;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the auction_id
     */
    public String getAuction_id() {
        return auction_id;
    }

    /**
     * @param auction_id
     *            the auction_id to set
     */
    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    /**
     * @return the vehicle_id
     */
    public String getVehicle_id() {
        return vehicle_id;
    }

    /**
     * @param vehicle_id
     *            the vehicle_id to set
     */
    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public Integer getAvCreatedBy() {
        return avCreatedBy;
    }

    public void setAvCreatedBy(Integer avCreatedBy) {
        this.avCreatedBy = avCreatedBy;
    }

    public Integer getVehicleSrcId() {
        return vehicleSrcId;
    }

    public void setVehicleSrcId(Integer vehicleSrcId) {
        this.vehicleSrcId = vehicleSrcId;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

}
