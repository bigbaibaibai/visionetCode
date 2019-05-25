package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestBase {

    @Test
    public void test1() {
//        double d = 5/2.0;
//        System.out.println(d);

        int i = 0;

        i = i++;
        //相当于
//       int stemp = i;  创建临时变量
//        i = i + 1;   （i++）
//        i = stemp;  赋值操作
        int a = 11;
        int b = a ^ 22;
        System.out.println(b);
        float f = 3.14F;

        System.out.println(i);

    }

    @Test
    public void test2() {
        int i = 0;

        for (int j = 0; j < 100; j++) {
            i = i++;
            //int temp = i;
            //i = i + 1;
            //i = temp;
        }
        System.out.println(i);

        //       0  +  2  +  1  +  1     =4
        int a = i++ + ++i + --i + i--;

        //第一个i++
        //int temp = i;  //0
        //i = i + 1; //1
        //第二个++i
        //i = i + 1;  //2
        //第三个--i
        //i = i -1;  //1
        //第四个i--
        //int temp = i;  //1
        //i = i - 1;   //0

        System.out.println(i);
        System.out.println(a);

        int b = i++ + --i;
        System.out.println(b);

        int c = i++ + 1;

//        int temp = i;
//        i = i + 1;
//        c = temp + 1;

//        int d = ++i + 1;
//        i = i + 1;
//        d = i + 1;
    }

    private static int synNum = 1;
    private static Long l = 1L;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (l) {

                    ++synNum;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(synNum);
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }

    @Test
    public void test5() {
        String str1 = "a";
        System.out.println(str1 == str1.intern());
    }

    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            list.remove(s);  //报异常
        }
    }

    @Test
    public void test7() {

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.print(100 + random.nextInt(100) + " ");
        }

    }

    @Test
    public void test8() {

        String str1 = "abc";
        String str2 = new String(new char[]{'a', 'b', 'c'});
        System.out.println(str1 == str2.intern());

        char[] chars1 = {'a', 'b', 'c'};
        char[] chars2 = {'a', 'b', 'c'};
        System.out.println(chars1);
    }

    @Test
    public void test9() {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        i1 = 128;
        i2 = 128;
        System.out.println(i2.intValue() == i1.intValue());
    }

    @Test
    public void test10() {

    }

}

class Parent {

    protected Object hello(Object o) throws RuntimeException {
        return null;
    }

}

class Son extends Parent {

    @Override
    public String hello(Object o) throws NullPointerException {
        super.hello("");
        return "abc";
    }

}
