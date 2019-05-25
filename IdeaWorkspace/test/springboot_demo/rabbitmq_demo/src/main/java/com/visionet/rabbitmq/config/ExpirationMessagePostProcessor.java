package com.visionet.rabbitmq.config;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

//用户设置Message过期时间的消息对象
public class ExpirationMessagePostProcessor implements MessagePostProcessor {

    private final Long ttl;  //过期时间

    public ExpirationMessagePostProcessor(Long ttl) {
        this.ttl = ttl;
    }

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        //设置消息的过期时间
        message.getMessageProperties().setExpiration(ttl + "");
        return message;
    }
}
