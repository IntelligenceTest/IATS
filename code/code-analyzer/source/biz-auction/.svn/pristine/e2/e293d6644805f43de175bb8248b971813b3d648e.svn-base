package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseFixedPriceExample implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6864057347785248320L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseFixedPriceExample() {
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
        private static final long serialVersionUID = -231149770423592432L;
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupIsNull() {
            addCriterion("low_price_group is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupIsNotNull() {
            addCriterion("low_price_group is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupEqualTo(BigDecimal value) {
            addCriterion("low_price_group =", value, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupNotEqualTo(BigDecimal value) {
            addCriterion("low_price_group <>", value, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupGreaterThan(BigDecimal value) {
            addCriterion("low_price_group >", value, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("low_price_group >=", value, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupLessThan(BigDecimal value) {
            addCriterion("low_price_group <", value, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupLessThanOrEqualTo(BigDecimal value) {
            addCriterion("low_price_group <=", value, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupIn(List<BigDecimal> values) {
            addCriterion("low_price_group in", values, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupNotIn(List<BigDecimal> values) {
            addCriterion("low_price_group not in", values, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low_price_group between", value1, value2, "lowPriceGroup");
            return (Criteria) this;
        }

        public Criteria andLowPriceGroupNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low_price_group not between", value1, value2, "lowPriceGroup");
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

        public Criteria andWhereStoreIsNull() {
            addCriterion("where_store is null");
            return (Criteria) this;
        }

        public Criteria andWhereStoreIsNotNull() {
            addCriterion("where_store is not null");
            return (Criteria) this;
        }

        public Criteria andWhereStoreEqualTo(String value) {
            addCriterion("where_store =", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreNotEqualTo(String value) {
            addCriterion("where_store <>", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreGreaterThan(String value) {
            addCriterion("where_store >", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreGreaterThanOrEqualTo(String value) {
            addCriterion("where_store >=", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreLessThan(String value) {
            addCriterion("where_store <", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreLessThanOrEqualTo(String value) {
            addCriterion("where_store <=", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreLike(String value) {
            addCriterion("where_store like", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreNotLike(String value) {
            addCriterion("where_store not like", value, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreIn(List<String> values) {
            addCriterion("where_store in", values, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreNotIn(List<String> values) {
            addCriterion("where_store not in", values, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreBetween(String value1, String value2) {
            addCriterion("where_store between", value1, value2, "whereStore");
            return (Criteria) this;
        }

        public Criteria andWhereStoreNotBetween(String value1, String value2) {
            addCriterion("where_store not between", value1, value2, "whereStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreIsNull() {
            addCriterion("address_detail_store is null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreIsNotNull() {
            addCriterion("address_detail_store is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreEqualTo(String value) {
            addCriterion("address_detail_store =", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreNotEqualTo(String value) {
            addCriterion("address_detail_store <>", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreGreaterThan(String value) {
            addCriterion("address_detail_store >", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreGreaterThanOrEqualTo(String value) {
            addCriterion("address_detail_store >=", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreLessThan(String value) {
            addCriterion("address_detail_store <", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreLessThanOrEqualTo(String value) {
            addCriterion("address_detail_store <=", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreLike(String value) {
            addCriterion("address_detail_store like", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreNotLike(String value) {
            addCriterion("address_detail_store not like", value, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreIn(List<String> values) {
            addCriterion("address_detail_store in", values, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreNotIn(List<String> values) {
            addCriterion("address_detail_store not in", values, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreBetween(String value1, String value2) {
            addCriterion("address_detail_store between", value1, value2, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreNotBetween(String value1, String value2) {
            addCriterion("address_detail_store not between", value1, value2, "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNull() {
            addCriterion("service_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNotNull() {
            addCriterion("service_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeEqualTo(String value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(String value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(String value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(String value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(String value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(String value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLike(String value) {
            addCriterion("service_time like", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotLike(String value) {
            addCriterion("service_time not like", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<String> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<String> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(String value1, String value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(String value1, String value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
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

        public Criteria andHiddenIsNull() {
            addCriterion("is_hidden is null");
            return (Criteria) this;
        }

        public Criteria andHiddenIsNotNull() {
            addCriterion("is_hidden is not null");
            return (Criteria) this;
        }

        public Criteria andHiddenEqualTo(Boolean value) {
            addCriterion("is_hidden =", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotEqualTo(Boolean value) {
            addCriterion("is_hidden <>", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThan(Boolean value) {
            addCriterion("is_hidden >", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_hidden >=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThan(Boolean value) {
            addCriterion("is_hidden <", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThanOrEqualTo(Boolean value) {
            addCriterion("is_hidden <=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenIn(List<Boolean> values) {
            addCriterion("is_hidden in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotIn(List<Boolean> values) {
            addCriterion("is_hidden not in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hidden between", value1, value2, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hidden not between", value1, value2, "hidden");
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

        public Criteria andApplyShelvesTimeIsNull() {
            addCriterion("apply_shelves_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeIsNotNull() {
            addCriterion("apply_shelves_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeEqualTo(Date value) {
            addCriterion("apply_shelves_time =", value, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeNotEqualTo(Date value) {
            addCriterion("apply_shelves_time <>", value, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeGreaterThan(Date value) {
            addCriterion("apply_shelves_time >", value, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_shelves_time >=", value, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeLessThan(Date value) {
            addCriterion("apply_shelves_time <", value, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_shelves_time <=", value, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeIn(List<Date> values) {
            addCriterion("apply_shelves_time in", values, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeNotIn(List<Date> values) {
            addCriterion("apply_shelves_time not in", values, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeBetween(Date value1, Date value2) {
            addCriterion("apply_shelves_time between", value1, value2, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andApplyShelvesTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_shelves_time not between", value1, value2, "applyShelvesTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeIsNull() {
            addCriterion("sell_time is null");
            return (Criteria) this;
        }

        public Criteria andSellTimeIsNotNull() {
            addCriterion("sell_time is not null");
            return (Criteria) this;
        }

        public Criteria andSellTimeEqualTo(Date value) {
            addCriterion("sell_time =", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeNotEqualTo(Date value) {
            addCriterion("sell_time <>", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeGreaterThan(Date value) {
            addCriterion("sell_time >", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sell_time >=", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeLessThan(Date value) {
            addCriterion("sell_time <", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeLessThanOrEqualTo(Date value) {
            addCriterion("sell_time <=", value, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeIn(List<Date> values) {
            addCriterion("sell_time in", values, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeNotIn(List<Date> values) {
            addCriterion("sell_time not in", values, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeBetween(Date value1, Date value2) {
            addCriterion("sell_time between", value1, value2, "sellTime");
            return (Criteria) this;
        }

        public Criteria andSellTimeNotBetween(Date value1, Date value2) {
            addCriterion("sell_time not between", value1, value2, "sellTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeIsNull() {
            addCriterion("off_shelves_time is null");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeIsNotNull() {
            addCriterion("off_shelves_time is not null");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeEqualTo(Date value) {
            addCriterion("off_shelves_time =", value, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeNotEqualTo(Date value) {
            addCriterion("off_shelves_time <>", value, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeGreaterThan(Date value) {
            addCriterion("off_shelves_time >", value, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("off_shelves_time >=", value, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeLessThan(Date value) {
            addCriterion("off_shelves_time <", value, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeLessThanOrEqualTo(Date value) {
            addCriterion("off_shelves_time <=", value, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeIn(List<Date> values) {
            addCriterion("off_shelves_time in", values, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeNotIn(List<Date> values) {
            addCriterion("off_shelves_time not in", values, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeBetween(Date value1, Date value2) {
            addCriterion("off_shelves_time between", value1, value2, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesTimeNotBetween(Date value1, Date value2) {
            addCriterion("off_shelves_time not between", value1, value2, "offShelvesTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkIsNull() {
            addCriterion("off_shelves_remark is null");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkIsNotNull() {
            addCriterion("off_shelves_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkEqualTo(String value) {
            addCriterion("off_shelves_remark =", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkNotEqualTo(String value) {
            addCriterion("off_shelves_remark <>", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkGreaterThan(String value) {
            addCriterion("off_shelves_remark >", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("off_shelves_remark >=", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkLessThan(String value) {
            addCriterion("off_shelves_remark <", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkLessThanOrEqualTo(String value) {
            addCriterion("off_shelves_remark <=", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkLike(String value) {
            addCriterion("off_shelves_remark like", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkNotLike(String value) {
            addCriterion("off_shelves_remark not like", value, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkIn(List<String> values) {
            addCriterion("off_shelves_remark in", values, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkNotIn(List<String> values) {
            addCriterion("off_shelves_remark not in", values, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkBetween(String value1, String value2) {
            addCriterion("off_shelves_remark between", value1, value2, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkNotBetween(String value1, String value2) {
            addCriterion("off_shelves_remark not between", value1, value2, "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andFavCountIsNull() {
            addCriterion("fav_count is null");
            return (Criteria) this;
        }

        public Criteria andFavCountIsNotNull() {
            addCriterion("fav_count is not null");
            return (Criteria) this;
        }

        public Criteria andFavCountEqualTo(Integer value) {
            addCriterion("fav_count =", value, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountNotEqualTo(Integer value) {
            addCriterion("fav_count <>", value, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountGreaterThan(Integer value) {
            addCriterion("fav_count >", value, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fav_count >=", value, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountLessThan(Integer value) {
            addCriterion("fav_count <", value, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountLessThanOrEqualTo(Integer value) {
            addCriterion("fav_count <=", value, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountIn(List<Integer> values) {
            addCriterion("fav_count in", values, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountNotIn(List<Integer> values) {
            addCriterion("fav_count not in", values, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountBetween(Integer value1, Integer value2) {
            addCriterion("fav_count between", value1, value2, "favCount");
            return (Criteria) this;
        }

        public Criteria andFavCountNotBetween(Integer value1, Integer value2) {
            addCriterion("fav_count not between", value1, value2, "favCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(code) like", value.toUpperCase(), "code");
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

        public Criteria andWhereStoreLikeInsensitive(String value) {
            addCriterion("upper(where_store) like", value.toUpperCase(), "whereStore");
            return (Criteria) this;
        }

        public Criteria andAddressDetailStoreLikeInsensitive(String value) {
            addCriterion("upper(address_detail_store) like", value.toUpperCase(), "addressDetailStore");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLikeInsensitive(String value) {
            addCriterion("upper(service_time) like", value.toUpperCase(), "serviceTime");
            return (Criteria) this;
        }

        public Criteria andOffShelvesRemarkLikeInsensitive(String value) {
            addCriterion("upper(off_shelves_remark) like", value.toUpperCase(), "offShelvesRemark");
            return (Criteria) this;
        }

        public Criteria andMemoLikeInsensitive(String value) {
            addCriterion("upper(memo) like", value.toUpperCase(), "memo");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(phone) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = 525084803653584293L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
         */
        private static final long serialVersionUID = 39767419580801201L;

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