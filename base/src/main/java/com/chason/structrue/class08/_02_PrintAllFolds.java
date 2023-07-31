package com.chason.structrue.class08;

/**
 * 打印所有折痕
 *
 * 一个纸条，从下往上对折  中间出现一个凹折痕
 * 再从下往上对折，  出现三条折痕 分别是 凹 凹 凸
 * 再从下往上对折 ，出现7条折痕 分别是 凹 凹 凸 凹 凹 凸 凸
 * 依次类推， 折纸N次，打印从上到下的折痕
 *
 */
public class _02_PrintAllFolds {

    public static void main(String[] args) {
        printAllFolds(4);
    }

    /*
       仔细思考，其实就是一棵树
       根节点是 凹
       每次都是从对应子树的根节点出发，上边都是凹，下边都是凸
       整个的顺序其实是中序遍历
     */
    static void printAllFolds (int N) {

        process(1, N, true);

    }

    /**
     * 递归的方法
     * @param level 当前节点是哪层
     * @param n     固定参数，层数多少 也就是折纸数
     * @param isDown 都节点是凹节点吗
     */
    static void process (int level, int n, boolean isDown) {

        if (level > n) {
            return;
        }

        process(level + 1, n, true); // 左树 子阶段 高度 +1

        System.out.println(isDown ? "凹" : "凸");  //  中序  打印时机就是左 打印 右

        process(level + 1, n, false);
    }





}
