package xyz.thishome.hotel.pojo;

import java.util.ArrayList;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
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

        public Criteria andHouseLevelIsNull() {
            addCriterion("house_level is null");
            return (Criteria) this;
        }

        public Criteria andHouseLevelIsNotNull() {
            addCriterion("house_level is not null");
            return (Criteria) this;
        }

        public Criteria andHouseLevelEqualTo(Integer value) {
            addCriterion("house_level =", value, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelNotEqualTo(Integer value) {
            addCriterion("house_level <>", value, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelGreaterThan(Integer value) {
            addCriterion("house_level >", value, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_level >=", value, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelLessThan(Integer value) {
            addCriterion("house_level <", value, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelLessThanOrEqualTo(Integer value) {
            addCriterion("house_level <=", value, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelIn(List<Integer> values) {
            addCriterion("house_level in", values, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelNotIn(List<Integer> values) {
            addCriterion("house_level not in", values, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelBetween(Integer value1, Integer value2) {
            addCriterion("house_level between", value1, value2, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHouseLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("house_level not between", value1, value2, "houseLevel");
            return (Criteria) this;
        }

        public Criteria andHousePriceIsNull() {
            addCriterion("house_price is null");
            return (Criteria) this;
        }

        public Criteria andHousePriceIsNotNull() {
            addCriterion("house_price is not null");
            return (Criteria) this;
        }

        public Criteria andHousePriceEqualTo(Integer value) {
            addCriterion("house_price =", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotEqualTo(Integer value) {
            addCriterion("house_price <>", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceGreaterThan(Integer value) {
            addCriterion("house_price >", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_price >=", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceLessThan(Integer value) {
            addCriterion("house_price <", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceLessThanOrEqualTo(Integer value) {
            addCriterion("house_price <=", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceIn(List<Integer> values) {
            addCriterion("house_price in", values, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotIn(List<Integer> values) {
            addCriterion("house_price not in", values, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceBetween(Integer value1, Integer value2) {
            addCriterion("house_price between", value1, value2, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("house_price not between", value1, value2, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNull() {
            addCriterion("house_status is null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNotNull() {
            addCriterion("house_status is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusEqualTo(Integer value) {
            addCriterion("house_status =", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotEqualTo(Integer value) {
            addCriterion("house_status <>", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThan(Integer value) {
            addCriterion("house_status >", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_status >=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThan(Integer value) {
            addCriterion("house_status <", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("house_status <=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIn(List<Integer> values) {
            addCriterion("house_status in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotIn(List<Integer> values) {
            addCriterion("house_status not in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusBetween(Integer value1, Integer value2) {
            addCriterion("house_status between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("house_status not between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseFloorIsNull() {
            addCriterion("house_floor is null");
            return (Criteria) this;
        }

        public Criteria andHouseFloorIsNotNull() {
            addCriterion("house_floor is not null");
            return (Criteria) this;
        }

        public Criteria andHouseFloorEqualTo(String value) {
            addCriterion("house_floor =", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotEqualTo(String value) {
            addCriterion("house_floor <>", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorGreaterThan(String value) {
            addCriterion("house_floor >", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorGreaterThanOrEqualTo(String value) {
            addCriterion("house_floor >=", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLessThan(String value) {
            addCriterion("house_floor <", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLessThanOrEqualTo(String value) {
            addCriterion("house_floor <=", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLike(String value) {
            addCriterion("house_floor like", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotLike(String value) {
            addCriterion("house_floor not like", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorIn(List<String> values) {
            addCriterion("house_floor in", values, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotIn(List<String> values) {
            addCriterion("house_floor not in", values, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorBetween(String value1, String value2) {
            addCriterion("house_floor between", value1, value2, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotBetween(String value1, String value2) {
            addCriterion("house_floor not between", value1, value2, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseImageIsNull() {
            addCriterion("house_image is null");
            return (Criteria) this;
        }

        public Criteria andHouseImageIsNotNull() {
            addCriterion("house_image is not null");
            return (Criteria) this;
        }

        public Criteria andHouseImageEqualTo(String value) {
            addCriterion("house_image =", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotEqualTo(String value) {
            addCriterion("house_image <>", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageGreaterThan(String value) {
            addCriterion("house_image >", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageGreaterThanOrEqualTo(String value) {
            addCriterion("house_image >=", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageLessThan(String value) {
            addCriterion("house_image <", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageLessThanOrEqualTo(String value) {
            addCriterion("house_image <=", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageLike(String value) {
            addCriterion("house_image like", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotLike(String value) {
            addCriterion("house_image not like", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageIn(List<String> values) {
            addCriterion("house_image in", values, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotIn(List<String> values) {
            addCriterion("house_image not in", values, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageBetween(String value1, String value2) {
            addCriterion("house_image between", value1, value2, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotBetween(String value1, String value2) {
            addCriterion("house_image not between", value1, value2, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseNumberIsNull() {
            addCriterion("house_number is null");
            return (Criteria) this;
        }

        public Criteria andHouseNumberIsNotNull() {
            addCriterion("house_number is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNumberEqualTo(Integer value) {
            addCriterion("house_number =", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotEqualTo(Integer value) {
            addCriterion("house_number <>", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberGreaterThan(Integer value) {
            addCriterion("house_number >", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_number >=", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberLessThan(Integer value) {
            addCriterion("house_number <", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberLessThanOrEqualTo(Integer value) {
            addCriterion("house_number <=", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberIn(List<Integer> values) {
            addCriterion("house_number in", values, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotIn(List<Integer> values) {
            addCriterion("house_number not in", values, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberBetween(Integer value1, Integer value2) {
            addCriterion("house_number between", value1, value2, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("house_number not between", value1, value2, "houseNumber");
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