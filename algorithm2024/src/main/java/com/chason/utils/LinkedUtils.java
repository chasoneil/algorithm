package com.chason.utils;

import com.chason.class02.base.DoubleNode;
import com.chason.class02.base.Node;
import org.junit.Test;

public class LinkedUtils {

    @Test
    public void test01 () {
        Node head = buildRandomNode(10, 10);
        printNode(head);
    }

    @Test
    public void test02 () {
        DoubleNode node = buildRandomDoubleNode(10, 10);
        printDoubleNode(node);
    }

    // 创建一个单链表
    public static Node buildRandomNode (int size, int range) {

        Node head = null;
        Node prev = null;
        for (int i=0; i<size; i++) {

            int randomNumber = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));

            if (prev == null) {
                head = prev = new Node(randomNumber);
            } else {
                prev.next = new Node(randomNumber);
                prev = prev.next;
            }
        }
        return head;
    }

    // 创建一个双链表
    public static DoubleNode buildRandomDoubleNode (int size, int range) {

        DoubleNode head = null;
        DoubleNode prev = null;

        for (int i=0; i<size; i++) {

            int randomNumber = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));

            if (prev == null) {
                head = prev = new DoubleNode(randomNumber);
            } else {
                DoubleNode curr = new DoubleNode(randomNumber);
                curr.prev = prev;
                prev.next = curr;
                prev = curr;
            }
        }

        return head;
    }

    public static void printNode (Node head) {

        if (head == null) {
            System.out.println("[]");
        }

        System.out.print("[");
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void printDoubleNode (DoubleNode head) {

        if (head == null) {
            System.out.println("[]");
        }

        System.out.print("[");
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }


}
