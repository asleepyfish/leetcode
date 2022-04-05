package com.asleepyfish;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-05 16:14
 * @Description: TODO
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
