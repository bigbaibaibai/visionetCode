package xyz.thishome.controller;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] a1 = {2, 5, 6, 9, 43, 53, 62, 75};
        int[] a2 = {2, 5, 6, 9, 43, 53, 62, 75, 432, 546, 754, 845};
        System.out.println(Arrays.toString(merge(a1, a2)));
    }

    //m和n没看明白是什么意思
    //假设小到大的排序
    public static int[] merge(int[] nums1, int[] nums2) {
        //第一步判空处理，增强健壮性
        if (nums1 == null && nums2 == null) {
            return null;
        }
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }

        //第二步合并数组
        int[] mergeArr = new int[nums1.length + nums2.length];
        for (int i = 0, index1 = 0, index2 = 0; i < mergeArr.length; i++) {

            if (nums1.length == index1 ||
                    (index2 != nums2.length && nums1[index1] > nums2[index2])) {
                mergeArr[i] = nums2[index2++];
            } else if (nums2.length == index2 || nums1[index1] < nums2[index2]) {
                mergeArr[i] = nums1[index1++];
            } else {
                int temp = nums1[index1++];
                index2++;
                mergeArr[i] = temp;
                mergeArr[++i] = temp;
            }

        }

        return mergeArr;
    }


}


class Bean{
    private static final Bean BEAN;

    static {
        BEAN = new Bean();
    }

}