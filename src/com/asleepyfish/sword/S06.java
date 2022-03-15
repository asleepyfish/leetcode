package com.asleepyfish.sword;

import com.asleepyfish.ListNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
        System.out.println(Arrays.toString(reversePrint2(x)));
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // 使用指针p用来逆转
        ListNode p = null;
        int len = 0;
        while (head != null) {
            // 记录长度
            len++;
            // 记录head的下一个避免等会被覆盖
            ListNode tmp = head.next;
            head.next = p;
            p = head;
            head = tmp;
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

    public static int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
