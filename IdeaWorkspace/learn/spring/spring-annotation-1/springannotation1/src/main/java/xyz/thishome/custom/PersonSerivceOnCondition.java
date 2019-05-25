package xyz.thishome.custom;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PersonSerivceOnCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            context.getClassLoader().loadClass("xyz.thishome.service.BookService");
        } catch (ClassNotFoundException e) {
            return false;
        }
        context.getRegistry().containsBeanDefinition("person");

        return true;
    }
}
