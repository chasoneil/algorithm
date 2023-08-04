package com.chason.structrue.class09;

import com.chason.structrue.base.Tree;

/**
 * 判断是不是满二叉树
 *
 * 所谓的满二叉树 ， 就是如果二叉树的高度是L 节点数是N
 * 那么一定满足 N = 2^L - 1
 *
 * 其实本质上就是二叉树满了
 */
public class _02_IsFullTree {


    static boolean isFullTree (Tree head) {
        Info info = process(head);
        return (1 << info.height) - 1 == info.nodes;
    }


    static Info process (Tree node) {

        if (node == null) {
            return new Info(0, 0);
        }

        Info L = process(node.left);
        Info R = process(node.right);

        int height = Math.max(L.height, R.height) + 1;
        int nodes = L.nodes + R.nodes + 1;

        return new Info(height, nodes);
    }

    static class Info {
        int height;
        int nodes;
        public Info (int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

}
