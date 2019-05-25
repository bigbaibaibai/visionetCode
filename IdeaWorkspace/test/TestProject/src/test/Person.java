package test;
public class Person {
    private String hello() {
        return "hello";
    }
}

interface Hello {
    default String hello() {
        return "你好";
    }
}

class Student extends Person implements Hello {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.hello());
    }
}
