package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArray {

    @Test
    public void test() {
        int[] array = {1, 3, 2, 0, 4};
        int count = 0;
        int len = array.length;
        if (array[0] > array[1]) {
            count++;
        }
        if (array[len - 1] > array[len - 2]) {
            count++;
        }
        for (int i = 1; i < len - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                count++;
                i++;
            }
        }
        System.out.println(count);
    }

    private int size = 100000000;

    @Test
    public void testList() {
        ArrayList<Object> list = new ArrayList<>(size);
        testConll(list);  //1358
        /**
         * 遍历添加元素耗时：657s
         * maxMemory:2944m
         * freeMemory:2501m
         * 只遍历耗时：23s
         */
    }

    @Test
    public void testLink() {
        LinkedList<Object> list = new LinkedList<>();
        testConll(list);  //1889
        /**
         * 遍历添加元素耗时：45485s
         * maxMemory:2944m
         * freeMemory:645m
         * 只遍历耗时：602s
         */
    }

    private void testConll(List list) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add("");
        }
        long end = System.currentTimeMillis();
        System.out.println("遍历添加元素耗时：" + (end - begin));
        System.out.println("maxMemory:" + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("freeMemory:" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        begin = System.currentTimeMillis();
        for (Object o : list) {
        }
        end = System.currentTimeMillis();
        System.out.println("只遍历耗时：" + (end - begin));
    }

}
