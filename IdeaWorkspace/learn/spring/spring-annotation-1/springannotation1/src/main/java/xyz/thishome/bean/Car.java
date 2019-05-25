package xyz.thishome.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car {

    public Car() {
        System.out.println("Car Constructor . . . ");
    }

    public void init() {
        System.out.println("Car init . . .");
    }

    public void destroy() {
        System.out.println("Car destroy . . .");
    }

}
