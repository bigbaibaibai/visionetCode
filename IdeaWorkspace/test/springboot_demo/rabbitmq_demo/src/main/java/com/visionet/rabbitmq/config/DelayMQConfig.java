package com.visionet.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DelayMQConfig {

    public static final String DELAY_QUEUE_PER_QUEUE_TTL_NAME = "delay.order";
    public static final String DELAY_EXCHANGE_NAME = "delay.exchange";
    public static final String DELAY_PROCESS_QUEUE_NAME = "process.order";
    public static final String DELAY_ORDER_ROUTING_KEY = "delay.order";
    public static final String DELAY_PROCESS_ROUTING_KEY = "process.order";


    @Bean   //添加队列缓存队列，过期后转到其他队列（可以实现订单转发）
    public Queue delayQueuePerQueueTTL() {
        return QueueBuilder.durable(DELAY_QUEUE_PER_QUEUE_TTL_NAME)
                .withArgument("x-dead-letter-exchange", DELAY_EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key", DELAY_PROCESS_ROUTING_KEY)
                .build();
    }

    @Bean  //添加真正的订单执行队列
    public Queue delayProcessQueue() {
        return QueueBuilder.durable(DELAY_PROCESS_QUEUE_NAME).build();
    }

    @Bean  //添加交换机，单播模式
    public DirectExchange delayExchange() {
        return new DirectExchange(DELAY_EXCHANGE_NAME);
    }

    @Bean   //绑定缓存队列
    public Binding dlxBinding() {
        return BindingBuilder.bind(delayQueuePerQueueTTL())
                .to(delayExchange())
                .with(DELAY_ORDER_ROUTING_KEY);

    }

    @Bean  //绑定真正的订单执行队列
    public Binding orderBinding(Queue delayProcessQueue, DirectExchange delayExchange) {
        return BindingBuilder.bind(delayProcessQueue)
                .to(delayExchange)
                .with(DELAY_PROCESS_ROUTING_KEY);
    }

}
