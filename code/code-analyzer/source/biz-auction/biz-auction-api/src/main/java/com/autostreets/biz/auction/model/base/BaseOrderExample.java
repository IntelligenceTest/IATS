package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseOrderExample implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4560298339356034284L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseOrderExample() {
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
        private static final long serialVersionUID = 3326930793785207899L;
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andBidderSidIsNull() {
            addCriterion("bidder_sid is null");
            return (Criteria) this;
        }

        public Criteria andBidderSidIsNotNull() {
            addCriterion("bidder_sid is not null");
            return (Criteria) this;
        }

        public Criteria andBidderSidEqualTo(String value) {
            addCriterion("bidder_sid =", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidNotEqualTo(String value) {
            addCriterion("bidder_sid <>", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidGreaterThan(String value) {
            addCriterion("bidder_sid >", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidGreaterThanOrEqualTo(String value) {
            addCriterion("bidder_sid >=", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidLessThan(String value) {
            addCriterion("bidder_sid <", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidLessThanOrEqualTo(String value) {
            addCriterion("bidder_sid <=", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidLike(String value) {
            addCriterion("bidder_sid like", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidNotLike(String value) {
            addCriterion("bidder_sid not like", value, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidIn(List<String> values) {
            addCriterion("bidder_sid in", values, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidNotIn(List<String> values) {
            addCriterion("bidder_sid not in", values, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidBetween(String value1, String value2) {
            addCriterion("bidder_sid between", value1, value2, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderSidNotBetween(String value1, String value2) {
            addCriterion("bidder_sid not between", value1, value2, "bidderSid");
            return (Criteria) this;
        }

        public Criteria andBidderNameIsNull() {
            addCriterion("bidder_name is null");
            return (Criteria) this;
        }

        public Criteria andBidderNameIsNotNull() {
            addCriterion("bidder_name is not null");
            return (Criteria) this;
        }

        public Criteria andBidderNameEqualTo(String value) {
            addCriterion("bidder_name =", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameNotEqualTo(String value) {
            addCriterion("bidder_name <>", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameGreaterThan(String value) {
            addCriterion("bidder_name >", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameGreaterThanOrEqualTo(String value) {
            addCriterion("bidder_name >=", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameLessThan(String value) {
            addCriterion("bidder_name <", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameLessThanOrEqualTo(String value) {
            addCriterion("bidder_name <=", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameLike(String value) {
            addCriterion("bidder_name like", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameNotLike(String value) {
            addCriterion("bidder_name not like", value, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameIn(List<String> values) {
            addCriterion("bidder_name in", values, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameNotIn(List<String> values) {
            addCriterion("bidder_name not in", values, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameBetween(String value1, String value2) {
            addCriterion("bidder_name between", value1, value2, "bidderName");
            return (Criteria) this;
        }

        public Criteria andBidderNameNotBetween(String value1, String value2) {
            addCriterion("bidder_name not between", value1, value2, "bidderName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameIsNull() {
            addCriterion("drawee_name is null");
            return (Criteria) this;
        }

        public Criteria andDraweeNameIsNotNull() {
            addCriterion("drawee_name is not null");
            return (Criteria) this;
        }

        public Criteria andDraweeNameEqualTo(String value) {
            addCriterion("drawee_name =", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameNotEqualTo(String value) {
            addCriterion("drawee_name <>", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameGreaterThan(String value) {
            addCriterion("drawee_name >", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameGreaterThanOrEqualTo(String value) {
            addCriterion("drawee_name >=", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameLessThan(String value) {
            addCriterion("drawee_name <", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameLessThanOrEqualTo(String value) {
            addCriterion("drawee_name <=", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameLike(String value) {
            addCriterion("drawee_name like", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameNotLike(String value) {
            addCriterion("drawee_name not like", value, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameIn(List<String> values) {
            addCriterion("drawee_name in", values, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameNotIn(List<String> values) {
            addCriterion("drawee_name not in", values, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameBetween(String value1, String value2) {
            addCriterion("drawee_name between", value1, value2, "draweeName");
            return (Criteria) this;
        }

        public Criteria andDraweeNameNotBetween(String value1, String value2) {
            addCriterion("drawee_name not between", value1, value2, "draweeName");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneIsNull() {
            addCriterion("buyer_cellphone is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneIsNotNull() {
            addCriterion("buyer_cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneEqualTo(String value) {
            addCriterion("buyer_cellphone =", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneNotEqualTo(String value) {
            addCriterion("buyer_cellphone <>", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneGreaterThan(String value) {
            addCriterion("buyer_cellphone >", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_cellphone >=", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneLessThan(String value) {
            addCriterion("buyer_cellphone <", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneLessThanOrEqualTo(String value) {
            addCriterion("buyer_cellphone <=", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneLike(String value) {
            addCriterion("buyer_cellphone like", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneNotLike(String value) {
            addCriterion("buyer_cellphone not like", value, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneIn(List<String> values) {
            addCriterion("buyer_cellphone in", values, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneNotIn(List<String> values) {
            addCriterion("buyer_cellphone not in", values, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneBetween(String value1, String value2) {
            addCriterion("buyer_cellphone between", value1, value2, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andBuyerCellphoneNotBetween(String value1, String value2) {
            addCriterion("buyer_cellphone not between", value1, value2, "buyerCellphone");
            return (Criteria) this;
        }

        public Criteria andDealTimestampIsNull() {
            addCriterion("deal_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andDealTimestampIsNotNull() {
            addCriterion("deal_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimestampEqualTo(Date value) {
            addCriterion("deal_timestamp =", value, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampNotEqualTo(Date value) {
            addCriterion("deal_timestamp <>", value, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampGreaterThan(Date value) {
            addCriterion("deal_timestamp >", value, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_timestamp >=", value, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampLessThan(Date value) {
            addCriterion("deal_timestamp <", value, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampLessThanOrEqualTo(Date value) {
            addCriterion("deal_timestamp <=", value, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampIn(List<Date> values) {
            addCriterion("deal_timestamp in", values, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampNotIn(List<Date> values) {
            addCriterion("deal_timestamp not in", values, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampBetween(Date value1, Date value2) {
            addCriterion("deal_timestamp between", value1, value2, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andDealTimestampNotBetween(Date value1, Date value2) {
            addCriterion("deal_timestamp not between", value1, value2, "dealTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampIsNull() {
            addCriterion("pay_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andPayTimestampIsNotNull() {
            addCriterion("pay_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimestampEqualTo(Date value) {
            addCriterion("pay_timestamp =", value, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampNotEqualTo(Date value) {
            addCriterion("pay_timestamp <>", value, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampGreaterThan(Date value) {
            addCriterion("pay_timestamp >", value, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_timestamp >=", value, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampLessThan(Date value) {
            addCriterion("pay_timestamp <", value, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampLessThanOrEqualTo(Date value) {
            addCriterion("pay_timestamp <=", value, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampIn(List<Date> values) {
            addCriterion("pay_timestamp in", values, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampNotIn(List<Date> values) {
            addCriterion("pay_timestamp not in", values, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampBetween(Date value1, Date value2) {
            addCriterion("pay_timestamp between", value1, value2, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andPayTimestampNotBetween(Date value1, Date value2) {
            addCriterion("pay_timestamp not between", value1, value2, "payTimestamp");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("`source` is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("`source` is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("`source` =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("`source` <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("`source` >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("`source` >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("`source` <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("`source` <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("`source` like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("`source` not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("`source` in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("`source` not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("`source` between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("`source` not between", value1, value2, "source");
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
    }

    public static class Criteria extends GeneratedCriteria {

        /**
         */
        private static final long serialVersionUID = 4153552606043020432L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        /**
         */
        private static final long serialVersionUID = -8567933483748867709L;

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