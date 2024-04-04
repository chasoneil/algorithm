package com.chason.utils;

import java.util.Arrays;

public class ArrayUtils {

    public static int[] buildRandomArray (int maxSize, int maxValue) {

        if (maxSize < 0) {
            throw new RuntimeException("Array size is under 0.");
        }

        int randomSize = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[randomSize];

        for (int i=0; i<arr.length; i++) {
            int random = (int)(Math.random() * (maxValue+1)) - (int)(Math.random() * (maxValue+1));
            arr[i] = random;
        }
        return arr;
    }

    public static int[] buildSortedRandomArray (int maxSize, int maxValue) {
        int[] arr = buildRandomArray(maxSize, maxValue);
        Arrays.sort(arr);
        return arr;
    }

    public static int[] copyArray(int[] arr) {

        if (arr == null) {
            throw new RuntimeException("Array is null");
        }

        int[] help = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            help[i] = arr[i];
        }

        return help;
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

    public static void printArray (int[] arr) {

        if (arr == null) {
            return;
        }

        System.out.print("[");

        for (int i=0; i<arr.length; i++) {

            System.out.print(arr[i]);
            if (i != arr.length-1) {
                System.out.print(",");
            }
        }

        System.out.println("]");

    }

}
