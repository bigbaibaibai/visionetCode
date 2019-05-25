package xyz.thishome;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.thishome.config.ApplicationConfig;
import xyz.thishome.config.ApplicationConfig2;
import xyz.thishome.config.ApplicationConfig3;
import xyz.thishome.config.ApplicationConfigValue;

public class TestApplication {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean("person1"));
    }

    @Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }


    @Test
    public void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
        //这里获取的是class xyz.thishome.bean.Color类型的对象
        System.out.println(context.getBean("color").getClass());
        //如果想直接获取这个工厂类，需要在ID前加上一个&符号，class xyz.thishome.bean.ColorFcotryBean
        System.out.println(context.getBean("&color").getClass());
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig3.class);
        System.out.println("容器创建完成 . . . ");
        System.out.println(context.getBean("car"));
        //关闭容器
        context.close();
    }

    @Test
    public void test5(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigValue.class);
        System.out.println(context.getBean("bookService"));
//        //获取运行时环境信息
//        ConfigurableEnvironment environment = context.getEnvironment();
//        //获取运行时环境中的某个属性值
//        String name = environment.getProperty("person.name");
//        System.out.println(name);
    }

}
