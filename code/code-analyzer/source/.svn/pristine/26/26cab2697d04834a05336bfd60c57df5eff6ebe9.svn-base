package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseDealerUsedVehicleExample implements Serializable {

    private static final long serialVersionUID = -6954598578411327671L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseDealerUsedVehicleExample() {
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

        private static final long serialVersionUID = -4655384900817375641L;

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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(String value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(String value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(String value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(String value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(String value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(String value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLike(String value) {
            addCriterion("brand_id like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotLike(String value) {
            addCriterion("brand_id not like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<String> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<String> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(String value1, String value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(String value1, String value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andVehicleModelIsNull() {
            addCriterion("vehicle_model is null");
            return (Criteria) this;
        }

        public Criteria andVehicleModelIsNotNull() {
            addCriterion("vehicle_model is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleModelEqualTo(String value) {
            addCriterion("vehicle_model =", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelNotEqualTo(String value) {
            addCriterion("vehicle_model <>", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelGreaterThan(String value) {
            addCriterion("vehicle_model >", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_model >=", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelLessThan(String value) {
            addCriterion("vehicle_model <", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelLessThanOrEqualTo(String value) {
            addCriterion("vehicle_model <=", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelLike(String value) {
            addCriterion("vehicle_model like", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelNotLike(String value) {
            addCriterion("vehicle_model not like", value, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelIn(List<String> values) {
            addCriterion("vehicle_model in", values, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelNotIn(List<String> values) {
            addCriterion("vehicle_model not in", values, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelBetween(String value1, String value2) {
            addCriterion("vehicle_model between", value1, value2, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVehicleModelNotBetween(String value1, String value2) {
            addCriterion("vehicle_model not between", value1, value2, "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVinCodeIsNull() {
            addCriterion("vin_code is null");
            return (Criteria) this;
        }

        public Criteria andVinCodeIsNotNull() {
            addCriterion("vin_code is not null");
            return (Criteria) this;
        }

        public Criteria andVinCodeEqualTo(String value) {
            addCriterion("vin_code =", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotEqualTo(String value) {
            addCriterion("vin_code <>", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeGreaterThan(String value) {
            addCriterion("vin_code >", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vin_code >=", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeLessThan(String value) {
            addCriterion("vin_code <", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeLessThanOrEqualTo(String value) {
            addCriterion("vin_code <=", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeLike(String value) {
            addCriterion("vin_code like", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotLike(String value) {
            addCriterion("vin_code not like", value, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeIn(List<String> values) {
            addCriterion("vin_code in", values, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotIn(List<String> values) {
            addCriterion("vin_code not in", values, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeBetween(String value1, String value2) {
            addCriterion("vin_code between", value1, value2, "vinCode");
            return (Criteria) this;
        }

        public Criteria andVinCodeNotBetween(String value1, String value2) {
            addCriterion("vin_code not between", value1, value2, "vinCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeIsNull() {
            addCriterion("license_code is null");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeIsNotNull() {
            addCriterion("license_code is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeEqualTo(String value) {
            addCriterion("license_code =", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotEqualTo(String value) {
            addCriterion("license_code <>", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeGreaterThan(String value) {
            addCriterion("license_code >", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("license_code >=", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLessThan(String value) {
            addCriterion("license_code <", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLessThanOrEqualTo(String value) {
            addCriterion("license_code <=", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLike(String value) {
            addCriterion("license_code like", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotLike(String value) {
            addCriterion("license_code not like", value, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeIn(List<String> values) {
            addCriterion("license_code in", values, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotIn(List<String> values) {
            addCriterion("license_code not in", values, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeBetween(String value1, String value2) {
            addCriterion("license_code between", value1, value2, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeNotBetween(String value1, String value2) {
            addCriterion("license_code not between", value1, value2, "licenseCode");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeIsNull() {
            addCriterion("vehicle_ppe is null");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeIsNotNull() {
            addCriterion("vehicle_ppe is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeEqualTo(String value) {
            addCriterion("vehicle_ppe =", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeNotEqualTo(String value) {
            addCriterion("vehicle_ppe <>", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeGreaterThan(String value) {
            addCriterion("vehicle_ppe >", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_ppe >=", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeLessThan(String value) {
            addCriterion("vehicle_ppe <", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeLessThanOrEqualTo(String value) {
            addCriterion("vehicle_ppe <=", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeLike(String value) {
            addCriterion("vehicle_ppe like", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeNotLike(String value) {
            addCriterion("vehicle_ppe not like", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeIn(List<String> values) {
            addCriterion("vehicle_ppe in", values, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeNotIn(List<String> values) {
            addCriterion("vehicle_ppe not in", values, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeBetween(String value1, String value2) {
            addCriterion("vehicle_ppe between", value1, value2, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeNotBetween(String value1, String value2) {
            addCriterion("vehicle_ppe not between", value1, value2, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNull() {
            addCriterion("purchase_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNotNull() {
            addCriterion("purchase_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeEqualTo(Date value) {
            addCriterion("purchase_time =", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotEqualTo(Date value) {
            addCriterion("purchase_time <>", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThan(Date value) {
            addCriterion("purchase_time >", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_time >=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThan(Date value) {
            addCriterion("purchase_time <", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_time <=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIn(List<Date> values) {
            addCriterion("purchase_time in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotIn(List<Date> values) {
            addCriterion("purchase_time not in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_time between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_time not between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceIsNull() {
            addCriterion("new_limited_price is null");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceIsNotNull() {
            addCriterion("new_limited_price is not null");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceEqualTo(BigDecimal value) {
            addCriterion("new_limited_price =", value, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceNotEqualTo(BigDecimal value) {
            addCriterion("new_limited_price <>", value, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceGreaterThan(BigDecimal value) {
            addCriterion("new_limited_price >", value, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("new_limited_price >=", value, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceLessThan(BigDecimal value) {
            addCriterion("new_limited_price <", value, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("new_limited_price <=", value, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceIn(List<BigDecimal> values) {
            addCriterion("new_limited_price in", values, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceNotIn(List<BigDecimal> values) {
            addCriterion("new_limited_price not in", values, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_limited_price between", value1, value2, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andNewLimitedPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_limited_price not between", value1, value2, "newLimitedPrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNull() {
            addCriterion("purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNotNull() {
            addCriterion("purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceEqualTo(BigDecimal value) {
            addCriterion("purchase_price =", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotEqualTo(BigDecimal value) {
            addCriterion("purchase_price <>", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThan(BigDecimal value) {
            addCriterion("purchase_price >", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price >=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThan(BigDecimal value) {
            addCriterion("purchase_price <", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price <=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIn(List<BigDecimal> values) {
            addCriterion("purchase_price in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotIn(List<BigDecimal> values) {
            addCriterion("purchase_price not in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price not between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceIsNull() {
            addCriterion("suggested_sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceIsNotNull() {
            addCriterion("suggested_sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceEqualTo(BigDecimal value) {
            addCriterion("suggested_sale_price =", value, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("suggested_sale_price <>", value, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceGreaterThan(BigDecimal value) {
            addCriterion("suggested_sale_price >", value, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("suggested_sale_price >=", value, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceLessThan(BigDecimal value) {
            addCriterion("suggested_sale_price <", value, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("suggested_sale_price <=", value, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceIn(List<BigDecimal> values) {
            addCriterion("suggested_sale_price in", values, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("suggested_sale_price not in", values, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("suggested_sale_price between", value1, value2, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSuggestedSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("suggested_sale_price not between", value1, value2, "suggestedSalePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(BigDecimal value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(BigDecimal value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(BigDecimal value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<BigDecimal> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
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

        public Criteria andRetireIsNull() {
            addCriterion("is_retire is null");
            return (Criteria) this;
        }

        public Criteria andRetireIsNotNull() {
            addCriterion("is_retire is not null");
            return (Criteria) this;
        }

        public Criteria andRetireEqualTo(Boolean value) {
            addCriterion("is_retire =", value, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireNotEqualTo(Boolean value) {
            addCriterion("is_retire <>", value, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireGreaterThan(Boolean value) {
            addCriterion("is_retire >", value, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_retire >=", value, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireLessThan(Boolean value) {
            addCriterion("is_retire <", value, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireLessThanOrEqualTo(Boolean value) {
            addCriterion("is_retire <=", value, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireIn(List<Boolean> values) {
            addCriterion("is_retire in", values, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireNotIn(List<Boolean> values) {
            addCriterion("is_retire not in", values, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireBetween(Boolean value1, Boolean value2) {
            addCriterion("is_retire between", value1, value2, "retire");
            return (Criteria) this;
        }

        public Criteria andRetireNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_retire not between", value1, value2, "retire");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNull() {
            addCriterion("is_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("is_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateEqualTo(Boolean value) {
            addCriterion("is_evaluate =", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotEqualTo(Boolean value) {
            addCriterion("is_evaluate <>", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThan(Boolean value) {
            addCriterion("is_evaluate >", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_evaluate >=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThan(Boolean value) {
            addCriterion("is_evaluate <", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThanOrEqualTo(Boolean value) {
            addCriterion("is_evaluate <=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateIn(List<Boolean> values) {
            addCriterion("is_evaluate in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotIn(List<Boolean> values) {
            addCriterion("is_evaluate not in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateBetween(Boolean value1, Boolean value2) {
            addCriterion("is_evaluate between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_evaluate not between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("is_audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("is_audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(Boolean value) {
            addCriterion("is_audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(Boolean value) {
            addCriterion("is_audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(Boolean value) {
            addCriterion("is_audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(Boolean value) {
            addCriterion("is_audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(Boolean value) {
            addCriterion("is_audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<Boolean> values) {
            addCriterion("is_audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<Boolean> values) {
            addCriterion("is_audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(Boolean value1, Boolean value2) {
            addCriterion("is_audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_audit not between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andSaleStatusIsNull() {
            addCriterion("sale_status is null");
            return (Criteria) this;
        }

        public Criteria andSaleStatusIsNotNull() {
            addCriterion("sale_status is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStatusEqualTo(Integer value) {
            addCriterion("sale_status =", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotEqualTo(Integer value) {
            addCriterion("sale_status <>", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusGreaterThan(Integer value) {
            addCriterion("sale_status >", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_status >=", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusLessThan(Integer value) {
            addCriterion("sale_status <", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sale_status <=", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusIn(List<Integer> values) {
            addCriterion("sale_status in", values, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotIn(List<Integer> values) {
            addCriterion("sale_status not in", values, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusBetween(Integer value1, Integer value2) {
            addCriterion("sale_status between", value1, value2, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_status not between", value1, value2, "saleStatus");
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

        public Criteria andSalesChannelIsNull() {
            addCriterion("sales_channel is null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIsNotNull() {
            addCriterion("sales_channel is not null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelEqualTo(String value) {
            addCriterion("sales_channel =", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotEqualTo(String value) {
            addCriterion("sales_channel <>", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelGreaterThan(String value) {
            addCriterion("sales_channel >", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelGreaterThanOrEqualTo(String value) {
            addCriterion("sales_channel >=", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLessThan(String value) {
            addCriterion("sales_channel <", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLessThanOrEqualTo(String value) {
            addCriterion("sales_channel <=", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLike(String value) {
            addCriterion("sales_channel like", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotLike(String value) {
            addCriterion("sales_channel not like", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIn(List<String> values) {
            addCriterion("sales_channel in", values, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotIn(List<String> values) {
            addCriterion("sales_channel not in", values, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelBetween(String value1, String value2) {
            addCriterion("sales_channel between", value1, value2, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotBetween(String value1, String value2) {
            addCriterion("sales_channel not between", value1, value2, "salesChannel");
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

        public Criteria andProcessInstanceIdIsNull() {
            addCriterion("process_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNotNull() {
            addCriterion("process_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdEqualTo(String value) {
            addCriterion("process_instance_id =", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotEqualTo(String value) {
            addCriterion("process_instance_id <>", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThan(String value) {
            addCriterion("process_instance_id >", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_instance_id >=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThan(String value) {
            addCriterion("process_instance_id <", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("process_instance_id <=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLike(String value) {
            addCriterion("process_instance_id like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotLike(String value) {
            addCriterion("process_instance_id not like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIn(List<String> values) {
            addCriterion("process_instance_id in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotIn(List<String> values) {
            addCriterion("process_instance_id not in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdBetween(String value1, String value2) {
            addCriterion("process_instance_id between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotBetween(String value1, String value2) {
            addCriterion("process_instance_id not between", value1, value2, "processInstanceId");
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

        public Criteria andSaleWarnTimeIsNull() {
            addCriterion("sale_warn_time is null");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeIsNotNull() {
            addCriterion("sale_warn_time is not null");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeEqualTo(Date value) {
            addCriterion("sale_warn_time =", value, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeNotEqualTo(Date value) {
            addCriterion("sale_warn_time <>", value, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeGreaterThan(Date value) {
            addCriterion("sale_warn_time >", value, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sale_warn_time >=", value, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeLessThan(Date value) {
            addCriterion("sale_warn_time <", value, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeLessThanOrEqualTo(Date value) {
            addCriterion("sale_warn_time <=", value, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeIn(List<Date> values) {
            addCriterion("sale_warn_time in", values, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeNotIn(List<Date> values) {
            addCriterion("sale_warn_time not in", values, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeBetween(Date value1, Date value2) {
            addCriterion("sale_warn_time between", value1, value2, "saleWarnTime");
            return (Criteria) this;
        }

        public Criteria andSaleWarnTimeNotBetween(Date value1, Date value2) {
            addCriterion("sale_warn_time not between", value1, value2, "saleWarnTime");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
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

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Boolean value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Boolean value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Boolean value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Boolean value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Boolean> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Boolean> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andBrandIdLikeInsensitive(String value) {
            addCriterion("upper(brand_id) like", value.toUpperCase(), "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandLikeInsensitive(String value) {
            addCriterion("upper(brand) like", value.toUpperCase(), "brand");
            return (Criteria) this;
        }

        public Criteria andVehicleModelLikeInsensitive(String value) {
            addCriterion("upper(vehicle_model) like", value.toUpperCase(), "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andVinCodeLikeInsensitive(String value) {
            addCriterion("upper(vin_code) like", value.toUpperCase(), "vinCode");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLikeInsensitive(String value) {
            addCriterion("upper(license_code) like", value.toUpperCase(), "licenseCode");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeLikeInsensitive(String value) {
            addCriterion("upper(vehicle_ppe) like", value.toUpperCase(), "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLikeInsensitive(String value) {
            addCriterion("upper(sales_channel) like", value.toUpperCase(), "salesChannel");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLikeInsensitive(String value) {
            addCriterion("upper(process_instance_id) like", value.toUpperCase(), "processInstanceId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        private static final long serialVersionUID = 5462765921669895221L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        private static final long serialVersionUID = 7397939954951428927L;

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