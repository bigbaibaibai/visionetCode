package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAddressExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDzMchIsNull() {
            addCriterion("dz_mch is null");
            return (Criteria) this;
        }

        public Criteria andDzMchIsNotNull() {
            addCriterion("dz_mch is not null");
            return (Criteria) this;
        }

        public Criteria andDzMchEqualTo(String value) {
            addCriterion("dz_mch =", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchNotEqualTo(String value) {
            addCriterion("dz_mch <>", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchGreaterThan(String value) {
            addCriterion("dz_mch >", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchGreaterThanOrEqualTo(String value) {
            addCriterion("dz_mch >=", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchLessThan(String value) {
            addCriterion("dz_mch <", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchLessThanOrEqualTo(String value) {
            addCriterion("dz_mch <=", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchLike(String value) {
            addCriterion("dz_mch like", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchNotLike(String value) {
            addCriterion("dz_mch not like", value, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchIn(List<String> values) {
            addCriterion("dz_mch in", values, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchNotIn(List<String> values) {
            addCriterion("dz_mch not in", values, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchBetween(String value1, String value2) {
            addCriterion("dz_mch between", value1, value2, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzMchNotBetween(String value1, String value2) {
            addCriterion("dz_mch not between", value1, value2, "dzMch");
            return (Criteria) this;
        }

        public Criteria andDzztIsNull() {
            addCriterion("dzzt is null");
            return (Criteria) this;
        }

        public Criteria andDzztIsNotNull() {
            addCriterion("dzzt is not null");
            return (Criteria) this;
        }

        public Criteria andDzztEqualTo(Integer value) {
            addCriterion("dzzt =", value, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztNotEqualTo(Integer value) {
            addCriterion("dzzt <>", value, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztGreaterThan(Integer value) {
            addCriterion("dzzt >", value, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztGreaterThanOrEqualTo(Integer value) {
            addCriterion("dzzt >=", value, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztLessThan(Integer value) {
            addCriterion("dzzt <", value, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztLessThanOrEqualTo(Integer value) {
            addCriterion("dzzt <=", value, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztIn(List<Integer> values) {
            addCriterion("dzzt in", values, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztNotIn(List<Integer> values) {
            addCriterion("dzzt not in", values, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztBetween(Integer value1, Integer value2) {
            addCriterion("dzzt between", value1, value2, "dzzt");
            return (Criteria) this;
        }

        public Criteria andDzztNotBetween(Integer value1, Integer value2) {
            addCriterion("dzzt not between", value1, value2, "dzzt");
            return (Criteria) this;
        }

        public Criteria andYhIdIsNull() {
            addCriterion("yh_id is null");
            return (Criteria) this;
        }

        public Criteria andYhIdIsNotNull() {
            addCriterion("yh_id is not null");
            return (Criteria) this;
        }

        public Criteria andYhIdEqualTo(Integer value) {
            addCriterion("yh_id =", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdNotEqualTo(Integer value) {
            addCriterion("yh_id <>", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdGreaterThan(Integer value) {
            addCriterion("yh_id >", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("yh_id >=", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdLessThan(Integer value) {
            addCriterion("yh_id <", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdLessThanOrEqualTo(Integer value) {
            addCriterion("yh_id <=", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdIn(List<Integer> values) {
            addCriterion("yh_id in", values, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdNotIn(List<Integer> values) {
            addCriterion("yh_id not in", values, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdBetween(Integer value1, Integer value2) {
            addCriterion("yh_id between", value1, value2, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdNotBetween(Integer value1, Integer value2) {
            addCriterion("yh_id not between", value1, value2, "yhId");
            return (Criteria) this;
        }

        public Criteria andShjrIsNull() {
            addCriterion("shjr is null");
            return (Criteria) this;
        }

        public Criteria andShjrIsNotNull() {
            addCriterion("shjr is not null");
            return (Criteria) this;
        }

        public Criteria andShjrEqualTo(String value) {
            addCriterion("shjr =", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrNotEqualTo(String value) {
            addCriterion("shjr <>", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrGreaterThan(String value) {
            addCriterion("shjr >", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrGreaterThanOrEqualTo(String value) {
            addCriterion("shjr >=", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrLessThan(String value) {
            addCriterion("shjr <", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrLessThanOrEqualTo(String value) {
            addCriterion("shjr <=", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrLike(String value) {
            addCriterion("shjr like", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrNotLike(String value) {
            addCriterion("shjr not like", value, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrIn(List<String> values) {
            addCriterion("shjr in", values, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrNotIn(List<String> values) {
            addCriterion("shjr not in", values, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrBetween(String value1, String value2) {
            addCriterion("shjr between", value1, value2, "shjr");
            return (Criteria) this;
        }

        public Criteria andShjrNotBetween(String value1, String value2) {
            addCriterion("shjr not between", value1, value2, "shjr");
            return (Criteria) this;
        }

        public Criteria andLxfshIsNull() {
            addCriterion("lxfsh is null");
            return (Criteria) this;
        }

        public Criteria andLxfshIsNotNull() {
            addCriterion("lxfsh is not null");
            return (Criteria) this;
        }

        public Criteria andLxfshEqualTo(String value) {
            addCriterion("lxfsh =", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshNotEqualTo(String value) {
            addCriterion("lxfsh <>", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshGreaterThan(String value) {
            addCriterion("lxfsh >", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshGreaterThanOrEqualTo(String value) {
            addCriterion("lxfsh >=", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshLessThan(String value) {
            addCriterion("lxfsh <", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshLessThanOrEqualTo(String value) {
            addCriterion("lxfsh <=", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshLike(String value) {
            addCriterion("lxfsh like", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshNotLike(String value) {
            addCriterion("lxfsh not like", value, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshIn(List<String> values) {
            addCriterion("lxfsh in", values, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshNotIn(List<String> values) {
            addCriterion("lxfsh not in", values, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshBetween(String value1, String value2) {
            addCriterion("lxfsh between", value1, value2, "lxfsh");
            return (Criteria) this;
        }

        public Criteria andLxfshNotBetween(String value1, String value2) {
            addCriterion("lxfsh not between", value1, value2, "lxfsh");
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