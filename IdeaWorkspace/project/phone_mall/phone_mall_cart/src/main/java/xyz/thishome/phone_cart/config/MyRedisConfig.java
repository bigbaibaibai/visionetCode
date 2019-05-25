package xyz.thishome.phone_cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import xyz.thishome.util.RedisUtil;

import java.net.UnknownHostException;


@Configuration
public class MyRedisConfig {

    @Bean  //配置一个自定义的RedisTemplate，设置序列化器
    public RedisTemplate<Object, Object> jsonRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        //设置json序列化器Jackson2JsonRedisSerializer
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        return template;
    }

    @Bean  //添加自定义RedisCacheManager
    @Primary  //设置为默认的CacheManager
    public RedisCacheManager cacheManager(RedisTemplate jsonRedisTemplate) {
        //传入我们自己的redisTemplate
        RedisCacheManager cacheManager = new RedisCacheManager(jsonRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

    @Bean
    public RedisUtil redisUtil() {
        return new RedisUtil();
    }

}
