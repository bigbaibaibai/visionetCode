package xyz.thishome;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import xyz.thishome.config.RootConfig;
import xyz.thishome.config.WebConfig;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    //全局根容器（spring容器，父容器）
    protected Class<?>[] getRootConfigClasses() {
        //这里返回配置类的数组
        return new Class[]{RootConfig.class};
    }

    @Override
    //web容器(springMVC容器，子容器)
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    //dispatcherServlet的映射路径配置
    protected String[] getServletMappings() {
        //所有但不包括.jsp请求
        return new String[]{"/"};
    }
}
