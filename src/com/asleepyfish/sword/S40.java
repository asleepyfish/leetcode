package com.asleepyfish.sword;

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
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
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
}
