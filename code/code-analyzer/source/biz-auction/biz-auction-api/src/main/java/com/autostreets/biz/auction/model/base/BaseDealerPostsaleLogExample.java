package com.autostreets.biz.auction.model.base;

import com.autostreets.framework.common.dal.Pagination;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDealerPostsaleLogExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseDealerPostsaleLogExample() {
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

        public Criteria andNewcarContractNoIsNull() {
            addCriterion("newcar_contract_no is null");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoIsNotNull() {
            addCriterion("newcar_contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoEqualTo(String value) {
            addCriterion("newcar_contract_no =", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoNotEqualTo(String value) {
            addCriterion("newcar_contract_no <>", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoGreaterThan(String value) {
            addCriterion("newcar_contract_no >", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("newcar_contract_no >=", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoLessThan(String value) {
            addCriterion("newcar_contract_no <", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoLessThanOrEqualTo(String value) {
            addCriterion("newcar_contract_no <=", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoLike(String value) {
            addCriterion("newcar_contract_no like", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoNotLike(String value) {
            addCriterion("newcar_contract_no not like", value, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoIn(List<String> values) {
            addCriterion("newcar_contract_no in", values, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoNotIn(List<String> values) {
            addCriterion("newcar_contract_no not in", values, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoBetween(String value1, String value2) {
            addCriterion("newcar_contract_no between", value1, value2, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarContractNoNotBetween(String value1, String value2) {
            addCriterion("newcar_contract_no not between", value1, value2, "newcarContractNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoIsNull() {
            addCriterion("newcar_vin_no is null");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoIsNotNull() {
            addCriterion("newcar_vin_no is not null");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoEqualTo(String value) {
            addCriterion("newcar_vin_no =", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoNotEqualTo(String value) {
            addCriterion("newcar_vin_no <>", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoGreaterThan(String value) {
            addCriterion("newcar_vin_no >", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoGreaterThanOrEqualTo(String value) {
            addCriterion("newcar_vin_no >=", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoLessThan(String value) {
            addCriterion("newcar_vin_no <", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoLessThanOrEqualTo(String value) {
            addCriterion("newcar_vin_no <=", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoLike(String value) {
            addCriterion("newcar_vin_no like", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoNotLike(String value) {
            addCriterion("newcar_vin_no not like", value, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoIn(List<String> values) {
            addCriterion("newcar_vin_no in", values, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoNotIn(List<String> values) {
            addCriterion("newcar_vin_no not in", values, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoBetween(String value1, String value2) {
            addCriterion("newcar_vin_no between", value1, value2, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarVinNoNotBetween(String value1, String value2) {
            addCriterion("newcar_vin_no not between", value1, value2, "newcarVinNo");
            return (Criteria) this;
        }

        public Criteria andNewcarModelIsNull() {
            addCriterion("newcar_model is null");
            return (Criteria) this;
        }

        public Criteria andNewcarModelIsNotNull() {
            addCriterion("newcar_model is not null");
            return (Criteria) this;
        }

        public Criteria andNewcarModelEqualTo(String value) {
            addCriterion("newcar_model =", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelNotEqualTo(String value) {
            addCriterion("newcar_model <>", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelGreaterThan(String value) {
            addCriterion("newcar_model >", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelGreaterThanOrEqualTo(String value) {
            addCriterion("newcar_model >=", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelLessThan(String value) {
            addCriterion("newcar_model <", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelLessThanOrEqualTo(String value) {
            addCriterion("newcar_model <=", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelLike(String value) {
            addCriterion("newcar_model like", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelNotLike(String value) {
            addCriterion("newcar_model not like", value, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelIn(List<String> values) {
            addCriterion("newcar_model in", values, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelNotIn(List<String> values) {
            addCriterion("newcar_model not in", values, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelBetween(String value1, String value2) {
            addCriterion("newcar_model between", value1, value2, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andNewcarModelNotBetween(String value1, String value2) {
            addCriterion("newcar_model not between", value1, value2, "newcarModel");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceIsNull() {
            addCriterion("replace_allowance is null");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceIsNotNull() {
            addCriterion("replace_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceEqualTo(BigDecimal value) {
            addCriterion("replace_allowance =", value, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("replace_allowance <>", value, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceGreaterThan(BigDecimal value) {
            addCriterion("replace_allowance >", value, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("replace_allowance >=", value, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceLessThan(BigDecimal value) {
            addCriterion("replace_allowance <", value, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("replace_allowance <=", value, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceIn(List<BigDecimal> values) {
            addCriterion("replace_allowance in", values, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("replace_allowance not in", values, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("replace_allowance between", value1, value2, "replaceAllowance");
            return (Criteria) this;
        }

        public Criteria andReplaceAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("replace_allowance not between", value1, value2, "replaceAllowance");
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

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Integer value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Integer value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Integer value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Integer value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Integer value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Integer> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Integer> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Integer value1, Integer value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Integer value1, Integer value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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