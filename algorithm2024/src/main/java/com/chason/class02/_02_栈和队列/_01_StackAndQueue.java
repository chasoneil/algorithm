package com.chason.class02._02_栈和队列;


/**
 * 用双向链表实现栈和队列
 */
public class _01_StackAndQueue {


    static class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node (int value) {
            this.value = value;
        }
    }

    static class LinkedHelp {

        public static Node head = null;

        public static Node tail;

        public static void addFromTail(int value) {
            Node node = new Node(value);

            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public static void addFromHead (int value) {

            Node node = new Node(value);

            if (head == null) {
                head = tail = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }

        }

        public static int popFromHead () {

            if (head == null) {
                throw new RuntimeException("container is empty");
            }

            int value = head.value;

            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }

            return value;
        }

        public static int popFromTail () {

            if (tail == null) {
                throw new RuntimeException("container is empty");
            }

            int value = tail.value;

            if (tail == head) {
                tail = head = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }

            return value;
        }

    }

    static class MyStack {

        public MyStack () {

        }

        public void push (int value) {
            LinkedHelp.addFromHead(value);
        }

        public int pop () {
            return LinkedHelp.popFromHead();
        }
    }

    static class MyQueue {

        public MyQueue () {

        }

        public void add (int value) {
            LinkedHelp.addFromHead(value);
        }

        public int poll () {
            return LinkedHelp.popFromTail();
        }

    }

}
