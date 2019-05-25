package xyz.thishome.custom;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取正在扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取类名
        String className = classMetadata.getClassName();
        //获取注解信息，获取所有注解
        metadataReader.getAnnotationMetadata().getAnnotationTypes();
        //如果类名包含er则返回true包含，否则返回false不包含
        if (className.matches("er")) {
            return true;
        }
        return false;
    }
}
