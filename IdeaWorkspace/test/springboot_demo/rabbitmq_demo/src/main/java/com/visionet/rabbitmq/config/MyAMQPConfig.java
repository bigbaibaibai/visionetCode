package com.visionet.rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
//rabbitmq配置类
public class MyAMQPConfig {

    @Bean
    //配置一个消息序列化器
    public MessageConverter messageConverter() {
        //添加json序列化的MessageConverter
        return new Jackson2JsonMessageConverter();
    }

}