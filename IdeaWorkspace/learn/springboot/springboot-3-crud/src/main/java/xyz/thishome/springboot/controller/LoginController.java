package xyz.thishome.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.springboot.exception.UserNotFoundException;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(){
        System.out.println("1");
            throw new UserNotFoundException("用户没找到");

    }
}
