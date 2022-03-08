package com.asleepyfish.easy;


import com.asleepyfish.ListNode;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-07 22:35
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode();
        list1.next.val = 3;
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode();
        list2.next.val = 4;
        ListNode listNode = mergeTwoLists2(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = new ListNode(-1);
        ListNode q = p;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                q.next = list1;
                list1 = list1.next;
            } else {
                q.next = list2;
                list2 = list2.next;
            }
            q = q.next;
        }
        q.next = list1 == null ? list2 : list1;
        return p.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res;
        if (list1.val <= list2.val) {
            res = list1;
            res.next = mergeTwoLists(list1.next, list2);
        } else {
            res = list2;
            res.next = mergeTwoLists(list1, list2.next);
        }
        return res;
    }
}
