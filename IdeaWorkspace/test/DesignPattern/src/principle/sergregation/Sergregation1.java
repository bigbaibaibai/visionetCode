package principle.sergregation;

/**
 * @Description: 不使用接口隔离原则
 */
public class Sergregation1 {
    public static void main(String[] args) {
        A1 a = new A1();
        B1 b = new B1();
        a.method1(b);
        a.method2(b);
        a.method3(b);

        C1 c = new C1();
        D1 d = new D1();
        c.method1(d);
        c.method4(d);
        c.method5(d);
    }
}

interface Interface{
    void method1();
    void method2();
    void method3();
    void method4();
    void method5();
}

/**
 * @Description: 类A通过接口  Sergregation1依赖于类B（因为类B实现了类A需要的方法）
 */
class A1{
    public void method1(Interface sergregation1){
        sergregation1.method1();
    }
    public void method2(Interface sergregation1){
        sergregation1.method2();
    }
    public void method3(Interface sergregation1){
        sergregation1.method3();
    }
}

/**
 * @Description:  类B实现接口，但是只用到方法1,2,3 其他的方法并不需要使用
 */
class B1 implements Interface{
    public void method1() {
        System.out.println("类B实现了方法1");
    }
    public void method2() {
        System.out.println("类B实现了方法2");
    }
    public void method3() {
        System.out.println("类B实现了方法3");
    }
    public void method4() {
        System.out.println("类B实现了方法4");
    }
    public void method5() {
        System.out.println("类B实现了方法5");
    }
}

class C1{
    public void method1(Interface sergregation1){
        sergregation1.method1();
    }
    public void method4(Interface sergregation1){
        sergregation1.method4();
    }
    public void method5(Interface sergregation1){
        sergregation1.method5();
    }
}

/**
 * @Description:  类D实现接口，但是只用到方法1,4,5 其他的方法并不需要使用
 */
class D1 implements Interface{
    public void method1() {
        System.out.println("类D实现了方法1");
    }
    public void method2() {
        System.out.println("类D实现了方法2");
    }
    public void method3() {
        System.out.println("类D实现了方法3");
    }
    public void method4() {
        System.out.println("类D实现了方法4");
    }
    public void method5() {
        System.out.println("类D实现了方法5");
    }
}
