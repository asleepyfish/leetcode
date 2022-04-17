package com.asleepyfish.sword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-14 22:31
 * @Description: 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 限制：
 * 1 <= 数组长度 <= 50000
 */
public class S39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.toList()).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int res = nums[0];
        int max = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = Math.toIntExact(entry.getValue());
                res = entry.getKey();
            }
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = nums[0];
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement4(int[] nums) {
        int votes = 0;
        // 众数
        int res = 0;
        for (int num : nums) {
            if (votes == 0) {
                res = num;
            }
            votes += num == res ? 1 : -1;
        }
        return res;
    }
}
