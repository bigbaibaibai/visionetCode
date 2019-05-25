package xyz.thishome.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Red implements InitializingBean, DisposableBean {

    public Red(){
        System.out.println("Red 构造器。 。 。 ");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Red 销毁。 。 。 ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Red 初始化。 。 。 ");
    }
}
