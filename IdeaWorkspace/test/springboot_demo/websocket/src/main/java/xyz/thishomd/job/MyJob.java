package xyz.thishomd.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Set;

@EnableScheduling
@Configuration
public class MyJob {

    @Autowired
    private Set<String> loginIdsList;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendMessage(){
        System.out.println("服务端发出广播信息");
        //这里要加上前缀server
        //所有连接这个URL的websocket都会收到消息，相当于广播
        simpMessagingTemplate.convertAndSend("/server/sendMessageByServer", System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 5000)
    public void sendMessageToUser(){
        for (String s : loginIdsList) {
            //这里的URL并不加user这个前缀
            simpMessagingTemplate.convertAndSendToUser(s, "/sendMessageByServer", "亲爱的用户" + s + "您好");
            System.out.println("服务端向用户  " + s + "  发送了一条信息");
        }
    }

 }
