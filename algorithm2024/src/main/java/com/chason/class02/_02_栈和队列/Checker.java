package com.chason.class02._02_栈和队列;


import com.chason.class02._02_栈和队列._01_StackAndQueue;
import com.chason.class02._02_栈和队列._02_StackAndQueue;
import com.chason.class02._02_栈和队列._03_StackGetMin;
import com.chason.class02._02_栈和队列._04_StackAndQueueTransfer;
import org.junit.Test;

public class Checker {

    @Test
    public void testStackByLinked () {

        int size = 10;
        int range = 10;
        _01_StackAndQueue.MyStack stack = new _01_StackAndQueue.MyStack();

        System.out.print("push:[");
        for (int i=0; i<size; i++) {
            int randomNumber = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
            stack.push(randomNumber);
            System.out.print(randomNumber);
            if (i != size-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();

        System.out.print(" pop:[");
        for (int i=0; i<size; i++) {
            System.out.print(stack.pop());
            if (i != size - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    @Test
    public void testQueueByLinked () {
        int size = 10;
        int range = 10;

        _01_StackAndQueue.MyQueue queue = new _01_StackAndQueue.MyQueue();

        System.out.print("push:[");
        for (int i=0; i<size; i++) {
            int randomNumber = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
            queue.add(randomNumber);
            System.out.print(randomNumber);
            if (i != size-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();

        System.out.print("poll:[");

        for (int i=0; i<size; i++) {

            System.out.print(queue.poll());
            if (i != size -1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }


    @Test
    public void testStackByArray () {

        int size = 10;
        int range = 10;
        _02_StackAndQueue.MyStack stack = new _02_StackAndQueue.MyStack(size);

        System.out.print("push:[");
        for (int i=0; i<size; i++) {
            int randomNumber = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
            stack.push(randomNumber);
            System.out.print(randomNumber);
            if (i != size-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();

        System.out.print(" pop:[");
        for (int i=0; i<size; i++) {
            System.out.print(stack.pop());
            if (i != size - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    @Test
    public void testStackGetMin () {

        _03_StackGetMin stackGetMin = new _03_StackGetMin();
        System.out.print("push:");
        for (int i=0; i<10; i++) {
            int random = (int) (Math.random() * 6) - (int) (Math.random() * 6);  // [-5, 5]
            stackGetMin.push(random);
            System.out.print(random);
            if (i != 9) {
                System.out.print(",");
            }
        }
        System.out.println();

        for (int i=0; i<10; i++) {
            System.out.print(" pop:" + stackGetMin.pop());
            System.out.println(" min:" + stackGetMin.getMin());
        }

    }

    @Test
    public void testQueueBuildStack () {

        _04_StackAndQueueTransfer.MyStack stack = new _04_StackAndQueueTransfer.MyStack();

        System.out.print("push:");
        for (int i=0; i<10; i++) {
            int random = (int) (Math.random() * 6) - (int) (Math.random() * 6);  // [-5, 5]
            stack.push(random);
            System.out.print(random + " ");
        }
        System.out.println();

        System.out.print(" pop:");
        for (int i=0; i<11; i++) {
            System.out.print(stack.pop() + " ");
        }

    }

    @Test
    public void testStackBuildQueue () {

        _04_StackAndQueueTransfer.MyQueue queue = new _04_StackAndQueueTransfer.MyQueue();

        System.out.print("push:");
        for (int i=0; i<10; i++) {
            int random = (int) (Math.random() * 6) - (int) (Math.random() * 6);  // [-5, 5]
            queue.add(random);
            System.out.print(random + " ");
        }
        System.out.println();

        System.out.print(" pop:");
        for (int i=0; i<10; i++) {
            System.out.print(queue.poll() + " ");
        }

    }


}
