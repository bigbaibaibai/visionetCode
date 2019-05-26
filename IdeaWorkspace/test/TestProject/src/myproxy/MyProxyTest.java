package myproxy;


import org.junit.Test;

public class MyProxyTest {

    @Test
    public void testProxy() {
        Flyable flyable = MyProxy.newProxyInstance(Flyable.class, new MyInvocationHandler(new Bird()));
        flyable.fly(1000);
    }

}
