package com.asleepyfish.array.easy;

import java.util.Arrays;

/**
 * @Author: asleepyfish
 * @Date: 2022-05-17 22:47
 * @Description: 多数元素
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1：
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class No169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int votes = 0;
        int res = 0;
        for (int num : nums) {
            if (votes == 0) {
                res = num;
            }
            votes += res == num ? 1 : -1;
        }
        return res;
    }
}
