package com.asleepyfish.sword;

import java.util.Arrays;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-23 22:53
 * @Description: n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * 限制：
 * 1 <= n <= 11
 */
public class S60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            // 这一步循环表示前i - 1步得到的概率
            for (int j = 0; j < dp.length; j++) {
                // 这步循环表示这次的骰子可以取1-6
                for (int k = 0; k < 6; k++) {
                    // 本次的概率受到上一步（i - 1）也就是dp[j]的影响
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public double[] dicesProbability2(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        // i表示投掷多少颗骰子
        for (int i = 2; i <= n; i++) {
            // i = 2时候，j从2开始到12结束，共11中可能出现的数字
            for (int j = i; j <= 6 * i; j++) {
                // 新加入的骰子的可能范围是1-6，但是k需要小于j保证j - k > 0。这样可以按照前i - 1步的数字得出结果
                for (int k = 1; k <= 6 && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] ans = new double[6 * n - n + 1];
        // i从n 到6n就是骰子可能取到的所有数字
        for (int i = n; i <= 6 * n; i++) {
            // 从0开始，dp[n][6n]为n个骰子，投处数字为6n的概率
            ans[i - n] = ((double) dp[n][i]) / (Math.pow(6, n));
        }
        return ans;
    }
}
