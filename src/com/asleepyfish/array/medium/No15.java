package com.asleepyfish.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: asleepyfish
 * @Date: 2022-05-17 22:47
 * @Description: 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!flag && nums[i] == 0 && nums[j] == 0) {
                            res.add(tmp);
                            flag = true;
                            break;
                        }
                        if (!contains(res, tmp)) {
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean contains(List<List<Integer>> main, List<Integer> sub) {
        for (List<Integer> list : main) {
            if (list.containsAll(sub)) {
                return true;
            }
        }
        return false;
    }
}
