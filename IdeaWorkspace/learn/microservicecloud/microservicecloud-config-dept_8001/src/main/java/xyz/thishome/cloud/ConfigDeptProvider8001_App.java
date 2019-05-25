package xyz.thishome.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("xyz.thishome.cloud.dao")
@EnableEurekaClient
public class ConfigDeptProvider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(ConfigDeptProvider8001_App.class, args);
    }


}
