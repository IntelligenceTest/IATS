package com.autostreets.biz.auction.model;

import java.util.Date;
import java.util.List;

import com.autostreets.biz.auction.model.base.BaseOrder;
import com.autostreets.framework.common.dal.Pagination;

public class Order extends BaseOrder {

    /**
     */
    private static final long serialVersionUID = -1054928825725441534L;

    private Integer productId; // 产品id

    private Integer productType; // 产品类型 【注：1.一口价；2.在线拍；3.同步拍；4.新车】

    private Integer orderType; // 订单类型 【注：1.定金;2.全额】

    private Date startDealTimestamp;

    private Date endDealTimestamp;

    private String vehicleSid; // 车辆sid

    private Vehicle vehicle; // 车辆vehicle对象

    private List<Integer> orgSids; // 门店列表

    private OrderItem item;

    private int isReviewOrder; // 是否财务审核【财务审核查询订单订单专用】

    private Pagination pagination;

    private String organSid;

    private Boolean dealerOrderStatus;// 商家后台使用，限制订单状态标示

    private Date startPayTimestamp;

    private Date endPayTimestamp;

    /**
     * @return the productType
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     * @param productType
     *            the productType to set
     */
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    /**
     * @return the orderType
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * @param orderType
     *            the orderType to set
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the startDealTimestamp
     */
    public Date getStartDealTimestamp() {
        return startDealTimestamp;
    }

    /**
     * @param startDealTimestamp
     *            the startDealTimestamp to set
     */
    public void setStartDealTimestamp(Date startDealTimestamp) {
        this.startDealTimestamp = startDealTimestamp;
    }

    /**
     * @return the endDealTimestamp
     */
    public Date getEndDealTimestamp() {
        return endDealTimestamp;
    }

    /**
     * @param endDealTimestamp
     *            the endDealTimestamp to set
     */
    public void setEndDealTimestamp(Date endDealTimestamp) {
        this.endDealTimestamp = endDealTimestamp;
    }

    /**
     * @return the vehicleSid
     */
    public String getVehicleSid() {
        return vehicleSid;
    }

    /**
     * @param vehicleSid
     *            the vehicleSid to set
     */
    public void setVehicleSid(String vehicleSid) {
        this.vehicleSid = vehicleSid;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle
     *            the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return the orgSids
     */
    public List<Integer> getOrgSids() {
        return orgSids;
    }

    /**
     * @param orgSids
     *            the orgSids to set
     */
    public void setOrgSids(List<Integer> orgSids) {
        this.orgSids = orgSids;
    }

    /**
     * @return the item
     */
    public OrderItem getItem() {
        return item;
    }

    /**
     * @param item
     *            the item to set
     */
    public void setItem(OrderItem item) {
        this.item = item;
    }

    /**
     * @return the isReviewOrder
     */
    public int getIsReviewOrder() {
        return isReviewOrder;
    }

    /**
     * @param isReviewOrder
     *            the isReviewOrder to set
     */
    public void setIsReviewOrder(int isReviewOrder) {
        this.isReviewOrder = isReviewOrder;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getOrganSid() {
        return organSid;
    }

    public void setOrganSid(String organSid) {
        this.organSid = organSid;
    }

    /**
     * @return the dealerOrderStatus
     */
    public Boolean getDealerOrderStatus() {
        return dealerOrderStatus;
    }

    /**
     * @param dealerOrderStatus
     *            the dealerOrderStatus to set
     */
    public void setDealerOrderStatus(Boolean dealerOrderStatus) {
        this.dealerOrderStatus = dealerOrderStatus;
    }

    /**
     * @return the startPayTimestamp
     */
    public Date getStartPayTimestamp() {
        return startPayTimestamp;
    }

    /**
     * @param startPayTimestamp
     *            the startPayTimestamp to set
     */
    public void setStartPayTimestamp(Date startPayTimestamp) {
        this.startPayTimestamp = startPayTimestamp;
    }

    /**
     * @return the endPayTimestamp
     */
    public Date getEndPayTimestamp() {
        return endPayTimestamp;
    }

    /**
     * @param endPayTimestamp
     *            the endPayTimestamp to set
     */
    public void setEndPayTimestamp(Date endPayTimestamp) {
        this.endPayTimestamp = endPayTimestamp;
    }
}
