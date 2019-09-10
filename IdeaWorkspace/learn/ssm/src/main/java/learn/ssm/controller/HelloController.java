package learn.ssm.controller;

import learn.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello(){

        try {
            System.out.println(userMapper.selectByExample(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

}
