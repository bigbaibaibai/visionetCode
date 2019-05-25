package xyz.thishome.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements EmbeddedValueResolverAware {

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        //可以解析字符串中的值，可以使用el表达式获取环境变量中的值，或者使用Spring表达式进行计算
        String value = resolver.resolveStringValue("你好${os.name},我是#{20*18}");
        //打印你好Windows 10,我是360
        System.out.println(value);
    }

    public Dog() {
        System.out.println("Dog Constructor . . .");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog Init . . .");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog Destroy . . .");
    }

}
