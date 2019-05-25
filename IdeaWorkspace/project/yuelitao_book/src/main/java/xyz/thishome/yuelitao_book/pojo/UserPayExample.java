package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserPayExample() {
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

        public Criteria andDdIdIsNull() {
            addCriterion("dd_id is null");
            return (Criteria) this;
        }

        public Criteria andDdIdIsNotNull() {
            addCriterion("dd_id is not null");
            return (Criteria) this;
        }

        public Criteria andDdIdEqualTo(Integer value) {
            addCriterion("dd_id =", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotEqualTo(Integer value) {
            addCriterion("dd_id <>", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdGreaterThan(Integer value) {
            addCriterion("dd_id >", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dd_id >=", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdLessThan(Integer value) {
            addCriterion("dd_id <", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdLessThanOrEqualTo(Integer value) {
            addCriterion("dd_id <=", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdIn(List<Integer> values) {
            addCriterion("dd_id in", values, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotIn(List<Integer> values) {
            addCriterion("dd_id not in", values, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdBetween(Integer value1, Integer value2) {
            addCriterion("dd_id between", value1, value2, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dd_id not between", value1, value2, "ddId");
            return (Criteria) this;
        }

        public Criteria andFkshjIsNull() {
            addCriterion("fkshj is null");
            return (Criteria) this;
        }

        public Criteria andFkshjIsNotNull() {
            addCriterion("fkshj is not null");
            return (Criteria) this;
        }

        public Criteria andFkshjEqualTo(Date value) {
            addCriterion("fkshj =", value, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjNotEqualTo(Date value) {
            addCriterion("fkshj <>", value, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjGreaterThan(Date value) {
            addCriterion("fkshj >", value, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjGreaterThanOrEqualTo(Date value) {
            addCriterion("fkshj >=", value, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjLessThan(Date value) {
            addCriterion("fkshj <", value, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjLessThanOrEqualTo(Date value) {
            addCriterion("fkshj <=", value, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjIn(List<Date> values) {
            addCriterion("fkshj in", values, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjNotIn(List<Date> values) {
            addCriterion("fkshj not in", values, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjBetween(Date value1, Date value2) {
            addCriterion("fkshj between", value1, value2, "fkshj");
            return (Criteria) this;
        }

        public Criteria andFkshjNotBetween(Date value1, Date value2) {
            addCriterion("fkshj not between", value1, value2, "fkshj");
            return (Criteria) this;
        }

        public Criteria andDdJeIsNull() {
            addCriterion("dd_je is null");
            return (Criteria) this;
        }

        public Criteria andDdJeIsNotNull() {
            addCriterion("dd_je is not null");
            return (Criteria) this;
        }

        public Criteria andDdJeEqualTo(Integer value) {
            addCriterion("dd_je =", value, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeNotEqualTo(Integer value) {
            addCriterion("dd_je <>", value, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeGreaterThan(Integer value) {
            addCriterion("dd_je >", value, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dd_je >=", value, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeLessThan(Integer value) {
            addCriterion("dd_je <", value, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeLessThanOrEqualTo(Integer value) {
            addCriterion("dd_je <=", value, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeIn(List<Integer> values) {
            addCriterion("dd_je in", values, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeNotIn(List<Integer> values) {
            addCriterion("dd_je not in", values, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeBetween(Integer value1, Integer value2) {
            addCriterion("dd_je between", value1, value2, "ddJe");
            return (Criteria) this;
        }

        public Criteria andDdJeNotBetween(Integer value1, Integer value2) {
            addCriterion("dd_je not between", value1, value2, "ddJe");
            return (Criteria) this;
        }

        public Criteria andZhfFshIsNull() {
            addCriterion("zhf_fsh is null");
            return (Criteria) this;
        }

        public Criteria andZhfFshIsNotNull() {
            addCriterion("zhf_fsh is not null");
            return (Criteria) this;
        }

        public Criteria andZhfFshEqualTo(String value) {
            addCriterion("zhf_fsh =", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshNotEqualTo(String value) {
            addCriterion("zhf_fsh <>", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshGreaterThan(String value) {
            addCriterion("zhf_fsh >", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshGreaterThanOrEqualTo(String value) {
            addCriterion("zhf_fsh >=", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshLessThan(String value) {
            addCriterion("zhf_fsh <", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshLessThanOrEqualTo(String value) {
            addCriterion("zhf_fsh <=", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshLike(String value) {
            addCriterion("zhf_fsh like", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshNotLike(String value) {
            addCriterion("zhf_fsh not like", value, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshIn(List<String> values) {
            addCriterion("zhf_fsh in", values, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshNotIn(List<String> values) {
            addCriterion("zhf_fsh not in", values, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshBetween(String value1, String value2) {
            addCriterion("zhf_fsh between", value1, value2, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andZhfFshNotBetween(String value1, String value2) {
            addCriterion("zhf_fsh not between", value1, value2, "zhfFsh");
            return (Criteria) this;
        }

        public Criteria andYhIsNull() {
            addCriterion("yh is null");
            return (Criteria) this;
        }

        public Criteria andYhIsNotNull() {
            addCriterion("yh is not null");
            return (Criteria) this;
        }

        public Criteria andYhEqualTo(String value) {
            addCriterion("yh =", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhNotEqualTo(String value) {
            addCriterion("yh <>", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhGreaterThan(String value) {
            addCriterion("yh >", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhGreaterThanOrEqualTo(String value) {
            addCriterion("yh >=", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhLessThan(String value) {
            addCriterion("yh <", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhLessThanOrEqualTo(String value) {
            addCriterion("yh <=", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhLike(String value) {
            addCriterion("yh like", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhNotLike(String value) {
            addCriterion("yh not like", value, "yh");
            return (Criteria) this;
        }

        public Criteria andYhIn(List<String> values) {
            addCriterion("yh in", values, "yh");
            return (Criteria) this;
        }

        public Criteria andYhNotIn(List<String> values) {
            addCriterion("yh not in", values, "yh");
            return (Criteria) this;
        }

        public Criteria andYhBetween(String value1, String value2) {
            addCriterion("yh between", value1, value2, "yh");
            return (Criteria) this;
        }

        public Criteria andYhNotBetween(String value1, String value2) {
            addCriterion("yh not between", value1, value2, "yh");
            return (Criteria) this;
        }

        public Criteria andYhLshIsNull() {
            addCriterion("yh_lsh is null");
            return (Criteria) this;
        }

        public Criteria andYhLshIsNotNull() {
            addCriterion("yh_lsh is not null");
            return (Criteria) this;
        }

        public Criteria andYhLshEqualTo(String value) {
            addCriterion("yh_lsh =", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshNotEqualTo(String value) {
            addCriterion("yh_lsh <>", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshGreaterThan(String value) {
            addCriterion("yh_lsh >", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshGreaterThanOrEqualTo(String value) {
            addCriterion("yh_lsh >=", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshLessThan(String value) {
            addCriterion("yh_lsh <", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshLessThanOrEqualTo(String value) {
            addCriterion("yh_lsh <=", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshLike(String value) {
            addCriterion("yh_lsh like", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshNotLike(String value) {
            addCriterion("yh_lsh not like", value, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshIn(List<String> values) {
            addCriterion("yh_lsh in", values, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshNotIn(List<String> values) {
            addCriterion("yh_lsh not in", values, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshBetween(String value1, String value2) {
            addCriterion("yh_lsh between", value1, value2, "yhLsh");
            return (Criteria) this;
        }

        public Criteria andYhLshNotBetween(String value1, String value2) {
            addCriterion("yh_lsh not between", value1, value2, "yhLsh");
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