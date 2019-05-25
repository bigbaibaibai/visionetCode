package xyz.thishome.phone_order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.common.utils.JsonUtils;
import xyz.thishome.phone.mapper.*;
import xyz.thishome.phone.pojo.*;
import xyz.thishome.phone_order.pojo.CartItemRedisVo;
import xyz.thishome.phone_order.pojo.OrderResult;
import xyz.thishome.phone_order.service.OrderService;
import xyz.thishome.util.RedisUtil;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${CART_KEY}")
    private String CART_KEY;
    @Value("${SSO_TOKEN}")
    private String SSO_TOKEN;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TbOrderMapper orderMapper;

    @Autowired
    private TbOrderItemMapper orderItemMapper;

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbOrderShippingMapper orderShippingMapper;

    @Autowired
    private TbUserAddressMapper userAddressMapper;

    @Autowired
    private TbUserMapper userMapper;

    @Value("${ORDER_ID_KEY}")
    private String ORDER_ID_KEY;


    @Transactional(propagation = Propagation.REQUIRED)
    public PhoneMsg createOrder(String token, Long[] ids, Long addressId, String receiver) {
        //通过token获取对象
        TbUser userByToken = getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid(null, "用户未登录", 400);
        }

        Long userId = userByToken.getId();

        //获取购物车对象
        String json = redisUtil.get(CART_KEY + ":" + userId);
        if (StringUtils.isBlank(json)) {
            return PhoneMsg.bulid("购物车为空");
        }
        List<CartItemRedisVo> cartItemRedisVos = JsonUtils.jsonToList(json, CartItemRedisVo.class);
        if (cartItemRedisVos == null || cartItemRedisVos.size() == 0) {
            return PhoneMsg.bulid("购物车为空");
        }
        //筛选出购物车中需要结算的商品集合，并移除购物车中相应的对象
        Set<CartItemRedisVo> willOrderItemRedisVo = new HashSet<>();
        for (CartItemRedisVo cartItemRedisVo : cartItemRedisVos) {
            for (Long id : ids) {
                if (cartItemRedisVo.getItemId().compareTo(id) == 0) {
                    willOrderItemRedisVo.add(cartItemRedisVo);
                    break;
                }
            }
        }
        if (willOrderItemRedisVo.size() == 0) {
            return PhoneMsg.bulid("没有选中商品");
        }
        //把购物车中响应商品删除
        cartItemRedisVos.removeAll(willOrderItemRedisVo);
        //创建订单集合
        Set<TbOrderItem> orderItems = new HashSet<>();

        //创建一个集合，如果有库存不足商品，添加到此集合中
        Set<TbItem> kcNoFill = new HashSet<>();

        //创建一个集合，用于存储需要修改的商品对象
        Set<TbItem> updateItems = new HashSet<>();

        //创建金额变量
        Long money = 0L;

        //存储第一个商品的图片作为订单图片
        String imageUrl = null;
        //创建判断库存的flag
        boolean flag = true;
        for (CartItemRedisVo cartItemRedisVo : willOrderItemRedisVo) {
            TbItem tbItem = itemMapper.selectByPrimaryKey(cartItemRedisVo.getItemId());
            //判断库存是否充足
            if (tbItem.getNum().compareTo(cartItemRedisVo.getNumber()) < 0) {
                kcNoFill.add(tbItem);
                flag = false;
                continue;
            }
            if (!flag) {
                break;
            }
            //更新商品库存，销量，热度
            tbItem.setNum(tbItem.getNum() - cartItemRedisVo.getNumber());
            tbItem.setBarcode(Integer.parseInt(tbItem.getBarcode() == null ? "0" : tbItem.getBarcode()) + tbItem.getNum() + "");
            tbItem.setPurpose(tbItem.getPurpose() + 10);
            updateItems.add(tbItem);
            //保存订单中第一个商品的图片url
            if (imageUrl == null) {
                imageUrl = tbItem.getImage();
            }

            //计算本个商品的价格（单价*数量）
            Long itemTitleMoney = cartItemRedisVo.getNumber() * tbItem.getPrice();
            //累加总价
            money += itemTitleMoney;

            //封装订单项对象
            TbOrderItem tbOrderItem = new TbOrderItem();
            tbOrderItem.setNum(cartItemRedisVo.getNumber());
            tbOrderItem.setId(getOrderItemId() + "");
            tbOrderItem.setItemId(tbItem.getId() + "");
            tbOrderItem.setTitle(tbItem.getTitle());
            tbOrderItem.setPrice(tbItem.getPrice());
            tbOrderItem.setTotalFee(itemTitleMoney);
            tbOrderItem.setPicPath(tbItem.getImage());
            orderItems.add(tbOrderItem);
        }

        if (kcNoFill.size() > 0) {
            return PhoneMsg.bulid(kcNoFill, "库存不足，商品为data信息", 401);
        }

        //计算金额
        String orderId = getOrderID() + "";

        //封装订单对象
        TbOrder tbOrder = new TbOrder();
        tbOrder.setUserId(userId);
        tbOrder.setOrderId(orderId);
        tbOrder.setShippingName(imageUrl);
        tbOrder.setPayment(money + "");
        tbOrder.setBuyerNick(receiver);

        Date date = new Date();
        tbOrder.setCreateTime(date);
        tbOrder.setUpdateTime(date);
        tbOrder.setCloseTime(date);
        tbOrder.setConsignTime(date);
        tbOrder.setPaymentTime(date);
        tbOrder.setEndTime(date);
        tbOrder.setStatus(2);
        tbOrder.setPaymentType(2);

        //封装订单联系信息
        TbUserAddress userAddress = userAddressMapper.selectByPrimaryKey(addressId);

        TbUser tbUser = userMapper.selectByPrimaryKey(userId);

        TbOrderShipping tbOrderShipping = new TbOrderShipping();
        tbOrderShipping.setOrderId(orderId);
        tbOrderShipping.setReceiverAddress(userAddress.getAddress());
        tbOrderShipping.setReceiverCity(userAddress.getCity());
        tbOrderShipping.setReceiverState(userAddress.getProvince());
        tbOrderShipping.setReceiverDistrict(userAddress.getDistrict());
        tbOrderShipping.setReceiverName(receiver);
        tbOrderShipping.setReceiverMobile(tbUser.getPhone());

        //插入订单信息
        orderMapper.insertSelective(tbOrder);

        //插入订单联系信息
        orderShippingMapper.insertSelective(tbOrderShipping);

        //插入订单项信息
        for (TbOrderItem orderItem : orderItems) {
            orderItem.setOrderId(orderId);
            orderItemMapper.insertSelective(orderItem);
        }

        //更新商品信息
        for (TbItem updateItem : updateItems) {
            itemMapper.updateByPrimaryKeySelective(updateItem);
        }

        //保存到购物车
        redisUtil.set(CART_KEY + ":" + userId, JsonUtils.objectToJson(cartItemRedisVos));

        return PhoneMsg.success();
    }


    private Long getOrderID() {
        //从redis中获取订单号
        Long orderId = redisUtil.incr(ORDER_ID_KEY, 1);
        //如果订单号等于1，设置初始订单号
        if (orderId.compareTo(1L) == 0) {
            redisUtil.set(ORDER_ID_KEY, 11544 + "");
            orderId = redisUtil.incr(ORDER_ID_KEY, 1);
        }
        return orderId;
    }

    @Value("${ORDER_ITEM_ID_KEY}")
    private String ORDER_ITEM_ID_KEY;

    private Long getOrderItemId() {
        //从redis中获取订单号
        Long orderId = redisUtil.incr(ORDER_ITEM_ID_KEY, 1);
        //如果订单号等于1，设置初始订单号
        if (orderId.compareTo(1L) == 0) {
            redisUtil.set(ORDER_ITEM_ID_KEY, 11544 + "");
            orderId = redisUtil.incr(ORDER_ITEM_ID_KEY, 1);
        }
        return orderId;
    }


    @Value("${SSO_EXPIRE_TIME}")
    private Long SSO_EXPIRE_TIME;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbUser getUserByToken(String token) {
        String json = redisUtil.get(SSO_TOKEN + ":" + token);
        if (json == null) {
            return null;
        }
        redisUtil.expire(SSO_TOKEN + ":" + token, SSO_EXPIRE_TIME);
        TbUser tbUser = JsonUtils.jsonToPojo(json, TbUser.class);
        return tbUser;
    }

    private void saveCart(Long userId, List<CartItemRedisVo> cartItemVos) {
        if (cartItemVos != null) {
            redisUtil.set(CART_KEY + ":" + userId, JsonUtils.objectToJson(cartItemVos));
        }
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public OrderResult getOrderInfo(Long orderId) {
        TbOrder tbOrder = orderMapper.selectByPrimaryKey(orderId + "");
        OrderResult orderResult = new OrderResult();

        BeanUtils.copyProperties(tbOrder, orderResult);

        TbOrderItemExample example = new TbOrderItemExample();
        TbOrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId + "");
        List<TbOrderItem> tbOrderItems = orderItemMapper.selectByExample(example);
        orderResult.setOrderItems(tbOrderItems);
        return orderResult;
    }

    @Value("${PAGE_ORDER_SIZE}")
    private Integer PAGE_ORDER_SIZE;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<TbOrder> getOrderList(Integer pageNo, Long userId) {

        PageHelper.startPage(pageNo, PAGE_ORDER_SIZE);
        TbOrderExample example = new TbOrderExample();
        TbOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TbOrder> tbOrders = orderMapper.selectByExample(example);
        PageInfo<TbOrder> of = PageInfo.of(tbOrders);
        return of;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbOrderShipping getOrderShipping(Long orderId) {
        TbOrderShipping tbOrderShipping = orderShippingMapper.selectByPrimaryKey(orderId + "");
        return tbOrderShipping;
    }
}
