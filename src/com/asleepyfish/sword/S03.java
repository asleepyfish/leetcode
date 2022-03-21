package com.asleepyfish.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-16 22:38
 * @Description: 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 */
public class S03 {
    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (arr[num] > 0) {
                return num;
            }
            arr[num]++;
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            // set.add()返回值是bool类型的可以用来判断是否添加成功
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
