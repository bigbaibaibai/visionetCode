package xyz.thishome.yuelitao_book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("xyz.thishome.yuelitao_book.mapper")
@EnableTransactionManagement
public class YuelitaoBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuelitaoBookApplication.class, args);
    }

}
