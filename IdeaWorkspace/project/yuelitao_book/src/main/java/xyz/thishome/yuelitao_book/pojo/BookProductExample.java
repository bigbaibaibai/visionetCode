package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookProductExample() {
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

        public Criteria andBookMchIsNull() {
            addCriterion("book_mch is null");
            return (Criteria) this;
        }

        public Criteria andBookMchIsNotNull() {
            addCriterion("book_mch is not null");
            return (Criteria) this;
        }

        public Criteria andBookMchEqualTo(String value) {
            addCriterion("book_mch =", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchNotEqualTo(String value) {
            addCriterion("book_mch <>", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchGreaterThan(String value) {
            addCriterion("book_mch >", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchGreaterThanOrEqualTo(String value) {
            addCriterion("book_mch >=", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchLessThan(String value) {
            addCriterion("book_mch <", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchLessThanOrEqualTo(String value) {
            addCriterion("book_mch <=", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchLike(String value) {
            addCriterion("book_mch like", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchNotLike(String value) {
            addCriterion("book_mch not like", value, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchIn(List<String> values) {
            addCriterion("book_mch in", values, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchNotIn(List<String> values) {
            addCriterion("book_mch not in", values, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchBetween(String value1, String value2) {
            addCriterion("book_mch between", value1, value2, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookMchNotBetween(String value1, String value2) {
            addCriterion("book_mch not between", value1, value2, "bookMch");
            return (Criteria) this;
        }

        public Criteria andBookTpIsNull() {
            addCriterion("book_tp is null");
            return (Criteria) this;
        }

        public Criteria andBookTpIsNotNull() {
            addCriterion("book_tp is not null");
            return (Criteria) this;
        }

        public Criteria andBookTpEqualTo(String value) {
            addCriterion("book_tp =", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpNotEqualTo(String value) {
            addCriterion("book_tp <>", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpGreaterThan(String value) {
            addCriterion("book_tp >", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpGreaterThanOrEqualTo(String value) {
            addCriterion("book_tp >=", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpLessThan(String value) {
            addCriterion("book_tp <", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpLessThanOrEqualTo(String value) {
            addCriterion("book_tp <=", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpLike(String value) {
            addCriterion("book_tp like", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpNotLike(String value) {
            addCriterion("book_tp not like", value, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpIn(List<String> values) {
            addCriterion("book_tp in", values, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpNotIn(List<String> values) {
            addCriterion("book_tp not in", values, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpBetween(String value1, String value2) {
            addCriterion("book_tp between", value1, value2, "bookTp");
            return (Criteria) this;
        }

        public Criteria andBookTpNotBetween(String value1, String value2) {
            addCriterion("book_tp not between", value1, value2, "bookTp");
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

        public Criteria andFlbhIsNull() {
            addCriterion("flbh is null");
            return (Criteria) this;
        }

        public Criteria andFlbhIsNotNull() {
            addCriterion("flbh is not null");
            return (Criteria) this;
        }

        public Criteria andFlbhEqualTo(Integer value) {
            addCriterion("flbh =", value, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhNotEqualTo(Integer value) {
            addCriterion("flbh <>", value, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhGreaterThan(Integer value) {
            addCriterion("flbh >", value, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhGreaterThanOrEqualTo(Integer value) {
            addCriterion("flbh >=", value, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhLessThan(Integer value) {
            addCriterion("flbh <", value, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhLessThanOrEqualTo(Integer value) {
            addCriterion("flbh <=", value, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhIn(List<Integer> values) {
            addCriterion("flbh in", values, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhNotIn(List<Integer> values) {
            addCriterion("flbh not in", values, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhBetween(Integer value1, Integer value2) {
            addCriterion("flbh between", value1, value2, "flbh");
            return (Criteria) this;
        }

        public Criteria andFlbhNotBetween(Integer value1, Integer value2) {
            addCriterion("flbh not between", value1, value2, "flbh");
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

        public Criteria andBookInfoShortIsNull() {
            addCriterion("book_info_short is null");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortIsNotNull() {
            addCriterion("book_info_short is not null");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortEqualTo(String value) {
            addCriterion("book_info_short =", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortNotEqualTo(String value) {
            addCriterion("book_info_short <>", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortGreaterThan(String value) {
            addCriterion("book_info_short >", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortGreaterThanOrEqualTo(String value) {
            addCriterion("book_info_short >=", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortLessThan(String value) {
            addCriterion("book_info_short <", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortLessThanOrEqualTo(String value) {
            addCriterion("book_info_short <=", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortLike(String value) {
            addCriterion("book_info_short like", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortNotLike(String value) {
            addCriterion("book_info_short not like", value, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortIn(List<String> values) {
            addCriterion("book_info_short in", values, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortNotIn(List<String> values) {
            addCriterion("book_info_short not in", values, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortBetween(String value1, String value2) {
            addCriterion("book_info_short between", value1, value2, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoShortNotBetween(String value1, String value2) {
            addCriterion("book_info_short not between", value1, value2, "bookInfoShort");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongIsNull() {
            addCriterion("book_info_long is null");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongIsNotNull() {
            addCriterion("book_info_long is not null");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongEqualTo(String value) {
            addCriterion("book_info_long =", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongNotEqualTo(String value) {
            addCriterion("book_info_long <>", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongGreaterThan(String value) {
            addCriterion("book_info_long >", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongGreaterThanOrEqualTo(String value) {
            addCriterion("book_info_long >=", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongLessThan(String value) {
            addCriterion("book_info_long <", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongLessThanOrEqualTo(String value) {
            addCriterion("book_info_long <=", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongLike(String value) {
            addCriterion("book_info_long like", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongNotLike(String value) {
            addCriterion("book_info_long not like", value, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongIn(List<String> values) {
            addCriterion("book_info_long in", values, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongNotIn(List<String> values) {
            addCriterion("book_info_long not in", values, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongBetween(String value1, String value2) {
            addCriterion("book_info_long between", value1, value2, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andBookInfoLongNotBetween(String value1, String value2) {
            addCriterion("book_info_long not between", value1, value2, "bookInfoLong");
            return (Criteria) this;
        }

        public Criteria andKcIsNull() {
            addCriterion("kc is null");
            return (Criteria) this;
        }

        public Criteria andKcIsNotNull() {
            addCriterion("kc is not null");
            return (Criteria) this;
        }

        public Criteria andKcEqualTo(Integer value) {
            addCriterion("kc =", value, "kc");
            return (Criteria) this;
        }

        public Criteria andKcNotEqualTo(Integer value) {
            addCriterion("kc <>", value, "kc");
            return (Criteria) this;
        }

        public Criteria andKcGreaterThan(Integer value) {
            addCriterion("kc >", value, "kc");
            return (Criteria) this;
        }

        public Criteria andKcGreaterThanOrEqualTo(Integer value) {
            addCriterion("kc >=", value, "kc");
            return (Criteria) this;
        }

        public Criteria andKcLessThan(Integer value) {
            addCriterion("kc <", value, "kc");
            return (Criteria) this;
        }

        public Criteria andKcLessThanOrEqualTo(Integer value) {
            addCriterion("kc <=", value, "kc");
            return (Criteria) this;
        }

        public Criteria andKcIn(List<Integer> values) {
            addCriterion("kc in", values, "kc");
            return (Criteria) this;
        }

        public Criteria andKcNotIn(List<Integer> values) {
            addCriterion("kc not in", values, "kc");
            return (Criteria) this;
        }

        public Criteria andKcBetween(Integer value1, Integer value2) {
            addCriterion("kc between", value1, value2, "kc");
            return (Criteria) this;
        }

        public Criteria andKcNotBetween(Integer value1, Integer value2) {
            addCriterion("kc not between", value1, value2, "kc");
            return (Criteria) this;
        }

        public Criteria andJgIsNull() {
            addCriterion("jg is null");
            return (Criteria) this;
        }

        public Criteria andJgIsNotNull() {
            addCriterion("jg is not null");
            return (Criteria) this;
        }

        public Criteria andJgEqualTo(Integer value) {
            addCriterion("jg =", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotEqualTo(Integer value) {
            addCriterion("jg <>", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThan(Integer value) {
            addCriterion("jg >", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThanOrEqualTo(Integer value) {
            addCriterion("jg >=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThan(Integer value) {
            addCriterion("jg <", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThanOrEqualTo(Integer value) {
            addCriterion("jg <=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgIn(List<Integer> values) {
            addCriterion("jg in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotIn(List<Integer> values) {
            addCriterion("jg not in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgBetween(Integer value1, Integer value2) {
            addCriterion("jg between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotBetween(Integer value1, Integer value2) {
            addCriterion("jg not between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andXlIsNull() {
            addCriterion("xl is null");
            return (Criteria) this;
        }

        public Criteria andXlIsNotNull() {
            addCriterion("xl is not null");
            return (Criteria) this;
        }

        public Criteria andXlEqualTo(Integer value) {
            addCriterion("xl =", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotEqualTo(Integer value) {
            addCriterion("xl <>", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlGreaterThan(Integer value) {
            addCriterion("xl >", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlGreaterThanOrEqualTo(Integer value) {
            addCriterion("xl >=", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlLessThan(Integer value) {
            addCriterion("xl <", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlLessThanOrEqualTo(Integer value) {
            addCriterion("xl <=", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlIn(List<Integer> values) {
            addCriterion("xl in", values, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotIn(List<Integer> values) {
            addCriterion("xl not in", values, "xl");
            return (Criteria) this;
        }

        public Criteria andXlBetween(Integer value1, Integer value2) {
            addCriterion("xl between", value1, value2, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotBetween(Integer value1, Integer value2) {
            addCriterion("xl not between", value1, value2, "xl");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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