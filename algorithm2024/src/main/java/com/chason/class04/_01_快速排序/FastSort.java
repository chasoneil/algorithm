package com.chason.class04._01_快速排序;

public class FastSort {

    public static void quickSort1 (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        process1(arr, 0, arr.length-1);
    }

    public static void quickSort2 (int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process2(arr, 0, arr.length-1);
    }

    public static void quickSort3 (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        process3(arr, 0, arr.length-1);
    }

    public static void process3 (int[] arr, int L, int R) {

        if (L >= R) {
            return;
        }

        // [0 - (R-L)]
        // + L -> [L - R]
        int randomPosition = (int) (Math.random() * (R-L+1)) + L;
        swap(arr, randomPosition, R);
        int[] area = partition2(arr, L, R);
        process3(arr, L, area[0]-1);
        process3(arr, area[1], R);
    }

    // arr[L...R] 上变有序
    public static void process1 (int[] arr, int L, int R) {

        if (L >= R) {
            return;
        }

        int p = partition1(arr, L, R);
        process1(arr, L, p-1);
        process1(arr, p+1, R);
    }

    public static void process2 (int[] arr, int L, int R) {

        if (L >= R) {
            return;
        }

        int[] area = partition2(arr, L, R);
        process2(arr, L, area[0] -1);
        process2(arr, area[1] + 1, R);
    }


    // arr[L...R]  target = arr[R]  (<= target target > target)
    // return position of target
    public static int partition1 (int[] arr, int L, int R) {

        if (L > R) {
            return -1;
        }

        if (L == R) {
            return L;
        }

        int less = L-1;
        int index = L;

        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index++, ++less);
            } else {
                index++;
            }
        }

        swap(arr, R, less+1);
        return less+1;
    }

    // arr[L...R] -> (<arr[R] =arr[R] >arr[R])
    public static int[] partition2 (int[] arr, int L, int R) {

        if (L > R) {
            return new int[] {-1, -1};
        }

        if (L == R) {
            return new int[] {L, R};
        }

        int less = L-1;
        int more = R;

        int index = L;

        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else if (arr[index] == arr[R]) {
                index++;
            } else {
                swap(arr, index, --more);
            }
        }

        swap(arr, R, more);
        return new int[] {less+1, more};
    }



    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
