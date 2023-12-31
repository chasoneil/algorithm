package com.chason.structrue.base;

/**
 * 双链表结构
 */
public class DoubleNode {

    public int value;

    public DoubleNode next;

    public DoubleNode prev;

    public DoubleNode (int value) {
        this.value = value;
    }

    public DoubleNode (int value, DoubleNode prev, DoubleNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}
