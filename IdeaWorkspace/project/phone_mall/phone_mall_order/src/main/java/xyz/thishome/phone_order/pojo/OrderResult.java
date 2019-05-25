package xyz.thishome.phone_order.pojo;

import xyz.thishome.phone.pojo.TbOrder;
import xyz.thishome.phone.pojo.TbOrderItem;

import java.util.List;

public class OrderResult extends TbOrder {

    private List<TbOrderItem> orderItems;


    public List<TbOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<TbOrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
