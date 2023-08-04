package com.chason.structrue.class09;

import com.chason.structrue.base.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一颗二叉树的头节点 返回二叉树是不是完全二叉树
 *
 * 完全二叉树： 从左往右，要么满的，要么是依次变满的状态
 *
 * 使用递归和非递归方式解决
 */
public class _03_IsCBT {


    /**
     * 非递归方式
     * @return
     */
    static boolean isCBT1(Tree head) {

        /*
         常规思路是二叉树的宽度优先遍历
         但是要满足下面两个条件：
         （1） 每个节点要么是左右孩子都存在，要么是存在左孩子，不能单独存在右孩子
         （2） 从第一个出现不是满孩子的节点开始，后面的节点都是叶子节点
               啥叫叶子节点：就是节点下面不能有任何节点了
         */

        if (head == null) {
            return true;
        }

        boolean leaf = false; // 标志遍历到某个节点 他不是满孩子了

        Queue<Tree> queue = new LinkedList<>();

        queue.add(head);
        Tree L = null;
        Tree R = null;

        while (!queue.isEmpty()) {

            head = queue.poll();

            L = head.left;
            R = head.right;

            if (R != null && L == null) {   // 条件1
                return false;
            }

            if (leaf && (L != null || R != null)) {  // 条件2
                return false;
            }

            if (L != null) {
                queue.add(L);
            }

            if (R != null) {
                queue.add(R);
            }

            if (L == null || R == null) {
                leaf = true;
            }


        }
        return true;
    }

    /*
        ======================= 递归 ========================

        以 X 为头的节点，必须满足一下四种才是完全二叉树

        1. 他的L是满二叉树 R是满二叉树 且L的高度和R高度相同
            1
           / \
          2   3
         / \ / \
        4  5 6  7

        2. 他的L是完全二叉树但不满，R是满的 且 L比R的高度 高1级
            1
           / \
          2   3
         /
        4

        3. L是满二叉树 R也是满二叉树 且L比R高1
            1
           / \
          2   3
         / \
        4  5

        4. L是满二叉树 R是完全二叉树 且两者的高度相等
            1
           / \
          2   3
         / \ /
        4  5 6

     */

    static class Info {

        boolean isFull;  // 是否是满二叉树

        boolean isCBT;   // 是否是完全二叉树

        int height;

        public Info (boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    static boolean isCBT2(Tree head) {

        Info info = process(head);
        return info.isCBT;
    }

    static Info process (Tree node) {

        if (node == null) {
            return new Info(true, true, 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        boolean isFull = false;
        boolean isCBT = false;

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;

        if (leftInfo.isFull && rightInfo.isFull && (leftInfo.height == rightInfo.height)) {  // 条件1
            isCBT = true;
        }

        if (leftInfo.isCBT && rightInfo.isFull && (leftInfo.height - rightInfo.height == 1)) { // 条件2
            isCBT = true;
        }

        if (leftInfo.isFull && rightInfo.isFull && (leftInfo.height - rightInfo.height == 1)) { // 条件3
            isCBT = true;
        }

        if (leftInfo.isFull && rightInfo.isCBT && (leftInfo.height == rightInfo.height)) {  // 条件4
            isCBT = true;
        }

        return new Info(isFull, isCBT, height);
    }


}
