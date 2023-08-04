package com.chason.fast.day01;

/**
 * 给定一个有序数组 代表x轴上的点
 * 给定一个正整数K 代表绳子长度
 * 返回绳子最多压中几个点
 * 绳子的边缘出压中也算
 */
public class _01_CoverPoint {

    public static void main(String[] args) {

        int[] arr = {1,3,4,5,7,9,13,15,21,22,25};
        int k= 4;
        System.out.println(cover2(arr, 6));

    }


    public static int cover (int[] arr, int K) {


        return 0;
    }


    /**
     * 滑动窗口算法
     * @param arr
     * @param k
     * @return
     */
    public static int cover2 (int[] arr, int k) {

        int L = 0;           //  L是数组的index  数组中的值 需要通过arr[index] 这样的方式获取
        int R = 0;

        int maxCover = 0;

        while (L < arr.length) {

            while (R < arr.length &&  arr[R] - arr[L] <= k) {
                R++;
            }

            int cover = R - L;      // R 动到不能再移动了，表示有效区域，开始统计覆盖的数
            maxCover = Math.max(maxCover, cover);
            L++;
        }

        return maxCover;

    }

}
