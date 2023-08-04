package com.chason.fast.day01;

/**
 * 给定一个非负整数 Number
 *
 * 不用循环语句，返回 >= num 且距离 num 最近的 2的某次方
 */
public class _03_ReturnNear {


    public static int getNearest(int num) {

        num--;

        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;

        return num + 1;
    }

}
