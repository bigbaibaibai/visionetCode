package test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestAgency {
    public static void main(String argv[]){
        NikeFactory nikeFactory=new NikeFactory();
        ClothesFactory dynamicProxy = (ClothesFactory) DynamicProxy.getDynamicProxy(nikeFactory);
        dynamicProxy.production();
    }

}

interface ClothesFactory {
    void production();
}

class NikeFactory implements ClothesFactory {
    public void production() {
        System.out.println("Nike生产一批衣服");
    }
}

class Agency implements InvocationHandler {
    private Object obj = null;

    public Agency() {
        System.out.println("我是动态代理类");
    }

    public Object getAgencyClass(Object obj) {
        this.obj = obj;
        System.out.println("动态生成代理对象");
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行代理方法");
        Object returnValue = method.invoke(obj, args);
        System.out.println("代理方法执行结束");
        return returnValue;
    }
}

class DynamicProxy {
    public static Object getDynamicProxy(Object obj) {
        Agency agency = new Agency();
        return agency.getAgencyClass(obj);
    }
}