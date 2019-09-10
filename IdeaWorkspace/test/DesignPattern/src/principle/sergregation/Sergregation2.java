package principle.sergregation;

/**
 * @Time: 2019/8/6 12:32
 * @Author: bxx
 * @Description:  遵循接口隔离原则
 */
public class Sergregation2 {
    public static void main(String[] args) {
        A2 a = new A2();
        B2 b = new B2();
        a.method1(b);
        a.method2(b);
        a.method3(b);

        C2 c = new C2();
        D2 d = new D2();
        c.method1(d);
        c.method4(d);
        c.method5(d);
    }
}
/**
 * @Description:  这里把一个接口细化为三个接口
 */

interface Interface1{
    void method1();
}
interface Interface2{
    void method2();
    void method3();
}
interface Interface3{
    void method4();
    void method5();
}

class A2{
    public void method1(Interface1 sergregation1){
        sergregation1.method1();
    }
    public void method2(Interface2 sergregation1){
        sergregation1.method2();
    }
    public void method3(Interface2 sergregation1){
        sergregation1.method3();
    }
}

class B2 implements Interface1,Interface2{
    public void method1() {
        System.out.println("类B实现了方法1");
    }
    public void method2() {
        System.out.println("类B实现了方法2");
    }
    public void method3() {
        System.out.println("类B实现了方法3");
    }
}


class C2{
    public void method1(Interface1 sergregation1){
        sergregation1.method1();
    }
    public void method4(Interface3 sergregation1){
        sergregation1.method4();
    }
    public void method5(Interface3 sergregation1){
        sergregation1.method5();
    }
}

class D2 implements Interface1,Interface3{
    public void method1() {
        System.out.println("类D实现了方法1");
    }
    public void method4() {
        System.out.println("类D实现了方法4");
    }
    public void method5() {
        System.out.println("类D实现了方法5");
    }
}