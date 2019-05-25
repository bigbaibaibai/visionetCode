package xyz.thishome.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean , DisposableBean {
    public Cat() {}
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy . . . ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet . . .");
    }
}
