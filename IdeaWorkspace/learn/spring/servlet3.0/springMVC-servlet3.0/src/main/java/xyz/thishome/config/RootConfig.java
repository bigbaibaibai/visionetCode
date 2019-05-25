package xyz.thishome.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@ComponentScan(value = {"xyz.thishome"},excludeFilters = {
        //根容器，父容器，不包含controller
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
@Configuration
public class RootConfig {
}
