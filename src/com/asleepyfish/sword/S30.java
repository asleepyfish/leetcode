package com.asleepyfish.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-13 22:26
 * @Description: 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 */
public class S30 {
    /**
     * initialize your data structure here.
     */
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public S30() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x < stack2.peek()) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (Objects.equals(stack1.peek(), stack2.peek())) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
