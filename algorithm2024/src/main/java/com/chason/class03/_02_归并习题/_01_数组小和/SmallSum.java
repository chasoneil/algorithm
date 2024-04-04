package com.chason.class03._02_归并习题._01_数组小和;

/**
 * 数组小和问题
 *
 * 当遍历数组时，遍历到 i，此时数组中所有比 arr[i] 小的数的和叫 arr[i]的小和
 * 求整个数组的数组小和
 * 要求时间复杂度 小于 O(N^2)
 */
public class SmallSum {

    public static int getSum (int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }

    public static int process (int[] arr, int L, int R) {

        if (L == R) {
            return 0;
        }

        int M = L + (R - L) / 2;
        return process(arr, L, M)
                + process(arr, M+1, R)
                + merge(arr, L, M, R);
    }

    // 进行数组的merge 过程中产生小和
    public static int merge(int[] arr, int L, int M, int R) {

        if (arr.length < 2) {
            return 0;
        }

        int[] help = new int[R-L+1];

        int index = 0;
        int p1 = L;
        int p2 = M+1;

        int ans = 0;

        while (p1 <= M && p2 <= R) {

            if (arr[p1] < arr[p2]) {        // 左组小 计算小和
                ans += (R-p2+1) * arr[p1];
                help[index++] = arr[p1++];
            } else {
                help[index++] = arr[p2++];
            }
        }

        while (p1 <= M) {
            help[index++] = arr[p1++];
        }

        while (p2 <= R) {
            help[index++] = arr[p2++];
        }

        for (int i=0; i<help.length; i++) {
            arr[L + i] = help[i];
        }

        return ans;
    }

    // 遍历的方式求小和  时间复杂度 O(N^2)
    public static int getSumBase (int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        int ans = 0;

        // i 位置的小和
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    ans += arr[j];
                }
            }
        }
        return ans;
    }



}

