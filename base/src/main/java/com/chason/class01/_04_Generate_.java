package com.chason.class01;

import java.util.Arrays;

/**
 * 对数器
 */
public class _04_Generate_ {

    /**
     * 随机数组产生器
     * 产生的数组元素都是整数
     * @return
     */
    public static int[] generateArray (int maxSize, int maxValue) {

        int randomSize = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[randomSize];

        for (int i=0; i<randomSize; i++) {
            int randomValue = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            arr[i] = randomValue;
        }

        return arr;

    }

    public static int[] copyArray (int[] arr) {

        int[] copy = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            copy[i] = arr[i];
        }

        return copy;
    }

    public static boolean isEqual (int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i=0; i<arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }


    /**
     * 对数器的入口
     */
    public static void startTest(int times, int maxSize, int maxValue) {

        for (int i=0; i<times; i++) {

            int[] ori = generateArray(maxSize, maxValue);
            int[] cpy = copyArray(ori);

            // 做你自己的测试方法

            // 系统提供的或者暴力但是正确的方法
            Arrays.sort(cpy);

            if (!isEqual(ori, cpy)) {
                System.out.println("Test method is Error!, please check");
            } else {
                System.out.println("Succeed !");
            }

        }


    }


}
