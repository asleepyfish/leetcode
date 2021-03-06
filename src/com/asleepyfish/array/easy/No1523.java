package com.asleepyfish.array.easy;

/**
 * @Author: asleepyfish
 * @Date: 2022-05-17 22:49
 * @Description: 在区间范围内统计奇数数目
 * 给你两个非负整数low 和high。请你返回low 和high之间（包括二者）奇数的数目。
 * 示例 1：
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * 提示：
 * 0 <= low <= high<= 10^9
 */
public class No1523 {
    public int countOdds(int low, int high) {
        return isEven(low) && isEven(high) ? (high - low) / 2 : (high - low) / 2 + 1;
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
