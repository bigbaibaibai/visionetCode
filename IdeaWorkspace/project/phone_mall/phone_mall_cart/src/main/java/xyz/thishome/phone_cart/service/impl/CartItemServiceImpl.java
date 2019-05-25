package xyz.thishome.phone_cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.thishome.common.utils.JsonUtils;
import xyz.thishome.phone.mapper.TbItemMapper;
import xyz.thishome.phone.pojo.CartItemVo;
import xyz.thishome.phone.pojo.TbItem;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone_cart.pojo.CartItemRedisVo;
import xyz.thishome.phone_cart.service.CartItemService;
import xyz.thishome.util.RedisUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${CART_KEY}")
    private String CART_KEY;
    @Value("${SSO_TOKEN}")
    private String SSO_TOKEN;
    @Value("${SSO_EXPIRE_TIME}")
    private Long SSO_EXPIRE_TIME;

    @Override
    public TbUser getUserByToken(String token) {
        String json = redisUtil.get(SSO_TOKEN + ":" + token);
        if (json == null) {
            return null;
        }
        redisUtil.expire(SSO_TOKEN + ":" + token,SSO_EXPIRE_TIME);
        TbUser tbUser = JsonUtils.jsonToPojo(json, TbUser.class);
        return tbUser;
    }

    @Override
    public List<CartItemRedisVo> getCart(Long userId) {
        String json = redisUtil.get(CART_KEY + ":" + userId);
        List<CartItemRedisVo> cartItemRedisVos = JsonUtils.jsonToList(json, CartItemRedisVo.class);
        return cartItemRedisVos;
    }

    @Override
    public void saveCart(Long userId, List<CartItemRedisVo> cartItemVos) {
        if (cartItemVos != null) {
            redisUtil.set(CART_KEY + ":" + userId, JsonUtils.objectToJson(cartItemVos));
        }
    }

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public List<CartItemVo> getCartItemVoByVarItemRedisVo(List<CartItemRedisVo> cartItemRedisVos) {
        List<CartItemVo> cartItemVos = new ArrayList<>();
        for (CartItemRedisVo cartItemRedisVo : cartItemRedisVos) {
            CartItemVo cartItemVo = new CartItemVo();

            TbItem tbItem = tbItemMapper.selectByPrimaryKey(cartItemRedisVo.getItemId());

            cartItemVo.setNum(cartItemRedisVo.getNumber());
            cartItemVo.setImage(tbItem.getImage());
            cartItemVo.setPrice(tbItem.getPrice());
            cartItemVo.setTitle(tbItem.getTitle());
            cartItemVo.setId(tbItem.getId());

            cartItemVos.add(cartItemVo);
        }

        return cartItemVos;
    }
}
