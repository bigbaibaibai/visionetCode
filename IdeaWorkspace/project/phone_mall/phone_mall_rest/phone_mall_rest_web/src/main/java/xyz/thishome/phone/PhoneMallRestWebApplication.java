package xyz.thishome.phone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@MapperScan("xyz.thishome.phone.mapper")
@EnableTransactionManagement
public class PhoneMallRestWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneMallRestWebApplication.class, args);
    }

}
