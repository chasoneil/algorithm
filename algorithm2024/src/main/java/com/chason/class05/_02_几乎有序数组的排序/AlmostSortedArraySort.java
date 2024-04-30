package com.chason.class05._02_几乎有序数组的排序;


import com.chason.class05._01_堆.Heap;

import java.util.PriorityQueue;

/**
 * 给定一个无序数组 arr 和一个正整数 k
 * 已知 arr 几乎有序
 * 几乎有序： 数组中每个位置的值如果排好序，移动的位置都小于等于 k
 * 请将 arr 排序 并使得排序算法的时间复杂度尽可能的低
 */
public class AlmostSortedArraySort {


    /**
     * 对 arr进行排序
     * @param arr 几乎有序的数组
     * @param k 几乎有序的值k
     * 时间复杂度 O(N*logK)
     */
    public static void sort (int[] arr, int k) {

        if (arr == null || arr.length < 2) {
            return;
        }

        if (k >= arr.length) {  // 如果你的k已经大到超过了整个数组的长度，那么直接使用堆排序
            Heap.heapSort(arr);
            return;
        }

        int[] help = new int[arr.length];

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i<k; i++) {
            heap.add(arr[i]);
        }

        int index = 0;
        for (int i=k; i<arr.length; i++) {
            help[index++] = heap.poll();
            heap.add(arr[i]);
        }

        while (!heap.isEmpty()) {
            help[index++] = heap.poll();
        }

        for (int i=0; i<arr.length; i++) {
            arr[i] = help[i];
        }
    }


}
