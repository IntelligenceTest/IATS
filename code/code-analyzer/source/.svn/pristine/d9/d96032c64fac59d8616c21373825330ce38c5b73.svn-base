package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseVehiclePriceLogExample implements Serializable {

    /**
     */
    private static final long serialVersionUID = 3159068412289152115L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseVehiclePriceLogExample() {
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
        private static final long serialVersionUID = 5907425054959623019L;
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

        public Criteria andRequirementTypeIsNull() {
            addCriterion("requirement_type is null");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeIsNotNull() {
            addCriterion("requirement_type is not null");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeEqualTo(Integer value) {
            addCriterion("requirement_type =", value, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeNotEqualTo(Integer value) {
            addCriterion("requirement_type <>", value, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeGreaterThan(Integer value) {
            addCriterion("requirement_type >", value, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("requirement_type >=", value, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeLessThan(Integer value) {
            addCriterion("requirement_type <", value, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeLessThanOrEqualTo(Integer value) {
            addCriterion("requirement_type <=", value, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeIn(List<Integer> values) {
            addCriterion("requirement_type in", values, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeNotIn(List<Integer> values) {
            addCriterion("requirement_type not in", values, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeBetween(Integer value1, Integer value2) {
            addCriterion("requirement_type between", value1, value2, "requirementType");
            return (Criteria) this;
        }

        public Criteria andRequirementTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("requirement_type not between", value1, value2, "requirementType");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andFpPriceIsNull() {
            addCriterion("fp_price is null");
            return (Criteria) this;
        }

        public Criteria andFpPriceIsNotNull() {
            addCriterion("fp_price is not null");
            return (Criteria) this;
        }

        public Criteria andFpPriceEqualTo(BigDecimal value) {
            addCriterion("fp_price =", value, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceNotEqualTo(BigDecimal value) {
            addCriterion("fp_price <>", value, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceGreaterThan(BigDecimal value) {
            addCriterion("fp_price >", value, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fp_price >=", value, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceLessThan(BigDecimal value) {
            addCriterion("fp_price <", value, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fp_price <=", value, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceIn(List<BigDecimal> values) {
            addCriterion("fp_price in", values, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceNotIn(List<BigDecimal> values) {
            addCriterion("fp_price not in", values, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fp_price between", value1, value2, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andFpPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fp_price not between", value1, value2, "fpPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceIsNull() {
            addCriterion("new_vehicle_suggestion_price is null");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceIsNotNull() {
            addCriterion("new_vehicle_suggestion_price is not null");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceEqualTo(BigDecimal value) {
            addCriterion("new_vehicle_suggestion_price =", value, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceNotEqualTo(BigDecimal value) {
            addCriterion("new_vehicle_suggestion_price <>", value, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceGreaterThan(BigDecimal value) {
            addCriterion("new_vehicle_suggestion_price >", value, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("new_vehicle_suggestion_price >=", value, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceLessThan(BigDecimal value) {
            addCriterion("new_vehicle_suggestion_price <", value, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("new_vehicle_suggestion_price <=", value, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceIn(List<BigDecimal> values) {
            addCriterion("new_vehicle_suggestion_price in", values, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceNotIn(List<BigDecimal> values) {
            addCriterion("new_vehicle_suggestion_price not in", values, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_vehicle_suggestion_price between", value1, value2, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andNewVehicleSuggestionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_vehicle_suggestion_price not between", value1, value2, "newVehicleSuggestionPrice");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyIsNull() {
            addCriterion("has_tax_buy is null");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyIsNotNull() {
            addCriterion("has_tax_buy is not null");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyEqualTo(Boolean value) {
            addCriterion("has_tax_buy =", value, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyNotEqualTo(Boolean value) {
            addCriterion("has_tax_buy <>", value, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyGreaterThan(Boolean value) {
            addCriterion("has_tax_buy >", value, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_tax_buy >=", value, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyLessThan(Boolean value) {
            addCriterion("has_tax_buy <", value, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyLessThanOrEqualTo(Boolean value) {
            addCriterion("has_tax_buy <=", value, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyIn(List<Boolean> values) {
            addCriterion("has_tax_buy in", values, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyNotIn(List<Boolean> values) {
            addCriterion("has_tax_buy not in", values, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyBetween(Boolean value1, Boolean value2) {
            addCriterion("has_tax_buy between", value1, value2, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andHasTaxBuyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_tax_buy not between", value1, value2, "hasTaxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyIsNull() {
            addCriterion("tax_buy is null");
            return (Criteria) this;
        }

        public Criteria andTaxBuyIsNotNull() {
            addCriterion("tax_buy is not null");
            return (Criteria) this;
        }

        public Criteria andTaxBuyEqualTo(BigDecimal value) {
            addCriterion("tax_buy =", value, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyNotEqualTo(BigDecimal value) {
            addCriterion("tax_buy <>", value, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyGreaterThan(BigDecimal value) {
            addCriterion("tax_buy >", value, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_buy >=", value, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyLessThan(BigDecimal value) {
            addCriterion("tax_buy <", value, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_buy <=", value, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyIn(List<BigDecimal> values) {
            addCriterion("tax_buy in", values, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyNotIn(List<BigDecimal> values) {
            addCriterion("tax_buy not in", values, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_buy between", value1, value2, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andTaxBuyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_buy not between", value1, value2, "taxBuy");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIsNull() {
            addCriterion("purchase_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIsNotNull() {
            addCriterion("purchase_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdEqualTo(Integer value) {
            addCriterion("purchase_id =", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotEqualTo(Integer value) {
            addCriterion("purchase_id <>", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThan(Integer value) {
            addCriterion("purchase_id >", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_id >=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThan(Integer value) {
            addCriterion("purchase_id <", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_id <=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIn(List<Integer> values) {
            addCriterion("purchase_id in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotIn(List<Integer> values) {
            addCriterion("purchase_id not in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id between", value1, value2, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id not between", value1, value2, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIsNull() {
            addCriterion("sale_channel is null");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIsNotNull() {
            addCriterion("sale_channel is not null");
            return (Criteria) this;
        }

        public Criteria andSaleChannelEqualTo(Integer value) {
            addCriterion("sale_channel =", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotEqualTo(Integer value) {
            addCriterion("sale_channel <>", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelGreaterThan(Integer value) {
            addCriterion("sale_channel >", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_channel >=", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLessThan(Integer value) {
            addCriterion("sale_channel <", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLessThanOrEqualTo(Integer value) {
            addCriterion("sale_channel <=", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIn(List<Integer> values) {
            addCriterion("sale_channel in", values, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotIn(List<Integer> values) {
            addCriterion("sale_channel not in", values, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelBetween(Integer value1, Integer value2) {
            addCriterion("sale_channel between", value1, value2, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_channel not between", value1, value2, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkIsNull() {
            addCriterion("channel_remark is null");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkIsNotNull() {
            addCriterion("channel_remark is not null");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkEqualTo(String value) {
            addCriterion("channel_remark =", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkNotEqualTo(String value) {
            addCriterion("channel_remark <>", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkGreaterThan(String value) {
            addCriterion("channel_remark >", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("channel_remark >=", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkLessThan(String value) {
            addCriterion("channel_remark <", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkLessThanOrEqualTo(String value) {
            addCriterion("channel_remark <=", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkLike(String value) {
            addCriterion("channel_remark like", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkNotLike(String value) {
            addCriterion("channel_remark not like", value, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkIn(List<String> values) {
            addCriterion("channel_remark in", values, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkNotIn(List<String> values) {
            addCriterion("channel_remark not in", values, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkBetween(String value1, String value2) {
            addCriterion("channel_remark between", value1, value2, "channelRemark");
            return (Criteria) this;
        }

        public Criteria andChannelRemarkNotBetween(String value1, String value2) {
            addCriterion("channel_remark not between", value1, value2, "channelRemark");
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

        public Criteria andNeedApproveIsNull() {
            addCriterion("is_need_approve is null");
            return (Criteria) this;
        }

        public Criteria andNeedApproveIsNotNull() {
            addCriterion("is_need_approve is not null");
            return (Criteria) this;
        }

        public Criteria andNeedApproveEqualTo(Boolean value) {
            addCriterion("is_need_approve =", value, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveNotEqualTo(Boolean value) {
            addCriterion("is_need_approve <>", value, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveGreaterThan(Boolean value) {
            addCriterion("is_need_approve >", value, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_need_approve >=", value, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveLessThan(Boolean value) {
            addCriterion("is_need_approve <", value, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_need_approve <=", value, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveIn(List<Boolean> values) {
            addCriterion("is_need_approve in", values, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveNotIn(List<Boolean> values) {
            addCriterion("is_need_approve not in", values, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_need_approve between", value1, value2, "needApprove");
            return (Criteria) this;
        }

        public Criteria andNeedApproveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_need_approve not between", value1, value2, "needApprove");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = -3514566428129548852L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
         */
        private static final long serialVersionUID = 5926923490462072295L;

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