package xyz.thishome.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.dao.UserDao;

@Service
public class UserService implements BeanFactoryAware {

    @Autowired
    private ApplicationEventMulticaster eventMulticaster;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ApplicationContext applicationContext;

    @Transactional
    public void insert() {
//        userDao.insert();
//        System.out.println("插入成功");
        System.out.println("Autowired");
        System.out.println(beanFactory.getBean("dataSource"));

        eventMulticaster.multicastEvent(new ApplicationEvent(new String("自定义事件")) {
        });
    }

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("监听到事件：" + event);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Aware");
        System.out.println(beanFactory.getBean("dataSource"));
    }
}
