package com.chason.structrue.class04;

import java.util.PriorityQueue;

/**
 * 系统自带的堆
 */
public class _02_SystemHeap_ {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(3);
        queue.add(2);
        queue.add(4);
        queue.add(6);
        queue.add(1);
        queue.add(7);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();

    }

}
