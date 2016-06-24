package com.autostreets.biz.auction.model.base;

import com.autostreets.framework.common.dal.Pagination;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseAuctionVehicleLogExample implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2044973837363522920L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseAuctionVehicleLogExample() {
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
		 * 
		 */
		private static final long serialVersionUID = -8008887648169743690L;
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

        public Criteria andAvIdIsNull() {
            addCriterion("av_id is null");
            return (Criteria) this;
        }

        public Criteria andAvIdIsNotNull() {
            addCriterion("av_id is not null");
            return (Criteria) this;
        }

        public Criteria andAvIdEqualTo(Integer value) {
            addCriterion("av_id =", value, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdNotEqualTo(Integer value) {
            addCriterion("av_id <>", value, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdGreaterThan(Integer value) {
            addCriterion("av_id >", value, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("av_id >=", value, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdLessThan(Integer value) {
            addCriterion("av_id <", value, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdLessThanOrEqualTo(Integer value) {
            addCriterion("av_id <=", value, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdIn(List<Integer> values) {
            addCriterion("av_id in", values, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdNotIn(List<Integer> values) {
            addCriterion("av_id not in", values, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdBetween(Integer value1, Integer value2) {
            addCriterion("av_id between", value1, value2, "avId");
            return (Criteria) this;
        }

        public Criteria andAvIdNotBetween(Integer value1, Integer value2) {
            addCriterion("av_id not between", value1, value2, "avId");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
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

        public Criteria andOperationTypeIsNull() {
            addCriterion("operation_type is null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNotNull() {
            addCriterion("operation_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeEqualTo(String value) {
            addCriterion("operation_type =", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotEqualTo(String value) {
            addCriterion("operation_type <>", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThan(String value) {
            addCriterion("operation_type >", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("operation_type >=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThan(String value) {
            addCriterion("operation_type <", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThanOrEqualTo(String value) {
            addCriterion("operation_type <=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLike(String value) {
            addCriterion("operation_type like", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotLike(String value) {
            addCriterion("operation_type not like", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIn(List<String> values) {
            addCriterion("operation_type in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotIn(List<String> values) {
            addCriterion("operation_type not in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeBetween(String value1, String value2) {
            addCriterion("operation_type between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotBetween(String value1, String value2) {
            addCriterion("operation_type not between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andAuctionIdIsNull() {
            addCriterion("auction_id is null");
            return (Criteria) this;
        }

        public Criteria andAuctionIdIsNotNull() {
            addCriterion("auction_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionIdEqualTo(Integer value) {
            addCriterion("auction_id =", value, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdNotEqualTo(Integer value) {
            addCriterion("auction_id <>", value, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdGreaterThan(Integer value) {
            addCriterion("auction_id >", value, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("auction_id >=", value, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdLessThan(Integer value) {
            addCriterion("auction_id <", value, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdLessThanOrEqualTo(Integer value) {
            addCriterion("auction_id <=", value, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdIn(List<Integer> values) {
            addCriterion("auction_id in", values, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdNotIn(List<Integer> values) {
            addCriterion("auction_id not in", values, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdBetween(Integer value1, Integer value2) {
            addCriterion("auction_id between", value1, value2, "auctionId");
            return (Criteria) this;
        }

        public Criteria andAuctionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("auction_id not between", value1, value2, "auctionId");
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

        public Criteria andReservePriceIsNull() {
            addCriterion("reserve_price is null");
            return (Criteria) this;
        }

        public Criteria andReservePriceIsNotNull() {
            addCriterion("reserve_price is not null");
            return (Criteria) this;
        }

        public Criteria andReservePriceEqualTo(BigDecimal value) {
            addCriterion("reserve_price =", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotEqualTo(BigDecimal value) {
            addCriterion("reserve_price <>", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThan(BigDecimal value) {
            addCriterion("reserve_price >", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_price >=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThan(BigDecimal value) {
            addCriterion("reserve_price <", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_price <=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceIn(List<BigDecimal> values) {
            addCriterion("reserve_price in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotIn(List<BigDecimal> values) {
            addCriterion("reserve_price not in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_price between", value1, value2, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_price not between", value1, value2, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNull() {
            addCriterion("start_price is null");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("start_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartPriceEqualTo(BigDecimal value) {
            addCriterion("start_price =", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotEqualTo(BigDecimal value) {
            addCriterion("start_price <>", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThan(BigDecimal value) {
            addCriterion("start_price >", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("start_price >=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThan(BigDecimal value) {
            addCriterion("start_price <", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("start_price <=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIn(List<BigDecimal> values) {
            addCriterion("start_price in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotIn(List<BigDecimal> values) {
            addCriterion("start_price not in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_price between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_price not between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andPlusRangeIsNull() {
            addCriterion("plus_range is null");
            return (Criteria) this;
        }

        public Criteria andPlusRangeIsNotNull() {
            addCriterion("plus_range is not null");
            return (Criteria) this;
        }

        public Criteria andPlusRangeEqualTo(Short value) {
            addCriterion("plus_range =", value, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeNotEqualTo(Short value) {
            addCriterion("plus_range <>", value, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeGreaterThan(Short value) {
            addCriterion("plus_range >", value, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeGreaterThanOrEqualTo(Short value) {
            addCriterion("plus_range >=", value, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeLessThan(Short value) {
            addCriterion("plus_range <", value, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeLessThanOrEqualTo(Short value) {
            addCriterion("plus_range <=", value, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeIn(List<Short> values) {
            addCriterion("plus_range in", values, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeNotIn(List<Short> values) {
            addCriterion("plus_range not in", values, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeBetween(Short value1, Short value2) {
            addCriterion("plus_range between", value1, value2, "plusRange");
            return (Criteria) this;
        }

        public Criteria andPlusRangeNotBetween(Short value1, Short value2) {
            addCriterion("plus_range not between", value1, value2, "plusRange");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceIsNull() {
            addCriterion("is_display_reserve_price is null");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceIsNotNull() {
            addCriterion("is_display_reserve_price is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceEqualTo(Boolean value) {
            addCriterion("is_display_reserve_price =", value, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceNotEqualTo(Boolean value) {
            addCriterion("is_display_reserve_price <>", value, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceGreaterThan(Boolean value) {
            addCriterion("is_display_reserve_price >", value, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_display_reserve_price >=", value, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceLessThan(Boolean value) {
            addCriterion("is_display_reserve_price <", value, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceLessThanOrEqualTo(Boolean value) {
            addCriterion("is_display_reserve_price <=", value, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceIn(List<Boolean> values) {
            addCriterion("is_display_reserve_price in", values, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceNotIn(List<Boolean> values) {
            addCriterion("is_display_reserve_price not in", values, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceBetween(Boolean value1, Boolean value2) {
            addCriterion("is_display_reserve_price between", value1, value2, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andDisplayReservePriceNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_display_reserve_price not between", value1, value2, "displayReservePrice");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDoneIsNull() {
            addCriterion("is_done is null");
            return (Criteria) this;
        }

        public Criteria andDoneIsNotNull() {
            addCriterion("is_done is not null");
            return (Criteria) this;
        }

        public Criteria andDoneEqualTo(Boolean value) {
            addCriterion("is_done =", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneNotEqualTo(Boolean value) {
            addCriterion("is_done <>", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneGreaterThan(Boolean value) {
            addCriterion("is_done >", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_done >=", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneLessThan(Boolean value) {
            addCriterion("is_done <", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneLessThanOrEqualTo(Boolean value) {
            addCriterion("is_done <=", value, "done");
            return (Criteria) this;
        }

        public Criteria andDoneIn(List<Boolean> values) {
            addCriterion("is_done in", values, "done");
            return (Criteria) this;
        }

        public Criteria andDoneNotIn(List<Boolean> values) {
            addCriterion("is_done not in", values, "done");
            return (Criteria) this;
        }

        public Criteria andDoneBetween(Boolean value1, Boolean value2) {
            addCriterion("is_done between", value1, value2, "done");
            return (Criteria) this;
        }

        public Criteria andDoneNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_done not between", value1, value2, "done");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
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

        public Criteria andBidQuantityIsNull() {
            addCriterion("bid_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBidQuantityIsNotNull() {
            addCriterion("bid_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBidQuantityEqualTo(Integer value) {
            addCriterion("bid_quantity =", value, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityNotEqualTo(Integer value) {
            addCriterion("bid_quantity <>", value, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityGreaterThan(Integer value) {
            addCriterion("bid_quantity >", value, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_quantity >=", value, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityLessThan(Integer value) {
            addCriterion("bid_quantity <", value, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("bid_quantity <=", value, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityIn(List<Integer> values) {
            addCriterion("bid_quantity in", values, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityNotIn(List<Integer> values) {
            addCriterion("bid_quantity not in", values, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityBetween(Integer value1, Integer value2) {
            addCriterion("bid_quantity between", value1, value2, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andBidQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_quantity not between", value1, value2, "bidQuantity");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentIsNull() {
            addCriterion("commission_percent is null");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentIsNotNull() {
            addCriterion("commission_percent is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentEqualTo(Byte value) {
            addCriterion("commission_percent =", value, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentNotEqualTo(Byte value) {
            addCriterion("commission_percent <>", value, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentGreaterThan(Byte value) {
            addCriterion("commission_percent >", value, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("commission_percent >=", value, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentLessThan(Byte value) {
            addCriterion("commission_percent <", value, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentLessThanOrEqualTo(Byte value) {
            addCriterion("commission_percent <=", value, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentIn(List<Byte> values) {
            addCriterion("commission_percent in", values, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentNotIn(List<Byte> values) {
            addCriterion("commission_percent not in", values, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentBetween(Byte value1, Byte value2) {
            addCriterion("commission_percent between", value1, value2, "commissionPercent");
            return (Criteria) this;
        }

        public Criteria andCommissionPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("commission_percent not between", value1, value2, "commissionPercent");
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

        public Criteria andClientCommissionRateIsNull() {
            addCriterion("client_commission_rate is null");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateIsNotNull() {
            addCriterion("client_commission_rate is not null");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateEqualTo(BigDecimal value) {
            addCriterion("client_commission_rate =", value, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateNotEqualTo(BigDecimal value) {
            addCriterion("client_commission_rate <>", value, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateGreaterThan(BigDecimal value) {
            addCriterion("client_commission_rate >", value, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("client_commission_rate >=", value, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateLessThan(BigDecimal value) {
            addCriterion("client_commission_rate <", value, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("client_commission_rate <=", value, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateIn(List<BigDecimal> values) {
            addCriterion("client_commission_rate in", values, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateNotIn(List<BigDecimal> values) {
            addCriterion("client_commission_rate not in", values, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("client_commission_rate between", value1, value2, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientCommissionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("client_commission_rate not between", value1, value2, "clientCommissionRate");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionIsNull() {
            addCriterion("client_fixed_commission is null");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionIsNotNull() {
            addCriterion("client_fixed_commission is not null");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionEqualTo(BigDecimal value) {
            addCriterion("client_fixed_commission =", value, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionNotEqualTo(BigDecimal value) {
            addCriterion("client_fixed_commission <>", value, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionGreaterThan(BigDecimal value) {
            addCriterion("client_fixed_commission >", value, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("client_fixed_commission >=", value, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionLessThan(BigDecimal value) {
            addCriterion("client_fixed_commission <", value, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("client_fixed_commission <=", value, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionIn(List<BigDecimal> values) {
            addCriterion("client_fixed_commission in", values, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionNotIn(List<BigDecimal> values) {
            addCriterion("client_fixed_commission not in", values, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("client_fixed_commission between", value1, value2, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andClientFixedCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("client_fixed_commission not between", value1, value2, "clientFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateIsNull() {
            addCriterion("buyer_commission_rate is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateIsNotNull() {
            addCriterion("buyer_commission_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_rate =", value, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateNotEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_rate <>", value, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateGreaterThan(BigDecimal value) {
            addCriterion("buyer_commission_rate >", value, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_rate >=", value, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateLessThan(BigDecimal value) {
            addCriterion("buyer_commission_rate <", value, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buyer_commission_rate <=", value, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateIn(List<BigDecimal> values) {
            addCriterion("buyer_commission_rate in", values, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateNotIn(List<BigDecimal> values) {
            addCriterion("buyer_commission_rate not in", values, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyer_commission_rate between", value1, value2, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerCommissionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyer_commission_rate not between", value1, value2, "buyerCommissionRate");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionIsNull() {
            addCriterion("buyer_fixed_commission is null");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionIsNotNull() {
            addCriterion("buyer_fixed_commission is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionEqualTo(BigDecimal value) {
            addCriterion("buyer_fixed_commission =", value, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionNotEqualTo(BigDecimal value) {
            addCriterion("buyer_fixed_commission <>", value, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionGreaterThan(BigDecimal value) {
            addCriterion("buyer_fixed_commission >", value, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buyer_fixed_commission >=", value, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionLessThan(BigDecimal value) {
            addCriterion("buyer_fixed_commission <", value, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buyer_fixed_commission <=", value, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionIn(List<BigDecimal> values) {
            addCriterion("buyer_fixed_commission in", values, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionNotIn(List<BigDecimal> values) {
            addCriterion("buyer_fixed_commission not in", values, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyer_fixed_commission between", value1, value2, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andBuyerFixedCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyer_fixed_commission not between", value1, value2, "buyerFixedCommission");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeIsNull() {
            addCriterion("see_car_time is null");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeIsNotNull() {
            addCriterion("see_car_time is not null");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeEqualTo(String value) {
            addCriterion("see_car_time =", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeNotEqualTo(String value) {
            addCriterion("see_car_time <>", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeGreaterThan(String value) {
            addCriterion("see_car_time >", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeGreaterThanOrEqualTo(String value) {
            addCriterion("see_car_time >=", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeLessThan(String value) {
            addCriterion("see_car_time <", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeLessThanOrEqualTo(String value) {
            addCriterion("see_car_time <=", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeLike(String value) {
            addCriterion("see_car_time like", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeNotLike(String value) {
            addCriterion("see_car_time not like", value, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeIn(List<String> values) {
            addCriterion("see_car_time in", values, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeNotIn(List<String> values) {
            addCriterion("see_car_time not in", values, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeBetween(String value1, String value2) {
            addCriterion("see_car_time between", value1, value2, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeNotBetween(String value1, String value2) {
            addCriterion("see_car_time not between", value1, value2, "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrIsNull() {
            addCriterion("see_car_addr is null");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrIsNotNull() {
            addCriterion("see_car_addr is not null");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrEqualTo(String value) {
            addCriterion("see_car_addr =", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrNotEqualTo(String value) {
            addCriterion("see_car_addr <>", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrGreaterThan(String value) {
            addCriterion("see_car_addr >", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrGreaterThanOrEqualTo(String value) {
            addCriterion("see_car_addr >=", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrLessThan(String value) {
            addCriterion("see_car_addr <", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrLessThanOrEqualTo(String value) {
            addCriterion("see_car_addr <=", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrLike(String value) {
            addCriterion("see_car_addr like", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrNotLike(String value) {
            addCriterion("see_car_addr not like", value, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrIn(List<String> values) {
            addCriterion("see_car_addr in", values, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrNotIn(List<String> values) {
            addCriterion("see_car_addr not in", values, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrBetween(String value1, String value2) {
            addCriterion("see_car_addr between", value1, value2, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrNotBetween(String value1, String value2) {
            addCriterion("see_car_addr not between", value1, value2, "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNull() {
            addCriterion("plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNotNull() {
            addCriterion("plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeEqualTo(Date value) {
            addCriterion("plan_end_time =", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotEqualTo(Date value) {
            addCriterion("plan_end_time <>", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThan(Date value) {
            addCriterion("plan_end_time >", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_end_time >=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThan(Date value) {
            addCriterion("plan_end_time <", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_end_time <=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIn(List<Date> values) {
            addCriterion("plan_end_time in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotIn(List<Date> values) {
            addCriterion("plan_end_time not in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("plan_end_time between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_end_time not between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andClientIsNull() {
            addCriterion("client is null");
            return (Criteria) this;
        }

        public Criteria andClientIsNotNull() {
            addCriterion("client is not null");
            return (Criteria) this;
        }

        public Criteria andClientEqualTo(String value) {
            addCriterion("client =", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotEqualTo(String value) {
            addCriterion("client <>", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThan(String value) {
            addCriterion("client >", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThanOrEqualTo(String value) {
            addCriterion("client >=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThan(String value) {
            addCriterion("client <", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThanOrEqualTo(String value) {
            addCriterion("client <=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLike(String value) {
            addCriterion("client like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotLike(String value) {
            addCriterion("client not like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientIn(List<String> values) {
            addCriterion("client in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotIn(List<String> values) {
            addCriterion("client not in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientBetween(String value1, String value2) {
            addCriterion("client between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotBetween(String value1, String value2) {
            addCriterion("client not between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeIsNull() {
            addCriterion("auction_type is null");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeIsNotNull() {
            addCriterion("auction_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeEqualTo(Integer value) {
            addCriterion("auction_type =", value, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeNotEqualTo(Integer value) {
            addCriterion("auction_type <>", value, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeGreaterThan(Integer value) {
            addCriterion("auction_type >", value, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("auction_type >=", value, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeLessThan(Integer value) {
            addCriterion("auction_type <", value, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("auction_type <=", value, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeIn(List<Integer> values) {
            addCriterion("auction_type in", values, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeNotIn(List<Integer> values) {
            addCriterion("auction_type not in", values, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeBetween(Integer value1, Integer value2) {
            addCriterion("auction_type between", value1, value2, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("auction_type not between", value1, value2, "auctionType");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderIsNull() {
            addCriterion("auction_vehicle_order is null");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderIsNotNull() {
            addCriterion("auction_vehicle_order is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderEqualTo(Short value) {
            addCriterion("auction_vehicle_order =", value, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderNotEqualTo(Short value) {
            addCriterion("auction_vehicle_order <>", value, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderGreaterThan(Short value) {
            addCriterion("auction_vehicle_order >", value, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderGreaterThanOrEqualTo(Short value) {
            addCriterion("auction_vehicle_order >=", value, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderLessThan(Short value) {
            addCriterion("auction_vehicle_order <", value, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderLessThanOrEqualTo(Short value) {
            addCriterion("auction_vehicle_order <=", value, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderIn(List<Short> values) {
            addCriterion("auction_vehicle_order in", values, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderNotIn(List<Short> values) {
            addCriterion("auction_vehicle_order not in", values, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderBetween(Short value1, Short value2) {
            addCriterion("auction_vehicle_order between", value1, value2, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andAuctionVehicleOrderNotBetween(Short value1, Short value2) {
            addCriterion("auction_vehicle_order not between", value1, value2, "auctionVehicleOrder");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Boolean value) {
            addCriterion("is_enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Boolean value) {
            addCriterion("is_enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Boolean value) {
            addCriterion("is_enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Boolean value) {
            addCriterion("is_enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("is_enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Boolean> values) {
            addCriterion("is_enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Boolean> values) {
            addCriterion("is_enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andModelDescIsNull() {
            addCriterion("model_desc is null");
            return (Criteria) this;
        }

        public Criteria andModelDescIsNotNull() {
            addCriterion("model_desc is not null");
            return (Criteria) this;
        }

        public Criteria andModelDescEqualTo(String value) {
            addCriterion("model_desc =", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotEqualTo(String value) {
            addCriterion("model_desc <>", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescGreaterThan(String value) {
            addCriterion("model_desc >", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescGreaterThanOrEqualTo(String value) {
            addCriterion("model_desc >=", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescLessThan(String value) {
            addCriterion("model_desc <", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescLessThanOrEqualTo(String value) {
            addCriterion("model_desc <=", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescLike(String value) {
            addCriterion("model_desc like", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotLike(String value) {
            addCriterion("model_desc not like", value, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescIn(List<String> values) {
            addCriterion("model_desc in", values, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotIn(List<String> values) {
            addCriterion("model_desc not in", values, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescBetween(String value1, String value2) {
            addCriterion("model_desc between", value1, value2, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andModelDescNotBetween(String value1, String value2) {
            addCriterion("model_desc not between", value1, value2, "modelDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescIsNull() {
            addCriterion("vehicle_desc is null");
            return (Criteria) this;
        }

        public Criteria andVehicleDescIsNotNull() {
            addCriterion("vehicle_desc is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleDescEqualTo(String value) {
            addCriterion("vehicle_desc =", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescNotEqualTo(String value) {
            addCriterion("vehicle_desc <>", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescGreaterThan(String value) {
            addCriterion("vehicle_desc >", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_desc >=", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescLessThan(String value) {
            addCriterion("vehicle_desc <", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescLessThanOrEqualTo(String value) {
            addCriterion("vehicle_desc <=", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescLike(String value) {
            addCriterion("vehicle_desc like", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescNotLike(String value) {
            addCriterion("vehicle_desc not like", value, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescIn(List<String> values) {
            addCriterion("vehicle_desc in", values, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescNotIn(List<String> values) {
            addCriterion("vehicle_desc not in", values, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescBetween(String value1, String value2) {
            addCriterion("vehicle_desc between", value1, value2, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescNotBetween(String value1, String value2) {
            addCriterion("vehicle_desc not between", value1, value2, "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelIsNull() {
            addCriterion("auction_model is null");
            return (Criteria) this;
        }

        public Criteria andAuctionModelIsNotNull() {
            addCriterion("auction_model is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionModelEqualTo(Integer value) {
            addCriterion("auction_model =", value, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelNotEqualTo(Integer value) {
            addCriterion("auction_model <>", value, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelGreaterThan(Integer value) {
            addCriterion("auction_model >", value, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("auction_model >=", value, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelLessThan(Integer value) {
            addCriterion("auction_model <", value, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelLessThanOrEqualTo(Integer value) {
            addCriterion("auction_model <=", value, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelIn(List<Integer> values) {
            addCriterion("auction_model in", values, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelNotIn(List<Integer> values) {
            addCriterion("auction_model not in", values, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelBetween(Integer value1, Integer value2) {
            addCriterion("auction_model between", value1, value2, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andAuctionModelNotBetween(Integer value1, Integer value2) {
            addCriterion("auction_model not between", value1, value2, "auctionModel");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceIsNull() {
            addCriterion("max_bid_price is null");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceIsNotNull() {
            addCriterion("max_bid_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceEqualTo(BigDecimal value) {
            addCriterion("max_bid_price =", value, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceNotEqualTo(BigDecimal value) {
            addCriterion("max_bid_price <>", value, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceGreaterThan(BigDecimal value) {
            addCriterion("max_bid_price >", value, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_bid_price >=", value, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceLessThan(BigDecimal value) {
            addCriterion("max_bid_price <", value, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_bid_price <=", value, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceIn(List<BigDecimal> values) {
            addCriterion("max_bid_price in", values, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceNotIn(List<BigDecimal> values) {
            addCriterion("max_bid_price not in", values, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_bid_price between", value1, value2, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andMaxBidPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_bid_price not between", value1, value2, "maxBidPrice");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeIsNull() {
            addCriterion("online_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeIsNotNull() {
            addCriterion("online_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeEqualTo(Date value) {
            addCriterion("online_end_time =", value, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeNotEqualTo(Date value) {
            addCriterion("online_end_time <>", value, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeGreaterThan(Date value) {
            addCriterion("online_end_time >", value, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("online_end_time >=", value, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeLessThan(Date value) {
            addCriterion("online_end_time <", value, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("online_end_time <=", value, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeIn(List<Date> values) {
            addCriterion("online_end_time in", values, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeNotIn(List<Date> values) {
            addCriterion("online_end_time not in", values, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeBetween(Date value1, Date value2) {
            addCriterion("online_end_time between", value1, value2, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andOnlineEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("online_end_time not between", value1, value2, "onlineEndTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andLatestIsNull() {
            addCriterion("is_latest is null");
            return (Criteria) this;
        }

        public Criteria andLatestIsNotNull() {
            addCriterion("is_latest is not null");
            return (Criteria) this;
        }

        public Criteria andLatestEqualTo(Boolean value) {
            addCriterion("is_latest =", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestNotEqualTo(Boolean value) {
            addCriterion("is_latest <>", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestGreaterThan(Boolean value) {
            addCriterion("is_latest >", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_latest >=", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestLessThan(Boolean value) {
            addCriterion("is_latest <", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestLessThanOrEqualTo(Boolean value) {
            addCriterion("is_latest <=", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestIn(List<Boolean> values) {
            addCriterion("is_latest in", values, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestNotIn(List<Boolean> values) {
            addCriterion("is_latest not in", values, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestBetween(Boolean value1, Boolean value2) {
            addCriterion("is_latest between", value1, value2, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_latest not between", value1, value2, "latest");
            return (Criteria) this;
        }

        public Criteria andAgentPriceIsNull() {
            addCriterion("agent_price is null");
            return (Criteria) this;
        }

        public Criteria andAgentPriceIsNotNull() {
            addCriterion("agent_price is not null");
            return (Criteria) this;
        }

        public Criteria andAgentPriceEqualTo(Integer value) {
            addCriterion("agent_price =", value, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceNotEqualTo(Integer value) {
            addCriterion("agent_price <>", value, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceGreaterThan(Integer value) {
            addCriterion("agent_price >", value, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_price >=", value, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceLessThan(Integer value) {
            addCriterion("agent_price <", value, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceLessThanOrEqualTo(Integer value) {
            addCriterion("agent_price <=", value, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceIn(List<Integer> values) {
            addCriterion("agent_price in", values, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceNotIn(List<Integer> values) {
            addCriterion("agent_price not in", values, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceBetween(Integer value1, Integer value2) {
            addCriterion("agent_price between", value1, value2, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andAgentPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_price not between", value1, value2, "agentPrice");
            return (Criteria) this;
        }

        public Criteria andOperatorLikeInsensitive(String value) {
            addCriterion("upper(operator) like", value.toUpperCase(), "operator");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLikeInsensitive(String value) {
            addCriterion("upper(operation_type) like", value.toUpperCase(), "operationType");
            return (Criteria) this;
        }

        public Criteria andCreatedByLikeInsensitive(String value) {
            addCriterion("upper(created_by) like", value.toUpperCase(), "createdBy");
            return (Criteria) this;
        }

        public Criteria andSeeCarTimeLikeInsensitive(String value) {
            addCriterion("upper(see_car_time) like", value.toUpperCase(), "seeCarTime");
            return (Criteria) this;
        }

        public Criteria andSeeCarAddrLikeInsensitive(String value) {
            addCriterion("upper(see_car_addr) like", value.toUpperCase(), "seeCarAddr");
            return (Criteria) this;
        }

        public Criteria andClientLikeInsensitive(String value) {
            addCriterion("upper(client) like", value.toUpperCase(), "client");
            return (Criteria) this;
        }

        public Criteria andModelDescLikeInsensitive(String value) {
            addCriterion("upper(model_desc) like", value.toUpperCase(), "modelDesc");
            return (Criteria) this;
        }

        public Criteria andVehicleDescLikeInsensitive(String value) {
            addCriterion("upper(vehicle_desc) like", value.toUpperCase(), "vehicleDesc");
            return (Criteria) this;
        }

        public Criteria andProvinceLikeInsensitive(String value) {
            addCriterion("upper(province) like", value.toUpperCase(), "province");
            return (Criteria) this;
        }

        public Criteria andCityLikeInsensitive(String value) {
            addCriterion("upper(city) like", value.toUpperCase(), "city");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
		 * 
		 */
		private static final long serialVersionUID = 6047793137850694300L;

		protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        /**
		 * 
		 */
		private static final long serialVersionUID = -6800915036455014667L;

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