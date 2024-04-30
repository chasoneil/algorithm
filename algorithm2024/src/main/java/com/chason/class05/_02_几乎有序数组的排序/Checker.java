package com.chason.class05._02_几乎有序数组的排序;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

public class Checker {

    @Test
    public void checkSort () {

        int[] arr = {3,2,1,4,6,5,7};
        AlmostSortedArraySort.sort(arr, 3);
        ArrayUtils.printArray(arr);
    }

}
