package xyz.thishome.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String sayHello(String name){
        return "hello "+name;
    }

}
