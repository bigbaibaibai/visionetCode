package xyz.thishome.bean;

import org.springframework.beans.factory.FactoryBean;

//定义工厂类，实现FactoryBean接口
public class ColorFcotryBean implements FactoryBean {

    @Override    //创建Bean的方法
    public Object getObject() throws Exception {
        return new Color();
    }

    @Override    //返回类的类型
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override    //是否为单实例
    public boolean isSingleton() {
        return true;
    }
}
