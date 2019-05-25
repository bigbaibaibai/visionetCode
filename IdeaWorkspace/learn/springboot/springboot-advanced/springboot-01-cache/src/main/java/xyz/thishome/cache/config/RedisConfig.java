package xyz.thishome.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import xyz.thishome.cache.bean.Employee;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean  //配置一个自定义的RedisTemplate，设置序列化器
    public RedisTemplate<Object, Object> jsonRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        //设置json序列化器Jackson2JsonRedisSerializer
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Employee.class));
        return template;
    }

    @Bean
    @Primary
    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> jsonRedisTemplate) {
        //传入我们自己的redisTemplate
        RedisCacheManager cacheManager = new RedisCacheManager(jsonRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

}
