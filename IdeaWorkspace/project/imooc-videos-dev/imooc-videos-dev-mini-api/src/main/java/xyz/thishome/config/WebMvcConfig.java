package xyz.thishome.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import xyz.thishome.common.utils.IMoocJSONResult;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Value("${FILES_BASICS_PATH}")
    private String FILES_BASICS_PATH;

    @Override   //添加静态资源映射
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射根路径
        registry.addResourceHandler("/**")
                //swagger2和druid的静态资源在此目录下
                .addResourceLocations("classpath:/META-INF/resources/")
                //映射盘符下的资源文件
                .addResourceLocations("file:" + FILES_BASICS_PATH + "/");
    }

}
