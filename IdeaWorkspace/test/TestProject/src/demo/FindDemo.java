package demo;

import org.junit.Test;

/**
 * @Time: 2019/6/19 10:45
 * @Author: bxx
 * @Description:
 */
public class FindDemo {

    @Test
    public void test() {
        int[][] arry = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println("------------------------------------");
        long l = System.currentTimeMillis();
        System.out.println(find(1, arry));
        long l1 = System.currentTimeMillis();
        System.out.println("----------------" + (l1 - l) + "ms-----------------");

        StringBuilder sb = new StringBuilder();
        sb.toString().replace("","%");
    }

    public boolean find(int target, int[][] array) {
        for (int [] arr : array){
            int l = 0,r = arr.length - 1;
            while(r - l >= 0){
                int mid = (r + l) / 2;
                if(arr[mid] > target){
                    r = mid - 1;
                }else if (arr[mid] < target){
                    l = mid + 1;
                }else {
                    return true;
                }
            }
        }
        return false;
//        int length = array.length - 1;
//        boolean flag = true;
//        int l = 0;
//        int r = length;
//        int lineIndex = 0;
//        int rowIndex = 0;
//        while (r - l >= 0) {
//            if (flag) {
//                lineIndex = (l + r) / 2;
//            } else {
//                rowIndex = (l + r) / 2;
//            }
//            int value = array[rowIndex][lineIndex];
//            if (value < target) {
//                if ((flag ? lineIndex == length : rowIndex == length) || (flag ? array[rowIndex][lineIndex + 1] : array[rowIndex + 1][lineIndex]) > target) {
//                    flag = !flag;
//                    r = length;
//                }
//                l = flag ? lineIndex + 1 : rowIndex + 1;
//            } else if (value > target) {
//                r = flag ? lineIndex - 1 : rowIndex - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
    }

    /**
     * int length = array.length - 1;
     *         boolean flag = true;
     *         int l = 0;
     *         int r = length;
     *         int lineIndex = 0;
     *         int rowIndex = 0;
     *         while (r - l >= 0) {
     *             if (flag) {
     *                 lineIndex = (l + r) / 2;
     *             } else {
     *                 rowIndex = (l + r) / 2;
     *             }
     *             int value = array[rowIndex][lineIndex];
     *             if (value < target) {
     *                 int nextValue;
     *                 if (flag) {
     *                     nextValue = lineIndex >= length ? value : array[rowIndex][lineIndex + 1];
     *                 } else {
     *                     nextValue = rowIndex >= length ? value : array[rowIndex - 1][lineIndex];
     *                 }
     *                 if (nextValue > target) {
     *                     flag = !flag;
     *                     r = length;
     *                 }
     *                 l = flag ? lineIndex + 1 : rowIndex + 1;
     *             } else if (value > target) {
     *                 r = flag ? lineIndex - 1 : rowIndex - 1;
     *             } else {
     *                 return true;
     *             }
     *         }
     *         return false;
     */



}
