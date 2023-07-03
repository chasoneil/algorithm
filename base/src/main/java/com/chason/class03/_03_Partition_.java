package com.chason.class03;

import com.chason.class04.Utils;

/**
 * 1. 给定一个数， 将数组比这个数小的数放在左边，比这个数大的放到右边
 * 2. 给定一个数， 将数组比这个数小的放左边， =他的放中间 >他的放右边  荷兰国旗过问
 */
public class _03_Partition_ {


    /*
        按指定的数分两半
     */
    public static void partition01(int[] arr, int target) {


        if (arr == null || arr.length < 2) {
            return;
        }

        int leftRange = -1;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] <= target) {
                swap(arr, leftRange + 1, i);
                leftRange++;
            }
        }
    }

    /*
        按照指定的数将数组分成三个部分
        1. arr[i] == target  i++
        2. arr[i] < target   交换，右扩 i++
        3. arr[i] > target   交换，左扩 i不变
      */
    public static void partition02(int[] arr, int target) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int leftRange = -1;
        int rightRange = arr.length;

        for (int i=0; i<rightRange;) {

            if (arr[i] < target) {
                swap(arr, leftRange+1, i);
                leftRange++;
                i++;
            } else if (arr[i] > target) {
                swap(arr, i, rightRange - 1);
                rightRange--;
            } else {
                i++;
            }
        }
    }

    /*
        荷兰国旗问题
        在 arr L...R 玩 partition02
        target = arr[R]
        返回等于区域的左右边界
     */
    public static int[] dutchFlag(int[] arr, int L, int R) {

        if (arr == null || arr.length < 2) {
            return new int[]{-1, -1};
        }

        if (L > R) {
            return new int[]{-1, -1};
        }

        if (L == R) {
            return new int[] {L, R};
        }

        int leftRange = L-1;
        int rightRange = R+1;
        int target = arr[R];

        for (int i=L; i<rightRange; ) {

            if (arr[i] < target) {
                swap(arr, leftRange + 1, i);
                leftRange++;
                i++;
            } else if (arr[i] > target) {
                swap(arr, i, rightRange-1);
                rightRange--;
            } else {
                i++;
            }
        }
        return new int[] {leftRange + 1, rightRange -1};

    }


    public static void swap (int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }



    public static void main(String[] args) {

        int[] arr = {4,5,3,6,2,5,1,3};

        //printArray(arr);
        // partition01(arr, 3);
        //partition02(arr, 3);
        //printArray(arr);

        int[] res = dutchFlag(arr, 0, arr.length-1);
        Utils.printArray(res);

    }



}
