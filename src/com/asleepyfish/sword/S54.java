package com.asleepyfish.sword;

import com.asleepyfish.TreeNode;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-05 16:52
 * @Description: 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class S54 {
    StringBuilder sb = new StringBuilder();
    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return Integer.parseInt(sb.toString().split("-")[sb.toString().split("-").length - k]);
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        sb.append(cur.val).append("-");
        dfs(cur.right);
    }

    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs2(root);
        return res;
    }

    private void dfs2(TreeNode cur) {
        if (cur == null || k == 0) {
            return;
        }
        dfs(cur.right);
        if (--k == 0) {
            res = cur.val;
        }
        dfs(cur.left);
    }
}
