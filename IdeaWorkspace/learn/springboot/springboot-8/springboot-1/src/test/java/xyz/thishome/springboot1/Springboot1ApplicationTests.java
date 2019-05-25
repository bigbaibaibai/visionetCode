package xyz.thishome.springboot1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot1ApplicationTests {


    @Test
    public void contextLoads() {
        System.out.println("--------------------------");

        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("这是trace. . . ");
        logger.info("这是info. . . ");
        logger.warn("这是warn. . . ");
        logger.error("这是error. . . ");

    }

}

