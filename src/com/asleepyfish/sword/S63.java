package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-23 21:31
 * @Description: 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 限制：
 * 0 <= 数组长度 <= 10^5
 */
public class S63 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > res) {
                    res = prices[j] - prices[i];
                }
            }
        }
        return Math.max(res, 0);
    }

    public static int maxProfit2(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if ((prices[i] - min) > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

    // 前i日的最大收益等于（前i - 1日的最大收益）和（第i日的价格和前i - 1日中最小价格的差值）中最大值，需要保存一下最小价格min
    // dp[i]=max(dp[i−1],prices[i]−min(min,prices[i])
    public static int maxProfit3(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
