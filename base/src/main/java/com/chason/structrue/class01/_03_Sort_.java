package com.chason.structrue.class01;

/**
 * 选择排序
 * 每次选择一个最小的数，依次放到数组对应的位置上
 *
 * 冒泡排序
 * 每次将最大的数冒泡到数组对应的位置
 *
 * 插入排序
 * 每次保证 0-N 位置上的数有序
 */
public class _03_Sort_ {

    public static void main(String[] args) {

        int[] arr = {4, 2, 6, 8, 9, 4, 2, 3, 1};
        printArray(arr);
        // selectSort(arr);
        // bubbleSort(arr);

        insertSort(arr);
        printArray(arr);

    }

    // 选择排序
    public static void selectSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i<arr.length; i++) {
            int minIndex = i;

            for (int j=i+1; j<arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 - N-1
        // 0 - N-2
        // 0 - end
        int N = arr.length;
        for (int end = N-1; end >= 0; end--) {

            // 0 - end 上做比较
            // 0 1比较； 1 2比较； ... end-1 end 比较
            for (int next = 1; next <= end; next++) {

                if (arr[next-1] > arr[next]) {
                    swap(arr, next-1, next);
                }
            }
        }

    }

    // 插入排序
    public static void insertSort (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 - i 位置上有序
        // 0-0 有序 完成 从1 开始
        for (int i=1; i < arr.length; i++) {

            int index = i;  // 新数的index
            // 当左边的数没有到数组头 并且 左边的数比右边的大
            // 交换 同时这个数的指针左移
            while (index-1>=0 && arr[index-1] > arr[index] ) {
                swap(arr, index -1, index);
                index--;
            }
        }
    }


    public static void printArray (int[] arr) {

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
