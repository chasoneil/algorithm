package com.chason.class01._02_二分法;

/**
 * _02_二分法
 */
public class Dichotomy {

    /**
     * 判断一个有序数组中一个数是否存在
     * @param arr
     */
    public static boolean isExist (int[] arr, int target) {

        if (!checkArr(arr)) return false;

        int L = 0;
        int R = arr.length - 1;

        int mid;
        while (L <= R) {
            mid = L + (R - L) / 2;      // 防止越界

            if (arr[mid] ==  target) {
                return true;
            }

            if (arr[mid] > target) { // 向左二分
                R = mid - 1;  // 防止指针命中回本身了
            } else if (arr[mid] < target) {
                L = mid + 1;
            }
        }
        return false;
    }

    /**
     * 二分的第二种写法
     * @return
     */
    public static boolean isExist1 (int[] arr, int target) {

        if (!checkArr(arr)) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        int mid;
        while (L < R) {  // 满足 L < R 的时候，最少需要两个数，所以退出循环的时候，必然有一个数还没判断

            mid = L + ((R - L) >> 1);
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                R = mid - 1;
            } else if (arr[mid] < target) {
                L = mid + 1;
            }
        }

        // 还有一个数没判断，所以在最后 return 的时候再判断 一下
        return arr[L] == target;
    }

    /*
     * 在一个有序数组中找到大于等于 target 的最左的位置
     * 这道题 如果数组最大值都没有 target 大，那么返回就是 -1 -> 没有 >= target的值
     * 这个二分其实是向左缩小数组的范围
     */
    public static int getNearestLeft(int[] arr, int target) {

        //  0,1,1,1,2,3,3,3,4,5   target = 1
        if (arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;

        int index = -1;
        while (L <= R) {
            int mid = L + ((R-L) >> 1);
            if (arr[mid] >= target) { // 向左二分
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return index;
    }

    private static boolean checkArr (int[] arr) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        return true;
    }

    // O(N)
    public static boolean isExistBase (int[] arr, int target) {
        if (!checkArr(arr)) return false;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // O(N)
    // 在 arr 上找 >= target 的最左侧的位置
    public static int getNearestLeftBase (int[] arr, int target) {

        if (arr.length == 0) {
            return -1;
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }

        return -1;
    }


    // 找 arr 上 <= target 的最右侧值
    // 0,1,1,2,3,3,3,4,5,5,5,6  target = 3
    public static int getNearestRight (int[] arr, int target) {

        if (arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;

        int index = -1;

        while (L <= R) {

            int mid = L + ((R-L)/2);
            if (arr[mid] <= target) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return index;
    }

    // 局部最小值问题  只要找一个局部最小的位置
    // 无序数组，相邻不等
    public static int isNearlyMinExist (int[] arr) {

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        // 除了特殊情况之外 开始二分

        int L = 0;
        int R = arr.length - 1;

        while (L <= R) {

            int mid = L + ((R - L)/2);
            if (arr[mid] > arr[mid + 1]) { // 往右二分
                L = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                return mid;
            }
        }

        return 0;
    }
}
