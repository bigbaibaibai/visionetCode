package xyz.thishome.phone_order.service;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.CartItemVo;
import xyz.thishome.phone.pojo.TbOrder;
import xyz.thishome.phone.pojo.TbOrderShipping;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone_order.pojo.CartItemRedisVo;
import xyz.thishome.phone_order.pojo.OrderResult;

import java.util.List;

public interface OrderService {

    //创建订单
    PhoneMsg createOrder(String token, Long[] ids, Long addressId, String receiver);

    //通过token获取对象
    TbUser getUserByToken(String token);

    //查询订单详情对象
    OrderResult getOrderInfo(Long orderId);

    //获取所有订单信息
    PageInfo<TbOrder> getOrderList(Integer pageNo, Long userId);

    //获取订单联系
    TbOrderShipping getOrderShipping(Long orderId);

}
