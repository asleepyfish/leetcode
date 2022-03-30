package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-28 21:04
 * @Description: 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 提示：
 * 0 <= num < 2^31
 */
public class S46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) {
            return 1;
        }
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 0;
        dp[s.length() - 1] = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            int tmp = 0;
            int value = Integer.parseInt(s.substring(i, i + 2));
            if (value >= 0 && value <= 25) {
                tmp = 1;
            }
            dp[i] = dp[i + 1] + dp[i + 2] * tmp;
        }
        return dp[0];
    }

    /**
     * dp[i]={dp[i−1]+dp[i−2] ，当i-1和i位在10到25之间
     * dp[i−1]
     *
     * @param num
     * @return
     */
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = s.substring(0, 2).compareTo("10") >= 0 && s.substring(0, 2).compareTo("25") <= 0 ? 2 : 1;
        for (int i = 2; i < s.length(); i++) {
            int tmp = s.substring(i - 1, i + 1).compareTo("10") >= 0 && s.substring(i - 1, i + 1).compareTo("25") <= 0 ? 1 : 0;
            dp[i] = dp[i - 1] + dp[i - 2] * tmp;
        }
        return dp[s.length() - 1];
    }
}
