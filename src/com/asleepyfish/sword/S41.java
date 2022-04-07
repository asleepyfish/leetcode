package com.asleepyfish.sword;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-06 23:20
 * @Description: 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * 限制：
 * 最多会对addNum、findMedian 进行50000次调用。
 */
public class S41 {
    /**
     * initialize your data structure here.
     */
    Queue<Integer> A, B;
    // List<Integer> list;

    public S41() {
        // list = new ArrayList<>();
        // 奇数时候，小顶堆多存一个，偶数时候存一样多
        // 小顶堆，保存较大的一半
        A = new PriorityQueue<>();
        // 大顶堆，保存较小的一半
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        // list.add(num);
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        /*list = list.stream().sorted().collect(Collectors.toList());
        return (list.size() % 2 == 1) ? (double) list.get(list.size() / 2) : (double) (list.get(list.size() / 2) + list.get((list.size() - 1) / 2)) / 2;*/
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;

    }

    public static void main(String[] args) {
        S41 s41 = new S41();
        s41.addNum(2);
        System.out.println(s41.findMedian());
        s41.addNum(5);
        System.out.println(s41.findMedian());
        s41.addNum(3);
        System.out.println(s41.findMedian());
        System.out.println((double) (2 + 5) / 2);
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
