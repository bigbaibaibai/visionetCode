package com.ssm.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBookClassIdIsNull() {
            addCriterion("book_class_id is null");
            return (Criteria) this;
        }

        public Criteria andBookClassIdIsNotNull() {
            addCriterion("book_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookClassIdEqualTo(Integer value) {
            addCriterion("book_class_id =", value, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdNotEqualTo(Integer value) {
            addCriterion("book_class_id <>", value, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdGreaterThan(Integer value) {
            addCriterion("book_class_id >", value, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_class_id >=", value, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdLessThan(Integer value) {
            addCriterion("book_class_id <", value, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_class_id <=", value, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdIn(List<Integer> values) {
            addCriterion("book_class_id in", values, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdNotIn(List<Integer> values) {
            addCriterion("book_class_id not in", values, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdBetween(Integer value1, Integer value2) {
            addCriterion("book_class_id between", value1, value2, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andBookClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_class_id not between", value1, value2, "bookClassId");
            return (Criteria) this;
        }

        public Criteria andSalesamountIsNull() {
            addCriterion("salesamount is null");
            return (Criteria) this;
        }

        public Criteria andSalesamountIsNotNull() {
            addCriterion("salesamount is not null");
            return (Criteria) this;
        }

        public Criteria andSalesamountEqualTo(Integer value) {
            addCriterion("salesamount =", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountNotEqualTo(Integer value) {
            addCriterion("salesamount <>", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountGreaterThan(Integer value) {
            addCriterion("salesamount >", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("salesamount >=", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountLessThan(Integer value) {
            addCriterion("salesamount <", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountLessThanOrEqualTo(Integer value) {
            addCriterion("salesamount <=", value, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountIn(List<Integer> values) {
            addCriterion("salesamount in", values, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountNotIn(List<Integer> values) {
            addCriterion("salesamount not in", values, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountBetween(Integer value1, Integer value2) {
            addCriterion("salesamount between", value1, value2, "salesamount");
            return (Criteria) this;
        }

        public Criteria andSalesamountNotBetween(Integer value1, Integer value2) {
            addCriterion("salesamount not between", value1, value2, "salesamount");
            return (Criteria) this;
        }

        public Criteria andStorenumberIsNull() {
            addCriterion("storenumber is null");
            return (Criteria) this;
        }

        public Criteria andStorenumberIsNotNull() {
            addCriterion("storenumber is not null");
            return (Criteria) this;
        }

        public Criteria andStorenumberEqualTo(Integer value) {
            addCriterion("storenumber =", value, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberNotEqualTo(Integer value) {
            addCriterion("storenumber <>", value, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberGreaterThan(Integer value) {
            addCriterion("storenumber >", value, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("storenumber >=", value, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberLessThan(Integer value) {
            addCriterion("storenumber <", value, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberLessThanOrEqualTo(Integer value) {
            addCriterion("storenumber <=", value, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberIn(List<Integer> values) {
            addCriterion("storenumber in", values, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberNotIn(List<Integer> values) {
            addCriterion("storenumber not in", values, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberBetween(Integer value1, Integer value2) {
            addCriterion("storenumber between", value1, value2, "storenumber");
            return (Criteria) this;
        }

        public Criteria andStorenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("storenumber not between", value1, value2, "storenumber");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNull() {
            addCriterion("picture_url is null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNotNull() {
            addCriterion("picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlEqualTo(String value) {
            addCriterion("picture_url =", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotEqualTo(String value) {
            addCriterion("picture_url <>", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThan(String value) {
            addCriterion("picture_url >", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("picture_url >=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThan(String value) {
            addCriterion("picture_url <", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("picture_url <=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLike(String value) {
            addCriterion("picture_url like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotLike(String value) {
            addCriterion("picture_url not like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIn(List<String> values) {
            addCriterion("picture_url in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotIn(List<String> values) {
            addCriterion("picture_url not in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlBetween(String value1, String value2) {
            addCriterion("picture_url between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotBetween(String value1, String value2) {
            addCriterion("picture_url not between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPublishingdateIsNull() {
            addCriterion("publishingdate is null");
            return (Criteria) this;
        }

        public Criteria andPublishingdateIsNotNull() {
            addCriterion("publishingdate is not null");
            return (Criteria) this;
        }

        public Criteria andPublishingdateEqualTo(Date value) {
            addCriterionForJDBCDate("publishingdate =", value, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("publishingdate <>", value, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateGreaterThan(Date value) {
            addCriterionForJDBCDate("publishingdate >", value, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishingdate >=", value, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateLessThan(Date value) {
            addCriterionForJDBCDate("publishingdate <", value, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishingdate <=", value, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateIn(List<Date> values) {
            addCriterionForJDBCDate("publishingdate in", values, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("publishingdate not in", values, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishingdate between", value1, value2, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andPublishingdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishingdate not between", value1, value2, "publishingdate");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIsNull() {
            addCriterion("status_code is null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIsNotNull() {
            addCriterion("status_code is not null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeEqualTo(Integer value) {
            addCriterion("status_code =", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotEqualTo(Integer value) {
            addCriterion("status_code <>", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeGreaterThan(Integer value) {
            addCriterion("status_code >", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_code >=", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeLessThan(Integer value) {
            addCriterion("status_code <", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeLessThanOrEqualTo(Integer value) {
            addCriterion("status_code <=", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIn(List<Integer> values) {
            addCriterion("status_code in", values, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotIn(List<Integer> values) {
            addCriterion("status_code not in", values, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeBetween(Integer value1, Integer value2) {
            addCriterion("status_code between", value1, value2, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("status_code not between", value1, value2, "statusCode");
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