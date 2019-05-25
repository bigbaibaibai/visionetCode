package xyz.thishome.phone_cart.service;

import xyz.thishome.phone.pojo.CartItemVo;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone_cart.pojo.CartItemRedisVo;

import java.util.List;

public interface CartItemService {

    //通过token获取用户对象
    TbUser getUserByToken(String token);

    //通过用户ID获取购物车对象
    List<CartItemRedisVo> getCart(Long userId);

    //保存购物车
    void saveCart(Long userId, List<CartItemRedisVo> cartItemVos);

    //通过CartItemRedisVo列表，获取CartItemVo列表
    List<CartItemVo> getCartItemVoByVarItemRedisVo(List<CartItemRedisVo> cartItemRedisVos);

}
