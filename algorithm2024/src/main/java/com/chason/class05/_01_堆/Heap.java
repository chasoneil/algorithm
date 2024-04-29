package com.chason.class05._01_堆;

import com.chason.utils.ArrayUtils;

public class Heap {



    public static void heapSort (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i<arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        ArrayUtils.swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapIfy(arr, 0, heapSize);
            ArrayUtils.swap(arr, 0, --heapSize);
        }

    }


    /**
     * 在数组 arr 中， 新加入了一个数，新的数位置在index, 通过调整
     * 将 arr 的结构维持为大根堆
     * @param arr 无序数组
     * @param index 新数的index
     */
    private static void heapInsert (int[] arr, int index) {
        while (arr[index] > arr[(index-1)/2]) {    // 当 index =0 这个判断条件必然不成立  arr[0] > arr[0] 必然错
            ArrayUtils.swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     * 从 index 位置往下调整
     * 将 整个数组调整成 大根堆结构
     * @param arr  堆数组
     * @param index 从index位置往下看
     * @param heapSize 堆的大小
     */
    private static void heapIfy (int[] arr, int index, int heapSize) {

        int left = 2 * index + 1;

        while (left < heapSize) { // 左子树如果越界,那么右子树一定越界

            int largeIndex = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1 : left;
            largeIndex = arr[largeIndex] > arr[index] ? largeIndex : index;

            if (index == largeIndex) {
                break;
            }

            ArrayUtils.swap(arr, largeIndex, index);
            index = largeIndex;
            left = 2 * index + 1;
        }

    }

}
