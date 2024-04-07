package com.chason.class02._02_栈和队列;


/**
 * 使用数组实现栈和队列
 */
public class StackAndQueueByArray {

    private static int[] arr = null;

    private static int index;

    public static class MyStack {

        public MyStack (int size) {
            arr = new int[size];
            index = 0;
        }

        public void push (int value) {

            if (index == arr.length) {
                throw new RuntimeException("Stack is full");
            }

            arr[index++] = value;
        }

        public int pop () {

            if (index == 0) {
                throw new RuntimeException("Stack is empty");
            }

            return arr[--index];
        }

    }

    public static class MyQueue {

        public MyQueue (int size) {
            arr = new int[size];
        }

    }



}
