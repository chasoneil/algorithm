package com.chason.class01;

/**
 * 给定一个整数 N 计算N的阶乘 的和
 * 1! + 2! + 3! + ... N!
 */
public class _02_factorial_ {


    public static void main(String[] args) {

        System.out.println(getFactorial(4));

    }

    // 时间复杂度 O(N)
    public static int getFactorial(int n) {

        int count = 0;
        int prev = 1; // 上次计算的结果

        for (int i=1; i<=n; i++) {
            prev = prev * i;
            count += prev;
        }

        return count;
    }

}
