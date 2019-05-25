package xyz.thishome.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;
import xyz.thishome.pojo.News;

import java.util.Date;

public class HibernateTest {

    @Test
    public void test(){

        //1.创建sessionfactory
        SessionFactory sessionFactory = null;
        //创建配置对象
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        //创建一个服务注册
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();
        //通过配置对象，传入服务注册，获取session
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        //2.创建会话
        Session session = sessionFactory.openSession();

        //3、开启事务
        Transaction transaction = session.beginTransaction();

        //4.执行保存操作
        News news = new News("这是一个新闻","鲁迅",new Date());
        session.save(news);

        //5.提交事务
        transaction.commit();

        //6.释放资源
        session.close();
        sessionFactory.close();
    }
}
