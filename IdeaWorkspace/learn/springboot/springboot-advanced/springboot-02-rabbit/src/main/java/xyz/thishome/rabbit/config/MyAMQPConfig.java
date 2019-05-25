package xyz.thishome.rabbit.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class MyAMQPConfig {

    @Bean
    public MessageConverter messageConverter() {
        //添加json序列化的MessageConverter
        return new Jackson2JsonMessageConverter();
    }

}
