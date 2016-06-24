package com.autostreets.biz.auction.model;

import java.math.BigDecimal;
import java.util.Date;

import com.autostreets.biz.auction.model.base.BaseFixedPrice;
import com.autostreets.framework.common.dal.Pagination;

public class FixedPrice extends BaseFixedPrice {

    private static final long serialVersionUID = -5744714878975280051L;

    private Vehicle vehicle = new Vehicle();
    private Order order = new Order();
    private OrderItem orderItem = new OrderItem();
    private String client;
    private Pagination pagination; // 分页
    private String orderByClause; // 排序
    private String memberName;
    private String allIds;
    private Boolean isStore; // 门店权限控制
    private Boolean isRecommend;// true 代表已推荐
    private String parentName;// 车辆所属门店名称，只用于页面查询传值
    private Date startTimestamp;
    private Date endTimestamp;
    private int salingdays;//展售时长
    private Date startOffShelvesTime;//下架时间区间
    private Date endOffShelvesTime;
    private boolean isDealer;

    
    public Date getStartOffShelvesTime() {
        return startOffShelvesTime;
    }

    
    public void setStartOffShelvesTime(Date startOffShelvesTime) {
        this.startOffShelvesTime = startOffShelvesTime;
    }

    
    public Date getEndOffShelvesTime() {
        return endOffShelvesTime;
    }

    
    public void setEndOffShelvesTime(Date endOffShelvesTime) {
        this.endOffShelvesTime = endOffShelvesTime;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public String getAllIds() {
        return allIds;
    }

    public void setAllIds(String allIds) {
        this.allIds = allIds;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Boolean getIsStore() {
        return isStore;
    }

    public void setIsStore(Boolean isStore) {
        this.isStore = isStore;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public BigDecimal getPriceNewcar() {
        return priceNewcar;
    }

    public void setPriceNewcar(BigDecimal priceNewcar) {
        this.priceNewcar = priceNewcar;
    }

    public int getSalingdays() {
        return salingdays;
    }

    public void setSalingdays(int salingdays) {
        this.salingdays = salingdays;
    }

    private BigDecimal priceNewcar;

    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean isDealer) {
        this.isDealer = isDealer;
    }

}
