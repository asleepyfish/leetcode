package com.asleepyfish.sword;

import com.asleepyfish.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-05 15:29
 * @Description: 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class S34 {
    /**
     * 用来存储结果
     */
    private final List<List<Integer>> res = new ArrayList<>();
    /**
     * 用来存贮路径
     * (先不向上转型，要使用LinkedList的API)
     * 你也可以使用 双端队列Deque
     * 但是Deque不能直接被list加入，需要调用 list.add(new ArrayList(deque));
     * 通过构造方法添加
     */
    private final LinkedList<Integer> path = new LinkedList<>();

    /**
     * 方案一： 这道题想都不用想，肯定DFS，深度搜索优先
     * 从根节点出发，到叶子节点返回
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        // 递归截至条件
        if (root == null) {
            return;
        }
        // 减去当前node的值，并加入路径
        target -= root.val;
        path.add(root.val);
        // 题目必须要求，必须是叶子节点才行
        // 查看当前target消耗后是否为0，如果为0加入到结果中
        if (root.left == null && root.right == null && target == 0) {
            // 细节：为什么我要通过构造方法传入path，不能直接res.add(path)
            // 因为直接加入，加入的是引用(指向的堆中数据会变化)，需要克隆一份加入
            res.add(new LinkedList<>(path));
            // 细节：找到后不能直接return，需要在path中移除最后一个元素，
            // 因为，即使你到根节点找到或找不到，该节点不能影响其他搜索
        }
        dfs(root.left, target);
        dfs(root.right, target);
        // 将本次搜索结果移除，方便其他搜索使用path变量
        path.removeLast();
    }
}
