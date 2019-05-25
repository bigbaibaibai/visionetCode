package xyz.thishome.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.thishome.mainconfig.MainConfigOfProfile;

import javax.sql.DataSource;

public class IOCTestProfile {

    @Test
    public void testMain() {
        //如果使用代码的方式，在IOC容器初始化之前就要设置，所以不能写有参构造器，因为在有参造构器中就已经把IOC容器初始化了
        //MainConfigOfProfile.class
        //1.创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //2.获取IOC环境对象，并设置环境变量，指定开发环境
        context.getEnvironment().setActiveProfiles("test","dev");
        //3.注册配置类
        context.register(MainConfigOfProfile.class);
        //4.手动启动刷新容器
        context.refresh();
        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
