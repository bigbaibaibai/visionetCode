package xyz.thishome.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println("将要加入IOC容器"+beanDefinitionCount+"个组件，分别是：");
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
