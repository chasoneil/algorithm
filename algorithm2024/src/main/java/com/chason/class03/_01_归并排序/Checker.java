package com.chason.class03._01_归并排序;


import com.chason.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

public class Checker {

    @Test
    public void testGetMax () {

        int testTime = 100000;
        int maxSize = 50;
        int maxValue = 50;

        boolean succeed = true;

        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildRandomArray(maxSize, maxValue);
            if (RecursionGetMax.getMax(arr) != RecursionGetMax.getMaxBase(arr)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice~": "Shit!");
    }

    @Test
    public void mergeSortTest () {
        int testTime = 100000;
        int maxSize = 50;
        int maxValue = 50;

        boolean succeed = true;

        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildRandomArray(maxSize, maxValue);
            int[] arr1 = ArrayUtils.copyArray(arr);

            MergeSort.sort(arr);
            Arrays.sort(arr1);

            if (!ArrayUtils.isEqual(arr, arr1)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice" :"Shit");
    }

}
