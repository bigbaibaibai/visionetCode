package xyz.thishome.bean;

import xyz.thishome.listener.UserListener;
import xyz.thishome.service.UserService;
import xyz.thishome.servlet.UserServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes(UserService.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    //Set<Class<?>> c  参数需要和类上的@HandlesTypes(UserService.class)注解配合使用
    //可以获取@HandlesTypes()中参数的所有后代（如果是接口，也会获取实现类或者子接口）
    //ServletContext ctx  参数代表一个servlet容器（Tomcat），可以用来注册三大组件
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyServletContainerInitializer. . . onStartup. . . ");
        //遍历@HandlesTypes(UserService.class)，中参数类型的所有后代
        for (Class<?> aClass : c) {
            System.out.println(aClass);
        }
        //添加servlet，用名字，servlet对象做参数方式
        ServletRegistration.Dynamic userServlet = ctx.addServlet("userServlet", new UserServlet());
        //添加映射关系
        userServlet.addMapping("/user");

        //添加filter，用名字，过滤器类型全限定名做参数的方式
        FilterRegistration.Dynamic userFilter = ctx.addFilter("userFilter", "xyz.thishome.filter.UserFilter");
        //添加过滤级别，是否匹配之后，拦截路径
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/user");

        //添加listener，无需添加映射关系
        ctx.addListener(UserListener.class);
    }
}
