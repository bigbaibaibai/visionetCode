package xyz.thishome.phone_cart.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.CartItemVo;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone_cart.pojo.CartItemRedisVo;
import xyz.thishome.phone_cart.service.CartItemService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    //添加一个商品到购物车
    @PostMapping("/add")
    public PhoneMsg addItemToCart(@RequestParam("itemId") Long itemId, @RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //通过token获取用户对象
        TbUser userByToken = cartItemService.getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid(null, "用户未登录", 400);
        }

        //通过用户对象获取购物车redis中的列表
        Long userId = userByToken.getId();
        List<CartItemRedisVo> cart = cartItemService.getCart(userId);
        //如果购物车对象为空，则创建购物车，添加商品
        if (cart == null) {
            cart = new ArrayList<>();
        }

        CartItemRedisVo itemFromCart = getItemFromCart(cart, itemId);
        if (itemFromCart != null) {
            //如果购物车中存在该商品，数量加1
            itemFromCart.setNumber(itemFromCart.getNumber() + 1);
        } else {
            //如果购物车中没有此商品，添加商品ID
            CartItemRedisVo cartItemRedisVo = new CartItemRedisVo();
            cartItemRedisVo.setItemId(itemId);
            cartItemRedisVo.setNumber(1);
            cart.add(cartItemRedisVo);
        }

        //保存购物车
        cartItemService.saveCart(userId, cart);

        return PhoneMsg.success();
    }

    //从购物车中查询一个对象
    private CartItemRedisVo getItemFromCart(List<CartItemRedisVo> cartItemRedisVos, Long itemId) {

        if (cartItemRedisVos != null && cartItemRedisVos.size() > 0) {
            for (CartItemRedisVo cartItemRedisVo : cartItemRedisVos) {
                if (cartItemRedisVo.getItemId().compareTo(itemId) == 0) {
                    return cartItemRedisVo;
                }
            }
        }
        return null;
    }

    //修改购物车数量
    @PutMapping("/update")
    public PhoneMsg updateCartNum(@RequestParam("token") String token, @RequestParam("itemId") Long itemId, @RequestParam("num") Integer num,  HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        //通过token获取用户对象
        TbUser userByToken = cartItemService.getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid(null, "用户未登录", 400);
        }

        //通过用户对象获取购物车redis中的列表
        Long userId = userByToken.getId();
        List<CartItemRedisVo> cart = cartItemService.getCart(userId);

        //修改数量
        CartItemRedisVo itemFromCart = getItemFromCart(cart, itemId);

        if (num == 0) {
            cart.remove(itemFromCart);
        } else {
            itemFromCart.setNumber(num);
        }

        //保存购物车
        cartItemService.saveCart(userId, cart);

        return PhoneMsg.success();
    }

    //从购物车中删除一个商品
    @DeleteMapping("/del")
    public PhoneMsg delCartItem(@RequestParam("token") String token, @RequestParam("itemId") Long itemId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //通过token获取用户对象
        TbUser userByToken = cartItemService.getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid(null, "用户未登录", 400);
        }

        //通过用户对象获取购物车redis中的列表
        Long userId = userByToken.getId();
        List<CartItemRedisVo> cart = cartItemService.getCart(userId);


        //删除商品
        CartItemRedisVo itemFromCart = getItemFromCart(cart, itemId);
        cart.remove(itemFromCart);

        //保存购物车
        cartItemService.saveCart(userId, cart);

        return PhoneMsg.success();
    }


    //获取购物车
    @PostMapping("/getCart")
    public PhoneMsg getCart(@RequestParam("token") String token,  HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //通过token获取用户对象
        TbUser userByToken = cartItemService.getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid(null, "用户未登录", 400);
        }

        //通过用户对象获取购物车redis中的列表
        Long userId = userByToken.getId();
        List<CartItemRedisVo> cart = cartItemService.getCart(userId);

        //通过id查询所有商品列表
        List<CartItemVo> cartItemVoList = cartItemService.getCartItemVoByVarItemRedisVo(cart);

        return PhoneMsg.success(cartItemVoList);
    }


}
