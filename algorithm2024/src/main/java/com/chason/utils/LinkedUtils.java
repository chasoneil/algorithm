package com.chason.utils;

import com.chason.class02.base.DoubleNode;
import com.chason.class02.base.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 创建一个随机的单链表
     * @param maxSize  最大长度
     * @param maxValue 最大值
     * @return 单链表的头节点
     */
    public static Node buildRandomNode (int maxSize, int maxValue) {

        int randomSize = (int) (Math.random() * (maxSize + 1));

        Node head = null;
        Node curr = null;
        for (int i=0; i<randomSize; i++) {

            int randomNumber = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            if (curr == null) {
                head = curr = new Node(randomNumber);
            } else {
                curr.next = new Node(randomNumber);
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * 创建一个随机的双链表
     * @param maxSize 最大长度
     * @param maxValue 最大值
     * @return 双链表的头节点
     */
    public static DoubleNode buildRandomDoubleNode (int maxSize, int maxValue) {

        int randomSize = (int) (Math.random() * (maxSize + 1));
        DoubleNode head = null;
        DoubleNode prev = null;

        for (int i=0; i<randomSize; i++) {
            int randomNumber = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));

            if (head == null) {
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

    /**
     * 打印单链表
     * @param head 单链表的头
     */
    public static void printNode (Node head) {

        if (head == null) {
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    /**
     * 打印双链表
     * @param head 双链表的头
     */
    public static void printDoubleNode (DoubleNode head) {

        if (head == null) {
            return;
        }

        DoubleNode curr = head;
        DoubleNode tail = curr;
        System.out.print("正向:");
        while (curr != null) {
            System.out.print(curr.value + " -> ");
            tail = curr;
            curr = curr.next;
        }
        System.out.println("null");

        System.out.print("反向:");
        while (tail != null) {
            System.out.print(tail.value + " -> ");
            tail = tail.prev;
        }

        System.out.println("null");
    }

    public static Node copyNode (Node head) {

        if (head == null) {
            return null;
        }

        Node prev = new Node(head.value);
        Node newCurr = prev;
        Node curr = head;
        while (curr != null) {
            newCurr.next = new Node(curr.value);
            newCurr = newCurr.next;
            curr = curr.next;
        }

        return prev.next;
    }


    public static List<Integer> linkedToArray (Node head) {

        if (head == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Node curr = head;
        while (curr != null) {
            result.add(curr.value);
            curr = curr.next;
        }

        return result;
    }
}
