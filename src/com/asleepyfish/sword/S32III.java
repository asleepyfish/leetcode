package com.asleepyfish.sword;

import com.asleepyfish.TreeNode;

import java.util.*;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-21 22:18
 * @Description: 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。nums
 * numsnums
 * 例如:
 * 给定二叉树:nums[3,9,20,null,null,15,7],nums
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：nums
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * numsnums
 * 提示：nums
 * 节点总数 <= 1000nums
 */
public class S32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int queueSize = queue.size();
            int listSize = res.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (listSize % 2 == 0) {
                Collections.reverse(list);
            }
            res.add(list);

        }
        return res;
    }
}
