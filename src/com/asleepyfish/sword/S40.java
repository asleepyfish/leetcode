package com.asleepyfish.sword;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-06 23:19
 * @Description: 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 */
public class S40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        quickSort(arr, 0, arr.length - 1);
        /*int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;*/
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int pivot = arr[low];
        while (i < j) {
            while (i < j && pivot <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        quickSort(arr, low, i - 1);
        quickSort(arr, j + 1, high);
    }

    /**
     * 大根堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        // 排除 0 的情况
        if (k == 0) {
            return res;
        }
        // 大根堆
        Queue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        // 先把前k个数加进大根堆
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        // 后续的数字中如果有比最大值（根）还小的，加进去，把根弹出
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
