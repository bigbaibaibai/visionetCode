package xyz.thishome;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.thishome.config.MainOfConfigTx;
import xyz.thishome.service.UserService;

public class TxText {

    @Test
    public void testInsert() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainOfConfigTx.class);
        context.publishEvent("自定义事件1");
        UserService userService = context.getBean(UserService.class);
        userService.insert();
        context.close();
    }

}
