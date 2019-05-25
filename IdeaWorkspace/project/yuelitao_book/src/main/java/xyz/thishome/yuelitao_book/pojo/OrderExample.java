package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("Id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("Id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShhrIsNull() {
            addCriterion("shhr is null");
            return (Criteria) this;
        }

        public Criteria andShhrIsNotNull() {
            addCriterion("shhr is not null");
            return (Criteria) this;
        }

        public Criteria andShhrEqualTo(String value) {
            addCriterion("shhr =", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrNotEqualTo(String value) {
            addCriterion("shhr <>", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrGreaterThan(String value) {
            addCriterion("shhr >", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrGreaterThanOrEqualTo(String value) {
            addCriterion("shhr >=", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrLessThan(String value) {
            addCriterion("shhr <", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrLessThanOrEqualTo(String value) {
            addCriterion("shhr <=", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrLike(String value) {
            addCriterion("shhr like", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrNotLike(String value) {
            addCriterion("shhr not like", value, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrIn(List<String> values) {
            addCriterion("shhr in", values, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrNotIn(List<String> values) {
            addCriterion("shhr not in", values, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrBetween(String value1, String value2) {
            addCriterion("shhr between", value1, value2, "shhr");
            return (Criteria) this;
        }

        public Criteria andShhrNotBetween(String value1, String value2) {
            addCriterion("shhr not between", value1, value2, "shhr");
            return (Criteria) this;
        }

        public Criteria andZjeIsNull() {
            addCriterion("zje is null");
            return (Criteria) this;
        }

        public Criteria andZjeIsNotNull() {
            addCriterion("zje is not null");
            return (Criteria) this;
        }

        public Criteria andZjeEqualTo(Integer value) {
            addCriterion("zje =", value, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeNotEqualTo(Integer value) {
            addCriterion("zje <>", value, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeGreaterThan(Integer value) {
            addCriterion("zje >", value, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeGreaterThanOrEqualTo(Integer value) {
            addCriterion("zje >=", value, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeLessThan(Integer value) {
            addCriterion("zje <", value, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeLessThanOrEqualTo(Integer value) {
            addCriterion("zje <=", value, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeIn(List<Integer> values) {
            addCriterion("zje in", values, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeNotIn(List<Integer> values) {
            addCriterion("zje not in", values, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeBetween(Integer value1, Integer value2) {
            addCriterion("zje between", value1, value2, "zje");
            return (Criteria) this;
        }

        public Criteria andZjeNotBetween(Integer value1, Integer value2) {
            addCriterion("zje not between", value1, value2, "zje");
            return (Criteria) this;
        }

        public Criteria andJdhIsNull() {
            addCriterion("jdh is null");
            return (Criteria) this;
        }

        public Criteria andJdhIsNotNull() {
            addCriterion("jdh is not null");
            return (Criteria) this;
        }

        public Criteria andJdhEqualTo(Integer value) {
            addCriterion("jdh =", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhNotEqualTo(Integer value) {
            addCriterion("jdh <>", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhGreaterThan(Integer value) {
            addCriterion("jdh >", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhGreaterThanOrEqualTo(Integer value) {
            addCriterion("jdh >=", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhLessThan(Integer value) {
            addCriterion("jdh <", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhLessThanOrEqualTo(Integer value) {
            addCriterion("jdh <=", value, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhIn(List<Integer> values) {
            addCriterion("jdh in", values, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhNotIn(List<Integer> values) {
            addCriterion("jdh not in", values, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhBetween(Integer value1, Integer value2) {
            addCriterion("jdh between", value1, value2, "jdh");
            return (Criteria) this;
        }

        public Criteria andJdhNotBetween(Integer value1, Integer value2) {
            addCriterion("jdh not between", value1, value2, "jdh");
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

        public Criteria andYjsdshjIsNull() {
            addCriterion("yjsdshj is null");
            return (Criteria) this;
        }

        public Criteria andYjsdshjIsNotNull() {
            addCriterion("yjsdshj is not null");
            return (Criteria) this;
        }

        public Criteria andYjsdshjEqualTo(Date value) {
            addCriterion("yjsdshj =", value, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjNotEqualTo(Date value) {
            addCriterion("yjsdshj <>", value, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjGreaterThan(Date value) {
            addCriterion("yjsdshj >", value, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjGreaterThanOrEqualTo(Date value) {
            addCriterion("yjsdshj >=", value, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjLessThan(Date value) {
            addCriterion("yjsdshj <", value, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjLessThanOrEqualTo(Date value) {
            addCriterion("yjsdshj <=", value, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjIn(List<Date> values) {
            addCriterion("yjsdshj in", values, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjNotIn(List<Date> values) {
            addCriterion("yjsdshj not in", values, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjBetween(Date value1, Date value2) {
            addCriterion("yjsdshj between", value1, value2, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andYjsdshjNotBetween(Date value1, Date value2) {
            addCriterion("yjsdshj not between", value1, value2, "yjsdshj");
            return (Criteria) this;
        }

        public Criteria andDzhIdIsNull() {
            addCriterion("dzh_id is null");
            return (Criteria) this;
        }

        public Criteria andDzhIdIsNotNull() {
            addCriterion("dzh_id is not null");
            return (Criteria) this;
        }

        public Criteria andDzhIdEqualTo(Integer value) {
            addCriterion("dzh_id =", value, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdNotEqualTo(Integer value) {
            addCriterion("dzh_id <>", value, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdGreaterThan(Integer value) {
            addCriterion("dzh_id >", value, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dzh_id >=", value, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdLessThan(Integer value) {
            addCriterion("dzh_id <", value, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdLessThanOrEqualTo(Integer value) {
            addCriterion("dzh_id <=", value, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdIn(List<Integer> values) {
            addCriterion("dzh_id in", values, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdNotIn(List<Integer> values) {
            addCriterion("dzh_id not in", values, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdBetween(Integer value1, Integer value2) {
            addCriterion("dzh_id between", value1, value2, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dzh_id not between", value1, value2, "dzhId");
            return (Criteria) this;
        }

        public Criteria andDzhMchIsNull() {
            addCriterion("dzh_mch is null");
            return (Criteria) this;
        }

        public Criteria andDzhMchIsNotNull() {
            addCriterion("dzh_mch is not null");
            return (Criteria) this;
        }

        public Criteria andDzhMchEqualTo(String value) {
            addCriterion("dzh_mch =", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchNotEqualTo(String value) {
            addCriterion("dzh_mch <>", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchGreaterThan(String value) {
            addCriterion("dzh_mch >", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchGreaterThanOrEqualTo(String value) {
            addCriterion("dzh_mch >=", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchLessThan(String value) {
            addCriterion("dzh_mch <", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchLessThanOrEqualTo(String value) {
            addCriterion("dzh_mch <=", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchLike(String value) {
            addCriterion("dzh_mch like", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchNotLike(String value) {
            addCriterion("dzh_mch not like", value, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchIn(List<String> values) {
            addCriterion("dzh_mch in", values, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchNotIn(List<String> values) {
            addCriterion("dzh_mch not in", values, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchBetween(String value1, String value2) {
            addCriterion("dzh_mch between", value1, value2, "dzhMch");
            return (Criteria) this;
        }

        public Criteria andDzhMchNotBetween(String value1, String value2) {
            addCriterion("dzh_mch not between", value1, value2, "dzhMch");
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