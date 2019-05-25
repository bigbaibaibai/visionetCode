package xyz.thishome.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * @ConfigurationProperties 告诉SpringBoot将本类中所有属性和配置文件中相关的配置进行绑定；
 * prefix = "person" 配置文件中那个下面的所有属性进行一一映射
 */


@ConfigurationProperties(prefix = "person")
//@PropertySource(value = {"classpath:person.properties"})
@Component
public class Person {
    private String name;
    private Integer age;
    private Boolean boss;

    private Map<String, String> maps;
    private List<String> lists;

    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public List<String> getLists() {
        return lists;
    }

    public Dog getDog() {
        return dog;
    }
}
