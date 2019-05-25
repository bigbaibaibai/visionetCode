package xyz.thishome.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//Durid数据源配置类
@Configuration
public class DuridConfig {

    //把我们自定义的数据源注册进去，并且设置配置文件前缀，可以自动把配置文件中的配置封装到对象中
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }

    //添加一个servlet组件
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //初始化参数
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("loginUsername", "root");
        stringStringMap.put("loginPassword", "123456");
        stringStringMap.put("allow","");
        stringStringMap.put("deny", "192.168.43.160");

        bean.setInitParameters(stringStringMap);
        return bean;
    }

    //添加一个filter组件
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置需要添加的Filter
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> map = new HashMap<>();
        //设置初始化参数，不需要过滤的文件
        map.put("exclusions", "*.html,*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(map);
        //设置FIlter拦截的路径
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }

}
