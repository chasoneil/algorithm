package com.chason.structrue.class02;

/**
 *  反转链表
 *  反转单双链表
 *
 */
public class _01_ReverseLinkedList_ {


    public static void main(String[] args) {

        Node head = new Node(3, new Node(2, new Node(1)));

        DoubleNode node1 = new DoubleNode(3);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(1);

        node1.prev = null;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = null;

        printLinkedList(reverseSimple(head), reverseDouble(node1));
    }


    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static Node reverseSimple(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    /**
     * 反转双链表
     * @param head
     */
    public static DoubleNode reverseDouble(DoubleNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        DoubleNode prev = null;
        DoubleNode curr = head;
        DoubleNode next = null;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void printLinkedList (Node node, DoubleNode doubleNode) {

        if (node != null) {
            System.out.print("print simple linkedList:");

            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }

            System.out.println();
        }

        if (doubleNode != null) {
            System.out.print("print double linkedList:");

            while (doubleNode != null) {
                System.out.print(doubleNode.value + " ");
                doubleNode = doubleNode.next;
            }

            System.out.println();

        }
    }


}
