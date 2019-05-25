package xyz.thishome.yuelitao_book.pojo;

import java.util.List;

public class OrderVo extends Order {

    List<OrderInfo> item;

    public List<OrderInfo> getItem() {
        return item;
    }

    public void setItem(List<OrderInfo> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        super.toString();
        return "OrderVo{" +
                "item=" + item +
                '}';
    }
}
