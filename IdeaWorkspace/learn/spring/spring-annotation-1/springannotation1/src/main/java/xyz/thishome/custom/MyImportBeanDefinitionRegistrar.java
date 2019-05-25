package xyz.thishome.custom;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import xyz.thishome.bean.Red;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //如果有person对象则创建Bean
        boolean hasPerson = registry.containsBeanDefinition("person");
        if (hasPerson){
            //定义注册Bean的信息，可以对Bean进行设置
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Red.class);
            //添加Bean到IOC容器，可以指定Bean名（id）
            registry.registerBeanDefinition("red",rootBeanDefinition);
        }
    }
}
