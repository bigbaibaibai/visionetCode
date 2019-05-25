package xyz.thishome.config;

import org.springframework.context.annotation.*;
import xyz.thishome.bean.*;
import xyz.thishome.custom.MyImportSelecter;
import xyz.thishome.custom.PersonSerivceOnCondition;
import xyz.thishome.custom.WindowsCondition;

@Configuration
@Import({MyImportSelecter.class})
public class ApplicationConfig2 {

    @Lazy
    @Bean
    public Person person1(){
        return new Person("小龙",23);
    }

    @Bean("bill")
    @Conditional({WindowsCondition.class,PersonSerivceOnCondition.class})
    public Person person(){
        return new Person("bill",60);
    }

    //这里虽然返回的是工厂类，但实际添加到容器中的是工厂类中getObject()的对象
    @Bean
    public ColorFcotryBean color(){
        return new ColorFcotryBean();
    }

}
