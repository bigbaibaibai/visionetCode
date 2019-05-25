package xyz.thishome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.thishome.bean.Person;

/**
 * @Configuration 标注这是一个配置类
 */
@Configuration
public class MyAppConfig {

    /**
     *
     * @Bean 标识把这个方法的返回值添加到容器中，id默认为方法名
     */
    @Bean
    public Person person2(){
        Person person2=new Person();
        person2.setName("王五");
        return person2;
    }

}
