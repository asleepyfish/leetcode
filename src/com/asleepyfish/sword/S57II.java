package com.asleepyfish.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-14 22:32
 * @Description: 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 限制：
 * 1 <= target <= 10^5
 */
public class S57II {
    public int[][] findContinuousSequence(int target) {
        if (target == 1) {
            return new int[0][0];
        }
        int[][] res;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            double tmp = (-1 + Math.sqrt(1 + 4 * ((long) i * i - i + 2L * target))) / 2;
            if (tmp % 1 == 0 && tmp > i && tmp < target) {
                int[] generate = generate(i, (int) tmp);
                list.add(generate);
            }
        }
        res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int[] generate(int i, int j) {
        int[] res = new int[j - i + 1];
        for (int k = 0; k < res.length; k++) {
            res[k] = i++;
        }
        return res;
    }

    public int[][] findContinuousSequence2(int target) {
        int left = 1;
        int right = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();
        while (left <= target / 2) {
            if (sum == target) {
                int[] generate = generate(left, right);
                res.add(generate);
            }
            if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
