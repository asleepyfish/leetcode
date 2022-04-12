package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-11 21:12
 * @Description: 数值的整数次方
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 * 提示：
 * -100.0 <x< 100.0
 * -2^31<= n <=2^31-1
 * -10^4<= x^n<= 10^4
 */
public class S16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int times = n > 0 ? n : -n;
        double res = 1;
        for (int i = 0; i < times; i++) {
            res *= x;
        }
        return n > 0 ? res : 1 / res;
    }

    public double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        double res = 1.0;
        while (m > 0) {
            if ((m & 1) == 1) {
                res *= x;
            }
            x *= x;
            m >>= 1;
        }
        return res;
    }
}
