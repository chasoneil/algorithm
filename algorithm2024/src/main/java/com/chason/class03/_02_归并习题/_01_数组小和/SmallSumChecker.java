package com.chason.class03._02_归并习题._01_数组小和;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

public class SmallSumChecker {

    @Test
    public void testBase () {
        int[] arr = {2, 3, 1, 6};  // 2+ (2+3+1) = 8
        System.out.println(SmallSum.getSumBase(arr));
    }

    @Test
    public void testSmallSum () {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildRandomArray(maxSize, maxValue);
            int[] arr1 = ArrayUtils.copyArray(arr);

            int rightSum = SmallSum.getSumBase(arr);

            // TODO your algorithm2024
            int ans = SmallSum.getSum(arr1);

            if (rightSum != ans) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Shit");
    }

}
