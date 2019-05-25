package xyz.thishome.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xyz.thishome.pojo.News;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class HibernateTest2 {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();
    }

    @After
    public void distroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSessionFlash(){
        News news = (News) session.get(News.class, 1);
        news.setTitle("这是一个好标题");
        session.flush();
    }

    @Test
    public void testSessionChace(){
        //查询id为1的News Bean对应数据库表的数据
        Object o = session.get(News.class, 1);
        System.out.println(o);
        //第二次查询
        Object o1 = session.get(News.class, 1);
        System.out.println(o1);
        //true，这里使用到了缓存机制
        System.out.println(o == o1);
    }

    @Test
    public void test4(){
        //获取一个持久化对象
        News news = (News) session.get(News.class, 1);
        //会话关闭后该对象以变为游离对象
        transaction.commit();
        session.close();

        //再次获取该持久化对象，这时session中已经有id为1的记录的缓存
        News news1 = (News) session.get(News.class,1);

        //更新上次会话留下的id为1的游离对象
        session.update(news);  //抛出异常
    }

    @Test
    public void test(){
        String str = "aaa|bbb||ccc|";
        String[] split = str.split("\\|{1,2}");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
