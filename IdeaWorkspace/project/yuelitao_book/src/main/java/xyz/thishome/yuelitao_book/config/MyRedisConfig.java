package xyz.thishome.yuelitao_book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisConfig {

    @Bean  //配置一个自定义的RedisTemplate，设置序列化器
    public RedisTemplate jsonRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        //设置json序列化器Jackson2JsonRedisSerializer
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(String.class));
        return template;
    }

}
