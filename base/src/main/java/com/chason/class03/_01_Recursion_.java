package com.chason.class03;

public class _01_Recursion_ {


    /**
     * 使用递归的方法求数组 arr L ... R上的最大值
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int getMax (int[] arr, int L, int R) {

        if (L >= R) {
            return arr[L];
        }

        int mid = L + ((R - L ) >> 1);
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid+1, R);

        return Math.max(leftMax, rightMax);
    }

}
