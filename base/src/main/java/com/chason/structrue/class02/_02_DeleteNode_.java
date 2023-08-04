package com.chason.structrue.class02;

import com.chason.structrue.base.Node;

/**
 * 删除单链表中给定的值
 */
public class _02_DeleteNode_ {


    /**
     * 删除链表中的节点可能会换头
     * @return
     */
    public static Node deleteNode (Node head, int number) {

        if (head == null) {
            return head;
        }

        // 头节点的处理  处理完head
        while (head != null) {
            if (head.value != number) {
                break;
            }
            head = head.next;
        }

        // 删除链表中的元素

        Node prev = new Node(-1);
        Node curr = head;

        while (curr != null) {

            if (curr.value != number) {
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return head;
    }


}
