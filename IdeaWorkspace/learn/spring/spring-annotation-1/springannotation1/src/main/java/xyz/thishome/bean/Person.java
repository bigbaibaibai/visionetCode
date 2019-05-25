package xyz.thishome.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, Integer age) {

        this.name = name;
        this.age = age;
    }
}
