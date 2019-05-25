package xyz.thishome.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer   //开启配置服务功能
public class Microservice_config_main {

    public static void main(String[] args) {
        SpringApplication.run(Microservice_config_main.class, args);
    }

}
