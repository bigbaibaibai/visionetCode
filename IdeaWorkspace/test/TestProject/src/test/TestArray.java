package test;

import org.junit.Test;

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


}
