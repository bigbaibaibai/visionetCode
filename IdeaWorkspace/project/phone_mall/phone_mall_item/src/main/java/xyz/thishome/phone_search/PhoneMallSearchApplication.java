package xyz.thishome.phone_search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class PhoneMallSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneMallSearchApplication.class, args);
    }

}
