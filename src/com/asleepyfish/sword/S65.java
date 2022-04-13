package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-12 22:16
 * @Description: 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * 提示：
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 */
public class S65 {
    public int add(int a, int b) {
        /*while (b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;*/
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
