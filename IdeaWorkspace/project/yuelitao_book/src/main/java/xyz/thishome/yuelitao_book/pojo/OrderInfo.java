package xyz.thishome.yuelitao_book.pojo;

import java.util.Date;

public class OrderInfo {
    private Integer id;

    private String ddId;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", ddId='" + ddId + '\'' +
                ", shpId=" + shpId +
                ", chjshj=" + chjshj +
                ", shpMch='" + shpMch + '\'' +
                ", shpTp='" + shpTp + '\'' +
                ", shpJg=" + shpJg +
                ", shpShl=" + shpShl +
                '}';
    }

    private Integer shpId;

    private Date chjshj;

    private String shpMch;

    private String shpTp;

    private Integer shpJg;

    private Integer shpShl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdId() {
        return ddId;
    }

    public void setDdId(String ddId) {
        this.ddId = ddId == null ? null : ddId.trim();
    }

    public Integer getShpId() {
        return shpId;
    }

    public void setShpId(Integer shpId) {
        this.shpId = shpId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public String getShpMch() {
        return shpMch;
    }

    public void setShpMch(String shpMch) {
        this.shpMch = shpMch == null ? null : shpMch.trim();
    }

    public String getShpTp() {
        return shpTp;
    }

    public void setShpTp(String shpTp) {
        this.shpTp = shpTp == null ? null : shpTp.trim();
    }

    public Integer getShpJg() {
        return shpJg;
    }

    public void setShpJg(Integer shpJg) {
        this.shpJg = shpJg;
    }

    public Integer getShpShl() {
        return shpShl;
    }

    public void setShpShl(Integer shpShl) {
        this.shpShl = shpShl;
    }
}