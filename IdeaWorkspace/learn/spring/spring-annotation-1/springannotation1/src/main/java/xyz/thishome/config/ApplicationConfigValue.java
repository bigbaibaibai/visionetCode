package xyz.thishome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.thishome.bean.Person;
import xyz.thishome.dao.BookDao;
import xyz.thishome.service.BookService;

@PropertySource(value = "classpath:person.properties")
@Configuration
public class ApplicationConfigValue {
    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public BookDao bookDao(){
        return new BookDao();
    }

    @Bean
    public BookService bookService(BookDao bookDao){
        BookService bookService = new BookService();
        bookService.setBookDao(bookDao);
        return bookService;
    }

}
