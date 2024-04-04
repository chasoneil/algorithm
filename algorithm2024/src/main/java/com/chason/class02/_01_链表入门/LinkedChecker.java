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

        Node head1 = LinkedUtils.buildRandomNode(10, 10);
        int randomTarget = (int)(Math.random() * (10 + 1)) - (int) (Math.random() * (10 + 1));
        LinkedUtils.printNode(head1);
        System.out.println();
        System.out.println("target:" + randomTarget);
        Node head2 = Linked.removeNode(head1, randomTarget);
        LinkedUtils.printNode(head2);
    }

}
