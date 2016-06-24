package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseUsedCarLogExample implements Serializable {

    /**
     */
    private static final long serialVersionUID = 197086153669006975L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseUsedCarLogExample() {
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
        this.pagination = pagination;
    }

    public Pagination getPagination() {
        return pagination;
    }

    protected abstract static class GeneratedCriteria implements Serializable {

        /**
         */
        private static final long serialVersionUID = -1192010997297526529L;
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

        public Criteria andFixedPriceIdIsNull() {
            addCriterion("fixed_price_id is null");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdIsNotNull() {
            addCriterion("fixed_price_id is not null");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdEqualTo(Integer value) {
            addCriterion("fixed_price_id =", value, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdNotEqualTo(Integer value) {
            addCriterion("fixed_price_id <>", value, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdGreaterThan(Integer value) {
            addCriterion("fixed_price_id >", value, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fixed_price_id >=", value, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdLessThan(Integer value) {
            addCriterion("fixed_price_id <", value, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdLessThanOrEqualTo(Integer value) {
            addCriterion("fixed_price_id <=", value, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdIn(List<Integer> values) {
            addCriterion("fixed_price_id in", values, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdNotIn(List<Integer> values) {
            addCriterion("fixed_price_id not in", values, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdBetween(Integer value1, Integer value2) {
            addCriterion("fixed_price_id between", value1, value2, "fixedPriceId");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fixed_price_id not between", value1, value2, "fixedPriceId");
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

        public Criteria andPreUsedCarStatusIsNull() {
            addCriterion("pre_used_car_status is null");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusIsNotNull() {
            addCriterion("pre_used_car_status is not null");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusEqualTo(Integer value) {
            addCriterion("pre_used_car_status =", value, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusNotEqualTo(Integer value) {
            addCriterion("pre_used_car_status <>", value, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusGreaterThan(Integer value) {
            addCriterion("pre_used_car_status >", value, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_used_car_status >=", value, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusLessThan(Integer value) {
            addCriterion("pre_used_car_status <", value, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pre_used_car_status <=", value, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusIn(List<Integer> values) {
            addCriterion("pre_used_car_status in", values, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusNotIn(List<Integer> values) {
            addCriterion("pre_used_car_status not in", values, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusBetween(Integer value1, Integer value2) {
            addCriterion("pre_used_car_status between", value1, value2, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreUsedCarStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_used_car_status not between", value1, value2, "preUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusIsNull() {
            addCriterion("current_used_car_status is null");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusIsNotNull() {
            addCriterion("current_used_car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusEqualTo(Integer value) {
            addCriterion("current_used_car_status =", value, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusNotEqualTo(Integer value) {
            addCriterion("current_used_car_status <>", value, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusGreaterThan(Integer value) {
            addCriterion("current_used_car_status >", value, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_used_car_status >=", value, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusLessThan(Integer value) {
            addCriterion("current_used_car_status <", value, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusLessThanOrEqualTo(Integer value) {
            addCriterion("current_used_car_status <=", value, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusIn(List<Integer> values) {
            addCriterion("current_used_car_status in", values, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusNotIn(List<Integer> values) {
            addCriterion("current_used_car_status not in", values, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusBetween(Integer value1, Integer value2) {
            addCriterion("current_used_car_status between", value1, value2, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentUsedCarStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("current_used_car_status not between", value1, value2, "currentUsedCarStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusIsNull() {
            addCriterion("pre_vehicle_sale_status is null");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusIsNotNull() {
            addCriterion("pre_vehicle_sale_status is not null");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusEqualTo(Integer value) {
            addCriterion("pre_vehicle_sale_status =", value, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusNotEqualTo(Integer value) {
            addCriterion("pre_vehicle_sale_status <>", value, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusGreaterThan(Integer value) {
            addCriterion("pre_vehicle_sale_status >", value, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_vehicle_sale_status >=", value, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusLessThan(Integer value) {
            addCriterion("pre_vehicle_sale_status <", value, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pre_vehicle_sale_status <=", value, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusIn(List<Integer> values) {
            addCriterion("pre_vehicle_sale_status in", values, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusNotIn(List<Integer> values) {
            addCriterion("pre_vehicle_sale_status not in", values, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusBetween(Integer value1, Integer value2) {
            addCriterion("pre_vehicle_sale_status between", value1, value2, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreVehicleSaleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_vehicle_sale_status not between", value1, value2, "preVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusIsNull() {
            addCriterion("current_vehicle_sale_status is null");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusIsNotNull() {
            addCriterion("current_vehicle_sale_status is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusEqualTo(Integer value) {
            addCriterion("current_vehicle_sale_status =", value, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusNotEqualTo(Integer value) {
            addCriterion("current_vehicle_sale_status <>", value, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusGreaterThan(Integer value) {
            addCriterion("current_vehicle_sale_status >", value, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_vehicle_sale_status >=", value, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusLessThan(Integer value) {
            addCriterion("current_vehicle_sale_status <", value, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("current_vehicle_sale_status <=", value, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusIn(List<Integer> values) {
            addCriterion("current_vehicle_sale_status in", values, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusNotIn(List<Integer> values) {
            addCriterion("current_vehicle_sale_status not in", values, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusBetween(Integer value1, Integer value2) {
            addCriterion("current_vehicle_sale_status between", value1, value2, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentVehicleSaleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("current_vehicle_sale_status not between", value1, value2, "currentVehicleSaleStatus");
            return (Criteria) this;
        }

        public Criteria andPreLatestIsNull() {
            addCriterion("pre_latest is null");
            return (Criteria) this;
        }

        public Criteria andPreLatestIsNotNull() {
            addCriterion("pre_latest is not null");
            return (Criteria) this;
        }

        public Criteria andPreLatestEqualTo(Boolean value) {
            addCriterion("pre_latest =", value, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestNotEqualTo(Boolean value) {
            addCriterion("pre_latest <>", value, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestGreaterThan(Boolean value) {
            addCriterion("pre_latest >", value, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pre_latest >=", value, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestLessThan(Boolean value) {
            addCriterion("pre_latest <", value, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestLessThanOrEqualTo(Boolean value) {
            addCriterion("pre_latest <=", value, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestIn(List<Boolean> values) {
            addCriterion("pre_latest in", values, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestNotIn(List<Boolean> values) {
            addCriterion("pre_latest not in", values, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestBetween(Boolean value1, Boolean value2) {
            addCriterion("pre_latest between", value1, value2, "preLatest");
            return (Criteria) this;
        }

        public Criteria andPreLatestNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pre_latest not between", value1, value2, "preLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestIsNull() {
            addCriterion("current_latest is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestIsNotNull() {
            addCriterion("current_latest is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestEqualTo(Boolean value) {
            addCriterion("current_latest =", value, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestNotEqualTo(Boolean value) {
            addCriterion("current_latest <>", value, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestGreaterThan(Boolean value) {
            addCriterion("current_latest >", value, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestGreaterThanOrEqualTo(Boolean value) {
            addCriterion("current_latest >=", value, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestLessThan(Boolean value) {
            addCriterion("current_latest <", value, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestLessThanOrEqualTo(Boolean value) {
            addCriterion("current_latest <=", value, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestIn(List<Boolean> values) {
            addCriterion("current_latest in", values, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestNotIn(List<Boolean> values) {
            addCriterion("current_latest not in", values, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestBetween(Boolean value1, Boolean value2) {
            addCriterion("current_latest between", value1, value2, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andCurrentLatestNotBetween(Boolean value1, Boolean value2) {
            addCriterion("current_latest not between", value1, value2, "currentLatest");
            return (Criteria) this;
        }

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("action like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("action not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("action not between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperaterIsNull() {
            addCriterion("operater is null");
            return (Criteria) this;
        }

        public Criteria andOperaterIsNotNull() {
            addCriterion("operater is not null");
            return (Criteria) this;
        }

        public Criteria andOperaterEqualTo(String value) {
            addCriterion("operater =", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotEqualTo(String value) {
            addCriterion("operater <>", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterGreaterThan(String value) {
            addCriterion("operater >", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterGreaterThanOrEqualTo(String value) {
            addCriterion("operater >=", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLessThan(String value) {
            addCriterion("operater <", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLessThanOrEqualTo(String value) {
            addCriterion("operater <=", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLike(String value) {
            addCriterion("operater like", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotLike(String value) {
            addCriterion("operater not like", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterIn(List<String> values) {
            addCriterion("operater in", values, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotIn(List<String> values) {
            addCriterion("operater not in", values, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterBetween(String value1, String value2) {
            addCriterion("operater between", value1, value2, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotBetween(String value1, String value2) {
            addCriterion("operater not between", value1, value2, "operater");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andActionLikeInsensitive(String value) {
            addCriterion("upper(action) like", value.toUpperCase(), "action");
            return (Criteria) this;
        }

        public Criteria andOperaterLikeInsensitive(String value) {
            addCriterion("upper(operater) like", value.toUpperCase(), "operater");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = 8931692552933912577L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
         */
        private static final long serialVersionUID = 1727827274789812034L;

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