package com.project.pojo;

import java.util.ArrayList;
import java.util.List;

public class PositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionExample() {
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

        public Criteria andPosidIsNull() {
            addCriterion("posid is null");
            return (Criteria) this;
        }

        public Criteria andPosidIsNotNull() {
            addCriterion("posid is not null");
            return (Criteria) this;
        }

        public Criteria andPosidEqualTo(Integer value) {
            addCriterion("posid =", value, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidNotEqualTo(Integer value) {
            addCriterion("posid <>", value, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidGreaterThan(Integer value) {
            addCriterion("posid >", value, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidGreaterThanOrEqualTo(Integer value) {
            addCriterion("posid >=", value, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidLessThan(Integer value) {
            addCriterion("posid <", value, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidLessThanOrEqualTo(Integer value) {
            addCriterion("posid <=", value, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidIn(List<Integer> values) {
            addCriterion("posid in", values, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidNotIn(List<Integer> values) {
            addCriterion("posid not in", values, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidBetween(Integer value1, Integer value2) {
            addCriterion("posid between", value1, value2, "posid");
            return (Criteria) this;
        }

        public Criteria andPosidNotBetween(Integer value1, Integer value2) {
            addCriterion("posid not between", value1, value2, "posid");
            return (Criteria) this;
        }

        public Criteria andPosinameIsNull() {
            addCriterion("posiname is null");
            return (Criteria) this;
        }

        public Criteria andPosinameIsNotNull() {
            addCriterion("posiname is not null");
            return (Criteria) this;
        }

        public Criteria andPosinameEqualTo(String value) {
            addCriterion("posiname =", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameNotEqualTo(String value) {
            addCriterion("posiname <>", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameGreaterThan(String value) {
            addCriterion("posiname >", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameGreaterThanOrEqualTo(String value) {
            addCriterion("posiname >=", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameLessThan(String value) {
            addCriterion("posiname <", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameLessThanOrEqualTo(String value) {
            addCriterion("posiname <=", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameLike(String value) {
            addCriterion("posiname like", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameNotLike(String value) {
            addCriterion("posiname not like", value, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameIn(List<String> values) {
            addCriterion("posiname in", values, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameNotIn(List<String> values) {
            addCriterion("posiname not in", values, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameBetween(String value1, String value2) {
            addCriterion("posiname between", value1, value2, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosinameNotBetween(String value1, String value2) {
            addCriterion("posiname not between", value1, value2, "posiname");
            return (Criteria) this;
        }

        public Criteria andPosidescIsNull() {
            addCriterion("posidesc is null");
            return (Criteria) this;
        }

        public Criteria andPosidescIsNotNull() {
            addCriterion("posidesc is not null");
            return (Criteria) this;
        }

        public Criteria andPosidescEqualTo(String value) {
            addCriterion("posidesc =", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescNotEqualTo(String value) {
            addCriterion("posidesc <>", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescGreaterThan(String value) {
            addCriterion("posidesc >", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescGreaterThanOrEqualTo(String value) {
            addCriterion("posidesc >=", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescLessThan(String value) {
            addCriterion("posidesc <", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescLessThanOrEqualTo(String value) {
            addCriterion("posidesc <=", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescLike(String value) {
            addCriterion("posidesc like", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescNotLike(String value) {
            addCriterion("posidesc not like", value, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescIn(List<String> values) {
            addCriterion("posidesc in", values, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescNotIn(List<String> values) {
            addCriterion("posidesc not in", values, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescBetween(String value1, String value2) {
            addCriterion("posidesc between", value1, value2, "posidesc");
            return (Criteria) this;
        }

        public Criteria andPosidescNotBetween(String value1, String value2) {
            addCriterion("posidesc not between", value1, value2, "posidesc");
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