package com.asleepyfish.sword;

import com.asleepyfish.TreeNode;

import java.util.Stack;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-22 21:37
 * @Description: 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 * 4
 * /  \
 * 2   7
 * / \  / \
 * 1  3 6  9
 * 镜像输出：
 * 4
 * /  \
 * 7   2
 * / \  / \
 * 9  6 3 1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 限制：
 * 0 <= 节点个数 <= 1000
 */
public class S27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 在递归右子节点 “root.left = mirrorTree(root.right);root.left=mirrorTree(root.right);”
        // 执行完毕后， root.leftroot.left 的值已经发生改变，此时递归左子节点 mirrorTree(root.left)mirrorTree(root.left) 则会出问题。
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
