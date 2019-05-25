package xyz.thishome.yuelitao_book.pojo;

public class BookProductVo extends BookProduct {

    private Integer number;

    @Override
    public String toString() {
        return "BookProductVo{" +
                "number=" + number +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
