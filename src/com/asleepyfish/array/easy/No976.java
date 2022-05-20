package com.asleepyfish.array.easy;

import java.util.Arrays;

/**
 * @Author: asleepyfish
 * @Date: 2022-05-19 21:38
 * @Description: 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 nums，返回 由其中三个长度组成的、面积不为零的三角形的最大周长。如果不能形成任何面积不为零的三角形，返回0。
 * 示例 1：
 * 输入：nums = [2,1,2]
 * 输出：5
 * 示例 2：
 * 输入：nums = [1,2,1]
 * 输出：0
 * 提示：
 * 3 <= nums.length <= 104
 * 1 <= nums[i] <= 106
 */
public class No976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[j] + nums[k] > nums[i]) {
                        return nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return 0;
    }

    public int largestPerimeter2(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            // 这一步里面如果num[i - 2] + nums[i - 1]都不大于nums[i]，更没必要比较前面的了，因为排序过了
            if (nums[i- 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
