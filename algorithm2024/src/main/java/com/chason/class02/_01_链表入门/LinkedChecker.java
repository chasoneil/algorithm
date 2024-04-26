package com.chason.class02._01_链表入门;


import com.chason.class02.base.DoubleNode;
import com.chason.class02.base.Node;
import com.chason.utils.LinkedUtils;
import org.junit.Test;

public class LinkedChecker {

    // 测试反转单链表
    @Test
    public void testReverseNode () {

        Node head = LinkedUtils.buildRandomNode(10, 10);
        LinkedUtils.printNode(head);
        System.out.println();
        Node newHead = Linked.reverseNode(head);
        LinkedUtils.printNode(newHead);
    }

    @Test
    public void testReverseDoubleNode () {

        DoubleNode head = LinkedUtils.buildRandomDoubleNode(10, 10);
        LinkedUtils.printDoubleNode(head);
        System.out.println();
        DoubleNode newHead = Linked.reverseDoubleNode(head);
        LinkedUtils.printDoubleNode(newHead);

    }

    @Test
    public void testRemoveNode () {

        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i=0; i<testTime; i++) {
            Node head = LinkedUtils.buildRandomNode(maxSize, maxValue);
            int randomTarget = (int)(Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            Node head1 = Linked.removeNode(head, randomTarget);
            if (Linked.checkTargetExist(head1, randomTarget)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice~" : "Shit!");

    }




}
