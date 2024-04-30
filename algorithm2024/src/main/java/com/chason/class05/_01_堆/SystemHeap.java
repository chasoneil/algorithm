package com.chason.class05._01_堆;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 系统堆的用法
 */
public class SystemHeap {

    /**
     * 测试系统堆
     */
    @Test
    public void systemHeapTest () {

        PriorityQueue<Integer> heap = new PriorityQueue<>();  // 默认是小根堆
        heap.add(3);
        heap.add(5);
        heap.add(4);
        heap.add(7);
        System.out.println(heap.peek());

        System.out.println("---------");

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        System.out.println("----------------");

        heap = new PriorityQueue<>(new MyComparator()); // 使用比较器将小根堆转变成大根堆
        heap.add(3);
        heap.add(5);
        heap.add(4);
        heap.add(7);

        System.out.println(heap.peek());

        System.out.println("---------");

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

    }


    private class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}
