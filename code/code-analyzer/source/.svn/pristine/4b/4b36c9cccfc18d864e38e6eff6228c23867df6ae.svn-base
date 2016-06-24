package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseAuctionExample implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7795206158505474527L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseAuctionExample() {
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
		 * 
		 */
        private static final long serialVersionUID = -8831927855820022634L;
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStartTimestampIsNull() {
            addCriterion("start_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andStartTimestampIsNotNull() {
            addCriterion("start_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimestampEqualTo(Date value) {
            addCriterion("start_timestamp =", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampNotEqualTo(Date value) {
            addCriterion("start_timestamp <>", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampGreaterThan(Date value) {
            addCriterion("start_timestamp >", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("start_timestamp >=", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampLessThan(Date value) {
            addCriterion("start_timestamp <", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampLessThanOrEqualTo(Date value) {
            addCriterion("start_timestamp <=", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampIn(List<Date> values) {
            addCriterion("start_timestamp in", values, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampNotIn(List<Date> values) {
            addCriterion("start_timestamp not in", values, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampBetween(Date value1, Date value2) {
            addCriterion("start_timestamp between", value1, value2, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampNotBetween(Date value1, Date value2) {
            addCriterion("start_timestamp not between", value1, value2, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampIsNull() {
            addCriterion("end_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andEndTimestampIsNotNull() {
            addCriterion("end_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimestampEqualTo(Date value) {
            addCriterion("end_timestamp =", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampNotEqualTo(Date value) {
            addCriterion("end_timestamp <>", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampGreaterThan(Date value) {
            addCriterion("end_timestamp >", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("end_timestamp >=", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampLessThan(Date value) {
            addCriterion("end_timestamp <", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampLessThanOrEqualTo(Date value) {
            addCriterion("end_timestamp <=", value, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampIn(List<Date> values) {
            addCriterion("end_timestamp in", values, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampNotIn(List<Date> values) {
            addCriterion("end_timestamp not in", values, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampBetween(Date value1, Date value2) {
            addCriterion("end_timestamp between", value1, value2, "endTimestamp");
            return (Criteria) this;
        }

        public Criteria andEndTimestampNotBetween(Date value1, Date value2) {
            addCriterion("end_timestamp not between", value1, value2, "endTimestamp");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneIsNull() {
            addCriterion("contact_tellphone is null");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneIsNotNull() {
            addCriterion("contact_tellphone is not null");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneEqualTo(String value) {
            addCriterion("contact_tellphone =", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneNotEqualTo(String value) {
            addCriterion("contact_tellphone <>", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneGreaterThan(String value) {
            addCriterion("contact_tellphone >", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_tellphone >=", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneLessThan(String value) {
            addCriterion("contact_tellphone <", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneLessThanOrEqualTo(String value) {
            addCriterion("contact_tellphone <=", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneLike(String value) {
            addCriterion("contact_tellphone like", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneNotLike(String value) {
            addCriterion("contact_tellphone not like", value, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneIn(List<String> values) {
            addCriterion("contact_tellphone in", values, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneNotIn(List<String> values) {
            addCriterion("contact_tellphone not in", values, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneBetween(String value1, String value2) {
            addCriterion("contact_tellphone between", value1, value2, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneNotBetween(String value1, String value2) {
            addCriterion("contact_tellphone not between", value1, value2, "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andDepositMarginIsNull() {
            addCriterion("is_deposit_margin is null");
            return (Criteria) this;
        }

        public Criteria andDepositMarginIsNotNull() {
            addCriterion("is_deposit_margin is not null");
            return (Criteria) this;
        }

        public Criteria andDepositMarginEqualTo(Boolean value) {
            addCriterion("is_deposit_margin =", value, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginNotEqualTo(Boolean value) {
            addCriterion("is_deposit_margin <>", value, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginGreaterThan(Boolean value) {
            addCriterion("is_deposit_margin >", value, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deposit_margin >=", value, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginLessThan(Boolean value) {
            addCriterion("is_deposit_margin <", value, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deposit_margin <=", value, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginIn(List<Boolean> values) {
            addCriterion("is_deposit_margin in", values, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginNotIn(List<Boolean> values) {
            addCriterion("is_deposit_margin not in", values, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deposit_margin between", value1, value2, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andDepositMarginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deposit_margin not between", value1, value2, "depositMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginIsNull() {
            addCriterion("vehicle_margin is null");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginIsNotNull() {
            addCriterion("vehicle_margin is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginEqualTo(BigDecimal value) {
            addCriterion("vehicle_margin =", value, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginNotEqualTo(BigDecimal value) {
            addCriterion("vehicle_margin <>", value, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginGreaterThan(BigDecimal value) {
            addCriterion("vehicle_margin >", value, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicle_margin >=", value, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginLessThan(BigDecimal value) {
            addCriterion("vehicle_margin <", value, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicle_margin <=", value, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginIn(List<BigDecimal> values) {
            addCriterion("vehicle_margin in", values, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginNotIn(List<BigDecimal> values) {
            addCriterion("vehicle_margin not in", values, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicle_margin between", value1, value2, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andVehicleMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicle_margin not between", value1, value2, "vehicleMargin");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlIsNull() {
            addCriterion("audio_url is null");
            return (Criteria) this;
        }

        public Criteria andAudioUrlIsNotNull() {
            addCriterion("audio_url is not null");
            return (Criteria) this;
        }

        public Criteria andAudioUrlEqualTo(String value) {
            addCriterion("audio_url =", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotEqualTo(String value) {
            addCriterion("audio_url <>", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlGreaterThan(String value) {
            addCriterion("audio_url >", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlGreaterThanOrEqualTo(String value) {
            addCriterion("audio_url >=", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlLessThan(String value) {
            addCriterion("audio_url <", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlLessThanOrEqualTo(String value) {
            addCriterion("audio_url <=", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlLike(String value) {
            addCriterion("audio_url like", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotLike(String value) {
            addCriterion("audio_url not like", value, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlIn(List<String> values) {
            addCriterion("audio_url in", values, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotIn(List<String> values) {
            addCriterion("audio_url not in", values, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlBetween(String value1, String value2) {
            addCriterion("audio_url between", value1, value2, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlNotBetween(String value1, String value2) {
            addCriterion("audio_url not between", value1, value2, "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneIsNull() {
            addCriterion("auctioneer_cellphone is null");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneIsNotNull() {
            addCriterion("auctioneer_cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneEqualTo(String value) {
            addCriterion("auctioneer_cellphone =", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneNotEqualTo(String value) {
            addCriterion("auctioneer_cellphone <>", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneGreaterThan(String value) {
            addCriterion("auctioneer_cellphone >", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("auctioneer_cellphone >=", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneLessThan(String value) {
            addCriterion("auctioneer_cellphone <", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneLessThanOrEqualTo(String value) {
            addCriterion("auctioneer_cellphone <=", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneLike(String value) {
            addCriterion("auctioneer_cellphone like", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneNotLike(String value) {
            addCriterion("auctioneer_cellphone not like", value, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneIn(List<String> values) {
            addCriterion("auctioneer_cellphone in", values, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneNotIn(List<String> values) {
            addCriterion("auctioneer_cellphone not in", values, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneBetween(String value1, String value2) {
            addCriterion("auctioneer_cellphone between", value1, value2, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneNotBetween(String value1, String value2) {
            addCriterion("auctioneer_cellphone not between", value1, value2, "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityIsNull() {
            addCriterion("vehicle_quantity is null");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityIsNotNull() {
            addCriterion("vehicle_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityEqualTo(Short value) {
            addCriterion("vehicle_quantity =", value, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityNotEqualTo(Short value) {
            addCriterion("vehicle_quantity <>", value, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityGreaterThan(Short value) {
            addCriterion("vehicle_quantity >", value, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityGreaterThanOrEqualTo(Short value) {
            addCriterion("vehicle_quantity >=", value, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityLessThan(Short value) {
            addCriterion("vehicle_quantity <", value, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityLessThanOrEqualTo(Short value) {
            addCriterion("vehicle_quantity <=", value, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityIn(List<Short> values) {
            addCriterion("vehicle_quantity in", values, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityNotIn(List<Short> values) {
            addCriterion("vehicle_quantity not in", values, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityBetween(Short value1, Short value2) {
            addCriterion("vehicle_quantity between", value1, value2, "vehicleQuantity");
            return (Criteria) this;
        }

        public Criteria andVehicleQuantityNotBetween(Short value1, Short value2) {
            addCriterion("vehicle_quantity not between", value1, value2, "vehicleQuantity");
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

        public Criteria andAuctionMarginIsNull() {
            addCriterion("auction_margin is null");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginIsNotNull() {
            addCriterion("auction_margin is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginEqualTo(BigDecimal value) {
            addCriterion("auction_margin =", value, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginNotEqualTo(BigDecimal value) {
            addCriterion("auction_margin <>", value, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginGreaterThan(BigDecimal value) {
            addCriterion("auction_margin >", value, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("auction_margin >=", value, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginLessThan(BigDecimal value) {
            addCriterion("auction_margin <", value, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("auction_margin <=", value, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginIn(List<BigDecimal> values) {
            addCriterion("auction_margin in", values, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginNotIn(List<BigDecimal> values) {
            addCriterion("auction_margin not in", values, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auction_margin between", value1, value2, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andAuctionMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auction_margin not between", value1, value2, "auctionMargin");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideIsNull() {
            addCriterion("transaction_guide is null");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideIsNotNull() {
            addCriterion("transaction_guide is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideEqualTo(String value) {
            addCriterion("transaction_guide =", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideNotEqualTo(String value) {
            addCriterion("transaction_guide <>", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideGreaterThan(String value) {
            addCriterion("transaction_guide >", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_guide >=", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideLessThan(String value) {
            addCriterion("transaction_guide <", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideLessThanOrEqualTo(String value) {
            addCriterion("transaction_guide <=", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideLike(String value) {
            addCriterion("transaction_guide like", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideNotLike(String value) {
            addCriterion("transaction_guide not like", value, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideIn(List<String> values) {
            addCriterion("transaction_guide in", values, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideNotIn(List<String> values) {
            addCriterion("transaction_guide not in", values, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideBetween(String value1, String value2) {
            addCriterion("transaction_guide between", value1, value2, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideNotBetween(String value1, String value2) {
            addCriterion("transaction_guide not between", value1, value2, "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNull() {
            addCriterion("notice is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNotNull() {
            addCriterion("notice is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEqualTo(String value) {
            addCriterion("notice =", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotEqualTo(String value) {
            addCriterion("notice <>", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThan(String value) {
            addCriterion("notice >", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("notice >=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThan(String value) {
            addCriterion("notice <", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThanOrEqualTo(String value) {
            addCriterion("notice <=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLike(String value) {
            addCriterion("notice like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotLike(String value) {
            addCriterion("notice not like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeIn(List<String> values) {
            addCriterion("notice in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotIn(List<String> values) {
            addCriterion("notice not in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeBetween(String value1, String value2) {
            addCriterion("notice between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotBetween(String value1, String value2) {
            addCriterion("notice not between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescIsNull() {
            addCriterion("auction_model_desc is null");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescIsNotNull() {
            addCriterion("auction_model_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescEqualTo(String value) {
            addCriterion("auction_model_desc =", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescNotEqualTo(String value) {
            addCriterion("auction_model_desc <>", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescGreaterThan(String value) {
            addCriterion("auction_model_desc >", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescGreaterThanOrEqualTo(String value) {
            addCriterion("auction_model_desc >=", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescLessThan(String value) {
            addCriterion("auction_model_desc <", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescLessThanOrEqualTo(String value) {
            addCriterion("auction_model_desc <=", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescLike(String value) {
            addCriterion("auction_model_desc like", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescNotLike(String value) {
            addCriterion("auction_model_desc not like", value, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescIn(List<String> values) {
            addCriterion("auction_model_desc in", values, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescNotIn(List<String> values) {
            addCriterion("auction_model_desc not in", values, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescBetween(String value1, String value2) {
            addCriterion("auction_model_desc between", value1, value2, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescNotBetween(String value1, String value2) {
            addCriterion("auction_model_desc not between", value1, value2, "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescIsNull() {
            addCriterion("acution_vehicle_desc is null");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescIsNotNull() {
            addCriterion("acution_vehicle_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescEqualTo(String value) {
            addCriterion("acution_vehicle_desc =", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescNotEqualTo(String value) {
            addCriterion("acution_vehicle_desc <>", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescGreaterThan(String value) {
            addCriterion("acution_vehicle_desc >", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescGreaterThanOrEqualTo(String value) {
            addCriterion("acution_vehicle_desc >=", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescLessThan(String value) {
            addCriterion("acution_vehicle_desc <", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescLessThanOrEqualTo(String value) {
            addCriterion("acution_vehicle_desc <=", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescLike(String value) {
            addCriterion("acution_vehicle_desc like", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescNotLike(String value) {
            addCriterion("acution_vehicle_desc not like", value, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescIn(List<String> values) {
            addCriterion("acution_vehicle_desc in", values, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescNotIn(List<String> values) {
            addCriterion("acution_vehicle_desc not in", values, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescBetween(String value1, String value2) {
            addCriterion("acution_vehicle_desc between", value1, value2, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescNotBetween(String value1, String value2) {
            addCriterion("acution_vehicle_desc not between", value1, value2, "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidIsNull() {
            addCriterion("current_av_sid is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidIsNotNull() {
            addCriterion("current_av_sid is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidEqualTo(String value) {
            addCriterion("current_av_sid =", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidNotEqualTo(String value) {
            addCriterion("current_av_sid <>", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidGreaterThan(String value) {
            addCriterion("current_av_sid >", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidGreaterThanOrEqualTo(String value) {
            addCriterion("current_av_sid >=", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidLessThan(String value) {
            addCriterion("current_av_sid <", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidLessThanOrEqualTo(String value) {
            addCriterion("current_av_sid <=", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidLike(String value) {
            addCriterion("current_av_sid like", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidNotLike(String value) {
            addCriterion("current_av_sid not like", value, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidIn(List<String> values) {
            addCriterion("current_av_sid in", values, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidNotIn(List<String> values) {
            addCriterion("current_av_sid not in", values, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidBetween(String value1, String value2) {
            addCriterion("current_av_sid between", value1, value2, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidNotBetween(String value1, String value2) {
            addCriterion("current_av_sid not between", value1, value2, "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeIsNull() {
            addCriterion("end_display_time is null");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeIsNotNull() {
            addCriterion("end_display_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeEqualTo(Date value) {
            addCriterion("end_display_time =", value, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeNotEqualTo(Date value) {
            addCriterion("end_display_time <>", value, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeGreaterThan(Date value) {
            addCriterion("end_display_time >", value, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_display_time >=", value, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeLessThan(Date value) {
            addCriterion("end_display_time <", value, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_display_time <=", value, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeIn(List<Date> values) {
            addCriterion("end_display_time in", values, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeNotIn(List<Date> values) {
            addCriterion("end_display_time not in", values, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeBetween(Date value1, Date value2) {
            addCriterion("end_display_time between", value1, value2, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andEndDisplayTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_display_time not between", value1, value2, "endDisplayTime");
            return (Criteria) this;
        }

        public Criteria andSpecialIsNull() {
            addCriterion("is_special is null");
            return (Criteria) this;
        }

        public Criteria andSpecialIsNotNull() {
            addCriterion("is_special is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialEqualTo(Boolean value) {
            addCriterion("is_special =", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialNotEqualTo(Boolean value) {
            addCriterion("is_special <>", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialGreaterThan(Boolean value) {
            addCriterion("is_special >", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_special >=", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialLessThan(Boolean value) {
            addCriterion("is_special <", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialLessThanOrEqualTo(Boolean value) {
            addCriterion("is_special <=", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialIn(List<Boolean> values) {
            addCriterion("is_special in", values, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialNotIn(List<Boolean> values) {
            addCriterion("is_special not in", values, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialBetween(Boolean value1, Boolean value2) {
            addCriterion("is_special between", value1, value2, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_special not between", value1, value2, "special");
            return (Criteria) this;
        }

        public Criteria andPlaceIdIsNull() {
            addCriterion("place_id is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIdIsNotNull() {
            addCriterion("place_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceIdEqualTo(Integer value) {
            addCriterion("place_id =", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdNotEqualTo(Integer value) {
            addCriterion("place_id <>", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdGreaterThan(Integer value) {
            addCriterion("place_id >", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("place_id >=", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdLessThan(Integer value) {
            addCriterion("place_id <", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdLessThanOrEqualTo(Integer value) {
            addCriterion("place_id <=", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdIn(List<Integer> values) {
            addCriterion("place_id in", values, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdNotIn(List<Integer> values) {
            addCriterion("place_id not in", values, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdBetween(Integer value1, Integer value2) {
            addCriterion("place_id between", value1, value2, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("place_id not between", value1, value2, "placeId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdIsNull() {
            addCriterion("driveway_id is null");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdIsNotNull() {
            addCriterion("driveway_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdEqualTo(Integer value) {
            addCriterion("driveway_id =", value, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdNotEqualTo(Integer value) {
            addCriterion("driveway_id <>", value, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdGreaterThan(Integer value) {
            addCriterion("driveway_id >", value, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("driveway_id >=", value, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdLessThan(Integer value) {
            addCriterion("driveway_id <", value, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdLessThanOrEqualTo(Integer value) {
            addCriterion("driveway_id <=", value, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdIn(List<Integer> values) {
            addCriterion("driveway_id in", values, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdNotIn(List<Integer> values) {
            addCriterion("driveway_id not in", values, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdBetween(Integer value1, Integer value2) {
            addCriterion("driveway_id between", value1, value2, "drivewayId");
            return (Criteria) this;
        }

        public Criteria andDrivewayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("driveway_id not between", value1, value2, "drivewayId");
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

        public Criteria andBanner1UrlIsNull() {
            addCriterion("banner1_url is null");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlIsNotNull() {
            addCriterion("banner1_url is not null");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlEqualTo(String value) {
            addCriterion("banner1_url =", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlNotEqualTo(String value) {
            addCriterion("banner1_url <>", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlGreaterThan(String value) {
            addCriterion("banner1_url >", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner1_url >=", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlLessThan(String value) {
            addCriterion("banner1_url <", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlLessThanOrEqualTo(String value) {
            addCriterion("banner1_url <=", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlLike(String value) {
            addCriterion("banner1_url like", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlNotLike(String value) {
            addCriterion("banner1_url not like", value, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlIn(List<String> values) {
            addCriterion("banner1_url in", values, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlNotIn(List<String> values) {
            addCriterion("banner1_url not in", values, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlBetween(String value1, String value2) {
            addCriterion("banner1_url between", value1, value2, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlNotBetween(String value1, String value2) {
            addCriterion("banner1_url not between", value1, value2, "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlIsNull() {
            addCriterion("banner2_url is null");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlIsNotNull() {
            addCriterion("banner2_url is not null");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlEqualTo(String value) {
            addCriterion("banner2_url =", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlNotEqualTo(String value) {
            addCriterion("banner2_url <>", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlGreaterThan(String value) {
            addCriterion("banner2_url >", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner2_url >=", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlLessThan(String value) {
            addCriterion("banner2_url <", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlLessThanOrEqualTo(String value) {
            addCriterion("banner2_url <=", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlLike(String value) {
            addCriterion("banner2_url like", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlNotLike(String value) {
            addCriterion("banner2_url not like", value, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlIn(List<String> values) {
            addCriterion("banner2_url in", values, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlNotIn(List<String> values) {
            addCriterion("banner2_url not in", values, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlBetween(String value1, String value2) {
            addCriterion("banner2_url between", value1, value2, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlNotBetween(String value1, String value2) {
            addCriterion("banner2_url not between", value1, value2, "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlIsNull() {
            addCriterion("banner3_url is null");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlIsNotNull() {
            addCriterion("banner3_url is not null");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlEqualTo(String value) {
            addCriterion("banner3_url =", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlNotEqualTo(String value) {
            addCriterion("banner3_url <>", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlGreaterThan(String value) {
            addCriterion("banner3_url >", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner3_url >=", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlLessThan(String value) {
            addCriterion("banner3_url <", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlLessThanOrEqualTo(String value) {
            addCriterion("banner3_url <=", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlLike(String value) {
            addCriterion("banner3_url like", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlNotLike(String value) {
            addCriterion("banner3_url not like", value, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlIn(List<String> values) {
            addCriterion("banner3_url in", values, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlNotIn(List<String> values) {
            addCriterion("banner3_url not in", values, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlBetween(String value1, String value2) {
            addCriterion("banner3_url between", value1, value2, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlNotBetween(String value1, String value2) {
            addCriterion("banner3_url not between", value1, value2, "banner3Url");
            return (Criteria) this;
        }

        public Criteria andAuctionNumIsNull() {
            addCriterion("auction_num is null");
            return (Criteria) this;
        }

        public Criteria andAuctionNumIsNotNull() {
            addCriterion("auction_num is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionNumEqualTo(Integer value) {
            addCriterion("auction_num =", value, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumNotEqualTo(Integer value) {
            addCriterion("auction_num <>", value, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumGreaterThan(Integer value) {
            addCriterion("auction_num >", value, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("auction_num >=", value, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumLessThan(Integer value) {
            addCriterion("auction_num <", value, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumLessThanOrEqualTo(Integer value) {
            addCriterion("auction_num <=", value, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumIn(List<Integer> values) {
            addCriterion("auction_num in", values, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumNotIn(List<Integer> values) {
            addCriterion("auction_num not in", values, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumBetween(Integer value1, Integer value2) {
            addCriterion("auction_num between", value1, value2, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andAuctionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("auction_num not between", value1, value2, "auctionNum");
            return (Criteria) this;
        }

        public Criteria andPushTmsIsNull() {
            addCriterion("is_push_tms is null");
            return (Criteria) this;
        }

        public Criteria andPushTmsIsNotNull() {
            addCriterion("is_push_tms is not null");
            return (Criteria) this;
        }

        public Criteria andPushTmsEqualTo(Boolean value) {
            addCriterion("is_push_tms =", value, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsNotEqualTo(Boolean value) {
            addCriterion("is_push_tms <>", value, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsGreaterThan(Boolean value) {
            addCriterion("is_push_tms >", value, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_push_tms >=", value, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsLessThan(Boolean value) {
            addCriterion("is_push_tms <", value, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsLessThanOrEqualTo(Boolean value) {
            addCriterion("is_push_tms <=", value, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsIn(List<Boolean> values) {
            addCriterion("is_push_tms in", values, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsNotIn(List<Boolean> values) {
            addCriterion("is_push_tms not in", values, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsBetween(Boolean value1, Boolean value2) {
            addCriterion("is_push_tms between", value1, value2, "pushTms");
            return (Criteria) this;
        }

        public Criteria andPushTmsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_push_tms not between", value1, value2, "pushTms");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneIsNull() {
            addCriterion("parker_cellphone is null");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneIsNotNull() {
            addCriterion("parker_cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneEqualTo(String value) {
            addCriterion("parker_cellphone =", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneNotEqualTo(String value) {
            addCriterion("parker_cellphone <>", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneGreaterThan(String value) {
            addCriterion("parker_cellphone >", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("parker_cellphone >=", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneLessThan(String value) {
            addCriterion("parker_cellphone <", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneLessThanOrEqualTo(String value) {
            addCriterion("parker_cellphone <=", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneLike(String value) {
            addCriterion("parker_cellphone like", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneNotLike(String value) {
            addCriterion("parker_cellphone not like", value, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneIn(List<String> values) {
            addCriterion("parker_cellphone in", values, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneNotIn(List<String> values) {
            addCriterion("parker_cellphone not in", values, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneBetween(String value1, String value2) {
            addCriterion("parker_cellphone between", value1, value2, "parkerCellphone");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneNotBetween(String value1, String value2) {
            addCriterion("parker_cellphone not between", value1, value2, "parkerCellphone");
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

        public Criteria andVehicleMaxIsNull() {
            addCriterion("vehicle_max is null");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxIsNotNull() {
            addCriterion("vehicle_max is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxEqualTo(Short value) {
            addCriterion("vehicle_max =", value, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxNotEqualTo(Short value) {
            addCriterion("vehicle_max <>", value, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxGreaterThan(Short value) {
            addCriterion("vehicle_max >", value, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxGreaterThanOrEqualTo(Short value) {
            addCriterion("vehicle_max >=", value, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxLessThan(Short value) {
            addCriterion("vehicle_max <", value, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxLessThanOrEqualTo(Short value) {
            addCriterion("vehicle_max <=", value, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxIn(List<Short> values) {
            addCriterion("vehicle_max in", values, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxNotIn(List<Short> values) {
            addCriterion("vehicle_max not in", values, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxBetween(Short value1, Short value2) {
            addCriterion("vehicle_max between", value1, value2, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andVehicleMaxNotBetween(Short value1, Short value2) {
            addCriterion("vehicle_max not between", value1, value2, "vehicleMax");
            return (Criteria) this;
        }

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(code) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andCreatedByLikeInsensitive(String value) {
            addCriterion("upper(created_by) like", value.toUpperCase(), "createdBy");
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

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andContactLikeInsensitive(String value) {
            addCriterion("upper(contact) like", value.toUpperCase(), "contact");
            return (Criteria) this;
        }

        public Criteria andContactTellphoneLikeInsensitive(String value) {
            addCriterion("upper(contact_tellphone) like", value.toUpperCase(), "contactTellphone");
            return (Criteria) this;
        }

        public Criteria andContentLikeInsensitive(String value) {
            addCriterion("upper(content) like", value.toUpperCase(), "content");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLikeInsensitive(String value) {
            addCriterion("upper(video_url) like", value.toUpperCase(), "videoUrl");
            return (Criteria) this;
        }

        public Criteria andAudioUrlLikeInsensitive(String value) {
            addCriterion("upper(audio_url) like", value.toUpperCase(), "audioUrl");
            return (Criteria) this;
        }

        public Criteria andAuctioneerCellphoneLikeInsensitive(String value) {
            addCriterion("upper(auctioneer_cellphone) like", value.toUpperCase(), "auctioneerCellphone");
            return (Criteria) this;
        }

        public Criteria andTransactionGuideLikeInsensitive(String value) {
            addCriterion("upper(transaction_guide) like", value.toUpperCase(), "transactionGuide");
            return (Criteria) this;
        }

        public Criteria andNoticeLikeInsensitive(String value) {
            addCriterion("upper(notice) like", value.toUpperCase(), "notice");
            return (Criteria) this;
        }

        public Criteria andAuctionModelDescLikeInsensitive(String value) {
            addCriterion("upper(auction_model_desc) like", value.toUpperCase(), "auctionModelDesc");
            return (Criteria) this;
        }

        public Criteria andAcutionVehicleDescLikeInsensitive(String value) {
            addCriterion("upper(acution_vehicle_desc) like", value.toUpperCase(), "acutionVehicleDesc");
            return (Criteria) this;
        }

        public Criteria andCurrentAvSidLikeInsensitive(String value) {
            addCriterion("upper(current_av_sid) like", value.toUpperCase(), "currentAvSid");
            return (Criteria) this;
        }

        public Criteria andPicUrlLikeInsensitive(String value) {
            addCriterion("upper(pic_url) like", value.toUpperCase(), "picUrl");
            return (Criteria) this;
        }

        public Criteria andBanner1UrlLikeInsensitive(String value) {
            addCriterion("upper(banner1_url) like", value.toUpperCase(), "banner1Url");
            return (Criteria) this;
        }

        public Criteria andBanner2UrlLikeInsensitive(String value) {
            addCriterion("upper(banner2_url) like", value.toUpperCase(), "banner2Url");
            return (Criteria) this;
        }

        public Criteria andBanner3UrlLikeInsensitive(String value) {
            addCriterion("upper(banner3_url) like", value.toUpperCase(), "banner3Url");
            return (Criteria) this;
        }

        public Criteria andParkerCellphoneLikeInsensitive(String value) {
            addCriterion("upper(parker_cellphone) like", value.toUpperCase(), "parkerCellphone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
		 * 
		 */
        private static final long serialVersionUID = 5122772658238457106L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
		 * 
		 */
        private static final long serialVersionUID = 4684095385724081858L;

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