package xyz.thishome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.thishome.bean.Car;
import xyz.thishome.bean.Dog;
import xyz.thishome.bean.MyBeanPostProcessor;

@Configuration
public class ApplicationConfig3 {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

    @Bean
    public MyBeanPostProcessor beanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }

}
