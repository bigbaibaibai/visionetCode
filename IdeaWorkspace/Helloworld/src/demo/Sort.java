package demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static int[] getArray(int num) {
        int[] array = new int[num];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    @Test    //插入排序
    public void testInsertSort() {
        int array[] = getArray(100000);
        System.out.println(Arrays.toString(array));

        long s = System.currentTimeMillis();



        long e = System.currentTimeMillis();

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (e - s));   //异步 1w 51  10w  2411
    }

    @Test
    public void testQuickSort(){
        int[] array = getArray(100000);  // 1w 82 10w 3747
        System.out.println(Arrays.toString(array));
        long s = System.currentTimeMillis();
        quickSort(array);
        long e = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));

        System.out.println("耗时：" + (e - s));   //
    }

    //插入排序
    public void insertSort(int array[]){
        //遍历这个数组
        for (int i = 1; i < array.length; i++) {
            //先把遍历到的值存到临时变量中
            int temp = array[i];
            //往前遍历
            for (int j = i; j >= 0; j--) {
                //如果下标大于0，并且前一个值比这个值大，把后面的那个值往前顶
                if (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                } else {
                    //如果下标志等于0，表示这个数比第一个还小，那就放到第一个的位置
                    //如果前一个数比这个数小，则可以把这个数放在这个位置
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    //快速排序
    public  void quickSort(int[] array) {
        onceQuickSort(array, 0, array.length - 1);
    }
    //快排执行代码
    public  void onceQuickSort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        boolean flag = true;
        int index = left;
        int value = array[index];
        while (flag) {
            //从后往前
            for (int i = right; i > index; i--) {
                if (array[i] < value) {
                    array[index] = array[i];
                    index = i;
                    array[index] = value;
                    break;
                }
                if (i == index + 1)
                    flag = false;
            }
            //从前往后
            for (int i = left; flag && i < index; i++) {
                if (array[i] > value) {
                    array[index] = array[i];
                    index = i;
                    array[index] = value;
                    break;
                }
                if (i == index - 1)
                    flag = false;
            }
        }

        //分隔，继续快排
        //左边
        int finalIndex = index;
        onceQuickSort(array, left, finalIndex - 1);
        //右边
        onceQuickSort(array, finalIndex + 1, right);
    }




}
