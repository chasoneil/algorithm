package com.chason.structrue.class02;

/**
 * 使用 数组 实现栈和队列
 * 1. 数组长度固定，所以实现的栈和队列的最大长度也固定
 * 2. 当超过最大长度的时候，抛出异常
 *
 */
public class _03_StackAndQueueImplByArray_ {

    private static final int LIMIT = 7;

    private static int[] arr = new int[LIMIT];

    private static int size = 0;

    private static int putIndex = 0;

    private static int popIndex = 0;

    static class MyStack {

        public void put (int value) {

            if (size == LIMIT) {
                throw new RuntimeException("stack is full");
            }

            arr[putIndex++] = value;
            size++;
        }


        // 弹出栈顶的元素
        public int pop () {

            if (size == 0) {
                throw new RuntimeException("stack is empty");
            }
            size--;
            return arr[--putIndex];
        }

        // 返回栈顶元素
        public int peek() {
            if (size == 0) {
                throw new RuntimeException("stack is empty");
            }

            return arr[putIndex - 1];
        }
    }

    static class MyQueue {

        public void offer(int value) {

            if (size == LIMIT) {
                throw new RuntimeException("queue is full");
            }
            arr[putIndex] = value;
            putIndex = nextIndex(putIndex);
            size++;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("queue is empty");
            }
            int res = arr[popIndex];
            size--;
            popIndex = nextIndex(popIndex);
            return res;

        }

        public int peek() {
            if (size == 0) {
                throw new RuntimeException("queue is empty");
            }
            return arr[popIndex];
        }

    }

    // 获取下一个指针的位置
    public static int nextIndex (int index) {
        return index < LIMIT - 1 ? index + 1 : 0;
    }

    public static void main(String[] args) {

//        MyStack stack = new MyStack();
//        stack.put(1);
//        stack.put(2);
//        stack.put(3);
//        stack.put(4);
//        stack.put(5);
//        stack.put(6);
//        stack.put(7);
//        stack.put(8);


        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);

        for (int i=0; i<9; i++) {
            System.out.println(queue.poll());
            // System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }


}
