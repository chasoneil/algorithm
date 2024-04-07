package com.chason.class03._01_归并排序;


import org.junit.Test;

public class Checker {

    @Test
    public void testGetMax () {

        int[] arr = randomArray(10, 10);
        System.out.println(RecursionGetMax.getMaxByRecursion(arr) == RecursionGetMax.getMaxBase(arr));
    }

    public int[] randomArray(int maxValue, int maxSize) {

        int randomSize = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[randomSize];

        for (int i = 0; i < randomSize; i++) {
            int randomValue = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            arr[i] = randomValue;
        }

        return arr;
    }

}
