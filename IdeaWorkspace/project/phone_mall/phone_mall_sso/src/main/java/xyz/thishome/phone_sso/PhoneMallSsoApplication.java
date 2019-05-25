package xyz.thishome.phone_sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class PhoneMallSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneMallSsoApplication.class, args);
    }

}
