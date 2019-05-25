package xyz.thishome.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.thishome.bean.Red;

public class RedService implements BeanFactoryAware {

    @Autowired
    private Red red;

    @Autowired
    private BeanFactory beanFactory;

    public void show() {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }
}
