package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAccountExample() {
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

        public Criteria andYhMchIsNull() {
            addCriterion("yh_mch is null");
            return (Criteria) this;
        }

        public Criteria andYhMchIsNotNull() {
            addCriterion("yh_mch is not null");
            return (Criteria) this;
        }

        public Criteria andYhMchEqualTo(String value) {
            addCriterion("yh_mch =", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchNotEqualTo(String value) {
            addCriterion("yh_mch <>", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchGreaterThan(String value) {
            addCriterion("yh_mch >", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchGreaterThanOrEqualTo(String value) {
            addCriterion("yh_mch >=", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchLessThan(String value) {
            addCriterion("yh_mch <", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchLessThanOrEqualTo(String value) {
            addCriterion("yh_mch <=", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchLike(String value) {
            addCriterion("yh_mch like", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchNotLike(String value) {
            addCriterion("yh_mch not like", value, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchIn(List<String> values) {
            addCriterion("yh_mch in", values, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchNotIn(List<String> values) {
            addCriterion("yh_mch not in", values, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchBetween(String value1, String value2) {
            addCriterion("yh_mch between", value1, value2, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhMchNotBetween(String value1, String value2) {
            addCriterion("yh_mch not between", value1, value2, "yhMch");
            return (Criteria) this;
        }

        public Criteria andYhNchIsNull() {
            addCriterion("yh_nch is null");
            return (Criteria) this;
        }

        public Criteria andYhNchIsNotNull() {
            addCriterion("yh_nch is not null");
            return (Criteria) this;
        }

        public Criteria andYhNchEqualTo(String value) {
            addCriterion("yh_nch =", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchNotEqualTo(String value) {
            addCriterion("yh_nch <>", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchGreaterThan(String value) {
            addCriterion("yh_nch >", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchGreaterThanOrEqualTo(String value) {
            addCriterion("yh_nch >=", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchLessThan(String value) {
            addCriterion("yh_nch <", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchLessThanOrEqualTo(String value) {
            addCriterion("yh_nch <=", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchLike(String value) {
            addCriterion("yh_nch like", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchNotLike(String value) {
            addCriterion("yh_nch not like", value, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchIn(List<String> values) {
            addCriterion("yh_nch in", values, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchNotIn(List<String> values) {
            addCriterion("yh_nch not in", values, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchBetween(String value1, String value2) {
            addCriterion("yh_nch between", value1, value2, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhNchNotBetween(String value1, String value2) {
            addCriterion("yh_nch not between", value1, value2, "yhNch");
            return (Criteria) this;
        }

        public Criteria andYhMmIsNull() {
            addCriterion("yh_mm is null");
            return (Criteria) this;
        }

        public Criteria andYhMmIsNotNull() {
            addCriterion("yh_mm is not null");
            return (Criteria) this;
        }

        public Criteria andYhMmEqualTo(String value) {
            addCriterion("yh_mm =", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmNotEqualTo(String value) {
            addCriterion("yh_mm <>", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmGreaterThan(String value) {
            addCriterion("yh_mm >", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmGreaterThanOrEqualTo(String value) {
            addCriterion("yh_mm >=", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmLessThan(String value) {
            addCriterion("yh_mm <", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmLessThanOrEqualTo(String value) {
            addCriterion("yh_mm <=", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmLike(String value) {
            addCriterion("yh_mm like", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmNotLike(String value) {
            addCriterion("yh_mm not like", value, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmIn(List<String> values) {
            addCriterion("yh_mm in", values, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmNotIn(List<String> values) {
            addCriterion("yh_mm not in", values, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmBetween(String value1, String value2) {
            addCriterion("yh_mm between", value1, value2, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhMmNotBetween(String value1, String value2) {
            addCriterion("yh_mm not between", value1, value2, "yhMm");
            return (Criteria) this;
        }

        public Criteria andYhXmIsNull() {
            addCriterion("yh_xm is null");
            return (Criteria) this;
        }

        public Criteria andYhXmIsNotNull() {
            addCriterion("yh_xm is not null");
            return (Criteria) this;
        }

        public Criteria andYhXmEqualTo(String value) {
            addCriterion("yh_xm =", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmNotEqualTo(String value) {
            addCriterion("yh_xm <>", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmGreaterThan(String value) {
            addCriterion("yh_xm >", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmGreaterThanOrEqualTo(String value) {
            addCriterion("yh_xm >=", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmLessThan(String value) {
            addCriterion("yh_xm <", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmLessThanOrEqualTo(String value) {
            addCriterion("yh_xm <=", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmLike(String value) {
            addCriterion("yh_xm like", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmNotLike(String value) {
            addCriterion("yh_xm not like", value, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmIn(List<String> values) {
            addCriterion("yh_xm in", values, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmNotIn(List<String> values) {
            addCriterion("yh_xm not in", values, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmBetween(String value1, String value2) {
            addCriterion("yh_xm between", value1, value2, "yhXm");
            return (Criteria) this;
        }

        public Criteria andYhXmNotBetween(String value1, String value2) {
            addCriterion("yh_xm not between", value1, value2, "yhXm");
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

        public Criteria andYhYxIsNull() {
            addCriterion("yh_yx is null");
            return (Criteria) this;
        }

        public Criteria andYhYxIsNotNull() {
            addCriterion("yh_yx is not null");
            return (Criteria) this;
        }

        public Criteria andYhYxEqualTo(String value) {
            addCriterion("yh_yx =", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxNotEqualTo(String value) {
            addCriterion("yh_yx <>", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxGreaterThan(String value) {
            addCriterion("yh_yx >", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxGreaterThanOrEqualTo(String value) {
            addCriterion("yh_yx >=", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxLessThan(String value) {
            addCriterion("yh_yx <", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxLessThanOrEqualTo(String value) {
            addCriterion("yh_yx <=", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxLike(String value) {
            addCriterion("yh_yx like", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxNotLike(String value) {
            addCriterion("yh_yx not like", value, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxIn(List<String> values) {
            addCriterion("yh_yx in", values, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxNotIn(List<String> values) {
            addCriterion("yh_yx not in", values, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxBetween(String value1, String value2) {
            addCriterion("yh_yx between", value1, value2, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhYxNotBetween(String value1, String value2) {
            addCriterion("yh_yx not between", value1, value2, "yhYx");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlIsNull() {
            addCriterion("yh_tx_url is null");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlIsNotNull() {
            addCriterion("yh_tx_url is not null");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlEqualTo(String value) {
            addCriterion("yh_tx_url =", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlNotEqualTo(String value) {
            addCriterion("yh_tx_url <>", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlGreaterThan(String value) {
            addCriterion("yh_tx_url >", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlGreaterThanOrEqualTo(String value) {
            addCriterion("yh_tx_url >=", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlLessThan(String value) {
            addCriterion("yh_tx_url <", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlLessThanOrEqualTo(String value) {
            addCriterion("yh_tx_url <=", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlLike(String value) {
            addCriterion("yh_tx_url like", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlNotLike(String value) {
            addCriterion("yh_tx_url not like", value, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlIn(List<String> values) {
            addCriterion("yh_tx_url in", values, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlNotIn(List<String> values) {
            addCriterion("yh_tx_url not in", values, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlBetween(String value1, String value2) {
            addCriterion("yh_tx_url between", value1, value2, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhTxUrlNotBetween(String value1, String value2) {
            addCriterion("yh_tx_url not between", value1, value2, "yhTxUrl");
            return (Criteria) this;
        }

        public Criteria andYhJbIsNull() {
            addCriterion("yh_jb is null");
            return (Criteria) this;
        }

        public Criteria andYhJbIsNotNull() {
            addCriterion("yh_jb is not null");
            return (Criteria) this;
        }

        public Criteria andYhJbEqualTo(String value) {
            addCriterion("yh_jb =", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbNotEqualTo(String value) {
            addCriterion("yh_jb <>", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbGreaterThan(String value) {
            addCriterion("yh_jb >", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbGreaterThanOrEqualTo(String value) {
            addCriterion("yh_jb >=", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbLessThan(String value) {
            addCriterion("yh_jb <", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbLessThanOrEqualTo(String value) {
            addCriterion("yh_jb <=", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbLike(String value) {
            addCriterion("yh_jb like", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbNotLike(String value) {
            addCriterion("yh_jb not like", value, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbIn(List<String> values) {
            addCriterion("yh_jb in", values, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbNotIn(List<String> values) {
            addCriterion("yh_jb not in", values, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbBetween(String value1, String value2) {
            addCriterion("yh_jb between", value1, value2, "yhJb");
            return (Criteria) this;
        }

        public Criteria andYhJbNotBetween(String value1, String value2) {
            addCriterion("yh_jb not between", value1, value2, "yhJb");
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