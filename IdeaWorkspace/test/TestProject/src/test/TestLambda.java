package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestLambda {

    public static void main(String[] args) {
        String str1 = new String("123");
        String str2 = new String("123");
        System.out.println(str1.hashCode() == str2.hashCode());
        long i1 = 1111L;
        long i2 = 1111L;
        System.out.println("" == "");

        synchronized ((i1 + "").intern()) {
            for (; ; ) {
                continue;
            }
        }
    }

    @Test
    public void testTow() {
        int[] array = {12, 32, 54, 61, 31, 84, 35, 46, 33, 8, 53, 44, 5, 4, 34, 64, 99, 98, 100};
        //int[] array = {1};

        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + "-" + array[i] + " ");
        }
        System.out.println();
        int value = 4;

//        System.out.println(find(array, 31));
        System.out.println(find3(array, value));
        System.out.println("-----------------");
        System.out.println(search(array, value));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (r == -1)
            return -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public int find2(int[] array, int value) {
        if (array.length != 0) {
            int mid = array.length / 2, d = mid / 2;
            for (int i = 0; i < Math.sqrt(array.length); i++, d = d / 2) {
                if (array[mid] == value)
                    return i;
                mid = array[mid] > value ? mid - d : mid + d;
                mid = mid < 0 ? 0 : mid;
                mid = mid > array.length - 1 ? array.length - 1 : mid;
            }
        }
        return -1;
    }

    public int find3(int[] array, int value) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] < value) {
                l = mid + 1;
            } else if (array[mid] > value) {
                r = mid - 1;
            } else return mid;
        }
        return -1;
    }
//
//    public int find(int[] array, int value) {
//        if (array.length == 0) {
//            return 0;
//        }
//        if (array.length == 1) {
//            return array[0] == value ? value : 0;
//        }
//        return findForTow(array, value, array.length / 2, 1);
//    }
//
//    public int findForTow(int[] array, int value, int mid, int count) {
//        if (mid <= 0 || mid >= array.length - 1) {
//            return 0;
//        }
//        int arrayValue = array[mid];
//        if (arrayValue == value) {
//            return value;
//        } else {
//            int forTow = 0;
//            if (count == array.length / 2 + 1) {
//                return 0;
//            }
//            if (arrayValue > value) {
//                return findForTow(array, value, mid - Math.round(mid / 2), count);
//            } else {
//                return findForTow(array, value, mid + Math.round(mid / 2), count);
//            }
//        }
//    }
//
//
//}

}