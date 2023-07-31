package com.chason.structrue.class04;

public class _01_HeapSort_ {


    public static void heapSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i<arr.length; i++) {
            Heap.heapInsert(arr, i);
        }

        int heapSize = arr.length;
        Utils.swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            Heap.heapIfy(arr, 0, heapSize);
            Utils.swap(arr, 0, --heapSize);
        }

    }

}
