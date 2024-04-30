package com.chason.class05._01_堆;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

public class HeapChecker {

    @Test
    public void baseHeapTest () {

        Heap heap = new Heap(10);
        heap.add(5);
        heap.add(6);
        heap.add(3);
        heap.add(8);
        heap.add(2);
        heap.add(4);
        heap.add(7);
        heap.add(1);
        heap.add(3);
        heap.add(2);
        ArrayUtils.printArray(heap.getHeapArray());

        System.out.println("peek:" + heap.peek());
        System.out.println("peek:" + heap.peek());

        System.out.println("----------");
        System.out.println("poll:" + heap.poll());
        System.out.println("poll:" + heap.poll());
        ArrayUtils.printArray(heap.getHeapArray());
    }

    @Test
    public void testHeapSort() {

        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;

        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildRandomArray(maxValue, maxSize);
            int[] arr1 = ArrayUtils.copyArray(arr);
            Arrays.sort(arr);
            Heap.heapSort(arr1);
            if (!ArrayUtils.isEqual(arr, arr1)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Shit");

    }
}
