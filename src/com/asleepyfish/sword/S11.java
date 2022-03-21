package com.asleepyfish.sword;

/**
 * @Author: zhoujh42045
 * @Date: 2022/3/17 19:59
 * @Description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class S11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
                break;
            }
        }
        return min;
    }

    public int minArray2(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        return binarySearch(numbers, numbers[0]);
    }

    private int binarySearch(int[] numbers, int min) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 当中间节点小于最小值时，记录一下，并且最小值只可能在左侧（包含，可能当前值为最小值），令right = mid
            if (numbers[mid] < min) {
                min = numbers[mid];
                right = mid;
            } else {
                // 中间节点大于等于最小值时候，最小值一定在右边
                left = mid + 1;
            }
        }
        return min;
    }
}
