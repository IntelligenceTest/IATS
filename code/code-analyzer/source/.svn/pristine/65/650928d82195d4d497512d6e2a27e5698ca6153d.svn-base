package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseVehicleExample implements Serializable {

    /**
     */
    private static final long serialVersionUID = 842696964552433384L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseVehicleExample() {
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
        private static final long serialVersionUID = 4741083114913564191L;
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

        public Criteria andBrandSeriesIsNull() {
            addCriterion("brand_series is null");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesIsNotNull() {
            addCriterion("brand_series is not null");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesEqualTo(String value) {
            addCriterion("brand_series =", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesNotEqualTo(String value) {
            addCriterion("brand_series <>", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesGreaterThan(String value) {
            addCriterion("brand_series >", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesGreaterThanOrEqualTo(String value) {
            addCriterion("brand_series >=", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesLessThan(String value) {
            addCriterion("brand_series <", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesLessThanOrEqualTo(String value) {
            addCriterion("brand_series <=", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesLike(String value) {
            addCriterion("brand_series like", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesNotLike(String value) {
            addCriterion("brand_series not like", value, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesIn(List<String> values) {
            addCriterion("brand_series in", values, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesNotIn(List<String> values) {
            addCriterion("brand_series not in", values, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesBetween(String value1, String value2) {
            addCriterion("brand_series between", value1, value2, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesNotBetween(String value1, String value2) {
            addCriterion("brand_series not between", value1, value2, "brandSeries");
            return (Criteria) this;
        }

        public Criteria andSelledNameIsNull() {
            addCriterion("selled_name is null");
            return (Criteria) this;
        }

        public Criteria andSelledNameIsNotNull() {
            addCriterion("selled_name is not null");
            return (Criteria) this;
        }

        public Criteria andSelledNameEqualTo(String value) {
            addCriterion("selled_name =", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameNotEqualTo(String value) {
            addCriterion("selled_name <>", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameGreaterThan(String value) {
            addCriterion("selled_name >", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameGreaterThanOrEqualTo(String value) {
            addCriterion("selled_name >=", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameLessThan(String value) {
            addCriterion("selled_name <", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameLessThanOrEqualTo(String value) {
            addCriterion("selled_name <=", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameLike(String value) {
            addCriterion("selled_name like", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameNotLike(String value) {
            addCriterion("selled_name not like", value, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameIn(List<String> values) {
            addCriterion("selled_name in", values, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameNotIn(List<String> values) {
            addCriterion("selled_name not in", values, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameBetween(String value1, String value2) {
            addCriterion("selled_name between", value1, value2, "selledName");
            return (Criteria) this;
        }

        public Criteria andSelledNameNotBetween(String value1, String value2) {
            addCriterion("selled_name not between", value1, value2, "selledName");
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

        public Criteria andModelYearIsNull() {
            addCriterion("model_year is null");
            return (Criteria) this;
        }

        public Criteria andModelYearIsNotNull() {
            addCriterion("model_year is not null");
            return (Criteria) this;
        }

        public Criteria andModelYearEqualTo(String value) {
            addCriterion("model_year =", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearNotEqualTo(String value) {
            addCriterion("model_year <>", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearGreaterThan(String value) {
            addCriterion("model_year >", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearGreaterThanOrEqualTo(String value) {
            addCriterion("model_year >=", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearLessThan(String value) {
            addCriterion("model_year <", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearLessThanOrEqualTo(String value) {
            addCriterion("model_year <=", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearLike(String value) {
            addCriterion("model_year like", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearNotLike(String value) {
            addCriterion("model_year not like", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearIn(List<String> values) {
            addCriterion("model_year in", values, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearNotIn(List<String> values) {
            addCriterion("model_year not in", values, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearBetween(String value1, String value2) {
            addCriterion("model_year between", value1, value2, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearNotBetween(String value1, String value2) {
            addCriterion("model_year not between", value1, value2, "modelYear");
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

        public Criteria andSweptVolumeIsNull() {
            addCriterion("swept_volume is null");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeIsNotNull() {
            addCriterion("swept_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeEqualTo(BigDecimal value) {
            addCriterion("swept_volume =", value, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeNotEqualTo(BigDecimal value) {
            addCriterion("swept_volume <>", value, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeGreaterThan(BigDecimal value) {
            addCriterion("swept_volume >", value, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("swept_volume >=", value, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeLessThan(BigDecimal value) {
            addCriterion("swept_volume <", value, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("swept_volume <=", value, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeIn(List<BigDecimal> values) {
            addCriterion("swept_volume in", values, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeNotIn(List<BigDecimal> values) {
            addCriterion("swept_volume not in", values, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("swept_volume between", value1, value2, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("swept_volume not between", value1, value2, "sweptVolume");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeIsNull() {
            addCriterion("swept_volume_type is null");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeIsNotNull() {
            addCriterion("swept_volume_type is not null");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeEqualTo(String value) {
            addCriterion("swept_volume_type =", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeNotEqualTo(String value) {
            addCriterion("swept_volume_type <>", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeGreaterThan(String value) {
            addCriterion("swept_volume_type >", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("swept_volume_type >=", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeLessThan(String value) {
            addCriterion("swept_volume_type <", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeLessThanOrEqualTo(String value) {
            addCriterion("swept_volume_type <=", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeLike(String value) {
            addCriterion("swept_volume_type like", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeNotLike(String value) {
            addCriterion("swept_volume_type not like", value, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeIn(List<String> values) {
            addCriterion("swept_volume_type in", values, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeNotIn(List<String> values) {
            addCriterion("swept_volume_type not in", values, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeBetween(String value1, String value2) {
            addCriterion("swept_volume_type between", value1, value2, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeNotBetween(String value1, String value2) {
            addCriterion("swept_volume_type not between", value1, value2, "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardIsNull() {
            addCriterion("swept_volume_standard is null");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardIsNotNull() {
            addCriterion("swept_volume_standard is not null");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardEqualTo(String value) {
            addCriterion("swept_volume_standard =", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardNotEqualTo(String value) {
            addCriterion("swept_volume_standard <>", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardGreaterThan(String value) {
            addCriterion("swept_volume_standard >", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardGreaterThanOrEqualTo(String value) {
            addCriterion("swept_volume_standard >=", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardLessThan(String value) {
            addCriterion("swept_volume_standard <", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardLessThanOrEqualTo(String value) {
            addCriterion("swept_volume_standard <=", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardLike(String value) {
            addCriterion("swept_volume_standard like", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardNotLike(String value) {
            addCriterion("swept_volume_standard not like", value, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardIn(List<String> values) {
            addCriterion("swept_volume_standard in", values, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardNotIn(List<String> values) {
            addCriterion("swept_volume_standard not in", values, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardBetween(String value1, String value2) {
            addCriterion("swept_volume_standard between", value1, value2, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardNotBetween(String value1, String value2) {
            addCriterion("swept_volume_standard not between", value1, value2, "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceIsNull() {
            addCriterion("register_province is null");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceIsNotNull() {
            addCriterion("register_province is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceEqualTo(String value) {
            addCriterion("register_province =", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotEqualTo(String value) {
            addCriterion("register_province <>", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceGreaterThan(String value) {
            addCriterion("register_province >", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("register_province >=", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceLessThan(String value) {
            addCriterion("register_province <", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceLessThanOrEqualTo(String value) {
            addCriterion("register_province <=", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceLike(String value) {
            addCriterion("register_province like", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotLike(String value) {
            addCriterion("register_province not like", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceIn(List<String> values) {
            addCriterion("register_province in", values, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotIn(List<String> values) {
            addCriterion("register_province not in", values, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceBetween(String value1, String value2) {
            addCriterion("register_province between", value1, value2, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotBetween(String value1, String value2) {
            addCriterion("register_province not between", value1, value2, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIsNull() {
            addCriterion("register_city is null");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIsNotNull() {
            addCriterion("register_city is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterCityEqualTo(String value) {
            addCriterion("register_city =", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotEqualTo(String value) {
            addCriterion("register_city <>", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityGreaterThan(String value) {
            addCriterion("register_city >", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityGreaterThanOrEqualTo(String value) {
            addCriterion("register_city >=", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLessThan(String value) {
            addCriterion("register_city <", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLessThanOrEqualTo(String value) {
            addCriterion("register_city <=", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLike(String value) {
            addCriterion("register_city like", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotLike(String value) {
            addCriterion("register_city not like", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIn(List<String> values) {
            addCriterion("register_city in", values, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotIn(List<String> values) {
            addCriterion("register_city not in", values, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityBetween(String value1, String value2) {
            addCriterion("register_city between", value1, value2, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotBetween(String value1, String value2) {
            addCriterion("register_city not between", value1, value2, "registerCity");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceIsNull() {
            addCriterion("current_province is null");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceIsNotNull() {
            addCriterion("current_province is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceEqualTo(String value) {
            addCriterion("current_province =", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceNotEqualTo(String value) {
            addCriterion("current_province <>", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceGreaterThan(String value) {
            addCriterion("current_province >", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("current_province >=", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceLessThan(String value) {
            addCriterion("current_province <", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceLessThanOrEqualTo(String value) {
            addCriterion("current_province <=", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceLike(String value) {
            addCriterion("current_province like", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceNotLike(String value) {
            addCriterion("current_province not like", value, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceIn(List<String> values) {
            addCriterion("current_province in", values, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceNotIn(List<String> values) {
            addCriterion("current_province not in", values, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceBetween(String value1, String value2) {
            addCriterion("current_province between", value1, value2, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceNotBetween(String value1, String value2) {
            addCriterion("current_province not between", value1, value2, "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentCityIsNull() {
            addCriterion("current_city is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCityIsNotNull() {
            addCriterion("current_city is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCityEqualTo(String value) {
            addCriterion("current_city =", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityNotEqualTo(String value) {
            addCriterion("current_city <>", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityGreaterThan(String value) {
            addCriterion("current_city >", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityGreaterThanOrEqualTo(String value) {
            addCriterion("current_city >=", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityLessThan(String value) {
            addCriterion("current_city <", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityLessThanOrEqualTo(String value) {
            addCriterion("current_city <=", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityLike(String value) {
            addCriterion("current_city like", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityNotLike(String value) {
            addCriterion("current_city not like", value, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityIn(List<String> values) {
            addCriterion("current_city in", values, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityNotIn(List<String> values) {
            addCriterion("current_city not in", values, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityBetween(String value1, String value2) {
            addCriterion("current_city between", value1, value2, "currentCity");
            return (Criteria) this;
        }

        public Criteria andCurrentCityNotBetween(String value1, String value2) {
            addCriterion("current_city not between", value1, value2, "currentCity");
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

        public Criteria andBodyColorIsNull() {
            addCriterion("body_color is null");
            return (Criteria) this;
        }

        public Criteria andBodyColorIsNotNull() {
            addCriterion("body_color is not null");
            return (Criteria) this;
        }

        public Criteria andBodyColorEqualTo(String value) {
            addCriterion("body_color =", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorNotEqualTo(String value) {
            addCriterion("body_color <>", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorGreaterThan(String value) {
            addCriterion("body_color >", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorGreaterThanOrEqualTo(String value) {
            addCriterion("body_color >=", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorLessThan(String value) {
            addCriterion("body_color <", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorLessThanOrEqualTo(String value) {
            addCriterion("body_color <=", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorLike(String value) {
            addCriterion("body_color like", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorNotLike(String value) {
            addCriterion("body_color not like", value, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorIn(List<String> values) {
            addCriterion("body_color in", values, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorNotIn(List<String> values) {
            addCriterion("body_color not in", values, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorBetween(String value1, String value2) {
            addCriterion("body_color between", value1, value2, "bodyColor");
            return (Criteria) this;
        }

        public Criteria andBodyColorNotBetween(String value1, String value2) {
            addCriterion("body_color not between", value1, value2, "bodyColor");
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

        public Criteria andVehicleTypeIsNull() {
            addCriterion("vehicle_type is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNotNull() {
            addCriterion("vehicle_type is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeEqualTo(String value) {
            addCriterion("vehicle_type =", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotEqualTo(String value) {
            addCriterion("vehicle_type <>", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThan(String value) {
            addCriterion("vehicle_type >", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_type >=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThan(String value) {
            addCriterion("vehicle_type <", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThanOrEqualTo(String value) {
            addCriterion("vehicle_type <=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLike(String value) {
            addCriterion("vehicle_type like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotLike(String value) {
            addCriterion("vehicle_type not like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIn(List<String> values) {
            addCriterion("vehicle_type in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotIn(List<String> values) {
            addCriterion("vehicle_type not in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeBetween(String value1, String value2) {
            addCriterion("vehicle_type between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotBetween(String value1, String value2) {
            addCriterion("vehicle_type not between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceIsNull() {
            addCriterion("start_bid_price is null");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceIsNotNull() {
            addCriterion("start_bid_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceEqualTo(BigDecimal value) {
            addCriterion("start_bid_price =", value, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceNotEqualTo(BigDecimal value) {
            addCriterion("start_bid_price <>", value, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceGreaterThan(BigDecimal value) {
            addCriterion("start_bid_price >", value, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("start_bid_price >=", value, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceLessThan(BigDecimal value) {
            addCriterion("start_bid_price <", value, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("start_bid_price <=", value, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceIn(List<BigDecimal> values) {
            addCriterion("start_bid_price in", values, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceNotIn(List<BigDecimal> values) {
            addCriterion("start_bid_price not in", values, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_bid_price between", value1, value2, "startBidPrice");
            return (Criteria) this;
        }

        public Criteria andStartBidPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_bid_price not between", value1, value2, "startBidPrice");
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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

        public Criteria andSaleStatusEqualTo(Short value) {
            addCriterion("sale_status =", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotEqualTo(Short value) {
            addCriterion("sale_status <>", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusGreaterThan(Short value) {
            addCriterion("sale_status >", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("sale_status >=", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusLessThan(Short value) {
            addCriterion("sale_status <", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusLessThanOrEqualTo(Short value) {
            addCriterion("sale_status <=", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusIn(List<Short> values) {
            addCriterion("sale_status in", values, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotIn(List<Short> values) {
            addCriterion("sale_status not in", values, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusBetween(Short value1, Short value2) {
            addCriterion("sale_status between", value1, value2, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotBetween(Short value1, Short value2) {
            addCriterion("sale_status not between", value1, value2, "saleStatus");
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

        public Criteria andAppraiserIdIsNull() {
            addCriterion("appraiser_id is null");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdIsNotNull() {
            addCriterion("appraiser_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdEqualTo(Integer value) {
            addCriterion("appraiser_id =", value, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdNotEqualTo(Integer value) {
            addCriterion("appraiser_id <>", value, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdGreaterThan(Integer value) {
            addCriterion("appraiser_id >", value, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appraiser_id >=", value, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdLessThan(Integer value) {
            addCriterion("appraiser_id <", value, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdLessThanOrEqualTo(Integer value) {
            addCriterion("appraiser_id <=", value, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdIn(List<Integer> values) {
            addCriterion("appraiser_id in", values, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdNotIn(List<Integer> values) {
            addCriterion("appraiser_id not in", values, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdBetween(Integer value1, Integer value2) {
            addCriterion("appraiser_id between", value1, value2, "appraiserId");
            return (Criteria) this;
        }

        public Criteria andAppraiserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appraiser_id not between", value1, value2, "appraiserId");
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

        public Criteria andEvalOrgIdIsNull() {
            addCriterion("eval_org_id is null");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdIsNotNull() {
            addCriterion("eval_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdEqualTo(Integer value) {
            addCriterion("eval_org_id =", value, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdNotEqualTo(Integer value) {
            addCriterion("eval_org_id <>", value, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdGreaterThan(Integer value) {
            addCriterion("eval_org_id >", value, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("eval_org_id >=", value, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdLessThan(Integer value) {
            addCriterion("eval_org_id <", value, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("eval_org_id <=", value, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdIn(List<Integer> values) {
            addCriterion("eval_org_id in", values, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdNotIn(List<Integer> values) {
            addCriterion("eval_org_id not in", values, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("eval_org_id between", value1, value2, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvalOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("eval_org_id not between", value1, value2, "evalOrgId");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptIsNull() {
            addCriterion("evaluation_dept is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptIsNotNull() {
            addCriterion("evaluation_dept is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptEqualTo(String value) {
            addCriterion("evaluation_dept =", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptNotEqualTo(String value) {
            addCriterion("evaluation_dept <>", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptGreaterThan(String value) {
            addCriterion("evaluation_dept >", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation_dept >=", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptLessThan(String value) {
            addCriterion("evaluation_dept <", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptLessThanOrEqualTo(String value) {
            addCriterion("evaluation_dept <=", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptLike(String value) {
            addCriterion("evaluation_dept like", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptNotLike(String value) {
            addCriterion("evaluation_dept not like", value, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptIn(List<String> values) {
            addCriterion("evaluation_dept in", values, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptNotIn(List<String> values) {
            addCriterion("evaluation_dept not in", values, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptBetween(String value1, String value2) {
            addCriterion("evaluation_dept between", value1, value2, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptNotBetween(String value1, String value2) {
            addCriterion("evaluation_dept not between", value1, value2, "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlIsNull() {
            addCriterion("first_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlIsNotNull() {
            addCriterion("first_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlEqualTo(String value) {
            addCriterion("first_photo_url =", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlNotEqualTo(String value) {
            addCriterion("first_photo_url <>", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlGreaterThan(String value) {
            addCriterion("first_photo_url >", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("first_photo_url >=", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlLessThan(String value) {
            addCriterion("first_photo_url <", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("first_photo_url <=", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlLike(String value) {
            addCriterion("first_photo_url like", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlNotLike(String value) {
            addCriterion("first_photo_url not like", value, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlIn(List<String> values) {
            addCriterion("first_photo_url in", values, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlNotIn(List<String> values) {
            addCriterion("first_photo_url not in", values, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlBetween(String value1, String value2) {
            addCriterion("first_photo_url between", value1, value2, "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("first_photo_url not between", value1, value2, "firstPhotoUrl");
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

        public Criteria andVehicleSrcTypeIsNull() {
            addCriterion("vehicle_src_type is null");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeIsNotNull() {
            addCriterion("vehicle_src_type is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeEqualTo(Short value) {
            addCriterion("vehicle_src_type =", value, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeNotEqualTo(Short value) {
            addCriterion("vehicle_src_type <>", value, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeGreaterThan(Short value) {
            addCriterion("vehicle_src_type >", value, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("vehicle_src_type >=", value, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeLessThan(Short value) {
            addCriterion("vehicle_src_type <", value, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeLessThanOrEqualTo(Short value) {
            addCriterion("vehicle_src_type <=", value, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeIn(List<Short> values) {
            addCriterion("vehicle_src_type in", values, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeNotIn(List<Short> values) {
            addCriterion("vehicle_src_type not in", values, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeBetween(Short value1, Short value2) {
            addCriterion("vehicle_src_type between", value1, value2, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcTypeNotBetween(Short value1, Short value2) {
            addCriterion("vehicle_src_type not between", value1, value2, "vehicleSrcType");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdIsNull() {
            addCriterion("vehicle_src_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdIsNotNull() {
            addCriterion("vehicle_src_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdEqualTo(Integer value) {
            addCriterion("vehicle_src_id =", value, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdNotEqualTo(Integer value) {
            addCriterion("vehicle_src_id <>", value, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdGreaterThan(Integer value) {
            addCriterion("vehicle_src_id >", value, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_src_id >=", value, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdLessThan(Integer value) {
            addCriterion("vehicle_src_id <", value, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_src_id <=", value, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdIn(List<Integer> values) {
            addCriterion("vehicle_src_id in", values, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdNotIn(List<Integer> values) {
            addCriterion("vehicle_src_id not in", values, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_src_id between", value1, value2, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andVehicleSrcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_src_id not between", value1, value2, "vehicleSrcId");
            return (Criteria) this;
        }

        public Criteria andCertifiedIsNull() {
            addCriterion("is_certified is null");
            return (Criteria) this;
        }

        public Criteria andCertifiedIsNotNull() {
            addCriterion("is_certified is not null");
            return (Criteria) this;
        }

        public Criteria andCertifiedEqualTo(Boolean value) {
            addCriterion("is_certified =", value, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedNotEqualTo(Boolean value) {
            addCriterion("is_certified <>", value, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedGreaterThan(Boolean value) {
            addCriterion("is_certified >", value, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_certified >=", value, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedLessThan(Boolean value) {
            addCriterion("is_certified <", value, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_certified <=", value, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedIn(List<Boolean> values) {
            addCriterion("is_certified in", values, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedNotIn(List<Boolean> values) {
            addCriterion("is_certified not in", values, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_certified between", value1, value2, "certified");
            return (Criteria) this;
        }

        public Criteria andCertifiedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_certified not between", value1, value2, "certified");
            return (Criteria) this;
        }

        public Criteria andGuaranteedIsNull() {
            addCriterion("is_guaranteed is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteedIsNotNull() {
            addCriterion("is_guaranteed is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteedEqualTo(Boolean value) {
            addCriterion("is_guaranteed =", value, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedNotEqualTo(Boolean value) {
            addCriterion("is_guaranteed <>", value, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedGreaterThan(Boolean value) {
            addCriterion("is_guaranteed >", value, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_guaranteed >=", value, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedLessThan(Boolean value) {
            addCriterion("is_guaranteed <", value, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_guaranteed <=", value, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedIn(List<Boolean> values) {
            addCriterion("is_guaranteed in", values, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedNotIn(List<Boolean> values) {
            addCriterion("is_guaranteed not in", values, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_guaranteed between", value1, value2, "guaranteed");
            return (Criteria) this;
        }

        public Criteria andGuaranteedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_guaranteed not between", value1, value2, "guaranteed");
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

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIsNull() {
            addCriterion("audit_flag is null");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIsNotNull() {
            addCriterion("audit_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAuditFlagEqualTo(Integer value) {
            addCriterion("audit_flag =", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotEqualTo(Integer value) {
            addCriterion("audit_flag <>", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagGreaterThan(Integer value) {
            addCriterion("audit_flag >", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_flag >=", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagLessThan(Integer value) {
            addCriterion("audit_flag <", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagLessThanOrEqualTo(Integer value) {
            addCriterion("audit_flag <=", value, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagIn(List<Integer> values) {
            addCriterion("audit_flag in", values, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotIn(List<Integer> values) {
            addCriterion("audit_flag not in", values, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagBetween(Integer value1, Integer value2) {
            addCriterion("audit_flag between", value1, value2, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andAuditFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_flag not between", value1, value2, "auditFlag");
            return (Criteria) this;
        }

        public Criteria andPricingIsNull() {
            addCriterion("is_pricing is null");
            return (Criteria) this;
        }

        public Criteria andPricingIsNotNull() {
            addCriterion("is_pricing is not null");
            return (Criteria) this;
        }

        public Criteria andPricingEqualTo(Boolean value) {
            addCriterion("is_pricing =", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingNotEqualTo(Boolean value) {
            addCriterion("is_pricing <>", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingGreaterThan(Boolean value) {
            addCriterion("is_pricing >", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_pricing >=", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingLessThan(Boolean value) {
            addCriterion("is_pricing <", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingLessThanOrEqualTo(Boolean value) {
            addCriterion("is_pricing <=", value, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingIn(List<Boolean> values) {
            addCriterion("is_pricing in", values, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingNotIn(List<Boolean> values) {
            addCriterion("is_pricing not in", values, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pricing between", value1, value2, "pricing");
            return (Criteria) this;
        }

        public Criteria andPricingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pricing not between", value1, value2, "pricing");
            return (Criteria) this;
        }

        public Criteria andVinCodeLikeInsensitive(String value) {
            addCriterion("upper(vin_code) like", value.toUpperCase(), "vinCode");
            return (Criteria) this;
        }

        public Criteria andBrandLikeInsensitive(String value) {
            addCriterion("upper(brand) like", value.toUpperCase(), "brand");
            return (Criteria) this;
        }

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(code) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andBrandSeriesLikeInsensitive(String value) {
            addCriterion("upper(brand_series) like", value.toUpperCase(), "brandSeries");
            return (Criteria) this;
        }

        public Criteria andSelledNameLikeInsensitive(String value) {
            addCriterion("upper(selled_name) like", value.toUpperCase(), "selledName");
            return (Criteria) this;
        }

        public Criteria andVehicleModelLikeInsensitive(String value) {
            addCriterion("upper(vehicle_model) like", value.toUpperCase(), "vehicleModel");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseYearsLikeInsensitive(String value) {
            addCriterion("upper(register_license_years) like", value.toUpperCase(), "registerLicenseYears");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeTypeLikeInsensitive(String value) {
            addCriterion("upper(swept_volume_type) like", value.toUpperCase(), "sweptVolumeType");
            return (Criteria) this;
        }

        public Criteria andSweptVolumeStandardLikeInsensitive(String value) {
            addCriterion("upper(swept_volume_standard) like", value.toUpperCase(), "sweptVolumeStandard");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceLikeInsensitive(String value) {
            addCriterion("upper(register_province) like", value.toUpperCase(), "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLikeInsensitive(String value) {
            addCriterion("upper(register_city) like", value.toUpperCase(), "registerCity");
            return (Criteria) this;
        }

        public Criteria andCurrentProvinceLikeInsensitive(String value) {
            addCriterion("upper(current_province) like", value.toUpperCase(), "currentProvince");
            return (Criteria) this;
        }

        public Criteria andCurrentCityLikeInsensitive(String value) {
            addCriterion("upper(current_city) like", value.toUpperCase(), "currentCity");
            return (Criteria) this;
        }

        public Criteria andLicenseCodeLikeInsensitive(String value) {
            addCriterion("upper(license_code) like", value.toUpperCase(), "licenseCode");
            return (Criteria) this;
        }

        public Criteria andBodyColorLikeInsensitive(String value) {
            addCriterion("upper(body_color) like", value.toUpperCase(), "bodyColor");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLikeInsensitive(String value) {
            addCriterion("upper(vehicle_type) like", value.toUpperCase(), "vehicleType");
            return (Criteria) this;
        }

        public Criteria andSourceLikeInsensitive(String value) {
            addCriterion("upper(source) like", value.toUpperCase(), "source");
            return (Criteria) this;
        }

        public Criteria andVehiclePpeLikeInsensitive(String value) {
            addCriterion("upper(vehicle_ppe) like", value.toUpperCase(), "vehiclePpe");
            return (Criteria) this;
        }

        public Criteria andVehicleAppraiserLikeInsensitive(String value) {
            addCriterion("upper(vehicle_appraiser) like", value.toUpperCase(), "vehicleAppraiser");
            return (Criteria) this;
        }

        public Criteria andEvaluationDeptLikeInsensitive(String value) {
            addCriterion("upper(evaluation_dept) like", value.toUpperCase(), "evaluationDept");
            return (Criteria) this;
        }

        public Criteria andFirstPhotoUrlLikeInsensitive(String value) {
            addCriterion("upper(first_photo_url) like", value.toUpperCase(), "firstPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andVehicleDescLikeInsensitive(String value) {
            addCriterion("upper(vehicle_desc) like", value.toUpperCase(), "vehicleDesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = 5990917122337371967L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
         */
        private static final long serialVersionUID = -5555142776068442334L;

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