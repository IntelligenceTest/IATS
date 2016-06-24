package com.autostreets.biz.auction.model.base;

import com.autostreets.framework.common.dal.Pagination;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseOrderItemExample implements Serializable {
    /**
     */
    private static final long serialVersionUID = -1160267413867887718L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseOrderItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPagination(Pagination pagination) {
        this.pagination=pagination;
    }

    public Pagination getPagination() {
        return pagination;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        /**
         */
        private static final long serialVersionUID = 2535828531022531838L;
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeIsNull() {
            addCriterion("license_fee is null");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeIsNotNull() {
            addCriterion("license_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeEqualTo(BigDecimal value) {
            addCriterion("license_fee =", value, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeNotEqualTo(BigDecimal value) {
            addCriterion("license_fee <>", value, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeGreaterThan(BigDecimal value) {
            addCriterion("license_fee >", value, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("license_fee >=", value, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeLessThan(BigDecimal value) {
            addCriterion("license_fee <", value, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("license_fee <=", value, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeIn(List<BigDecimal> values) {
            addCriterion("license_fee in", values, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeNotIn(List<BigDecimal> values) {
            addCriterion("license_fee not in", values, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("license_fee between", value1, value2, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("license_fee not between", value1, value2, "licenseFee");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeIsNull() {
            addCriterion("license_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeIsNotNull() {
            addCriterion("license_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeEqualTo(Integer value) {
            addCriterion("license_fee_type =", value, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeNotEqualTo(Integer value) {
            addCriterion("license_fee_type <>", value, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeGreaterThan(Integer value) {
            addCriterion("license_fee_type >", value, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("license_fee_type >=", value, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeLessThan(Integer value) {
            addCriterion("license_fee_type <", value, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("license_fee_type <=", value, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeIn(List<Integer> values) {
            addCriterion("license_fee_type in", values, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeNotIn(List<Integer> values) {
            addCriterion("license_fee_type not in", values, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("license_fee_type between", value1, value2, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andLicenseFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("license_fee_type not between", value1, value2, "licenseFeeType");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeIsNull() {
            addCriterion("ex_warehouse_fee is null");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeIsNotNull() {
            addCriterion("ex_warehouse_fee is not null");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeEqualTo(BigDecimal value) {
            addCriterion("ex_warehouse_fee =", value, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeNotEqualTo(BigDecimal value) {
            addCriterion("ex_warehouse_fee <>", value, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeGreaterThan(BigDecimal value) {
            addCriterion("ex_warehouse_fee >", value, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ex_warehouse_fee >=", value, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeLessThan(BigDecimal value) {
            addCriterion("ex_warehouse_fee <", value, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ex_warehouse_fee <=", value, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeIn(List<BigDecimal> values) {
            addCriterion("ex_warehouse_fee in", values, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeNotIn(List<BigDecimal> values) {
            addCriterion("ex_warehouse_fee not in", values, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ex_warehouse_fee between", value1, value2, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andExWarehouseFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ex_warehouse_fee not between", value1, value2, "exWarehouseFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeIsNull() {
            addCriterion("parking_fee is null");
            return (Criteria) this;
        }

        public Criteria andParkingFeeIsNotNull() {
            addCriterion("parking_fee is not null");
            return (Criteria) this;
        }

        public Criteria andParkingFeeEqualTo(BigDecimal value) {
            addCriterion("parking_fee =", value, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeNotEqualTo(BigDecimal value) {
            addCriterion("parking_fee <>", value, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeGreaterThan(BigDecimal value) {
            addCriterion("parking_fee >", value, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("parking_fee >=", value, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeLessThan(BigDecimal value) {
            addCriterion("parking_fee <", value, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("parking_fee <=", value, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeIn(List<BigDecimal> values) {
            addCriterion("parking_fee in", values, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeNotIn(List<BigDecimal> values) {
            addCriterion("parking_fee not in", values, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("parking_fee between", value1, value2, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andParkingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("parking_fee not between", value1, value2, "parkingFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeIsNull() {
            addCriterion("traffic_fee is null");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeIsNotNull() {
            addCriterion("traffic_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeEqualTo(BigDecimal value) {
            addCriterion("traffic_fee =", value, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeNotEqualTo(BigDecimal value) {
            addCriterion("traffic_fee <>", value, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeGreaterThan(BigDecimal value) {
            addCriterion("traffic_fee >", value, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("traffic_fee >=", value, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeLessThan(BigDecimal value) {
            addCriterion("traffic_fee <", value, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("traffic_fee <=", value, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeIn(List<BigDecimal> values) {
            addCriterion("traffic_fee in", values, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeNotIn(List<BigDecimal> values) {
            addCriterion("traffic_fee not in", values, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("traffic_fee between", value1, value2, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("traffic_fee not between", value1, value2, "trafficFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeIsNull() {
            addCriterion("traffic_violation_fee is null");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeIsNotNull() {
            addCriterion("traffic_violation_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeEqualTo(BigDecimal value) {
            addCriterion("traffic_violation_fee =", value, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeNotEqualTo(BigDecimal value) {
            addCriterion("traffic_violation_fee <>", value, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeGreaterThan(BigDecimal value) {
            addCriterion("traffic_violation_fee >", value, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("traffic_violation_fee >=", value, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeLessThan(BigDecimal value) {
            addCriterion("traffic_violation_fee <", value, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("traffic_violation_fee <=", value, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeIn(List<BigDecimal> values) {
            addCriterion("traffic_violation_fee in", values, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeNotIn(List<BigDecimal> values) {
            addCriterion("traffic_violation_fee not in", values, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("traffic_violation_fee between", value1, value2, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andTrafficViolationFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("traffic_violation_fee not between", value1, value2, "trafficViolationFee");
            return (Criteria) this;
        }

        public Criteria andBidIdIsNull() {
            addCriterion("bid_id is null");
            return (Criteria) this;
        }

        public Criteria andBidIdIsNotNull() {
            addCriterion("bid_id is not null");
            return (Criteria) this;
        }

        public Criteria andBidIdEqualTo(Integer value) {
            addCriterion("bid_id =", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotEqualTo(Integer value) {
            addCriterion("bid_id <>", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdGreaterThan(Integer value) {
            addCriterion("bid_id >", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_id >=", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdLessThan(Integer value) {
            addCriterion("bid_id <", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdLessThanOrEqualTo(Integer value) {
            addCriterion("bid_id <=", value, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdIn(List<Integer> values) {
            addCriterion("bid_id in", values, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotIn(List<Integer> values) {
            addCriterion("bid_id not in", values, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdBetween(Integer value1, Integer value2) {
            addCriterion("bid_id between", value1, value2, "bidId");
            return (Criteria) this;
        }

        public Criteria andBidIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_id not between", value1, value2, "bidId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNull() {
            addCriterion("vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNotNull() {
            addCriterion("vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdEqualTo(Integer value) {
            addCriterion("vehicle_id =", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotEqualTo(Integer value) {
            addCriterion("vehicle_id <>", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThan(Integer value) {
            addCriterion("vehicle_id >", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id >=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThan(Integer value) {
            addCriterion("vehicle_id <", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id <=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIn(List<Integer> values) {
            addCriterion("vehicle_id in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotIn(List<Integer> values) {
            addCriterion("vehicle_id not in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id not between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdIsNull() {
            addCriterion("auction_vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdIsNotNull() {
            addCriterion("auction_vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdEqualTo(Integer value) {
            addCriterion("auction_vehicle_id =", value, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdNotEqualTo(Integer value) {
            addCriterion("auction_vehicle_id <>", value, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdGreaterThan(Integer value) {
            addCriterion("auction_vehicle_id >", value, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("auction_vehicle_id >=", value, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdLessThan(Integer value) {
            addCriterion("auction_vehicle_id <", value, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdLessThanOrEqualTo(Integer value) {
            addCriterion("auction_vehicle_id <=", value, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdIn(List<Integer> values) {
            addCriterion("auction_vehicle_id in", values, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdNotIn(List<Integer> values) {
            addCriterion("auction_vehicle_id not in", values, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdBetween(Integer value1, Integer value2) {
            addCriterion("auction_vehicle_id between", value1, value2, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("auction_vehicle_id not between", value1, value2, "auctionVehicleId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidIsNull() {
            addCriterion("guarantee_sid is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidIsNotNull() {
            addCriterion("guarantee_sid is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidEqualTo(String value) {
            addCriterion("guarantee_sid =", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidNotEqualTo(String value) {
            addCriterion("guarantee_sid <>", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidGreaterThan(String value) {
            addCriterion("guarantee_sid >", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_sid >=", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidLessThan(String value) {
            addCriterion("guarantee_sid <", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidLessThanOrEqualTo(String value) {
            addCriterion("guarantee_sid <=", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidLike(String value) {
            addCriterion("guarantee_sid like", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidNotLike(String value) {
            addCriterion("guarantee_sid not like", value, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidIn(List<String> values) {
            addCriterion("guarantee_sid in", values, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidNotIn(List<String> values) {
            addCriterion("guarantee_sid not in", values, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidBetween(String value1, String value2) {
            addCriterion("guarantee_sid between", value1, value2, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSidNotBetween(String value1, String value2) {
            addCriterion("guarantee_sid not between", value1, value2, "guaranteeSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidIsNull() {
            addCriterion("recondition_sid is null");
            return (Criteria) this;
        }

        public Criteria andReconditionSidIsNotNull() {
            addCriterion("recondition_sid is not null");
            return (Criteria) this;
        }

        public Criteria andReconditionSidEqualTo(String value) {
            addCriterion("recondition_sid =", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidNotEqualTo(String value) {
            addCriterion("recondition_sid <>", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidGreaterThan(String value) {
            addCriterion("recondition_sid >", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidGreaterThanOrEqualTo(String value) {
            addCriterion("recondition_sid >=", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidLessThan(String value) {
            addCriterion("recondition_sid <", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidLessThanOrEqualTo(String value) {
            addCriterion("recondition_sid <=", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidLike(String value) {
            addCriterion("recondition_sid like", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidNotLike(String value) {
            addCriterion("recondition_sid not like", value, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidIn(List<String> values) {
            addCriterion("recondition_sid in", values, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidNotIn(List<String> values) {
            addCriterion("recondition_sid not in", values, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidBetween(String value1, String value2) {
            addCriterion("recondition_sid between", value1, value2, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andReconditionSidNotBetween(String value1, String value2) {
            addCriterion("recondition_sid not between", value1, value2, "reconditionSid");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampIsNull() {
            addCriterion("created_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampIsNotNull() {
            addCriterion("created_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampEqualTo(Date value) {
            addCriterion("created_timestamp =", value, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampNotEqualTo(Date value) {
            addCriterion("created_timestamp <>", value, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampGreaterThan(Date value) {
            addCriterion("created_timestamp >", value, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("created_timestamp >=", value, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampLessThan(Date value) {
            addCriterion("created_timestamp <", value, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampLessThanOrEqualTo(Date value) {
            addCriterion("created_timestamp <=", value, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampIn(List<Date> values) {
            addCriterion("created_timestamp in", values, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampNotIn(List<Date> values) {
            addCriterion("created_timestamp not in", values, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampBetween(Date value1, Date value2) {
            addCriterion("created_timestamp between", value1, value2, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreatedTimestampNotBetween(Date value1, Date value2) {
            addCriterion("created_timestamp not between", value1, value2, "createdTimestamp");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNull() {
            addCriterion("final_price is null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNotNull() {
            addCriterion("final_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceEqualTo(BigDecimal value) {
            addCriterion("final_price =", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotEqualTo(BigDecimal value) {
            addCriterion("final_price <>", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThan(BigDecimal value) {
            addCriterion("final_price >", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_price >=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThan(BigDecimal value) {
            addCriterion("final_price <", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_price <=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIn(List<BigDecimal> values) {
            addCriterion("final_price in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotIn(List<BigDecimal> values) {
            addCriterion("final_price not in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_price between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_price not between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIsNull() {
            addCriterion("settle_price is null");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIsNotNull() {
            addCriterion("settle_price is not null");
            return (Criteria) this;
        }

        public Criteria andSettlePriceEqualTo(BigDecimal value) {
            addCriterion("settle_price =", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotEqualTo(BigDecimal value) {
            addCriterion("settle_price <>", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceGreaterThan(BigDecimal value) {
            addCriterion("settle_price >", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_price >=", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceLessThan(BigDecimal value) {
            addCriterion("settle_price <", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_price <=", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIn(List<BigDecimal> values) {
            addCriterion("settle_price in", values, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotIn(List<BigDecimal> values) {
            addCriterion("settle_price not in", values, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_price between", value1, value2, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_price not between", value1, value2, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(BigDecimal value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDealTypeIsNull() {
            addCriterion("deal_type is null");
            return (Criteria) this;
        }

        public Criteria andDealTypeIsNotNull() {
            addCriterion("deal_type is not null");
            return (Criteria) this;
        }

        public Criteria andDealTypeEqualTo(Integer value) {
            addCriterion("deal_type =", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotEqualTo(Integer value) {
            addCriterion("deal_type <>", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeGreaterThan(Integer value) {
            addCriterion("deal_type >", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_type >=", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeLessThan(Integer value) {
            addCriterion("deal_type <", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeLessThanOrEqualTo(Integer value) {
            addCriterion("deal_type <=", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeIn(List<Integer> values) {
            addCriterion("deal_type in", values, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotIn(List<Integer> values) {
            addCriterion("deal_type not in", values, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeBetween(Integer value1, Integer value2) {
            addCriterion("deal_type between", value1, value2, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_type not between", value1, value2, "dealType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIsNull() {
            addCriterion("sale_type is null");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIsNotNull() {
            addCriterion("sale_type is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTypeEqualTo(Integer value) {
            addCriterion("sale_type =", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotEqualTo(Integer value) {
            addCriterion("sale_type <>", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeGreaterThan(Integer value) {
            addCriterion("sale_type >", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_type >=", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeLessThan(Integer value) {
            addCriterion("sale_type <", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sale_type <=", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIn(List<Integer> values) {
            addCriterion("sale_type in", values, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotIn(List<Integer> values) {
            addCriterion("sale_type not in", values, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeBetween(Integer value1, Integer value2) {
            addCriterion("sale_type between", value1, value2, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_type not between", value1, value2, "saleType");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeIsNull() {
            addCriterion("client_commission_fee is null");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeIsNotNull() {
            addCriterion("client_commission_fee is not null");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeEqualTo(BigDecimal value) {
            addCriterion("client_commission_fee =", value, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeNotEqualTo(BigDecimal value) {
            addCriterion("client_commission_fee <>", value, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeGreaterThan(BigDecimal value) {
            addCriterion("client_commission_fee >", value, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("client_commission_fee >=", value, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeLessThan(BigDecimal value) {
            addCriterion("client_commission_fee <", value, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("client_commission_fee <=", value, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeIn(List<BigDecimal> values) {
            addCriterion("client_commission_fee in", values, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeNotIn(List<BigDecimal> values) {
            addCriterion("client_commission_fee not in", values, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("client_commission_fee between", value1, value2, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andClientCommissionFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("client_commission_fee not between", value1, value2, "clientCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeIsNull() {
            addCriterion("buyer_commission_fee is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeIsNotNull() {
            addCriterion("buyer_commission_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_fee =", value, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeNotEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_fee <>", value, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeGreaterThan(BigDecimal value) {
            addCriterion("buyer_commission_fee >", value, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_fee >=", value, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeLessThan(BigDecimal value) {
            addCriterion("buyer_commission_fee <", value, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_fee <=", value, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeIn(List<BigDecimal> values) {
            addCriterion("buyer_commission_fee in", values, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeNotIn(List<BigDecimal> values) {
            addCriterion("buyer_commission_fee not in", values, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyer_commission_fee between", value1, value2, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyer_commission_fee not between", value1, value2, "buyerCommissionFee");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andPrePriceIsNull() {
            addCriterion("pre_price is null");
            return (Criteria) this;
        }

        public Criteria andPrePriceIsNotNull() {
            addCriterion("pre_price is not null");
            return (Criteria) this;
        }

        public Criteria andPrePriceEqualTo(BigDecimal value) {
            addCriterion("pre_price =", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceNotEqualTo(BigDecimal value) {
            addCriterion("pre_price <>", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceGreaterThan(BigDecimal value) {
            addCriterion("pre_price >", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_price >=", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceLessThan(BigDecimal value) {
            addCriterion("pre_price <", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_price <=", value, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceIn(List<BigDecimal> values) {
            addCriterion("pre_price in", values, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceNotIn(List<BigDecimal> values) {
            addCriterion("pre_price not in", values, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_price between", value1, value2, "prePrice");
            return (Criteria) this;
        }

        public Criteria andPrePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_price not between", value1, value2, "prePrice");
            return (Criteria) this;
        }

        public Criteria andFinAuditIsNull() {
            addCriterion("fin_audit is null");
            return (Criteria) this;
        }

        public Criteria andFinAuditIsNotNull() {
            addCriterion("fin_audit is not null");
            return (Criteria) this;
        }

        public Criteria andFinAuditEqualTo(Integer value) {
            addCriterion("fin_audit =", value, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditNotEqualTo(Integer value) {
            addCriterion("fin_audit <>", value, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditGreaterThan(Integer value) {
            addCriterion("fin_audit >", value, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditGreaterThanOrEqualTo(Integer value) {
            addCriterion("fin_audit >=", value, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditLessThan(Integer value) {
            addCriterion("fin_audit <", value, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditLessThanOrEqualTo(Integer value) {
            addCriterion("fin_audit <=", value, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditIn(List<Integer> values) {
            addCriterion("fin_audit in", values, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditNotIn(List<Integer> values) {
            addCriterion("fin_audit not in", values, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditBetween(Integer value1, Integer value2) {
            addCriterion("fin_audit between", value1, value2, "finAudit");
            return (Criteria) this;
        }

        public Criteria andFinAuditNotBetween(Integer value1, Integer value2) {
            addCriterion("fin_audit not between", value1, value2, "finAudit");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("is_enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("is_enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("is_enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("is_enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("is_enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("is_enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("is_enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyIsNull() {
            addCriterion("collection_party is null");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyIsNotNull() {
            addCriterion("collection_party is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyEqualTo(Integer value) {
            addCriterion("collection_party =", value, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyNotEqualTo(Integer value) {
            addCriterion("collection_party <>", value, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyGreaterThan(Integer value) {
            addCriterion("collection_party >", value, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_party >=", value, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyLessThan(Integer value) {
            addCriterion("collection_party <", value, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyLessThanOrEqualTo(Integer value) {
            addCriterion("collection_party <=", value, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyIn(List<Integer> values) {
            addCriterion("collection_party in", values, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyNotIn(List<Integer> values) {
            addCriterion("collection_party not in", values, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyBetween(Integer value1, Integer value2) {
            addCriterion("collection_party between", value1, value2, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionPartyNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_party not between", value1, value2, "collectionParty");
            return (Criteria) this;
        }

        public Criteria andCollectionModelIsNull() {
            addCriterion("collection_model is null");
            return (Criteria) this;
        }

        public Criteria andCollectionModelIsNotNull() {
            addCriterion("collection_model is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionModelEqualTo(Integer value) {
            addCriterion("collection_model =", value, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelNotEqualTo(Integer value) {
            addCriterion("collection_model <>", value, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelGreaterThan(Integer value) {
            addCriterion("collection_model >", value, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_model >=", value, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelLessThan(Integer value) {
            addCriterion("collection_model <", value, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelLessThanOrEqualTo(Integer value) {
            addCriterion("collection_model <=", value, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelIn(List<Integer> values) {
            addCriterion("collection_model in", values, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelNotIn(List<Integer> values) {
            addCriterion("collection_model not in", values, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelBetween(Integer value1, Integer value2) {
            addCriterion("collection_model between", value1, value2, "collectionModel");
            return (Criteria) this;
        }

        public Criteria andCollectionModelNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_model not between", value1, value2, "collectionModel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = -1072463694921778822L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        /**
         */
        private static final long serialVersionUID = 1882148221675756763L;

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}