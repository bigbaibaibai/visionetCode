package xyz.thishomd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class IndexController {

    @GetMapping("/")
    public String toIndex(){
        return "index";
    }

    @Autowired
    private Set<String> loginIdsList;

    @GetMapping("/login/{id}")
    public String login(@PathVariable String id){
        loginIdsList.add(id);
        return "success";
    }

    //接收前台发送的websocket消息，使用以下注解，和RequestMapping用法一直，入参需与客户端传过来的数据对应
    //@MessageMapping

}
