package test;

import org.junit.Test;

public class TestInnerClass {

    static {
        System.out.println("Out 静态代码块 。 。 。");
    }

    public TestInnerClass() {
        System.out.println("Out 构造器 。 。 。");
    }
    static void  hello(){

    }

    static class Inner {

        public Inner() {
            System.out.println("Inner 构造器 。 。 。");
        }

    }

}

class Next extends TestInnerClass{

}

class Testt{
    @Test
    public void test(){

    }
}

