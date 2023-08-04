package com.chason.structrue.class03;

import com.chason.structrue.utils.Utils;

/**
 * 快排
 */
public class _04_FastSot_ {

    public static void fastSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int L, int R) {

        if (L >= R) {
            return;
        }

        // 产生一个随机位置
        // 这里为什么不能用arr.length 因为在递归的时候，arr 一直没变，但是length的有效区间变了
        // 所以这里我们用动态的长度 R-L+1
        int randomIndex = L + (int) (Math.random() * (R-L+1));
        _03_Partition_.swap(arr, randomIndex, R);

        int[] area = _03_Partition_.dutchFlag(arr, L, R);
        sort(arr, L, area[0] - 1);
        sort(arr, area[1] + 1, R);
    }


    public static void main(String[] args) {

        int[] arr = {4,5,3,6,2,5,1,3};
        fastSort(arr);
        Utils.printArray(arr);

    }
}
