package xyz.thishome.phone_cart.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("xyz.thishome.phone.mapper")
public class MyBatisConfig {

}
