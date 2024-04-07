package com.chason.class04._01_快速排序;

public class DutchFlag {

    // <= target  |  > target
    public static void minEqualLeftAndRight (int[] arr, int target) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int left = -1;  // <= area
        for (int i=0; i<arr.length; i++) {
            if (arr[i] <= target) {
                swap(arr, left+1, i);
                left++;
            }
        }
    }

    // < target | = target | > target
    // version 1 right 区域是 数组越界的位置
    public static void minLeftAndEqualAndRight (int[] arr, int target) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int left = -1;
        int right = arr.length;

        for (int i=0; i<right;) {
            if (arr[i] < target) {
                swap(arr, left+1, i);
                left++;
                i++;
            } else if (arr[i] == target) {
                i++;
            } else {
                swap(arr, i, right-1);
                right--;
            }
        }
    }

    // version 2   right = arr.length - 1  && no target
    public static void minLeftAndEqualAndRight1 (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int left = -1;
        int right = arr.length - 1;

        int target = arr[arr.length - 1];

        for (int i=0; i<right;) {

            if (arr[i] < target) {
                swap(arr, left+1, i);
                left++;
                i++;
            } else if (arr[i] == target) {
                i++;
            } else {
                swap(arr, right-1, i);
                right--;
            }
        }

        swap(arr, right, arr.length-1);  // swap target
    }

    public static void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
