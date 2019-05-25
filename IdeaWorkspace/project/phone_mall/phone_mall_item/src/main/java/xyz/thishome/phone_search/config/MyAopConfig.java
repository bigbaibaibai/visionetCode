package xyz.thishome.phone_search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.thishome.phone_search.aop.ControllerExceptionAop;

@EnableAspectJAutoProxy
@Configuration
public class MyAopConfig {

    @Bean
    public ControllerExceptionAop logAspects() {
        return new ControllerExceptionAop();
    }

}
