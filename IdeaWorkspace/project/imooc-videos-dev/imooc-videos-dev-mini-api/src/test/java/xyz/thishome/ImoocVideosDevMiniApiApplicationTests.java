package xyz.thishome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImoocVideosDevMiniApiApplicationTests {

    @Value("${USER_REDIS_SESSION}")
    private String USER_REDIS_SESSION;

    @Test
    public void contextLoads() {
        System.out.println(USER_REDIS_SESSION);
    }

}

