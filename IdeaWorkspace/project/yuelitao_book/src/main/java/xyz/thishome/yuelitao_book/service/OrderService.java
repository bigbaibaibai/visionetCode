package xyz.thishome.yuelitao_book.service;

import com.github.pagehelper.PageInfo;
import xyz.thishome.yuelitao_book.pojo.OrderVo;
import xyz.thishome.yuelitao_book.util.BookMsg;

public interface OrderService {

    //获取所有订单信息
    PageInfo<OrderVo> getOrderVos(Integer userId, Integer pageNo);

    //创建订单，成功返回金额，失败返回库存不足图书列表
    BookMsg createOrder(Integer[] bookIds, Integer userId, Integer addressId, String addressMch);

}
