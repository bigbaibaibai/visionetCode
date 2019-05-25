package xyz.thishome.springboot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.thishomespringbootstarterautoconfiguration.HelloService;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        helloService.sayHello(name);
        return null;
    }

}
