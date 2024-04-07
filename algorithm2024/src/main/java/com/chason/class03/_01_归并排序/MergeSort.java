package com.chason.class03._01_归并排序;

public class MergeSort {


    public static void sort (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length-1);
    }


    public static void process (int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int mid = L + (R-L)/2;

        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }


    public static void merge (int[] arr, int L, int M, int R) {

        int[] help = new int[R-L+1];
        int index = 0;

        int p1 = L;
        int p2 = M+1;

        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
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
    }


    // 非递归方式实现 归并排序
    public static void sort1 (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int step = 1;  // 步长
        while (step < arr.length) {
            int leftStartPoint = 0; // 每次进行merge的左指针的位置
            while (leftStartPoint < arr.length) {

                int leftEndPoint = leftStartPoint + step -1;
                if (leftEndPoint > arr.length-1) {          // 意味着本组完全结束
                    break;
                }

                // 到这里左组长度肯定够 处理右组
                int rightEndPoint = Math.min(leftStartPoint + 2*step - 1, arr.length-1);
                merge(arr, leftStartPoint, leftEndPoint, rightEndPoint);
                leftStartPoint = rightEndPoint + 1;
            }

            // 防止越界
            if (step > arr.length/2) {
                return;
            }
            step = step * 2;
        }
    }


}
