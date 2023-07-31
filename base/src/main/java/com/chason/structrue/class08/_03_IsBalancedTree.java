package com.chason.structrue.class08;

import com.chason.structrue.class07.Tree;

/**
 * 给定一颗二叉树的头节点head，返回二叉树是不是个平衡二叉树
 * 平衡二叉树指的是在一颗树中，每个子树的左树和右树的高度差不超过 1
 */
public class _03_IsBalancedTree {


    static boolean isBalancedTree(Tree head) {

        return process(head).isBalanced;
    }

    static class Info {

        boolean isBalanced;
        int height;

        public Info (boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    static Info process (Tree node) {

        if (node == null) {
            return new Info(true, 0);
        }

        Info left = process(node.left);
        Info right = process(node.right);

        // 将左右两树的结果 合并
        int height = Math.max(left.height, right.height) + 1;

        boolean isBalanced = true;
        if (!left.isBalanced || !right.isBalanced
            || Math.abs(left.height - right.height) > 1) {
            isBalanced = false;
        }

        return new Info(isBalanced, height);

    }

}
