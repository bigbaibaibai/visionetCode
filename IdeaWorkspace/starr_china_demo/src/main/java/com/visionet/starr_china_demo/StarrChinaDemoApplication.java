package com.visionet.starr_china_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.visionet.starr_china_demo.demo")
public class StarrChinaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarrChinaDemoApplication.class, args);
    }

}
