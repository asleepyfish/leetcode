package com.asleepyfish.sword;

import com.asleepyfish.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-21 22:17
 * @Description: 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。nums
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
 * [9,20],
 * [15,7]
 * ]
 * numsnums
 * 提示：nums
 * 节点总数 <= 1000nums
 */
public class S32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 这里需要注意如果for循环中使用queue.size()直接用，因为不断往queue中放，queue的长度会增加。倒序的话可以
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
