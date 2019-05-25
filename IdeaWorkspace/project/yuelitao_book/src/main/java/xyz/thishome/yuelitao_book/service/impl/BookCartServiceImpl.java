package xyz.thishome.yuelitao_book.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import xyz.thishome.yuelitao_book.pojo.BookCartVo;
import xyz.thishome.yuelitao_book.service.BookCartService;
import xyz.thishome.yuelitao_book.util.JsonUtils;

import java.util.concurrent.TimeUnit;

@Service
public class BookCartServiceImpl implements BookCartService {

    @Autowired
    private RedisTemplate<String, String> jsonRedisTemplate;

    @Value("${BOOK_SHOP_CART_REDIS_KEY}")
    private String BOOK_SHOP_CART_REDIS_KEY;

    @Override   //修改购物车，只存储商品ID，不存储商品具体信息，防止商品信息被修改，购物车中信息不变
    public BookCartVo getBookCart(Integer userId) {
        ValueOperations<String, String> valueOperations = jsonRedisTemplate.opsForValue();
        //尝试从redis中获取
        String json = valueOperations.get(BOOK_SHOP_CART_REDIS_KEY + ":" + userId);
        BookCartVo bookCartVo = null;
        //如果redis中的json字符串为空，则创建购物车对象
        if (StringUtils.isBlank(json)) {
            bookCartVo = new BookCartVo();
            bookCartVo.setUserId(userId);
        } else {
            //把json字符串转化为购物车对象
            bookCartVo = JsonUtils.jsonToPojo(json, BookCartVo.class);
        }
        return bookCartVo;
    }

    @Override
    public void setBookCart(Integer userId, BookCartVo bookCartVo) {
        ValueOperations<String, String> valueOperations = jsonRedisTemplate.opsForValue();
        valueOperations.set(BOOK_SHOP_CART_REDIS_KEY + ":" + userId,
                JsonUtils.objectToJson(bookCartVo));
    }

    @Override
    public void clearBookCart(Integer userId) {
        jsonRedisTemplate.expire(BOOK_SHOP_CART_REDIS_KEY + ":" + userId, 0, TimeUnit.MINUTES);
    }

}
