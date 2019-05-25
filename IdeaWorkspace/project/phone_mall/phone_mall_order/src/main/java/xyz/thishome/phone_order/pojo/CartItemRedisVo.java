package xyz.thishome.phone_order.pojo;

public class CartItemRedisVo {

    private Long itemId;
    private Integer number;

    public Long getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "CartItemRedisVo{" +
                "itemId=" + itemId +
                ", number=" + number +
                '}';
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
