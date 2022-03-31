package com.asleepyfish.sword;

import com.asleepyfish.ListNode;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-30 21:59
 * @Description: 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class S25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = l2;
                break;
            }
            if (l2 == null) {
                tmp.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        return res.next;
    }
}
