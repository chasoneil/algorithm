package com.chason.class01._01_简单排序;

/**
 * 简单排序
 */
public class SimpleSort {

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i<arr.length; i++) {

            for (int j=i-1;j>=0 && arr[j] > arr[j+1] ;j--) {
                swap(arr, j, j+1);
            }
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=arr.length; i>0; i--) {
            for (int j=0; j<i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for (int j=i; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i , int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
