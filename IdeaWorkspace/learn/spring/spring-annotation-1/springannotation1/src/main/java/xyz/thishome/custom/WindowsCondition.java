package xyz.thishome.custom;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//实现condition 接口
public class WindowsCondition implements Condition {
    //在此方法中定义规则
    //context，获取上下文信息，metadata获取注解信息
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取Bean创建的工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        //获取类的注册信息
        BeanDefinitionRegistry registry = context.getRegistry();

        //获取运行时环境信息
        Environment environment = context.getEnvironment();
        //获取当前操作系统环境
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
        //如果为Windows系统则返回true
        if(osName.contains("Windows")){
            return true;
        }

        return false;
    }
}
