package com.chason.class03._02_归并习题._02_逆序对;


/**
 * 求一个无序数组的逆序对个数
 *
 * _02_逆序对： 在一个数组中，对于任意一个位置 i，满足 arr[i] > arr[j](j > i) 则 (arr[i],arr[j]) 为一组逆序对
 * 求一个数组中一共有多少个逆序对
 * 要求： 时间复杂度越低越好
 */
public class RightSmaller {

    public static int smallCount (int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length-1);
    }

    // 数组 arr L ~ R范围上有多少个逆序对
    public static int process (int[] arr, int L, int R) {

        if (L == R) {
            return 0;
        }

        int M = L + (R-L)/2;

        return process(arr, L, M)
                + process(arr, M+1, R)
                + merge(arr, L, M, R);
    }


    public static int merge (int[] arr, int L, int M, int R) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        int count = 0;
        int N = R-L+1;
        int[] help = new int[N];

        int index = N-1;

        // 从右往左merge
        int p1 = M;
        int p2 = R;

        while (p1 >= L && p2 >= M+1) {
            if (arr[p1] > arr[p2]) {
                count += (p2 - M);
                help[index--] = arr[p1--];
            }  else {
                help[index--] = arr[p2--];
            }
        }

        while (p1 >= L) {
            help[index--] = arr[p1--];
        }

        while (p2 >= R) {
            help[index--] = arr[p2--];
        }

        for (int i=0; i<help.length; i++) {
            arr[L + i] = help[i];
        }

        return count;
    }

    public static int smallCountBase (int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }


}
