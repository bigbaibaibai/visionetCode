package xyz.thishome.onling_ksxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("xyz.thishome.onling_ksxt.mapper")
public class OnlingKsxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlingKsxtApplication.class, args);
    }

}
