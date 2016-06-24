package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseMemberVehicleFavoriteExample implements Serializable {

    /**
     */
    private static final long serialVersionUID = -6443212492764558077L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseMemberVehicleFavoriteExample() {
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
        private static final long serialVersionUID = -7460437686097609110L;
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

        public Criteria andMemberSidIsNull() {
            addCriterion("member_sid is null");
            return (Criteria) this;
        }

        public Criteria andMemberSidIsNotNull() {
            addCriterion("member_sid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberSidEqualTo(String value) {
            addCriterion("member_sid =", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidNotEqualTo(String value) {
            addCriterion("member_sid <>", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidGreaterThan(String value) {
            addCriterion("member_sid >", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidGreaterThanOrEqualTo(String value) {
            addCriterion("member_sid >=", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidLessThan(String value) {
            addCriterion("member_sid <", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidLessThanOrEqualTo(String value) {
            addCriterion("member_sid <=", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidLike(String value) {
            addCriterion("member_sid like", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidNotLike(String value) {
            addCriterion("member_sid not like", value, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidIn(List<String> values) {
            addCriterion("member_sid in", values, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidNotIn(List<String> values) {
            addCriterion("member_sid not in", values, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidBetween(String value1, String value2) {
            addCriterion("member_sid between", value1, value2, "memberSid");
            return (Criteria) this;
        }

        public Criteria andMemberSidNotBetween(String value1, String value2) {
            addCriterion("member_sid not between", value1, value2, "memberSid");
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

        public Criteria andMemberSidLikeInsensitive(String value) {
            addCriterion("upper(member_sid) like", value.toUpperCase(), "memberSid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = 6166771157755540162L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
         */
        private static final long serialVersionUID = -1542391247592923814L;

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