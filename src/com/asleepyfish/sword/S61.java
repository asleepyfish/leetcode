package com.asleepyfish.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-05 16:55
 * @Description: 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 */
public class S61 {
    /**
     * 1.无重复的牌
     * 2.最大牌减去最小牌 < 5 (除去大小王)
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int num : nums) {
            // 例子：0 0 1 2 5 不是，如不加这一句，最小是0，最大是5
            if (num == 0) {
                continue;
            }
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (set.contains(num)) {
                return false;
            }
        }
        return max - min < 5;
    }

    public boolean isStraight2(int[] nums) {
        int joker = 0;
        // 数组排序
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                // 统计大小王数量
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                // 若有重复，提前返回 false
                return false;
            }
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }
}
