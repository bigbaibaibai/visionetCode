package xyz.thishome.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity   //开启web安全功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //重写请求配置方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        // 开启登录页面跳转
        //默认
        // 1、如果未登录，默认发送/login请求
        // 2、重定向到/login?error，表示登录失败
        //http.formLogin();
        //设置我们的登录请求
        http.formLogin().loginProcessingUrl("/userLogin");
    }

    //重写用户配置方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加用户到内存中
        auth.inMemoryAuthentication()
                .withUser("baibaibai1").password("{noop}123456").roles("VIP1", "VIP2")
                .and()
                .withUser("baibaibai2").password("{noop}123456").roles("VIP2", "VIP3")
                .and()
                .withUser("baibaibai3").password("{noop}123456").roles("VIP1", "VIP3");
    }

}
