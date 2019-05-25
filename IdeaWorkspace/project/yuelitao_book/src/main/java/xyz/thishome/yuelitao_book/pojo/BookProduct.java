package xyz.thishome.yuelitao_book.pojo;

import java.util.Date;

public class BookProduct {
    private Integer id;

    @Override
    public String toString() {
        return "BookProduct{" +
                "id=" + id +
                ", bookMch='" + bookMch + '\'' +
                ", bookTp='" + bookTp + '\'' +
                ", author='" + author + '\'' +
                ", flbh=" + flbh +
                ", chjshj=" + chjshj +
                ", bookInfoShort='" + bookInfoShort + '\'' +
                ", bookInfoLong='" + bookInfoLong + '\'' +
                ", kc=" + kc +
                ", jg=" + jg +
                ", xl=" + xl +
                ", status=" + status +
                '}';
    }

    private String bookMch;

    private String bookTp;

    private String author;

    private Integer flbh;

    private Date chjshj;

    private String bookInfoShort;

    private String bookInfoLong;

    private Integer kc;

    private Integer jg;

    private Integer xl;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookMch() {
        return bookMch;
    }

    public void setBookMch(String bookMch) {
        this.bookMch = bookMch == null ? null : bookMch.trim();
    }

    public String getBookTp() {
        return bookTp;
    }

    public void setBookTp(String bookTp) {
        this.bookTp = bookTp == null ? null : bookTp.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getFlbh() {
        return flbh;
    }

    public void setFlbh(Integer flbh) {
        this.flbh = flbh;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public String getBookInfoShort() {
        return bookInfoShort;
    }

    public void setBookInfoShort(String bookInfoShort) {
        this.bookInfoShort = bookInfoShort == null ? null : bookInfoShort.trim();
    }

    public String getBookInfoLong() {
        return bookInfoLong;
    }

    public void setBookInfoLong(String bookInfoLong) {
        this.bookInfoLong = bookInfoLong == null ? null : bookInfoLong.trim();
    }

    public Integer getKc() {
        return kc;
    }

    public void setKc(Integer kc) {
        this.kc = kc;
    }

    public Integer getJg() {
        return jg;
    }

    public void setJg(Integer jg) {
        this.jg = jg;
    }

    public Integer getXl() {
        return xl;
    }

    public void setXl(Integer xl) {
        this.xl = xl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}