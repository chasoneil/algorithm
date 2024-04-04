package com.chason.class03._02_归并习题._02_逆序对;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

public class RightSmallerChecker {

    @Test
    public void baseTest () {
        int[] arr = {3, 1, 4, 2, 5};  // 2 + 1 = 3
        // System.out.println(RightSmaller.smallCountBase(arr));

        System.out.println(RightSmaller.smallCount(arr));
    }

    @Test
    public void testRightSmaller () {

        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;

        boolean succeed = true;
        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildRandomArray(maxSize, maxValue);
            int[] arr1 = ArrayUtils.copyArray(arr);

            int[] copy = ArrayUtils.copyArray(arr);

            int count = RightSmaller.smallCountBase(arr);

            // TODO your algorithm2024
            int ans = RightSmaller.smallCount(arr1);

            if (count != ans) {
                succeed = false;
                ArrayUtils.printArray(copy);
                ArrayUtils.printArray(arr1);
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Shit");
    }



}
