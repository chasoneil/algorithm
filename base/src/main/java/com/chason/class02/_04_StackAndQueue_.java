package com.chason.class02;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 1. 只用栈实现队列
 * 2. 只用队列结构实现栈
 *
 */
public class _04_StackAndQueue_ {

    /**
     * 两个队列
     */

    static class QueueToStack {

        LinkedList<Integer> data = new LinkedList<>();
        LinkedList<Integer> help  =new LinkedList<>();

        public void put (int value) {
            data.offer(value);
        }

        public int pop () {

            while (data.size() != 1) {
                help.offer(data.poll());
            }

            int res = data.poll();
            LinkedList<Integer> tmp;
            tmp = data;
            data = help;
            help = tmp;
            return res;
        }
    }


    static class StackToQueue {

        Stack<Integer> push;
        Stack<Integer> pop;

        public StackToQueue () {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void offer (int value) {
            push.push(value);
            pushToPop();
        }

        public int poll () {
            int res = pop.pop();
            pushToPop();
            return res;
        }

        /*
        倒数据有两个原则： 1.pop栈为空才能倒数据
        2. 要倒就全部倒，不能只倒部分数据
         */
        private void pushToPop() {
            if (pop.empty()) {
                while(!push.empty()) {
                    pop.push(push.pop());
                }
            }

        }

        public static void main(String[] args) {


            QueueToStack stack = new QueueToStack();
            stack.put(1);
            stack.put(2);
            stack.put(3);

            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        }

    }

}
