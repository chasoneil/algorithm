package com.chason.structrue.class07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 按层遍历  宽度优先遍历
 */
public class _02_ListTree_ {

    /**
     * 使用队列按层遍历
     */
    public static void level (Tree root) {

        if (root == null) {
            return;
        }

        Queue<Tree> queue = new LinkedList<>();

        queue.add(root);
        Tree node = null;

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    /**
     * 获取二叉树的最大宽度
     * 最主要的是，我们在宽度优先遍历的时候，发现每层的开始和结束，我们就能统计每层的宽度是多少
     * 使用Map可以实现上述功能
     * @return
     */
    public static int maxWidthByMap (Tree root) {

        if (root == null) {
            return 0;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        Tree node = root;

        Map<Tree, Integer> levelMap = new HashMap<>();  // key node value level
        levelMap.put(root, 1);
        int level = 1; // 当前统计哪一层
        int levelNodes = 0; // 改成的node数
        int max = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            int nodeOfLevel = levelMap.get(node);
            if (node.left != null) {
                queue.add(node.left);
                levelMap.put(node.left, nodeOfLevel+1);
            }

            if (node.right != null) {
                queue.add(node.right);
                levelMap.put(node.right, nodeOfLevel+1);
            }

            // 层数相关
            if (level == nodeOfLevel) {     // 当前弹出的节点 和当前层在一层 ，那么当前层节点数 ++
                levelNodes++;
            } else {
                max = Math.max(max, levelNodes);
                level++;
                levelNodes = 1;
            }

        }

        max = Math.max(max, levelNodes);        // 每层开始的时候结算，但是最后一层结束的时候没有结算
        return max;
    }

    public static int maxWidthWithoutMap (Tree root) {

        if (root == null) {
            return 0;
        }

        Queue<Tree> queue = new LinkedList<>();

        queue.add(root);
        Tree node = root;

        Tree currEnd = root;    // 当前层的最后一个节点
        Tree nextEnd = null;    // 下一层的最后一个节点

        int max = 0 ;
        int currLevelNodes = 0;

        while (!queue.isEmpty()) {

            node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                nextEnd = node.left;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextEnd = node.right;   // update nextEnd Node
            }

            currLevelNodes++;

            if(node == currEnd) { // if node == currEnd means current level over
                max = Math.max(max, currLevelNodes);
                currLevelNodes = 0;
                currEnd = nextEnd;      // sign nextEnd to current end
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        level(root);
        System.out.println("===================");

        System.out.println(maxWidthByMap(root));
        System.out.println("===================");


    }


}
