package com.chason.structrue.class06;

import com.chason.structrue.class02.Node;
import com.chason.structrue.class04.Utils;

/**
 * 在链表上玩荷兰国旗问题
 */
public class _03_LinkedDutchFlag_ {

    /**
     * 准备一个数组，遍历一遍链表将链表的数都放到数组中 玩partition
     * 玩好了之后，将数组中的数重新组织成链表返回
     * @param head
     * @param number
     * @return
     */
    public static Node partition1 (Node head, int number) {

        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int[] arr = new int[count];

        // 遍历一遍放数组
        curr = head;
        int index = 0;
        while (curr != null) {
            arr[index++] = curr.value;
            curr = curr.next;
        }

        // 在数组中玩partition
        partition(arr, 0, arr.length-1, number);

        // 将数组重新串成链表
        Node newHead = new Node(arr[0]);
        curr = newHead;
        for (int i=1; i<arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

        return newHead;
    }

    /**
     * #todo
     * 使用  六个变量 时间复杂度 O(N) 实现上述功能
     * @return
     */
    public static Node partition2 () {
        return null;
    }


    // 在数组 arr  L...R 上玩partition
    public static void partition(int[] arr, int L, int R, int target) {

        if (L >= R) {
            return;
        }

        int leftRange = L - 1;
        int rightRange = R + 1;

        int index = 0;
        while (index < rightRange) {
            if (arr[index] < target) {
                Utils.swap(arr, leftRange + 1, index);
                index++;
                leftRange++;
            } else if (arr[index] > target) {
                Utils.swap(arr, index, rightRange - 1);
                rightRange--;
            } else {
                index++;
            }
        }

    }




    public static void main(String[] args) {

        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(8);

        Utils.printLinkedList(partition1(head, 3));


    }

}
