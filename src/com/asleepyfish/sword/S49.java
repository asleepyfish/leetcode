package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-21 20:52
 * @Description: 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * 1是丑数。
 * n不超过1690。
 */
public class S49 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("第" + i + "个丑数是：" + nthUglyNumber(i));
        }
    }
    public static int nthUglyNumber(int n) {
        // 使用dp数组来存储丑数序列
        int[] dp = new int[n];
        // dp[0]已知为1
        dp[0] = 1;
        // 下个应该通过乘2来获得新丑数的数据是第a个， 同理b, c
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                // 第a个数已经通过乘2得到了一个新的丑数，那下个需要通过乘2得到一个新的丑数的数应该是第(a+1)个数
                a++;
            }
            if (dp[i] == n3) {
                // 第b个数已经通过乘3得到了一个新的丑数，那下个需要通过乘3得到一个新的丑数的数应该是第(b+1)个数
                b++;
            }
            if (dp[i] == n5) {
                // 第c个数已经通过乘5得到了一个新的丑数，那下个需要通过乘5得到一个新的丑数的数应该是第(c+1)个数
                c++;
            }
        }
        return dp[n - 1];
    }
}
