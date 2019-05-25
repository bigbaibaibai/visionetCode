package xyz.thishome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Import(Swagger2.class)
@ComponentScan({"xyz.thishome.*","org.n3r.idworker"})
@MapperScan("xyz.thishome.mapper")
//@PropertySource({"classpath:config/*.properties"})
public class ImoocVideosDevMiniApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocVideosDevMiniApiApplication.class, args);
    }

}

