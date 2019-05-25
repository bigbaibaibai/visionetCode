package xyz.thishome.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//实现ImportSelector接口
public class MyImportSelecter implements ImportSelector {

    @Override    //AnnotationMetadata包含了当前类被标注的所有注解信息
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //返回需要导入组件的群类名，如果为null会报错
        return new String[]{"xyz.thishome.bean.Red","xyz.thishome.bean.Color"};
    }
}
