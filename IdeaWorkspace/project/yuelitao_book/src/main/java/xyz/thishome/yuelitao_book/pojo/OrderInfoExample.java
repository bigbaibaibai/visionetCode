package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
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

        public Criteria andDdIdIsNull() {
            addCriterion("dd_id is null");
            return (Criteria) this;
        }

        public Criteria andDdIdIsNotNull() {
            addCriterion("dd_id is not null");
            return (Criteria) this;
        }

        public Criteria andDdIdEqualTo(String value) {
            addCriterion("dd_id =", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotEqualTo(String value) {
            addCriterion("dd_id <>", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdGreaterThan(String value) {
            addCriterion("dd_id >", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdGreaterThanOrEqualTo(String value) {
            addCriterion("dd_id >=", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdLessThan(String value) {
            addCriterion("dd_id <", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdLessThanOrEqualTo(String value) {
            addCriterion("dd_id <=", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdLike(String value) {
            addCriterion("dd_id like", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotLike(String value) {
            addCriterion("dd_id not like", value, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdIn(List<String> values) {
            addCriterion("dd_id in", values, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotIn(List<String> values) {
            addCriterion("dd_id not in", values, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdBetween(String value1, String value2) {
            addCriterion("dd_id between", value1, value2, "ddId");
            return (Criteria) this;
        }

        public Criteria andDdIdNotBetween(String value1, String value2) {
            addCriterion("dd_id not between", value1, value2, "ddId");
            return (Criteria) this;
        }

        public Criteria andShpIdIsNull() {
            addCriterion("shp_id is null");
            return (Criteria) this;
        }

        public Criteria andShpIdIsNotNull() {
            addCriterion("shp_id is not null");
            return (Criteria) this;
        }

        public Criteria andShpIdEqualTo(Integer value) {
            addCriterion("shp_id =", value, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdNotEqualTo(Integer value) {
            addCriterion("shp_id <>", value, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdGreaterThan(Integer value) {
            addCriterion("shp_id >", value, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shp_id >=", value, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdLessThan(Integer value) {
            addCriterion("shp_id <", value, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdLessThanOrEqualTo(Integer value) {
            addCriterion("shp_id <=", value, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdIn(List<Integer> values) {
            addCriterion("shp_id in", values, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdNotIn(List<Integer> values) {
            addCriterion("shp_id not in", values, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdBetween(Integer value1, Integer value2) {
            addCriterion("shp_id between", value1, value2, "shpId");
            return (Criteria) this;
        }

        public Criteria andShpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shp_id not between", value1, value2, "shpId");
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

        public Criteria andShpMchIsNull() {
            addCriterion("shp_mch is null");
            return (Criteria) this;
        }

        public Criteria andShpMchIsNotNull() {
            addCriterion("shp_mch is not null");
            return (Criteria) this;
        }

        public Criteria andShpMchEqualTo(String value) {
            addCriterion("shp_mch =", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchNotEqualTo(String value) {
            addCriterion("shp_mch <>", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchGreaterThan(String value) {
            addCriterion("shp_mch >", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchGreaterThanOrEqualTo(String value) {
            addCriterion("shp_mch >=", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchLessThan(String value) {
            addCriterion("shp_mch <", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchLessThanOrEqualTo(String value) {
            addCriterion("shp_mch <=", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchLike(String value) {
            addCriterion("shp_mch like", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchNotLike(String value) {
            addCriterion("shp_mch not like", value, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchIn(List<String> values) {
            addCriterion("shp_mch in", values, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchNotIn(List<String> values) {
            addCriterion("shp_mch not in", values, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchBetween(String value1, String value2) {
            addCriterion("shp_mch between", value1, value2, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpMchNotBetween(String value1, String value2) {
            addCriterion("shp_mch not between", value1, value2, "shpMch");
            return (Criteria) this;
        }

        public Criteria andShpTpIsNull() {
            addCriterion("shp_tp is null");
            return (Criteria) this;
        }

        public Criteria andShpTpIsNotNull() {
            addCriterion("shp_tp is not null");
            return (Criteria) this;
        }

        public Criteria andShpTpEqualTo(String value) {
            addCriterion("shp_tp =", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpNotEqualTo(String value) {
            addCriterion("shp_tp <>", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpGreaterThan(String value) {
            addCriterion("shp_tp >", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpGreaterThanOrEqualTo(String value) {
            addCriterion("shp_tp >=", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpLessThan(String value) {
            addCriterion("shp_tp <", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpLessThanOrEqualTo(String value) {
            addCriterion("shp_tp <=", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpLike(String value) {
            addCriterion("shp_tp like", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpNotLike(String value) {
            addCriterion("shp_tp not like", value, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpIn(List<String> values) {
            addCriterion("shp_tp in", values, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpNotIn(List<String> values) {
            addCriterion("shp_tp not in", values, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpBetween(String value1, String value2) {
            addCriterion("shp_tp between", value1, value2, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpTpNotBetween(String value1, String value2) {
            addCriterion("shp_tp not between", value1, value2, "shpTp");
            return (Criteria) this;
        }

        public Criteria andShpJgIsNull() {
            addCriterion("shp_jg is null");
            return (Criteria) this;
        }

        public Criteria andShpJgIsNotNull() {
            addCriterion("shp_jg is not null");
            return (Criteria) this;
        }

        public Criteria andShpJgEqualTo(Integer value) {
            addCriterion("shp_jg =", value, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgNotEqualTo(Integer value) {
            addCriterion("shp_jg <>", value, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgGreaterThan(Integer value) {
            addCriterion("shp_jg >", value, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgGreaterThanOrEqualTo(Integer value) {
            addCriterion("shp_jg >=", value, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgLessThan(Integer value) {
            addCriterion("shp_jg <", value, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgLessThanOrEqualTo(Integer value) {
            addCriterion("shp_jg <=", value, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgIn(List<Integer> values) {
            addCriterion("shp_jg in", values, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgNotIn(List<Integer> values) {
            addCriterion("shp_jg not in", values, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgBetween(Integer value1, Integer value2) {
            addCriterion("shp_jg between", value1, value2, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpJgNotBetween(Integer value1, Integer value2) {
            addCriterion("shp_jg not between", value1, value2, "shpJg");
            return (Criteria) this;
        }

        public Criteria andShpShlIsNull() {
            addCriterion("shp_shl is null");
            return (Criteria) this;
        }

        public Criteria andShpShlIsNotNull() {
            addCriterion("shp_shl is not null");
            return (Criteria) this;
        }

        public Criteria andShpShlEqualTo(Integer value) {
            addCriterion("shp_shl =", value, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlNotEqualTo(Integer value) {
            addCriterion("shp_shl <>", value, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlGreaterThan(Integer value) {
            addCriterion("shp_shl >", value, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlGreaterThanOrEqualTo(Integer value) {
            addCriterion("shp_shl >=", value, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlLessThan(Integer value) {
            addCriterion("shp_shl <", value, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlLessThanOrEqualTo(Integer value) {
            addCriterion("shp_shl <=", value, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlIn(List<Integer> values) {
            addCriterion("shp_shl in", values, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlNotIn(List<Integer> values) {
            addCriterion("shp_shl not in", values, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlBetween(Integer value1, Integer value2) {
            addCriterion("shp_shl between", value1, value2, "shpShl");
            return (Criteria) this;
        }

        public Criteria andShpShlNotBetween(Integer value1, Integer value2) {
            addCriterion("shp_shl not between", value1, value2, "shpShl");
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