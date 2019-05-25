package xyz.thishome.yuelitao_book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.yuelitao_book.mapper.OrderInfoMapper;
import xyz.thishome.yuelitao_book.mapper.OrderMapper;
import xyz.thishome.yuelitao_book.pojo.*;
import xyz.thishome.yuelitao_book.service.BookCartService;
import xyz.thishome.yuelitao_book.service.BookService;
import xyz.thishome.yuelitao_book.service.OrderService;
import xyz.thishome.yuelitao_book.service.UserService;
import xyz.thishome.yuelitao_book.util.BookMsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Value("${PAGE_ORDER_NUM}")
    private Integer PAGE_ORDER_NUM;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<OrderVo> getOrderVos(Integer userId, Integer pageNo) {
        //分页，一页三个
        PageHelper.startPage(pageNo, PAGE_ORDER_NUM);

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria1 = orderExample.createCriteria();
        criteria1.andYhIdEqualTo(userId);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orders) {
            System.out.println("数据库中查询的订单信息：" + order);
            OrderVo orderVo = new OrderVo();
            BeanUtils.copyProperties(order, orderVo);
            orderVos.add(orderVo);
        }

        //查询每个订单对应的订单项，和订单信息封装成一个对象
        PageInfo<OrderVo> of1 = PageInfo.of(orderVos);

        for (OrderVo orderVo : of1.getList()) {
            System.out.println("封装后的订单信息：" + orderVo);
            //封装条件
            OrderInfoExample orderInfoExample = new OrderInfoExample();
            OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
            criteria.andDdIdEqualTo(orderVo.getId());
            //查询订单对应的订单项
            List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(orderInfoExample);
            System.out.println("订单项信息：" + orderInfos);
            //封装订单项到订单对象中
            orderVo.setItem(orderInfos);
        }
        return of1;
    }

    @Autowired
    private BookCartService bookCartService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BookMsg createOrder(Integer[] bookIds, Integer userId, Integer addressId, String addressMch) {
        //从redis中获取购物车对象
        BookCartVo bookCart = bookCartService.getBookCart(userId);
        if (bookCart == null || bookCart.getBookProducts() == null || bookCart.getBookProducts().size() <= 0) {
            return BookMsg.bulid("购物车为空");
        }
        List<BookProductVo> bookProducts = bookCart.getBookProducts();
        //判断库存
        List<BookProduct> kcNoFill = new ArrayList<>();
        for (Integer bookId : bookIds) {
            BookProduct bookForId = bookService.getBookForId(bookId);
            //如果库存不足，存起来
            if (bookForId == null) {
                BookProductVo bookOneForId = bookCart.findBookOneForId(bookId);
                BookProduct bookProduct = new BookProduct();
                bookProduct.setBookMch(bookOneForId.getBookMch());
                kcNoFill.add(bookProduct);
            } else if (bookForId.getKc() < bookCart.findBookOneForId(bookId).getNumber()) {
                kcNoFill.add(bookForId);
            }
        }
        if (kcNoFill.size() > 0) {
            return BookMsg.bulid(kcNoFill, "库存不足，或图书已失效！", 501);
        }

        //计算金额
        int money = 0;
        for (BookProductVo bookProductVo : bookProducts) {
            money += bookProductVo.getNumber() * bookProductVo.getJg();
        }

        UserAccount uesrForId = userService.getUesrForId(userId);
        //封装订单信息
        Order order = new Order();
        Long orderID = getOrderID();
        order.setId(orderID + "");
        order.setDzhId(addressId);
        order.setDzhMch(addressMch);
        order.setZje(money);
        order.setYhId(userId);
        order.setShhr(uesrForId.getYhMch());

        orderMapper.insertSelective(order);
        //封装订单项信息
        OrderInfo orderInfo = new OrderInfo();
        for (BookProductVo bookProductVo : bookProducts) {
            orderInfo.setDdId(orderID + "");
            orderInfo.setShpId(bookProductVo.getId());
            orderInfo.setShpMch(bookProductVo.getBookMch());
            orderInfo.setShpJg(bookProductVo.getJg());
            orderInfo.setShpShl(bookProductVo.getNumber());
            orderInfo.setShpTp(bookProductVo.getBookTp());
            //添加到数据库
            orderInfoMapper.insert(orderInfo);
        }

        //清空所支付的购物车
        bookCart.removeBookProductsForIds(bookIds);
        //更新购物车
        bookCartService.setBookCart(userId, bookCart);
        //返回金额
        return BookMsg.success(money);
    }

    @Autowired
    private RedisTemplate<String, String> jsonRedisTemplate;

    @Value("${ORDER_ID_VALUE_REDIS_KEY}")
    private String ORDER_ID_VALUE_REDIS_KEY;

    @Value("${ORDER_BEGIN_ID_VALUE}")
    private Long ORDER_BEGIN_ID_VALUE;

    @Autowired
    RedisTemplate<String, Long> redisTemplate;

    private Long getOrderID() {
        ValueOperations<String, Long> integerValueOperations = redisTemplate.opsForValue();
        //从redis中获取订单号
        Long orderId = integerValueOperations.increment(ORDER_ID_VALUE_REDIS_KEY);
        //如果订单号等于1，设置初始订单号
        if (orderId.compareTo(1L) == 0) {
            integerValueOperations.set(ORDER_ID_VALUE_REDIS_KEY, ORDER_BEGIN_ID_VALUE);
            orderId = integerValueOperations.increment(ORDER_ID_VALUE_REDIS_KEY);
        }
        return orderId;
    }
}
