package xyz.thishome.myrule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelRule {

    @Bean
    public MyRule randomRule(){
        return new MyRule();
    }

}
