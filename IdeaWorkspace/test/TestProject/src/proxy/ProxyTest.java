package proxy;

import myproxy.Flyable;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Flyable o = (Flyable) Proxy.newProxyInstance(Flyable.class.getClassLoader(),
                new Class[]{Flyable.class}, (Object proxy, Method method, Object[] param) -> {
                    return proxy;
                }
        );
        o.fly(1000);
    }

}
