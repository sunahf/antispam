package com.yy.business.dao.gen.model;

import java.util.ArrayList;
import java.util.List;

public class AppModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AppModuleExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNull() {
            addCriterion("module_name is null");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNotNull() {
            addCriterion("module_name is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNameEqualTo(String value) {
            addCriterion("module_name =", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotEqualTo(String value) {
            addCriterion("module_name <>", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThan(String value) {
            addCriterion("module_name >", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("module_name >=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThan(String value) {
            addCriterion("module_name <", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThanOrEqualTo(String value) {
            addCriterion("module_name <=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLike(String value) {
            addCriterion("module_name like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotLike(String value) {
            addCriterion("module_name not like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameIn(List<String> values) {
            addCriterion("module_name in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotIn(List<String> values) {
            addCriterion("module_name not in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameBetween(String value1, String value2) {
            addCriterion("module_name between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotBetween(String value1, String value2) {
            addCriterion("module_name not between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIsNull() {
            addCriterion("module_type is null");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIsNotNull() {
            addCriterion("module_type is not null");
            return (Criteria) this;
        }

        public Criteria andModuleTypeEqualTo(Integer value) {
            addCriterion("module_type =", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotEqualTo(Integer value) {
            addCriterion("module_type <>", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeGreaterThan(Integer value) {
            addCriterion("module_type >", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_type >=", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeLessThan(Integer value) {
            addCriterion("module_type <", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("module_type <=", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIn(List<Integer> values) {
            addCriterion("module_type in", values, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotIn(List<Integer> values) {
            addCriterion("module_type not in", values, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeBetween(Integer value1, Integer value2) {
            addCriterion("module_type between", value1, value2, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("module_type not between", value1, value2, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleClassIsNull() {
            addCriterion("module_class is null");
            return (Criteria) this;
        }

        public Criteria andModuleClassIsNotNull() {
            addCriterion("module_class is not null");
            return (Criteria) this;
        }

        public Criteria andModuleClassEqualTo(String value) {
            addCriterion("module_class =", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassNotEqualTo(String value) {
            addCriterion("module_class <>", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassGreaterThan(String value) {
            addCriterion("module_class >", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassGreaterThanOrEqualTo(String value) {
            addCriterion("module_class >=", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassLessThan(String value) {
            addCriterion("module_class <", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassLessThanOrEqualTo(String value) {
            addCriterion("module_class <=", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassLike(String value) {
            addCriterion("module_class like", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassNotLike(String value) {
            addCriterion("module_class not like", value, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassIn(List<String> values) {
            addCriterion("module_class in", values, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassNotIn(List<String> values) {
            addCriterion("module_class not in", values, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassBetween(String value1, String value2) {
            addCriterion("module_class between", value1, value2, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleClassNotBetween(String value1, String value2) {
            addCriterion("module_class not between", value1, value2, "moduleClass");
            return (Criteria) this;
        }

        public Criteria andModuleArgIsNull() {
            addCriterion("module_arg is null");
            return (Criteria) this;
        }

        public Criteria andModuleArgIsNotNull() {
            addCriterion("module_arg is not null");
            return (Criteria) this;
        }

        public Criteria andModuleArgEqualTo(String value) {
            addCriterion("module_arg =", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgNotEqualTo(String value) {
            addCriterion("module_arg <>", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgGreaterThan(String value) {
            addCriterion("module_arg >", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgGreaterThanOrEqualTo(String value) {
            addCriterion("module_arg >=", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgLessThan(String value) {
            addCriterion("module_arg <", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgLessThanOrEqualTo(String value) {
            addCriterion("module_arg <=", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgLike(String value) {
            addCriterion("module_arg like", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgNotLike(String value) {
            addCriterion("module_arg not like", value, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgIn(List<String> values) {
            addCriterion("module_arg in", values, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgNotIn(List<String> values) {
            addCriterion("module_arg not in", values, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgBetween(String value1, String value2) {
            addCriterion("module_arg between", value1, value2, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andModuleArgNotBetween(String value1, String value2) {
            addCriterion("module_arg not between", value1, value2, "moduleArg");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameIsNull() {
            addCriterion("upstream_module_name is null");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameIsNotNull() {
            addCriterion("upstream_module_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameEqualTo(String value) {
            addCriterion("upstream_module_name =", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameNotEqualTo(String value) {
            addCriterion("upstream_module_name <>", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameGreaterThan(String value) {
            addCriterion("upstream_module_name >", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("upstream_module_name >=", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameLessThan(String value) {
            addCriterion("upstream_module_name <", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameLessThanOrEqualTo(String value) {
            addCriterion("upstream_module_name <=", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameLike(String value) {
            addCriterion("upstream_module_name like", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameNotLike(String value) {
            addCriterion("upstream_module_name not like", value, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameIn(List<String> values) {
            addCriterion("upstream_module_name in", values, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameNotIn(List<String> values) {
            addCriterion("upstream_module_name not in", values, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameBetween(String value1, String value2) {
            addCriterion("upstream_module_name between", value1, value2, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andUpstreamModuleNameNotBetween(String value1, String value2) {
            addCriterion("upstream_module_name not between", value1, value2, "upstreamModuleName");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNull() {
            addCriterion("group_type is null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNotNull() {
            addCriterion("group_type is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeEqualTo(Integer value) {
            addCriterion("group_type =", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotEqualTo(Integer value) {
            addCriterion("group_type <>", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThan(Integer value) {
            addCriterion("group_type >", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_type >=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThan(Integer value) {
            addCriterion("group_type <", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThanOrEqualTo(Integer value) {
            addCriterion("group_type <=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIn(List<Integer> values) {
            addCriterion("group_type in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotIn(List<Integer> values) {
            addCriterion("group_type not in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeBetween(Integer value1, Integer value2) {
            addCriterion("group_type between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("group_type not between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andParallelismIsNull() {
            addCriterion("parallelism is null");
            return (Criteria) this;
        }

        public Criteria andParallelismIsNotNull() {
            addCriterion("parallelism is not null");
            return (Criteria) this;
        }

        public Criteria andParallelismEqualTo(Integer value) {
            addCriterion("parallelism =", value, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismNotEqualTo(Integer value) {
            addCriterion("parallelism <>", value, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismGreaterThan(Integer value) {
            addCriterion("parallelism >", value, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismGreaterThanOrEqualTo(Integer value) {
            addCriterion("parallelism >=", value, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismLessThan(Integer value) {
            addCriterion("parallelism <", value, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismLessThanOrEqualTo(Integer value) {
            addCriterion("parallelism <=", value, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismIn(List<Integer> values) {
            addCriterion("parallelism in", values, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismNotIn(List<Integer> values) {
            addCriterion("parallelism not in", values, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismBetween(Integer value1, Integer value2) {
            addCriterion("parallelism between", value1, value2, "parallelism");
            return (Criteria) this;
        }

        public Criteria andParallelismNotBetween(Integer value1, Integer value2) {
            addCriterion("parallelism not between", value1, value2, "parallelism");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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