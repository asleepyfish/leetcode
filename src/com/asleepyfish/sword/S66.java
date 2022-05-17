package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-23 22:56
 * @Description: 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class S66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            int tmp = 1;
            for (int j = 0; j < res.length; j++) {
                if (j == i) {
                    continue;
                }
                tmp *= a[j];
            }
            res[i] = tmp;
        }
        return res;
    }

    public int[] constructArr2(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i <= a.length - 1; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
