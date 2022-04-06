package com.asleepyfish.sword;

import java.util.Arrays;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-05 16:54
 * @Description: 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class S45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    private void quickSort(String[] strs, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        String pivot = strs[low];
        while (i < j) {
            while (i < j && (strs[j] + pivot).compareTo(pivot + strs[j]) >= 0) {
                j--;
            }
            strs[i] = strs[j];
            while (i < j && (strs[i] + pivot).compareTo(pivot + strs[i]) <= 0) {
                i++;
            }
            strs[j] = strs[i];
        }
        strs[i] = pivot;
        quickSort(strs, low, i - 1);
        quickSort(strs, j + 1, high);
    }
}
