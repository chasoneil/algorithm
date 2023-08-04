package com.chason.structrue.class07;

import com.chason.structrue.base.Tree;

import java.util.Stack;

/**
 * 遍历二叉树
 */
public class _01_ListTree_ {

    /**
     * 递归的方式先序
     */
    public static void recurPre(Tree root) {

        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        recurPre(root.left);
        recurPre(root.right);
    }

    /**
     * 递归的方式中序
     * @param root
     */
    public static void recurIn (Tree root) {

        if (root == null) {
            return;
        }

        recurIn(root.left);
        System.out.print(root.value + " ");
        recurIn(root.right);

    }

    /**
     * 递归方式后序
     * @param root
     */
    public static void recurPos (Tree root) {

        if (root == null) {
            return;
        }

        recurPos(root.left);
        recurPos(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 非递归方式实现先序遍历
     *
     * 1. 准备栈， 压入root
     * 2. 弹出 节点，如果弹出的节点有右 压入右，如果弹出的节点有左压入左
     * 3. 弹出即打印
     */
    public static void pre(Tree root) {

        if (root == null) {
            return;
        }

        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        Tree node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.value + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历 非递归
     * 因为中序遍历是 左头右 那么肯定的，需要先把整棵树的左子树入栈
     * @param root
     */
    public static void in (Tree root) {

        if (root == null) {
            return;
        }

        // 这里有个坑， 如果先把root 压栈，那么我们的判断就是root.left
        // 但是root 会到右节点上，我们没法判断右节点是不是空
        // 所以 root.left 就会空指针
        Stack<Tree> stack = new Stack<>();
        Tree node = root;

        while (!stack.empty() || node != null) {
            if (node != null) {    // 有左子树 那么入栈
                stack.push(node);
                node = node.left;
            } else {    // 弹出打印 再去处理右树
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     * 在先序遍历的基础上 调整压栈顺序 使先序遍历变成 头右左
     * 再逆过来就变成了 左右头 即后序遍历
     * @param root
     */
    public static void pos1 (Tree root) {

        if (root == null) {
            return;
        }

        Stack<Tree> push = new Stack<>();
        Stack<Tree> pop = new Stack<>();

        push.push(root);
        Tree node;

        while (!push.empty()) {

            node = push.pop();

            pop.push(node); // 出栈即入栈

            if (node.left != null) {
                push.push(node.left);
            }

            if (node.right != null) {
                push.push(node.right);
            }
        }

        // 打印pop栈中的内容
        while (!pop.empty()) {
            System.out.print(pop.pop().value + " ");
        }
    }

    /**
     * 使用一个栈 实现后序遍历
     * @param root
     */
    public static void pos2(Tree root) {

        if (root == null) {
            return;
        }

        Stack<Tree> stack = new Stack<>();
        stack.push(root);


        Tree curr = root;
        Tree lastPrint = null;

        while (!stack.empty()) {
            lastPrint = stack.peek();

            if (lastPrint.left != null && curr != lastPrint.left && curr != lastPrint.right) {
                stack.push(lastPrint.left);
            } else if (lastPrint.right != null && curr != lastPrint.right) {
                stack.push(lastPrint.right);
            } else {
                System.out.print(stack.pop().value + " ");
                curr = lastPrint;
            }
        }
    }


    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        recurPre(root);
        System.out.println();
        pre(root);
        System.out.println();
        System.out.println("=======================");

        recurIn(root);
        System.out.println();
        in(root);
        System.out.println();
        System.out.println("=======================");

        recurPos(root);
        System.out.println();
        pos1(root);
        System.out.println();
        pos2(root);
        System.out.println();
        System.out.println("=======================");

    }



}
