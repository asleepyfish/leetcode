package com.asleepyfish.sword;

import com.asleepyfish.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-21 22:16
 * @Description: 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。nums
 * numsnums
 * 例如:
 * 给定二叉树:nums[3,9,20,null,null,15,7],nums
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：nums
 * [3,9,20,15,7]
 * numsnums
 * 提示：nums
 * 节点总数 <= 1000nums
 */
public class S32I {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        // 因为不知道最后返回的数组的大小，使用list暂存一下
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
