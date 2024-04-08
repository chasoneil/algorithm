package com.chason.class04._01_快速排序;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

public class Checker {

    @Test
    public void testDutchFlag01 () {
        int[] arr = {1, 3, 4, 2, 5, 3};
        DutchFlag.minEqualLeftAndRight(arr, 3);
        ArrayUtils.printArray(arr);
    }

    @Test
    public void testDutchFlag02 () {
        int[] arr = {1, 3, 4, 2, 5, 3};
        DutchFlag.minLeftAndEqualAndRight1(arr);
        ArrayUtils.printArray(arr);
    }

    @Test
    public void testPartition1 () {
        int[] arr = {1, 3, 4, 2, 5, 2};
        int p = FastSort.partition1(arr, 0, arr.length-1);
        System.out.println(p);
        ArrayUtils.printArray(arr);
    }

    @Test
    public void testPartition2 () {
        int[] arr = {1, 3, 4, 2, 5, 3};
        int[] ints = FastSort.partition2(arr, 0, arr.length - 1);
        System.out.println(ints[0] + ":" + ints[1]);
        ArrayUtils.printArray(arr);
    }

    @Test
    public void quickSortTest () {

        int testTime = 500000;
        int maxSize = 100;      // Means size  0-100
        int maxValue = 100;     // means value -100 - 100

        boolean succeed = true;

        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildRandomArray(maxValue, maxSize);
            int[] arr1 = ArrayUtils.copyArray(arr);
            Arrays.sort(arr);
            // TODO your sort algorithm2024
            // FastSort.quickSort1(arr1);
            // FastSort.quickSort2(arr1);

            FastSort.quickSort3(arr1);
            if (!ArrayUtils.isEqual(arr, arr1)) {
                succeed = false;
                ArrayUtils.printArray(arr);
                ArrayUtils.printArray(arr1);
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Shit");

    }


}
