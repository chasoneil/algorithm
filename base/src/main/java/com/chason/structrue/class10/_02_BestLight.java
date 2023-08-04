package com.chason.structrue.class10;

import java.util.HashSet;

/**
 * 最佳放灯问题：
 *
 * 给定一个数组 数组中是由X和 . 构成的，并且只有这两种
 *
 * 数组相当于一个街道X相当于墙 他是不透光的 不能放灯  .相当于居民区 他是可以放灯的而且需要被照亮
 * 每个灯可以照亮三个区域  他自己的位置 以及左右两个点
 * 问放最少的灯照亮整个街道
 *
 * 例如 数组如下 [..XX....XX.X.]
 * 那么至少需要在 0或者1 位置放灯保证第一个区域的两个点全亮
 * 第二个区域至少放两个灯 因为有四个. 一个灯最多只能照亮三个点，所以至少需要两盏灯
 * 第三个区域和第四个区域被X隔开了，各需要一盏灯
 * 所以上面的数组，最少需要五盏灯才能全部照亮
 */
public class _02_BestLight {

    /*
        暴力方法
     */
    static int bestLight1 (String road) {

        if (road == null || road.length() == 0) {
            return 0;
        }

        return process(road.toCharArray(), 0, new HashSet<>());

    }

    /*
        strs[index...] 自由选择放灯还是不放灯
        index - 1之前的位置都已经放好灯了
        具体哪些位置放了灯存在 lights 中
        返回照亮全部点的方案中需要最小灯的数量
     */
    static int process (char[] strs, int index, HashSet<Integer> lights) {

        if (index == strs.length) { // 已经放完灯了 结束
            // 验证，当前的方案能不能照亮所有的点
            for (int i=0; i<strs.length; i++) {
                if (strs[i] != 'X') {
                    if (!lights.contains(i-1) && !lights.contains(i) && !lights.contains(i+1)) { // . 的前自己后三个位置都没有灯
                        return Integer.MAX_VALUE;
                    }
                }

            }
            return lights.size();
        } else {    // 还没结束呢，那我要继续放灯

            int no = process(strs, index, lights);  // 当前index 我选择不放灯  不管你是不是 . 还是X都能选择不放灯
            int yes = Integer.MAX_VALUE;    // 如果你选择放灯，这个位置必须是.
            if (strs[index] == '.') {

                lights.add(index);
                yes = process(strs, index + 1, lights);
                lights.remove(index);
            }

            return Math.min(yes, no);
        }

    }


    // ============= 贪心 ============

    /*
        1. if current position is index, if index was 'X', we can do nothing, index++

        2. if index was '.', we had different decisions:
            (1) if index + 1 was 'X' -> we need put light on index
            because if didn't put light, although we put on index + 2, the position index was dark.

            (2)if index + 1 was '.', we have different decisions too:
                (1)if index + 2 was 'X',it means '..X', we need to put light on the index + 1,then index = index + 3
                (2)if index + 2 was '.',it means '...', we need to put light on the index + 1,then index = index + 3
        ...

     */
    static int bestLight2 (String road) {

        if (road == null || road.length() == 0) {
            return 0;
        }

        char[] strs = road.toCharArray();

        int index = 0;      // start position from index 0
        int lights = 0;     // the number we put

        while (index < strs.length) {   // means not finished yet

            if (strs[index] == 'X') {   // we can't put light go next
                index++;
            } else {
                lights++;
                if (index + 1 == strs.length) {
                    break; // means over
                } else {

                    if (strs[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return lights;
    }


}
