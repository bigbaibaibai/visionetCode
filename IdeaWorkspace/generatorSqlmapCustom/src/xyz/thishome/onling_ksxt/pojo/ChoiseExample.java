package xyz.thishome.onling_ksxt.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChoiseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChoiseExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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

        public Criteria andChoiseAIsNull() {
            addCriterion("choise_a is null");
            return (Criteria) this;
        }

        public Criteria andChoiseAIsNotNull() {
            addCriterion("choise_a is not null");
            return (Criteria) this;
        }

        public Criteria andChoiseAEqualTo(String value) {
            addCriterion("choise_a =", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseANotEqualTo(String value) {
            addCriterion("choise_a <>", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseAGreaterThan(String value) {
            addCriterion("choise_a >", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseAGreaterThanOrEqualTo(String value) {
            addCriterion("choise_a >=", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseALessThan(String value) {
            addCriterion("choise_a <", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseALessThanOrEqualTo(String value) {
            addCriterion("choise_a <=", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseALike(String value) {
            addCriterion("choise_a like", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseANotLike(String value) {
            addCriterion("choise_a not like", value, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseAIn(List<String> values) {
            addCriterion("choise_a in", values, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseANotIn(List<String> values) {
            addCriterion("choise_a not in", values, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseABetween(String value1, String value2) {
            addCriterion("choise_a between", value1, value2, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseANotBetween(String value1, String value2) {
            addCriterion("choise_a not between", value1, value2, "choiseA");
            return (Criteria) this;
        }

        public Criteria andChoiseBIsNull() {
            addCriterion("choise_b is null");
            return (Criteria) this;
        }

        public Criteria andChoiseBIsNotNull() {
            addCriterion("choise_b is not null");
            return (Criteria) this;
        }

        public Criteria andChoiseBEqualTo(String value) {
            addCriterion("choise_b =", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBNotEqualTo(String value) {
            addCriterion("choise_b <>", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBGreaterThan(String value) {
            addCriterion("choise_b >", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBGreaterThanOrEqualTo(String value) {
            addCriterion("choise_b >=", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBLessThan(String value) {
            addCriterion("choise_b <", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBLessThanOrEqualTo(String value) {
            addCriterion("choise_b <=", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBLike(String value) {
            addCriterion("choise_b like", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBNotLike(String value) {
            addCriterion("choise_b not like", value, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBIn(List<String> values) {
            addCriterion("choise_b in", values, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBNotIn(List<String> values) {
            addCriterion("choise_b not in", values, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBBetween(String value1, String value2) {
            addCriterion("choise_b between", value1, value2, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseBNotBetween(String value1, String value2) {
            addCriterion("choise_b not between", value1, value2, "choiseB");
            return (Criteria) this;
        }

        public Criteria andChoiseCIsNull() {
            addCriterion("choise_c is null");
            return (Criteria) this;
        }

        public Criteria andChoiseCIsNotNull() {
            addCriterion("choise_c is not null");
            return (Criteria) this;
        }

        public Criteria andChoiseCEqualTo(String value) {
            addCriterion("choise_c =", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCNotEqualTo(String value) {
            addCriterion("choise_c <>", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCGreaterThan(String value) {
            addCriterion("choise_c >", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCGreaterThanOrEqualTo(String value) {
            addCriterion("choise_c >=", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCLessThan(String value) {
            addCriterion("choise_c <", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCLessThanOrEqualTo(String value) {
            addCriterion("choise_c <=", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCLike(String value) {
            addCriterion("choise_c like", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCNotLike(String value) {
            addCriterion("choise_c not like", value, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCIn(List<String> values) {
            addCriterion("choise_c in", values, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCNotIn(List<String> values) {
            addCriterion("choise_c not in", values, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCBetween(String value1, String value2) {
            addCriterion("choise_c between", value1, value2, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseCNotBetween(String value1, String value2) {
            addCriterion("choise_c not between", value1, value2, "choiseC");
            return (Criteria) this;
        }

        public Criteria andChoiseDIsNull() {
            addCriterion("choise_d is null");
            return (Criteria) this;
        }

        public Criteria andChoiseDIsNotNull() {
            addCriterion("choise_d is not null");
            return (Criteria) this;
        }

        public Criteria andChoiseDEqualTo(String value) {
            addCriterion("choise_d =", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDNotEqualTo(String value) {
            addCriterion("choise_d <>", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDGreaterThan(String value) {
            addCriterion("choise_d >", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDGreaterThanOrEqualTo(String value) {
            addCriterion("choise_d >=", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDLessThan(String value) {
            addCriterion("choise_d <", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDLessThanOrEqualTo(String value) {
            addCriterion("choise_d <=", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDLike(String value) {
            addCriterion("choise_d like", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDNotLike(String value) {
            addCriterion("choise_d not like", value, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDIn(List<String> values) {
            addCriterion("choise_d in", values, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDNotIn(List<String> values) {
            addCriterion("choise_d not in", values, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDBetween(String value1, String value2) {
            addCriterion("choise_d between", value1, value2, "choiseD");
            return (Criteria) this;
        }

        public Criteria andChoiseDNotBetween(String value1, String value2) {
            addCriterion("choise_d not between", value1, value2, "choiseD");
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