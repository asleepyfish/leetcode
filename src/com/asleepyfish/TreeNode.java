package com.asleepyfish;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-21 22:15
 * @Description: TODO
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
