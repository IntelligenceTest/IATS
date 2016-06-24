package com.autostreets.biz.auction.model.base;

import com.autostreets.framework.common.dal.Pagination;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDealerPurchaseVehicleExample implements Serializable {
    /**
     */
    private static final long serialVersionUID = 2595035656830954168L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseDealerPurchaseVehicleExample() {
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
        private static final long serialVersionUID = -7464375747847232955L;
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

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNull() {
            addCriterion("cust_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("cust_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("cust_phone =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("cust_phone <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("cust_phone >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cust_phone >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("cust_phone <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("cust_phone <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("cust_phone like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("cust_phone not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("cust_phone in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("cust_phone not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("cust_phone between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("cust_phone not between", value1, value2, "custPhone");
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

        public Criteria andSeriesIsNull() {
            addCriterion("series is null");
            return (Criteria) this;
        }

        public Criteria andSeriesIsNotNull() {
            addCriterion("series is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesEqualTo(String value) {
            addCriterion("series =", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotEqualTo(String value) {
            addCriterion("series <>", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThan(String value) {
            addCriterion("series >", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThanOrEqualTo(String value) {
            addCriterion("series >=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThan(String value) {
            addCriterion("series <", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThanOrEqualTo(String value) {
            addCriterion("series <=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLike(String value) {
            addCriterion("series like", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotLike(String value) {
            addCriterion("series not like", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesIn(List<String> values) {
            addCriterion("series in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotIn(List<String> values) {
            addCriterion("series not in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesBetween(String value1, String value2) {
            addCriterion("series between", value1, value2, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotBetween(String value1, String value2) {
            addCriterion("series not between", value1, value2, "series");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
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

        public Criteria andDisplayMileageIsNull() {
            addCriterion("display_mileage is null");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageIsNotNull() {
            addCriterion("display_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageEqualTo(BigDecimal value) {
            addCriterion("display_mileage =", value, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageNotEqualTo(BigDecimal value) {
            addCriterion("display_mileage <>", value, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageGreaterThan(BigDecimal value) {
            addCriterion("display_mileage >", value, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("display_mileage >=", value, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageLessThan(BigDecimal value) {
            addCriterion("display_mileage <", value, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("display_mileage <=", value, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageIn(List<BigDecimal> values) {
            addCriterion("display_mileage in", values, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageNotIn(List<BigDecimal> values) {
            addCriterion("display_mileage not in", values, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("display_mileage between", value1, value2, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andDisplayMileageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("display_mileage not between", value1, value2, "displayMileage");
            return (Criteria) this;
        }

        public Criteria andProducedYearsIsNull() {
            addCriterion("produced_years is null");
            return (Criteria) this;
        }

        public Criteria andProducedYearsIsNotNull() {
            addCriterion("produced_years is not null");
            return (Criteria) this;
        }

        public Criteria andProducedYearsEqualTo(String value) {
            addCriterion("produced_years =", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsNotEqualTo(String value) {
            addCriterion("produced_years <>", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsGreaterThan(String value) {
            addCriterion("produced_years >", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsGreaterThanOrEqualTo(String value) {
            addCriterion("produced_years >=", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsLessThan(String value) {
            addCriterion("produced_years <", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsLessThanOrEqualTo(String value) {
            addCriterion("produced_years <=", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsLike(String value) {
            addCriterion("produced_years like", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsNotLike(String value) {
            addCriterion("produced_years not like", value, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsIn(List<String> values) {
            addCriterion("produced_years in", values, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsNotIn(List<String> values) {
            addCriterion("produced_years not in", values, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsBetween(String value1, String value2) {
            addCriterion("produced_years between", value1, value2, "producedYears");
            return (Criteria) this;
        }

        public Criteria andProducedYearsNotBetween(String value1, String value2) {
            addCriterion("produced_years not between", value1, value2, "producedYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsIsNull() {
            addCriterion("register_license_years is null");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsIsNotNull() {
            addCriterion("register_license_years is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsEqualTo(String value) {
            addCriterion("register_license_years =", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsNotEqualTo(String value) {
            addCriterion("register_license_years <>", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsGreaterThan(String value) {
            addCriterion("register_license_years >", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsGreaterThanOrEqualTo(String value) {
            addCriterion("register_license_years >=", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsLessThan(String value) {
            addCriterion("register_license_years <", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsLessThanOrEqualTo(String value) {
            addCriterion("register_license_years <=", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsLike(String value) {
            addCriterion("register_license_years like", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsNotLike(String value) {
            addCriterion("register_license_years not like", value, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsIn(List<String> values) {
            addCriterion("register_license_years in", values, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsNotIn(List<String> values) {
            addCriterion("register_license_years not in", values, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsBetween(String value1, String value2) {
            addCriterion("register_license_years between", value1, value2, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsNotBetween(String value1, String value2) {
            addCriterion("register_license_years not between", value1, value2, "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserIsNull() {
            addCriterion("vehicle_appraiser is null");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserIsNotNull() {
            addCriterion("vehicle_appraiser is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserEqualTo(String value) {
            addCriterion("vehicle_appraiser =", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserNotEqualTo(String value) {
            addCriterion("vehicle_appraiser <>", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserGreaterThan(String value) {
            addCriterion("vehicle_appraiser >", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_appraiser >=", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserLessThan(String value) {
            addCriterion("vehicle_appraiser <", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserLessThanOrEqualTo(String value) {
            addCriterion("vehicle_appraiser <=", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserLike(String value) {
            addCriterion("vehicle_appraiser like", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserNotLike(String value) {
            addCriterion("vehicle_appraiser not like", value, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserIn(List<String> values) {
            addCriterion("vehicle_appraiser in", values, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserNotIn(List<String> values) {
            addCriterion("vehicle_appraiser not in", values, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserBetween(String value1, String value2) {
            addCriterion("vehicle_appraiser between", value1, value2, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserNotBetween(String value1, String value2) {
            addCriterion("vehicle_appraiser not between", value1, value2, "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andRecommenderIsNull() {
            addCriterion("recommender is null");
            return (Criteria) this;
        }

        public Criteria andRecommenderIsNotNull() {
            addCriterion("recommender is not null");
            return (Criteria) this;
        }

        public Criteria andRecommenderEqualTo(String value) {
            addCriterion("recommender =", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotEqualTo(String value) {
            addCriterion("recommender <>", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderGreaterThan(String value) {
            addCriterion("recommender >", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderGreaterThanOrEqualTo(String value) {
            addCriterion("recommender >=", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderLessThan(String value) {
            addCriterion("recommender <", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderLessThanOrEqualTo(String value) {
            addCriterion("recommender <=", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderLike(String value) {
            addCriterion("recommender like", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotLike(String value) {
            addCriterion("recommender not like", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderIn(List<String> values) {
            addCriterion("recommender in", values, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotIn(List<String> values) {
            addCriterion("recommender not in", values, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderBetween(String value1, String value2) {
            addCriterion("recommender between", value1, value2, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotBetween(String value1, String value2) {
            addCriterion("recommender not between", value1, value2, "recommender");
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

        public Criteria andVehiclePpeEqualTo(Integer value) {
            addCriterion("vehicle_ppe =", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeNotEqualTo(Integer value) {
            addCriterion("vehicle_ppe <>", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeGreaterThan(Integer value) {
            addCriterion("vehicle_ppe >", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_ppe >=", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeLessThan(Integer value) {
            addCriterion("vehicle_ppe <", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_ppe <=", value, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeIn(List<Integer> values) {
            addCriterion("vehicle_ppe in", values, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeNotIn(List<Integer> values) {
            addCriterion("vehicle_ppe not in", values, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_ppe between", value1, value2, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_ppe not between", value1, value2, "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeIsNull() {
            addCriterion("user_ppe is null");
            return (Criteria) this;
        }

        public Criteria andUserPpeIsNotNull() {
            addCriterion("user_ppe is not null");
            return (Criteria) this;
        }

        public Criteria andUserPpeEqualTo(Integer value) {
            addCriterion("user_ppe =", value, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeNotEqualTo(Integer value) {
            addCriterion("user_ppe <>", value, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeGreaterThan(Integer value) {
            addCriterion("user_ppe >", value, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_ppe >=", value, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeLessThan(Integer value) {
            addCriterion("user_ppe <", value, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeLessThanOrEqualTo(Integer value) {
            addCriterion("user_ppe <=", value, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeIn(List<Integer> values) {
            addCriterion("user_ppe in", values, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeNotIn(List<Integer> values) {
            addCriterion("user_ppe not in", values, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeBetween(Integer value1, Integer value2) {
            addCriterion("user_ppe between", value1, value2, "userPpe");
            return (Criteria) this;
        }

        public Criteria andUserPpeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_ppe not between", value1, value2, "userPpe");
            return (Criteria) this;
        }

        public Criteria andCustIntentionIsNull() {
            addCriterion("cust_intention is null");
            return (Criteria) this;
        }

        public Criteria andCustIntentionIsNotNull() {
            addCriterion("cust_intention is not null");
            return (Criteria) this;
        }

        public Criteria andCustIntentionEqualTo(Integer value) {
            addCriterion("cust_intention =", value, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionNotEqualTo(Integer value) {
            addCriterion("cust_intention <>", value, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionGreaterThan(Integer value) {
            addCriterion("cust_intention >", value, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_intention >=", value, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionLessThan(Integer value) {
            addCriterion("cust_intention <", value, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionLessThanOrEqualTo(Integer value) {
            addCriterion("cust_intention <=", value, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionIn(List<Integer> values) {
            addCriterion("cust_intention in", values, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionNotIn(List<Integer> values) {
            addCriterion("cust_intention not in", values, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionBetween(Integer value1, Integer value2) {
            addCriterion("cust_intention between", value1, value2, "custIntention");
            return (Criteria) this;
        }

        public Criteria andCustIntentionNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_intention not between", value1, value2, "custIntention");
            return (Criteria) this;
        }

        public Criteria andFirstPriceIsNull() {
            addCriterion("first_price is null");
            return (Criteria) this;
        }

        public Criteria andFirstPriceIsNotNull() {
            addCriterion("first_price is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPriceEqualTo(BigDecimal value) {
            addCriterion("first_price =", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceNotEqualTo(BigDecimal value) {
            addCriterion("first_price <>", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceGreaterThan(BigDecimal value) {
            addCriterion("first_price >", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_price >=", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceLessThan(BigDecimal value) {
            addCriterion("first_price <", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_price <=", value, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceIn(List<BigDecimal> values) {
            addCriterion("first_price in", values, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceNotIn(List<BigDecimal> values) {
            addCriterion("first_price not in", values, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_price between", value1, value2, "firstPrice");
            return (Criteria) this;
        }

        public Criteria andFirstPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_price not between", value1, value2, "firstPrice");
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

        public Criteria andVisitTimeIsNull() {
            addCriterion("visit_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNotNull() {
            addCriterion("visit_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEqualTo(Date value) {
            addCriterion("visit_time =", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotEqualTo(Date value) {
            addCriterion("visit_time <>", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThan(Date value) {
            addCriterion("visit_time >", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_time >=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThan(Date value) {
            addCriterion("visit_time <", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThanOrEqualTo(Date value) {
            addCriterion("visit_time <=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIn(List<Date> values) {
            addCriterion("visit_time in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotIn(List<Date> values) {
            addCriterion("visit_time not in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeBetween(Date value1, Date value2) {
            addCriterion("visit_time between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotBetween(Date value1, Date value2) {
            addCriterion("visit_time not between", value1, value2, "visitTime");
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

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
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

        public Criteria andContractTimeIsNull() {
            addCriterion("contract_time is null");
            return (Criteria) this;
        }

        public Criteria andContractTimeIsNotNull() {
            addCriterion("contract_time is not null");
            return (Criteria) this;
        }

        public Criteria andContractTimeEqualTo(Date value) {
            addCriterion("contract_time =", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeNotEqualTo(Date value) {
            addCriterion("contract_time <>", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeGreaterThan(Date value) {
            addCriterion("contract_time >", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("contract_time >=", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeLessThan(Date value) {
            addCriterion("contract_time <", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeLessThanOrEqualTo(Date value) {
            addCriterion("contract_time <=", value, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeIn(List<Date> values) {
            addCriterion("contract_time in", values, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeNotIn(List<Date> values) {
            addCriterion("contract_time not in", values, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeBetween(Date value1, Date value2) {
            addCriterion("contract_time between", value1, value2, "contractTime");
            return (Criteria) this;
        }

        public Criteria andContractTimeNotBetween(Date value1, Date value2) {
            addCriterion("contract_time not between", value1, value2, "contractTime");
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

        public Criteria andAvTypeIsNull() {
            addCriterion("av_type is null");
            return (Criteria) this;
        }

        public Criteria andAvTypeIsNotNull() {
            addCriterion("av_type is not null");
            return (Criteria) this;
        }

        public Criteria andAvTypeEqualTo(Integer value) {
            addCriterion("av_type =", value, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeNotEqualTo(Integer value) {
            addCriterion("av_type <>", value, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeGreaterThan(Integer value) {
            addCriterion("av_type >", value, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("av_type >=", value, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeLessThan(Integer value) {
            addCriterion("av_type <", value, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeLessThanOrEqualTo(Integer value) {
            addCriterion("av_type <=", value, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeIn(List<Integer> values) {
            addCriterion("av_type in", values, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeNotIn(List<Integer> values) {
            addCriterion("av_type not in", values, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeBetween(Integer value1, Integer value2) {
            addCriterion("av_type between", value1, value2, "avType");
            return (Criteria) this;
        }

        public Criteria andAvTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("av_type not between", value1, value2, "avType");
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

        public Criteria andFixedPriceIsNull() {
            addCriterion("fixed_price is null");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIsNotNull() {
            addCriterion("fixed_price is not null");
            return (Criteria) this;
        }

        public Criteria andFixedPriceEqualTo(BigDecimal value) {
            addCriterion("fixed_price =", value, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceNotEqualTo(BigDecimal value) {
            addCriterion("fixed_price <>", value, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceGreaterThan(BigDecimal value) {
            addCriterion("fixed_price >", value, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fixed_price >=", value, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceLessThan(BigDecimal value) {
            addCriterion("fixed_price <", value, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fixed_price <=", value, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceIn(List<BigDecimal> values) {
            addCriterion("fixed_price in", values, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceNotIn(List<BigDecimal> values) {
            addCriterion("fixed_price not in", values, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixed_price between", value1, value2, "fixedPrice");
            return (Criteria) this;
        }

        public Criteria andFixedPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixed_price not between", value1, value2, "fixedPrice");
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

        public Criteria andFinalSalePriceIsNull() {
            addCriterion("final_sale_price is null");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceIsNotNull() {
            addCriterion("final_sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceEqualTo(BigDecimal value) {
            addCriterion("final_sale_price =", value, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("final_sale_price <>", value, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceGreaterThan(BigDecimal value) {
            addCriterion("final_sale_price >", value, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_sale_price >=", value, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceLessThan(BigDecimal value) {
            addCriterion("final_sale_price <", value, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_sale_price <=", value, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceIn(List<BigDecimal> values) {
            addCriterion("final_sale_price in", values, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("final_sale_price not in", values, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_sale_price between", value1, value2, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andFinalSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_sale_price not between", value1, value2, "finalSalePrice");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdIsNull() {
            addCriterion("dealer_member_id is null");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdIsNotNull() {
            addCriterion("dealer_member_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdEqualTo(Integer value) {
            addCriterion("dealer_member_id =", value, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdNotEqualTo(Integer value) {
            addCriterion("dealer_member_id <>", value, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdGreaterThan(Integer value) {
            addCriterion("dealer_member_id >", value, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dealer_member_id >=", value, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdLessThan(Integer value) {
            addCriterion("dealer_member_id <", value, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("dealer_member_id <=", value, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdIn(List<Integer> values) {
            addCriterion("dealer_member_id in", values, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdNotIn(List<Integer> values) {
            addCriterion("dealer_member_id not in", values, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("dealer_member_id between", value1, value2, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealerMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dealer_member_id not between", value1, value2, "dealerMemberId");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = -8360273159735158801L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        /**
         */
        private static final long serialVersionUID = -2668687543327199733L;

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