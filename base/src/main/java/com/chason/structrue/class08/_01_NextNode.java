package com.chason.structrue.class08;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个特殊的二叉树结构  本包中的TreeNode 主要包含一个parent指针
 *
 * 给你一个任意节点 node 找这个node的后继节点
 *
 * 后继节点： 在二叉树中序遍历中的后一个节点
 *
 */
public class _01_NextNode {

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        head.left = node1;
        head.right = node2;
        node1.parent = head;
        node2.parent = head;

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;
        node3.parent = node1;
        node4.parent = node1;
        node5.parent = node2;
        node6.parent = node2;

        TreeNode node7 = new TreeNode(8);

        node3.left = node7;
        node7.parent = node3;

        //System.out.println(getNext1(node6).value);

        TreeNode node = getNext2(node6);
        if (node == null) {
            System.out.println(node);
        } else {
            System.out.println(node.value);
        }



    }


    /**
     * 普通的想法，先遍历找到root
     * 然后直接中序遍历，找到当前节点
     * 然后next就是后继
     * @return
     */
    public static TreeNode getNext1 (TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode head = node;

        while (head.parent != null) {
            head = head.parent;
        }

        List<TreeNode> lists = new ArrayList<>();
        process1(head, lists);

        for (int i=0; i<lists.size(); i++) {
            if (lists.get(i) == node) {
                return lists.get(i+1);
            }
        }

        return null;
    }

    public static void process1 (TreeNode head, List<TreeNode> lists) {

        if (head == null) {
            return;
        }

        process1(head.left, lists);
        lists.add(head);
        process1(head.right, lists);

    }

    /**
     * 在一个二叉树中， 如果一个节点他有右树，那么他的后继节点一定是右树上的最左节点
     * 如果他没有右树，那么他的后继节点就要这么找了，他去找他的父节点，如果他是他父节点的右节点则继续往上找
     * 一直到他是他的父节点的左节点的时候，这个父节点就是他的后继节点
     *
     * 整颗二叉树的最右节点是没有后继节点的
     * @param node
     */
    public static TreeNode getNext2(TreeNode node) {

        if (node == null) {
            return null;
        }

        if (node.right != null) {   // 有右树
            return getTreeLeft(node);
        }

        // 没有右树的情况
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;

    }

    // 获取一颗二叉树的最左节点
    public static TreeNode getTreeLeft (TreeNode node) {

        while (node.left !=  null) {
            node = node.left;
        }
        return node;
    }

}
