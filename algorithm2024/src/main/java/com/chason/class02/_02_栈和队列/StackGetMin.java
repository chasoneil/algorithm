package com.chason.class02._02_栈和队列;

import java.util.Stack;

/**
 * 可以使用栈的原生方法 pop push 实现一个方法 getMin()
 * 要求在任何时候都可以通过 getMin() 方法获取最小值
 * 要求getMin() 方法的时间复杂度为 O(1)
 */
public class StackGetMin {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    public void push (int value) {

        stack.push(value);

        if (min.size() == 0) {
            min.push(value);
        } else {
            min.push(min.peek() > value ? value : min.peek());
        }
    }

    public int pop () {

        if (stack.size() == 0) {
            throw new RuntimeException("Stack is empty");
        }

        int value = stack.pop();
        min.pop();
        return value;
    }

    public int getMin () {

        if (min.size() == 0) {
            throw new RuntimeException("Stack is empty");
        }

        return min.peek();
    }

}
