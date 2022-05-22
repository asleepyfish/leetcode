package com.asleepyfish.array.structure;

import java.util.List;

/**
 * @Author: asleepyfish
 * @Date: 2022-05-22 21:54
 * @Description: TODO
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
