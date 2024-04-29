package com.chason.class03._01_归并排序;

/**
 * 使用递归求一个无序数组的最大值
 */
public class RecursionGetMax {


    public static int getMax(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        return process(arr, 0, arr.length -1);
    }

    public static int process (int[] arr, int L, int R) {

        if (L >= R) {
            return arr[L];
        }

        int mid = L + (R-L)/2;

        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid+1, R);

        return Math.max(leftMax, rightMax);
    }


    public static int getMaxBase (int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxValue = arr[0];

        for (int i=0; i<arr.length; i++) {
            maxValue = arr[i] > maxValue ? arr[i] : maxValue;
        }

        return maxValue;
    }



}
