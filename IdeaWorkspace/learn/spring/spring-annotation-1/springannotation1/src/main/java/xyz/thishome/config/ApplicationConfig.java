package xyz.thishome.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import xyz.thishome.custom.MyTypeFilter;
import xyz.thishome.bean.Person;

//表示这个类是一个配置类
@ComponentScan(value = "xyz.thishome" , excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type=FilterType.CUSTOM,classes = MyTypeFilter.class)
})
@Configuration
public class ApplicationConfig {
    //这里表示为容器中添加一个Bean，对应配置文件的bean标签
    // Bean的id默认为方法名，可以通过value属性指定Id
    @Bean
    public Person person(){
        return new Person("小蓝",17);
    }
}
