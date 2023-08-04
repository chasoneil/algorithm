package com.chason.structrue.base;

/**
 * 二叉树
 */
public class Tree {

    public int value;

    public Tree left;

    public Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static Tree buildTree () {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        return root;
    }

}
