package xyz.thishome.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(value = {"xyz.thishome"}, includeFilters = {
        //web容器，子容器，只包含controler
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@Configuration
//相当于mvc:annotation-driven，开启SpringMVC高级功能
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    //配置视图解析器
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/pages/");
        resourceViewResolver.setSuffix(".jsp");
        registry.viewResolver(resourceViewResolver);
    }

    @Override
    //相当于mvc:default-servlet-handler，SpringMVC处理不了的请求交给tomcat处理（静态资源）
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //........

}
