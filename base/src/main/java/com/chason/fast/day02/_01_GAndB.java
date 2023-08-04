package com.chason.fast.day02;

/**
 * 一个数组中只有'G' 'B'两种字符
 * 将G放在左侧 将B放在右侧 或者 所有的B在左边 所有的G放在右边
 * 但是只能在相邻字符之间进行交换操作
 * 返回至少需要交换几次
 */
public class _01_GAndB {

    public static void main(String[] args) {

        char[] chars = {'B','G','G','B','G','B','B'};

        System.out.println(leastMoveTimes(chars));

    }

    /**
     * 如果要实现上述目标，第一个G 一定在 数组0位置，第二个G一定在数组1位置 依此类推
     * 为啥呢？ 因为你但凡后面的G跑到前面的G前面去了，他都有无效交换，都不是最优解
     * 当你的G 都在左边的时候，你的B自然而然都在右边了
     *
     * 我们使用双指针，其中一个指针 L 从0 开始
     * 另一个指针 index 从 L+1 开始，开始遍历，如果 index 位置是G 计算 index 到L的距离，因为这个G至少要移动这么多次才可能在他该有的位置上
     * 计算完 L++ index++
     *
     * 如果不是G 直接index++
     *
     *
     * @param chars
     * @return
     */
    public static int leastMoveTimes(char[] chars) {

        int L = 0;
        int index = L + 1;

        int GLeftCount = 0;

        while (index < chars.length) {

            if (chars[index] == 'G') {
                GLeftCount += (index - L);
                L++;
            }
            index++;
        }


        L = 0;
        index = L + 1;

        int BLeftCount = 0;
        while (index < chars.length) {

            if (chars[index] == 'B') {
                BLeftCount += (index - L);
                L++;
            }
            index++;
        }

        return Math.min(GLeftCount, BLeftCount);

    }

}
