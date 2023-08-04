package com.chason.structrue.base;

/**
 * 特殊的单链表，除了拥有一个指向next的 指针之外还有个random指针
 */
public class RandomNode {

    int value;

    RandomNode next;

    RandomNode random;

    public RandomNode (int value) {
        this.value = value;
    }

}
