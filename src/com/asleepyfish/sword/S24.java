package com.asleepyfish.sword;

import com.asleepyfish.ListNode;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-14 21:27
 * @Description: 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class S24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = res;
            res = head;
            head = tmp;
        }
        return res;
    }
}
