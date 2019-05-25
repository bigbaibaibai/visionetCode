package xyz.thishome.rabbit.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import xyz.thishome.rabbit.bean.Book;

@Service
public class BookService {

    //queues指定需要监听的消息队列，数组类型，可以监听多个消息队列
    @RabbitListener(queues = "atguigu")
    public void receive(Book book){
        System.out.println(book);
    }

}
