package com.chason.structrue.class01;

/**
 * 给定一个整数，将这个整数转化成 对应的 二进制  展示全部的32位， 不足的用0 补齐
 * 例如 ：
 * 1 -> 00000000 00000000 00000000 00000001
 * 2 -> 00000000 00000000 00000000 00000010
 *
 */
public class _01_binary_ {

    public static void main(String[] args) {

        printBinary(3);
        printBinary(3 << 28);
        printBinary((3 << 28) >> 28);


    }

    public static void printBinary (int number) {

        for (int i=31; i>=0; i--) {
            System.out.print( (number & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

}
