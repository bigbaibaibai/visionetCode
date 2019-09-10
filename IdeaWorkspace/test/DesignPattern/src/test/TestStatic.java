package test;

import java.util.HashMap;

public class TestStatic {

    static {
        name = "123";
    }

    public static final String name;

    public static void main(String[] args) {
        System.out.println(name);
    }

}
