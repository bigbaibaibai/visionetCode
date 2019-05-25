package xyz.thishome.phone_order.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.TbOrder;
import xyz.thishome.phone.pojo.TbOrderShipping;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone_order.pojo.OrderResult;
import xyz.thishome.phone_order.service.OrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public PhoneMsg createOrder(@RequestParam("token") String token,
                                @RequestParam("ids") Long[] ids,
                                @RequestParam("addressId") Long addressId,
                                @RequestParam("receiver") String receiver, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return orderService.createOrder(token, ids, addressId, receiver);
    }


    //查看订单详情
    @GetMapping("/desc")
    public PhoneMsg getDesc(@RequestParam("orderId") Long orderId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        //查询订单详情对象
        Map<String, Object> map = new HashMap<>();
        OrderResult orderInfo = orderService.getOrderInfo(orderId);
        TbOrderShipping orderShipping = orderService.getOrderShipping(orderId);

        map.put("orderInfo", orderInfo);
        map.put("orderShipping", orderShipping);

        return PhoneMsg.success(map);
    }


    //分页获取所有订单
    @PostMapping("/getAll")
    public PhoneMsg getAll(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        //通过token获取用户对象
        TbUser userByToken = orderService.getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid("用户未登录");
        }
        //获取所有订单信息
        PageInfo<TbOrder> orderList = orderService.getOrderList(pageNo, userByToken.getId());

        return PhoneMsg.success(orderList);
    }
}