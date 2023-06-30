package com.chason.class03;

/**
 * 归并排序
 */
public class _02_recurSort_ {

    public static void mergeSort (int[] arr) {

        process(arr, 0, arr.length-1);

    }

    // arr L...R 变得有序
    public static void process (int[] arr, int L, int R) {

        if (L == R) {
            return;
        }

        int mid = L + ((R - L) >> 1);

        process(arr, L, mid);
        process(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {

        int[] help = new int[R - L + 1];
        int index = 0;  // help 的index

        int p1 = L;
        int p2 = M+1;

        while (p1 <= M && p2 <= R) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[index++] = arr[p1++];
        }

        while (p2 <= R) {
            help[index++] = arr[p2++];
        }

        // 将数组复制回去
        for (int i=0; i<help.length; i++) {
            arr[L + i] = help[i];
        }

    }

}
