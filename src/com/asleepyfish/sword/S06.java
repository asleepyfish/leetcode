package com.asleepyfish.sword;

import com.asleepyfish.ListNode;

import java.util.Arrays;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-14 21:25
 * @Description: 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
public class S06 {
    public static void main(String[] args) {
        ListNode x = new ListNode(2);
        x.next = new ListNode(1);
        x.next.next = new ListNode(3);
        System.out.println(Arrays.toString(reversePrint(x)));
    }

    public static int[] reversePrint(ListNode head) {
        ListNode p = new ListNode(head.val);
        ListNode q = head.next;
        int len = 1;
        while (q != null) {
            len++;
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        int[] res = new int[len];
        int j = 0;
        while (p != null) {
            res[j] = p.val;
            j++;
            p = p.next;
        }
        return res;
    }
}
