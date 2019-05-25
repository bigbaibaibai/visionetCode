package test;

public class TestInterface {

    public static void main(String[] args) {
        Dog dog = new Dog();
    }

}

interface Hel{
    int a = 0;
    static void hello(){
        System.out.println("hello");
    }
}

class Dog implements Hel{

    void a(){
    }
}

