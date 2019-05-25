package xyz.thishome.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//实现ApplicationContextAware接口
public class Pig implements ApplicationContextAware {
    //定义一个ApplicationContext变量，便于把IOC容器保存起来
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //把IOC容器赋值给属性
        this.context=applicationContext;
    }

}
