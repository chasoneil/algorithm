package com.chason.structrue.class08;

import com.chason.structrue.base.Tree;

/**
 * 给定一颗二叉树的头节点，任意两个节点之间都存在距离1  也就是说从某个节点到另外的节点，中间经过几个节点（不能重复）
 * 我们就说距离是几
 * 要求返回整颗二叉树的最大距离
 */
public class _04_TreeMaxLength {


    static int maxDistance(Tree head) {
        return process(head).maxDistance;
    }

    /*
        这题的建模需要分类了：
        1. 对于任一节点X 如果最大距离和X没有关系，那么他的最大距离是 ： 左树的最大距离或者右树的最大距离
        2. 对于任一节点X 如果最大距离和X有关系， 那么一定是左树距离X最远的距离到右树距离X最远的距离
            左树距离自己最远的点是多少？ 左树的高度  右树离自己最远的点是多少？右树的高度

        3.  抽象化的结果，需要子树的最大距离 以及子树的高度
     */

    static class Info {

        int maxDistance;

        int height;

        public Info (int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static Info process (Tree node) {

        if (node == null) {
            return new Info(0, 0);
        }

        Info L = process(node.left);
        Info R = process(node.right);

        int height = Math.max(L.height, R.height) + 1;
        // 左树的最大值 || 右树的最大值 || 左高+右高+1 中的最大值
        int maxDistance = Math.max(Math.max(L.maxDistance, R.maxDistance), (L.height + R.height + 1));

        return new Info(maxDistance, height);
    }


}
