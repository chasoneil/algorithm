package com.chason.class04._01_快速排序;

public class FastSort {

    public static void quickSort1 (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        partition1(arr, 0, arr.length-1);

    }

    public static void process (int[] arr, int L, int R) {

        int p = partition1(arr, L, R);




    }


    // arr[L...R]  target = arr[R]  (<= target target > target)
    // return position of target
    public static int partition1 (int[] arr, int L, int R) {

        if (L > R) {
            return -1;
        }

        if (L == R) {
            return L;
        }

        int less = L-1;
        int index = L;

        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index++, ++less);
            } else {
                index++;
            }
        }

        swap(arr, R, less+1);
        return less+1;
    }



    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
