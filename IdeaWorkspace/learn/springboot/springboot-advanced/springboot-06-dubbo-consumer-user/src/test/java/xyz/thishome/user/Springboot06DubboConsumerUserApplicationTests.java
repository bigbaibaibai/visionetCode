package xyz.thishome.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.thishome.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot06DubboConsumerUserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        userService.hello();
    }

}

