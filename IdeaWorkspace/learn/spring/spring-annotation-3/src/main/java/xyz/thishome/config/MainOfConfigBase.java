package xyz.thishome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import xyz.thishome.bean.Red;

@Configuration
@ComponentScan(basePackages = {"xyz.thishome"})
public class MainOfConfigBase {

    @Bean
    public Red red() {
        return new Red();
    }

}
