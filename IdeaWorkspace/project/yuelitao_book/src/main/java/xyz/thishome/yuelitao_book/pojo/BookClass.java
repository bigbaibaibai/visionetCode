package xyz.thishome.yuelitao_book.pojo;

public class BookClass {
    private Integer id;

    private String flMch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlMch() {
        return flMch;
    }

    public void setFlMch(String flMch) {
        this.flMch = flMch == null ? null : flMch.trim();
    }
}