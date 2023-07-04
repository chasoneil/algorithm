package com.chason.class06;

import com.chason.class02.Node;

/**
 * 给定链表返回中点
 *
 *
 * 快慢指针
 */
public class _01_ReturnMiddle_ {

    /**
     * 奇数个返回中点，偶数个返回上中点
     * @param head
     * @return
     */
    public static Node middle1(Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // 链表有三个以上的节点
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    /**
     * 奇数个返回中点，偶数个返回下中点
     * @param head
     * @return
     */
    public static Node middle2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 奇数个返回中点前一个，偶数个返回上中点
     * @param head
     * @return
     */
    public static Node middle3 (Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


}
