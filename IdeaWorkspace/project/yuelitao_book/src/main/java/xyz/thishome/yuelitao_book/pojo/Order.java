package xyz.thishome.yuelitao_book.pojo;

import java.util.Date;

public class Order {
    private String id;

    private String shhr;

    private Integer zje;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", shhr='" + shhr + '\'' +
                ", zje=" + zje +
                ", jdh=" + jdh +
                ", yhId=" + yhId +
                ", chjshj=" + chjshj +
                ", yjsdshj=" + yjsdshj +
                ", dzhId=" + dzhId +
                ", dzhMch='" + dzhMch + '\'' +
                '}';
    }

    private Integer jdh;

    private Integer yhId;

    private Date chjshj;

    private Date yjsdshj;

    private Integer dzhId;

    private String dzhMch;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShhr() {
        return shhr;
    }

    public void setShhr(String shhr) {
        this.shhr = shhr == null ? null : shhr.trim();
    }

    public Integer getZje() {
        return zje;
    }

    public void setZje(Integer zje) {
        this.zje = zje;
    }

    public Integer getJdh() {
        return jdh;
    }

    public void setJdh(Integer jdh) {
        this.jdh = jdh;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public Date getYjsdshj() {
        return yjsdshj;
    }

    public void setYjsdshj(Date yjsdshj) {
        this.yjsdshj = yjsdshj;
    }

    public Integer getDzhId() {
        return dzhId;
    }

    public void setDzhId(Integer dzhId) {
        this.dzhId = dzhId;
    }

    public String getDzhMch() {
        return dzhMch;
    }

    public void setDzhMch(String dzhMch) {
        this.dzhMch = dzhMch == null ? null : dzhMch.trim();
    }
}