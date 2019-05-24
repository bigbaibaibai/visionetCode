package com.visionet.rabbitmq.controller;

import com.visionet.rabbitmq.config.DelayMQConfig;
import com.visionet.rabbitmq.config.ExpirationMessagePostProcessor;
import com.visionet.rabbitmq.pojo.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/hello")
    public String testRabbit() {
        System.out.println("----------------------------开始发送消息--------------------------");
        Person person = new Person("小明", 18);
        rabbitTemplate.convertAndSend("create.order", person);
        rabbitTemplate.convertAndSend("order", "create.order", person);
        System.out.println(person);
        System.out.println("----------------------------消息发送成功--------------------------");
        return "success";
    }

    //    @RabbitListener(queues = "create.order")
    //SpringBoot会自动把消息体中的内容反序列化为一个对象，传入方法参数
    //也可以写一个Message类型
    private void receive(Person person) {
        System.out.println("----------------------------接收消息成功--------------------------");
        System.out.println(person);
        System.out.println("----------------------------消息处理成功--------------------------");
    }

    @GetMapping("/createOrder")
    public String createOrder() {
        Person person = new Person("大明", 19);
        System.out.println(System.currentTimeMillis());
        rabbitTemplate.convertAndSend(DelayMQConfig.DELAY_EXCHANGE_NAME,
                DelayMQConfig.DELAY_ORDER_ROUTING_KEY, person, new ExpirationMessagePostProcessor(5000L));
        return "success";
    }

    @RabbitListener(queues = DelayMQConfig.DELAY_PROCESS_QUEUE_NAME)
    private void saveOrder(Person person) {
        System.out.println(person);
        System.out.println(System.currentTimeMillis());
    }


}
