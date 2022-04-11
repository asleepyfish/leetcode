package com.asleepyfish.sword;

import com.asleepyfish.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-11 21:08
 * @Description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class S07 {
    private final Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        int inorderRoot = map.get(preorder[preorderLeft]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int targetRootIndex = 0;
        for (int i = 0; i < len; i++) {
            if (inorder[i] == preorder[0]) {
                targetRootIndex = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, targetRootIndex + 1), Arrays.copyOfRange(inorder, 0, targetRootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, targetRootIndex + 1, len), Arrays.copyOfRange(inorder, targetRootIndex + 1, len));
        return root;
    }
}
