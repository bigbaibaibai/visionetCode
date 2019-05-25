package xyz.thishome.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//定义一个后置处理器
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override    //bean  刚创建出来的实例    beanName  实例在容器中的名字（id）
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization--->"+beanName+"--->"+ bean +" . . . ");
        //返回后来需要用的对象，如，返回传入的实例，或者包装后返回
        return bean;
    }

    @Override    //bean  初始化后的实例    beanName  实例在容器中的名字（id）
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization--->"+beanName+"--->"+ bean +" . . . ");
        return bean;
    }

}
