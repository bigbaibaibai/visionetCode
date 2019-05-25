package xyz.thishome.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.IdWorker;

@Configuration
public class BeanConfig {

    @Bean //Id生成器
    public IdWorker idWorker() {
        return new IdWorker();
    }


}
