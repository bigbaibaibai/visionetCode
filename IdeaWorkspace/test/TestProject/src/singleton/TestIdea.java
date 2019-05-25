package singleton;


public class TestIdea {
    public static void main(String[] args) {
        Singleton singleton2 = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);

    }

}
