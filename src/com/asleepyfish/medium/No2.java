package com.asleepyfish.medium;

import com.asleepyfish.ListNode;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-09 20:47
 * @Description: 两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class No2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode p2 = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);
        ListNode res = addTwoNumbers(p1, p2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode p = res;
        int high = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val;
            int low = (tmp + high) % 10;
            high = (tmp + high) / 10;
            p.next = new ListNode(low);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        while (l1 != null) {
            p.next = new ListNode((high + l1.val) % 10);
            high = (high + l1.val) / 10;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = new ListNode((high + l2.val) % 10);
            high = (high + l2.val) / 10;
            l2 = l2.next;
            p = p.next;
        }
        if (high != 0) {
            p.next = new ListNode(high);
        }
        return res.next;
    }
}
