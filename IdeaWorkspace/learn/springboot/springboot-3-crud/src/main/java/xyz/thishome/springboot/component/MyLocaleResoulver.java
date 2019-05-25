package xyz.thishome.springboot.component;


import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//自定义一个LocaleResolver,实现国际化
public class MyLocaleResoulver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale = request.getLocale();
//        如果请求中有language这个参数证明这是一次语言切换请求
        if (request.getParameter("language") != null) {
            String[] languages = request.getParameter("language").split("_");
            locale = new Locale(languages[0], languages[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
