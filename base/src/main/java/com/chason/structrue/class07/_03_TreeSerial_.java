package com.chason.structrue.class07;

import com.chason.structrue.base.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化 和 反序列化
 */
public class _03_TreeSerial_ {

    /**
     * preview to serialize tree
     * @return
     */
    public static Queue<String> seriaByPre (Tree head) {

        Queue<String> queue = new LinkedList<>();
        pres(head, queue);
        return queue;

    }

    public static void pres (Tree root, Queue<String> queue) {
        if (root == null) {
            queue.add(null);
        } else {
            queue.add(String.valueOf(root.value));
            pres(root.left, queue);
            pres(root.right, queue);
        }
    }

    public static Tree buildTreeByPre(Queue<String> queue) {

        if (queue == null || queue.isEmpty()) {
            return null;
        }

        return buildTree(queue);

    }

    public static Tree buildTree(Queue<String> queue) {
        String value = queue.poll();
        if (value == null) {
            return null;
        }

        Tree head = new Tree(Integer.parseInt(value));
        head.left = buildTree(queue);
        head.right = buildTree(queue);
        return head;
    }


}
