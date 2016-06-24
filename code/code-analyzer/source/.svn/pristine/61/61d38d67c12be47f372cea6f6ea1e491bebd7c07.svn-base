package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

public class BaseUsedcarShopExtExample implements Serializable {

    private static final long serialVersionUID = -8986289255833058716L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public BaseUsedcarShopExtExample() {
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

        private static final long serialVersionUID = -917384159416856520L;

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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andOrgSidIsNull() {
            addCriterion("org_sid is null");
            return (Criteria) this;
        }

        public Criteria andOrgSidIsNotNull() {
            addCriterion("org_sid is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSidEqualTo(Integer value) {
            addCriterion("org_sid =", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidNotEqualTo(Integer value) {
            addCriterion("org_sid <>", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidGreaterThan(Integer value) {
            addCriterion("org_sid >", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_sid >=", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidLessThan(Integer value) {
            addCriterion("org_sid <", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidLessThanOrEqualTo(Integer value) {
            addCriterion("org_sid <=", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidIn(List<Integer> values) {
            addCriterion("org_sid in", values, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidNotIn(List<Integer> values) {
            addCriterion("org_sid not in", values, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidBetween(Integer value1, Integer value2) {
            addCriterion("org_sid between", value1, value2, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidNotBetween(Integer value1, Integer value2) {
            addCriterion("org_sid not between", value1, value2, "orgSid");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlIsNull() {
            addCriterion("banner_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlIsNotNull() {
            addCriterion("banner_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlEqualTo(String value) {
            addCriterion("banner_pic_url =", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlNotEqualTo(String value) {
            addCriterion("banner_pic_url <>", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlGreaterThan(String value) {
            addCriterion("banner_pic_url >", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner_pic_url >=", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlLessThan(String value) {
            addCriterion("banner_pic_url <", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlLessThanOrEqualTo(String value) {
            addCriterion("banner_pic_url <=", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlLike(String value) {
            addCriterion("banner_pic_url like", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlNotLike(String value) {
            addCriterion("banner_pic_url not like", value, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlIn(List<String> values) {
            addCriterion("banner_pic_url in", values, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlNotIn(List<String> values) {
            addCriterion("banner_pic_url not in", values, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlBetween(String value1, String value2) {
            addCriterion("banner_pic_url between", value1, value2, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerPicUrlNotBetween(String value1, String value2) {
            addCriterion("banner_pic_url not between", value1, value2, "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlIsNull() {
            addCriterion("banner_link_url is null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlIsNotNull() {
            addCriterion("banner_link_url is not null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlEqualTo(String value) {
            addCriterion("banner_link_url =", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotEqualTo(String value) {
            addCriterion("banner_link_url <>", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlGreaterThan(String value) {
            addCriterion("banner_link_url >", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner_link_url >=", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLessThan(String value) {
            addCriterion("banner_link_url <", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("banner_link_url <=", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLike(String value) {
            addCriterion("banner_link_url like", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotLike(String value) {
            addCriterion("banner_link_url not like", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlIn(List<String> values) {
            addCriterion("banner_link_url in", values, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotIn(List<String> values) {
            addCriterion("banner_link_url not in", values, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlBetween(String value1, String value2) {
            addCriterion("banner_link_url between", value1, value2, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotBetween(String value1, String value2) {
            addCriterion("banner_link_url not between", value1, value2, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameIsNull() {
            addCriterion("banner_template_name is null");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameIsNotNull() {
            addCriterion("banner_template_name is not null");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameEqualTo(String value) {
            addCriterion("banner_template_name =", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameNotEqualTo(String value) {
            addCriterion("banner_template_name <>", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameGreaterThan(String value) {
            addCriterion("banner_template_name >", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("banner_template_name >=", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameLessThan(String value) {
            addCriterion("banner_template_name <", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("banner_template_name <=", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameLike(String value) {
            addCriterion("banner_template_name like", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameNotLike(String value) {
            addCriterion("banner_template_name not like", value, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameIn(List<String> values) {
            addCriterion("banner_template_name in", values, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameNotIn(List<String> values) {
            addCriterion("banner_template_name not in", values, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameBetween(String value1, String value2) {
            addCriterion("banner_template_name between", value1, value2, "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameNotBetween(String value1, String value2) {
            addCriterion("banner_template_name not between", value1, value2, "bannerTemplateName");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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

        public Criteria andBannerPicUrlLikeInsensitive(String value) {
            addCriterion("upper(banner_pic_url) like", value.toUpperCase(), "bannerPicUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLikeInsensitive(String value) {
            addCriterion("upper(banner_link_url) like", value.toUpperCase(), "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerTemplateNameLikeInsensitive(String value) {
            addCriterion("upper(banner_template_name) like", value.toUpperCase(), "bannerTemplateName");
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeInsensitive(String value) {
            addCriterion("upper(create_user) like", value.toUpperCase(), "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLikeInsensitive(String value) {
            addCriterion("upper(update_user) like", value.toUpperCase(), "updateUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        private static final long serialVersionUID = 3563297096019547915L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        private static final long serialVersionUID = -2596105533687670975L;

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