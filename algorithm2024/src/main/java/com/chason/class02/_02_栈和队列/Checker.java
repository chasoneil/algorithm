package com.chason.class02._02_栈和队列;


import org.junit.Test;

public class Checker {

    @Test
    public void testStackByLinked () {

        int size = 10;
        int range = 10;
        StackAndQueueByLinked.MyStack stack = new StackAndQueueByLinked.MyStack();

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

        StackAndQueueByLinked.MyQueue queue = new StackAndQueueByLinked.MyQueue();

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
        StackAndQueueByArray.MyStack stack = new StackAndQueueByArray.MyStack(size);

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

        StackGetMin stackGetMin = new StackGetMin();
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

        StackAndQueueTransfer.MyStack stack = new StackAndQueueTransfer.MyStack();

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

        StackAndQueueTransfer.MyQueue queue = new StackAndQueueTransfer.MyQueue();

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
