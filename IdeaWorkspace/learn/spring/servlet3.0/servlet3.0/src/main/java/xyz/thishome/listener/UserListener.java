package xyz.thishome.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class UserListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("UserListener. . . contextInitialized. . . ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //获取ServletContext对象，可以注册组件
        ServletContext servletContext = sce.getServletContext();
        System.out.println("UserListener. . . contextDestroyed. . . ");
    }
}
