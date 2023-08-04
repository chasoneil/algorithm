package com.chason.structrue.class06;

import com.chason.structrue.base.Node;

import java.util.Stack;

/**
 * 判断单链表是不是回文结构
 */
public class _02_Palindrome_ {

    /**
     * 最常规的方法 :
     * 使用一个栈，将链表的节点依次放到栈中
     * 再从迭代弹出，互相比较，如果出现不等就不是回文，全部相等那就是回文
     * 额外空间复杂度 O(N)
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Stack<Node> stack = new Stack<>();

        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {  // 压栈结束开始比较
            if (cur.value != stack.pop().value) {
                return false;
            }
        }

        return true;
    }

    /**
     * #todo
     * 使用 一半的空间 完成上面的操作
     * 要求额外空间复杂度 是上面的一半
     *
     * 使用快慢指针，奇数定位到中点，偶数定位到上中点
     * 从中点的位置压栈到结束
     * 从头开始比，比一个出栈一个， 使用一半的空间
     *
     * @return
     */
    public static boolean isPalindrome2 () {
        return false;
    }

    /**
     * #todo
     * 空间复杂度 O(1)
     * 使用快慢指针定位到中点，将中点后面的链表逆序
     * 从左右两边走开始比较
     * 结束之后将逆序的链表返回回去
     * @return
     */
    public static boolean isPalindrome3 () {
        return false;
    }

}
