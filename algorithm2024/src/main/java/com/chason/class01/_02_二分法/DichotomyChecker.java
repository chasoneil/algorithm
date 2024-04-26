package com.chason.class01._02_二分法;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

public class DichotomyChecker {

    @Test
    public void testExist() {

        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i=0; i<testTimes; i++) {
            int[] arr = ArrayUtils.buildSortedRandomArray(maxSize, maxValue);
            int target = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            boolean exist = Dichotomy.isExistBase(arr, target);
            // TODO your algorithm
            // boolean result = Dichotomy.isExist(arr, target);
            boolean result = Dichotomy.isExist1(arr, target);
            if (exist != result) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Shit");
    }

    @Test
    public void testNearestLeft () {

        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i=0; i<testTime; i++) {

            int[] arr = ArrayUtils.buildSortedRandomArray(maxSize, maxValue);
            int target = (int) (Math.random() * (maxValue + 1));
            int index = Dichotomy.getNearestLeftBase(arr, target);
            int result = Dichotomy.getNearestLeft(arr, target);

            if (index != result) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Shit");
    }

    @Test
    public void testAreaMin () {
        int testTime = 1000000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i=0; i<testTime; i++) {
            int[] arr = ArrayUtils.buildArrayNextNotEqual(maxSize, maxValue);
            int position = Dichotomy.isNearlyMinExist(arr);

            if (!checkNearlyMin(arr, position)) {
                succeed = false;
                ArrayUtils.printArray(arr);
                System.out.println(position);
                break;
            }
        }

        System.out.println(succeed ? "Pass" : "Failed");
    }

    private static boolean checkNearlyMin (int[] arr, int index) {

        if (index < 0) {
            return true;
        }

        if (arr.length < 2) {
            return true;
        }

        if (index == 0 && arr[index] < arr[index+1]) {
            return true;
        }

        if (index == arr.length - 1 && arr[index] < arr[index-1]) {
            return true;
        }

        if (arr[index] < arr[index + 1] && arr[index] < arr[index -1]) {
            return true;
        }

        return false;
    }



}
