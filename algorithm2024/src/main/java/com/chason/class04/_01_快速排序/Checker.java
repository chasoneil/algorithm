package com.chason.class04._01_快速排序;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

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


}
