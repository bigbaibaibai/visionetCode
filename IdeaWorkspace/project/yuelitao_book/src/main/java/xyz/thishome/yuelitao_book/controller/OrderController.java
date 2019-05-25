package xyz.thishome.yuelitao_book.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.yuelitao_book.pojo.OrderVo;
import xyz.thishome.yuelitao_book.service.OrderService;
import xyz.thishome.yuelitao_book.util.BookMsg;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //通过用户id分页获取3个订单信息
    @GetMapping("/getOrderInfo/{userId}")
    public BookMsg getOrderInfo(@PathVariable Integer userId, @RequestParam("pageNo") Integer pageNo, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //返回列表
        PageInfo<OrderVo> orderVos = orderService.getOrderVos(userId, pageNo);
        return BookMsg.success(orderVos);
    }

    //创建订单
    @PutMapping("/createOrder")
    public BookMsg createOrder(@RequestParam("bookIds") Integer[] bookIds, @RequestParam("userId") Integer userId,
                               @RequestParam("addressId") Integer addressId, @RequestParam("addressMch") String addressMch,
                               HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return orderService.createOrder(bookIds, userId, addressId, addressMch);
    }

}
