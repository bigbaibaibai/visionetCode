package extendstest;

public class ExtendsStatic {

    public static void main(String[] args) {
        B.hello();
    }

}

class A{
    static void hello(){
        System.out.println("hello");
    }
}
class B extends A{

}
