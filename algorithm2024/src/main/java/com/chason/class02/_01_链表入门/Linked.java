package com.chason.class02._01_链表入门;

import com.chason.class02.base.DoubleNode;
import com.chason.class02.base.Node;

import java.util.ArrayList;
import java.util.List;

public class Linked {

    // 反转单链表
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

    // 反转双链表
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

    // 删除单链表中指定的值
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

        Node curr = head;
        Node prev = head;
        while (curr.next != null) {
            curr = curr.next;
            if (curr.value != target) {
                prev.next = curr;
                prev = curr;
            }
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
}
