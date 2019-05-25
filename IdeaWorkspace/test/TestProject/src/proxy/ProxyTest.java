package proxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void testProxy() {
        Flyable flyable = Proxy.newProxyInstance(Flyable.class, new MyInvocationHandler(new Bird()));
        System.out.println(flyable);
    }

}
