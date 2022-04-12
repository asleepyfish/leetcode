package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-11 21:14
 * @Description: 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * 提示：
 * 数组长度 <= 1000
 */
public class S33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int i = start;
        while (i < end) {
            if (postorder[i] > root) {
                break;
            }
            i++;
        }
        int j = i;
        while (j < end) {
            if (postorder[j] < root) {
                return false;
            }
            j++;
        }
        return verifyPostorder(postorder, start, i - 1) && verifyPostorder(postorder, i, end - 1);
    }
}
