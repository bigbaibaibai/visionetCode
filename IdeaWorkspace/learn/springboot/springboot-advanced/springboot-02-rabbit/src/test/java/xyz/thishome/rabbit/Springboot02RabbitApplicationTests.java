package xyz.thishome.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.thishome.rabbit.bean.Book;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02RabbitApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //两种发消息方法
    @Test
    public void contextLoads() {
        //1.需要传入exchange（String），routingKey（string），message（Message需要自己new一个对象）
        //rabbitTemplate.send(exchange,routingKey,message);

        //2.前两个对象和上面的一样，object序列化后会被默认放到Message的消息体中
        //如果不需要定制消息的消息头，属性等内容，可以直接使用这个方法
        //rabbitTemplate.convertAndSend(exchange,routingKey,object);
        Map<String, String> map = new HashMap<>();
        map.put("msg", "rabbitTemplate");
        map.put("exchange", "exchange.direct");
        map.put("routingKey", "atguigu.news");
        //传入的对象呗默认序列化后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
    }

    //接收消息
    @Test
    public void testReceive() {
        //两种方式
        //1.接收消息，返回消息对象（Message）
        //Message receive = rabbitTemplate.receive("");

        //2.接收消息，把消息体转化为Object对象返回
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o);
        //接收消息后，消息队列中的这条消息就会被移除
    }

    //测试监听器，发送消息
    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu", new Book("三国演义", "吴承恩"));
    }

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void testAmqpAdmin(){
        //创建一个exchange，exchange类型参考Exchange的继承树，构造方法参数参考源码
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //创建一个queues
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        //创建绑定关系
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin","amqpAdmin",null));
        //删除
        //amqpAdmin.deleteXXX(name);
    }

}

