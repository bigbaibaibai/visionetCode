package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(Integer value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(Integer value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(Integer value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(Integer value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(Integer value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<Integer> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<Integer> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(Integer value1, Integer value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(Integer value1, Integer value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
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

        public Criteria andYhShjhIsNull() {
            addCriterion("yh_shjh is null");
            return (Criteria) this;
        }

        public Criteria andYhShjhIsNotNull() {
            addCriterion("yh_shjh is not null");
            return (Criteria) this;
        }

        public Criteria andYhShjhEqualTo(String value) {
            addCriterion("yh_shjh =", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhNotEqualTo(String value) {
            addCriterion("yh_shjh <>", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhGreaterThan(String value) {
            addCriterion("yh_shjh >", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhGreaterThanOrEqualTo(String value) {
            addCriterion("yh_shjh >=", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhLessThan(String value) {
            addCriterion("yh_shjh <", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhLessThanOrEqualTo(String value) {
            addCriterion("yh_shjh <=", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhLike(String value) {
            addCriterion("yh_shjh like", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhNotLike(String value) {
            addCriterion("yh_shjh not like", value, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhIn(List<String> values) {
            addCriterion("yh_shjh in", values, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhNotIn(List<String> values) {
            addCriterion("yh_shjh not in", values, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhBetween(String value1, String value2) {
            addCriterion("yh_shjh between", value1, value2, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhShjhNotBetween(String value1, String value2) {
            addCriterion("yh_shjh not between", value1, value2, "yhShjh");
            return (Criteria) this;
        }

        public Criteria andYhJgIsNull() {
            addCriterion("yh_jg is null");
            return (Criteria) this;
        }

        public Criteria andYhJgIsNotNull() {
            addCriterion("yh_jg is not null");
            return (Criteria) this;
        }

        public Criteria andYhJgEqualTo(String value) {
            addCriterion("yh_jg =", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgNotEqualTo(String value) {
            addCriterion("yh_jg <>", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgGreaterThan(String value) {
            addCriterion("yh_jg >", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgGreaterThanOrEqualTo(String value) {
            addCriterion("yh_jg >=", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgLessThan(String value) {
            addCriterion("yh_jg <", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgLessThanOrEqualTo(String value) {
            addCriterion("yh_jg <=", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgLike(String value) {
            addCriterion("yh_jg like", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgNotLike(String value) {
            addCriterion("yh_jg not like", value, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgIn(List<String> values) {
            addCriterion("yh_jg in", values, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgNotIn(List<String> values) {
            addCriterion("yh_jg not in", values, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgBetween(String value1, String value2) {
            addCriterion("yh_jg between", value1, value2, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhJgNotBetween(String value1, String value2) {
            addCriterion("yh_jg not between", value1, value2, "yhJg");
            return (Criteria) this;
        }

        public Criteria andYhZhzhIsNull() {
            addCriterion("yh_zhzh is null");
            return (Criteria) this;
        }

        public Criteria andYhZhzhIsNotNull() {
            addCriterion("yh_zhzh is not null");
            return (Criteria) this;
        }

        public Criteria andYhZhzhEqualTo(String value) {
            addCriterion("yh_zhzh =", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhNotEqualTo(String value) {
            addCriterion("yh_zhzh <>", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhGreaterThan(String value) {
            addCriterion("yh_zhzh >", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhGreaterThanOrEqualTo(String value) {
            addCriterion("yh_zhzh >=", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhLessThan(String value) {
            addCriterion("yh_zhzh <", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhLessThanOrEqualTo(String value) {
            addCriterion("yh_zhzh <=", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhLike(String value) {
            addCriterion("yh_zhzh like", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhNotLike(String value) {
            addCriterion("yh_zhzh not like", value, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhIn(List<String> values) {
            addCriterion("yh_zhzh in", values, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhNotIn(List<String> values) {
            addCriterion("yh_zhzh not in", values, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhBetween(String value1, String value2) {
            addCriterion("yh_zhzh between", value1, value2, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhZhzhNotBetween(String value1, String value2) {
            addCriterion("yh_zhzh not between", value1, value2, "yhZhzh");
            return (Criteria) this;
        }

        public Criteria andYhXbIsNull() {
            addCriterion("yh_xb is null");
            return (Criteria) this;
        }

        public Criteria andYhXbIsNotNull() {
            addCriterion("yh_xb is not null");
            return (Criteria) this;
        }

        public Criteria andYhXbEqualTo(Integer value) {
            addCriterion("yh_xb =", value, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbNotEqualTo(Integer value) {
            addCriterion("yh_xb <>", value, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbGreaterThan(Integer value) {
            addCriterion("yh_xb >", value, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbGreaterThanOrEqualTo(Integer value) {
            addCriterion("yh_xb >=", value, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbLessThan(Integer value) {
            addCriterion("yh_xb <", value, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbLessThanOrEqualTo(Integer value) {
            addCriterion("yh_xb <=", value, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbIn(List<Integer> values) {
            addCriterion("yh_xb in", values, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbNotIn(List<Integer> values) {
            addCriterion("yh_xb not in", values, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbBetween(Integer value1, Integer value2) {
            addCriterion("yh_xb between", value1, value2, "yhXb");
            return (Criteria) this;
        }

        public Criteria andYhXbNotBetween(Integer value1, Integer value2) {
            addCriterion("yh_xb not between", value1, value2, "yhXb");
            return (Criteria) this;
        }

        public Criteria andChjshjIsNull() {
            addCriterion("chjshj is null");
            return (Criteria) this;
        }

        public Criteria andChjshjIsNotNull() {
            addCriterion("chjshj is not null");
            return (Criteria) this;
        }

        public Criteria andChjshjEqualTo(Date value) {
            addCriterion("chjshj =", value, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjNotEqualTo(Date value) {
            addCriterion("chjshj <>", value, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjGreaterThan(Date value) {
            addCriterion("chjshj >", value, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjGreaterThanOrEqualTo(Date value) {
            addCriterion("chjshj >=", value, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjLessThan(Date value) {
            addCriterion("chjshj <", value, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjLessThanOrEqualTo(Date value) {
            addCriterion("chjshj <=", value, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjIn(List<Date> values) {
            addCriterion("chjshj in", values, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjNotIn(List<Date> values) {
            addCriterion("chjshj not in", values, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjBetween(Date value1, Date value2) {
            addCriterion("chjshj between", value1, value2, "chjshj");
            return (Criteria) this;
        }

        public Criteria andChjshjNotBetween(Date value1, Date value2) {
            addCriterion("chjshj not between", value1, value2, "chjshj");
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