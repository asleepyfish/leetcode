package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-16 22:39
 * @Description: 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 */
public class S53I {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        int res = 0;
        for (int num : nums) {
            if (target < num) {
                break;
            }
            if (target == num) {
                res++;
            }
        }
        return res;
    }
}
