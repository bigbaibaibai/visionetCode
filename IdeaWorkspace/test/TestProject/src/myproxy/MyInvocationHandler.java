package myproxy;

import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Bird bird;

    public MyInvocationHandler(Bird bird) {
        this.bird = bird;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object... args) {
        System.out.println(System.currentTimeMillis());
        try {
            Object invoke = method.invoke(bird, args);
            System.out.println(System.currentTimeMillis());
            return invoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
