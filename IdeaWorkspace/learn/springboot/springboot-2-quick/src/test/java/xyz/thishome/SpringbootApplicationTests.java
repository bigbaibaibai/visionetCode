package xyz.thishome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.thishome.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private Person person;

//    @Autowired
//    private ApplicationContext ioc;

//    @Test
//    public void testPerson(){
//        System.out.println(ioc.getBean("person1"));
//
//    }


    @Test
    public void contextLoads() {
        System.out.println(person);
    }
}
