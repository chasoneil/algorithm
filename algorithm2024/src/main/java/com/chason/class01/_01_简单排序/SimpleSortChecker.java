package com.chason.class01._01_简单排序;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 简单排序对数器
 */
public class SimpleSortChecker {

    @Test
    public void testSimpleSort() {

        int testTime = 500000;
        int maxSize = 100;      // Means size  0-100
        int maxValue = 100;     // means value -100 - 100

        boolean succeed = true;

        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildRandomArray(maxValue, maxSize);
            int[] arr1 = ArrayUtils.copyArray(arr);
            Arrays.sort(arr);
            // TODO your sort algorithm2024
            // SimpleSort.selectSort(arr1);
            // SimpleSort.bubbleSort(arr1);
            SimpleSort.insertSort(arr1);
            if (!ArrayUtils.isEqual(arr, arr1)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Shit");
    }




}
