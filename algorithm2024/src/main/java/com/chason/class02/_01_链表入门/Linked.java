package com.chason.class02._01_链表入门;


import com.chason.class02.base.DoubleNode;
import com.chason.class02.base.Node;

import java.util.ArrayList;
import java.util.List;

public class Linked {

    /**
     * 反转单链表
     * @param head 单链表的头节点
     * @return 反转之后的头节点
     */
    public static Node reverseNode (Node head) {

        if (head == null) {
            return null;
        }

        Node pre = null;
        Node next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 反转双链表
     * @param head 双链表的头节点
     * @return 反转之后的头节点
     */
    public static DoubleNode reverseDoubleNode (DoubleNode head) {

        if (head == null) {
            return null;
        }

        DoubleNode prev = null;
        DoubleNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;

            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 删除单链表中指定的值
     * @param head  单链表的头节点
     * @param target 目标数
     * @return 新的单链表的头节点
     */
    public static Node removeNode (Node head, int target) {

        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.value == target) {
                head = head.next;
            } else {
                break;
            }
        }

        // 将头删除之后，可能一个节点都没有了
        if (head == null) {
            return null;
        }

        Node curr = head.next;
        Node prev = head;

        while (curr != null) {

            if (curr.value != target) {
                prev.next = curr;
                prev = curr;
            }

            // 处理当要删除的元素在结尾的时候
            if (curr.next == null && prev != curr) {
                prev.next = null;
                break;
            }

            curr = curr.next;
        }

        return head;
    }

    public static List<Integer> removeNodeBase (Node head, int target) {

        if (head == null) {
            return null;
        }

        List<Integer> help = new ArrayList<>();

        while (head != null) {
            help.add(head.value);
        }

        for (int i=0; i<help.size(); i++) {
            if (help.get(i) == target) {
                help.remove(i);
            }
        }

        return help;
    }

    /**
     * 校验 target 在不在链表中
     * @param head 链表的头节点
     * @param target 目标数
     * @return 是否存在
     */
    public static boolean checkTargetExist (Node head, int target) {

        if (head == null) {
            return false;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.value == target) {
                return true;
            }
            curr = curr.next;
        }

        return false;

    }
}
