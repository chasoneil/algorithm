package com.chason.class04;

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

}
