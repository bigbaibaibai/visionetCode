package xyz.thishome.mainconfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

@Configuration
//把数据源配置文件中的属性加载到环境变量中去
@PropertySource("classpath:db.properties")
//实现字符串解析的接口，可以通过字符串的解析获取环境变量中的值
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${jdbc.username}")
    private String user;

    private String driver;

    //测试环境下使用的数据源
    @Bean
    @Profile("test")
    public DataSource testDateSource(@Value("${jdbc.password}") String psw) { //value注解标注在参数上
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(psw);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    //开发环境下使用的数据源
    @Bean
    @Profile("dev")
    public DataSource devDateSource(@Value("${jdbc.password}") String psw) { //value注解标注在参数上
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(psw);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/book");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        //通过解析字符串，获取环境变量中的值，赋值到对象的属性中
        driver = resolver.resolveStringValue("jdbc.driver");
    }
}
