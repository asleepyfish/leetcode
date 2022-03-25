package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-23 21:30
 * @Description: 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * 提示：
 * 0 <= n <= 100
 */
public class S10II {
    public static void main(String[] args) {
        System.out.println(numWays(7));
        System.out.println(numWays2(7));
    }
    public static int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
    }

    public static int numWays2(int n) {
        if (n < 2) {
            return 1;
        }
        int fast = 1;
        int slow = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (fast + slow) % 1000000007;
            slow = fast;
            fast = res;
        }
        return res;
    }
}
