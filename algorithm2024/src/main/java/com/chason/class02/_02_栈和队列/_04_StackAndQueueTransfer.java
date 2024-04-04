package com.chason.class02._02_栈和队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用栈实现队列
 * 使用队列实现栈
 */
public class _04_StackAndQueueTransfer {


    public static class MyQueue {

        private Stack<Integer> stackPush = new Stack<>();

        private Stack<Integer> stackPop = new Stack<>();

        public void add (int value) {
            stackPush.push(value);
            pushToPop();
        }

        public int poll () {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        private void pushToPop () {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }


    public static class MyStack {

        private Queue<Integer> push = new LinkedList<>();

        private Queue<Integer> pop = new LinkedList<>();

        public void push(int value) {
            push.add(value);
        }

        public int pop () {

            if (push.size() == 0) {
                throw new RuntimeException("Stack is empty");
            }

            while (push.size() > 1) {
                pop.add(push.poll());
            }

            int value = push.poll();

            Queue<Integer> tmp = pop;
            pop = push;
            push = tmp;

            return value;
        }

    }


}
