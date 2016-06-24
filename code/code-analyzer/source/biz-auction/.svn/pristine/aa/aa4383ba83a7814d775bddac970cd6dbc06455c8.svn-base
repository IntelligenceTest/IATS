package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseBidExample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9016750074116484421L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public BaseBidExample() {
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
		private static final long serialVersionUID = -1111856351073538808L;
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

		public Criteria andSidIsNull() {
			addCriterion("sid is null");
			return (Criteria) this;
		}

		public Criteria andSidIsNotNull() {
			addCriterion("sid is not null");
			return (Criteria) this;
		}

		public Criteria andSidEqualTo(String value) {
			addCriterion("sid =", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotEqualTo(String value) {
			addCriterion("sid <>", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThan(String value) {
			addCriterion("sid >", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThanOrEqualTo(String value) {
			addCriterion("sid >=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThan(String value) {
			addCriterion("sid <", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThanOrEqualTo(String value) {
			addCriterion("sid <=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLike(String value) {
			addCriterion("sid like", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotLike(String value) {
			addCriterion("sid not like", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidIn(List<String> values) {
			addCriterion("sid in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotIn(List<String> values) {
			addCriterion("sid not in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidBetween(String value1, String value2) {
			addCriterion("sid between", value1, value2, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotBetween(String value1, String value2) {
			addCriterion("sid not between", value1, value2, "sid");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdIsNull() {
			addCriterion("auction_vehicle_id is null");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdIsNotNull() {
			addCriterion("auction_vehicle_id is not null");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdEqualTo(Integer value) {
			addCriterion("auction_vehicle_id =", value, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdNotEqualTo(Integer value) {
			addCriterion("auction_vehicle_id <>", value, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdGreaterThan(Integer value) {
			addCriterion("auction_vehicle_id >", value, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("auction_vehicle_id >=", value, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdLessThan(Integer value) {
			addCriterion("auction_vehicle_id <", value, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdLessThanOrEqualTo(Integer value) {
			addCriterion("auction_vehicle_id <=", value, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdIn(List<Integer> values) {
			addCriterion("auction_vehicle_id in", values, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdNotIn(List<Integer> values) {
			addCriterion("auction_vehicle_id not in", values, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdBetween(Integer value1, Integer value2) {
			addCriterion("auction_vehicle_id between", value1, value2, "auctionVehicleId");
			return (Criteria) this;
		}

		public Criteria andAuctionVehicleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("auction_vehicle_id not between", value1, value2, "auctionVehicleId");
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

		public Criteria andBidderUsernameIsNull() {
			addCriterion("bidder_username is null");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameIsNotNull() {
			addCriterion("bidder_username is not null");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameEqualTo(String value) {
			addCriterion("bidder_username =", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameNotEqualTo(String value) {
			addCriterion("bidder_username <>", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameGreaterThan(String value) {
			addCriterion("bidder_username >", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("bidder_username >=", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameLessThan(String value) {
			addCriterion("bidder_username <", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameLessThanOrEqualTo(String value) {
			addCriterion("bidder_username <=", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameLike(String value) {
			addCriterion("bidder_username like", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameNotLike(String value) {
			addCriterion("bidder_username not like", value, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameIn(List<String> values) {
			addCriterion("bidder_username in", values, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameNotIn(List<String> values) {
			addCriterion("bidder_username not in", values, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameBetween(String value1, String value2) {
			addCriterion("bidder_username between", value1, value2, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidderUsernameNotBetween(String value1, String value2) {
			addCriterion("bidder_username not between", value1, value2, "bidderUsername");
			return (Criteria) this;
		}

		public Criteria andBidTimestampIsNull() {
			addCriterion("bid_timestamp is null");
			return (Criteria) this;
		}

		public Criteria andBidTimestampIsNotNull() {
			addCriterion("bid_timestamp is not null");
			return (Criteria) this;
		}

		public Criteria andBidTimestampEqualTo(Date value) {
			addCriterion("bid_timestamp =", value, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampNotEqualTo(Date value) {
			addCriterion("bid_timestamp <>", value, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampGreaterThan(Date value) {
			addCriterion("bid_timestamp >", value, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampGreaterThanOrEqualTo(Date value) {
			addCriterion("bid_timestamp >=", value, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampLessThan(Date value) {
			addCriterion("bid_timestamp <", value, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampLessThanOrEqualTo(Date value) {
			addCriterion("bid_timestamp <=", value, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampIn(List<Date> values) {
			addCriterion("bid_timestamp in", values, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampNotIn(List<Date> values) {
			addCriterion("bid_timestamp not in", values, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampBetween(Date value1, Date value2) {
			addCriterion("bid_timestamp between", value1, value2, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andBidTimestampNotBetween(Date value1, Date value2) {
			addCriterion("bid_timestamp not between", value1, value2, "bidTimestamp");
			return (Criteria) this;
		}

		public Criteria andOriginPriceIsNull() {
			addCriterion("origin_price is null");
			return (Criteria) this;
		}

		public Criteria andOriginPriceIsNotNull() {
			addCriterion("origin_price is not null");
			return (Criteria) this;
		}

		public Criteria andOriginPriceEqualTo(BigDecimal value) {
			addCriterion("origin_price =", value, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceNotEqualTo(BigDecimal value) {
			addCriterion("origin_price <>", value, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceGreaterThan(BigDecimal value) {
			addCriterion("origin_price >", value, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("origin_price >=", value, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceLessThan(BigDecimal value) {
			addCriterion("origin_price <", value, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("origin_price <=", value, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceIn(List<BigDecimal> values) {
			addCriterion("origin_price in", values, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceNotIn(List<BigDecimal> values) {
			addCriterion("origin_price not in", values, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("origin_price between", value1, value2, "originPrice");
			return (Criteria) this;
		}

		public Criteria andOriginPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("origin_price not between", value1, value2, "originPrice");
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

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andMsgIsNull() {
			addCriterion("is_msg is null");
			return (Criteria) this;
		}

		public Criteria andMsgIsNotNull() {
			addCriterion("is_msg is not null");
			return (Criteria) this;
		}

		public Criteria andMsgEqualTo(Boolean value) {
			addCriterion("is_msg =", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgNotEqualTo(Boolean value) {
			addCriterion("is_msg <>", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgGreaterThan(Boolean value) {
			addCriterion("is_msg >", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_msg >=", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgLessThan(Boolean value) {
			addCriterion("is_msg <", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgLessThanOrEqualTo(Boolean value) {
			addCriterion("is_msg <=", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgIn(List<Boolean> values) {
			addCriterion("is_msg in", values, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgNotIn(List<Boolean> values) {
			addCriterion("is_msg not in", values, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgBetween(Boolean value1, Boolean value2) {
			addCriterion("is_msg between", value1, value2, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_msg not between", value1, value2, "msg");
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
	}

	public static class Criteria extends GeneratedCriteria {

		/**
		 * 
		 */
		private static final long serialVersionUID = -7955932042663166334L;

		protected Criteria() {
			super();
		}
	}

	public static class Criterion implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5476717446115105998L;

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