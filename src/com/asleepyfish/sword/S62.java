package com.asleepyfish.sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-23 22:54
 * @Description: 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出:3
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出:2
 * 限制：
 * 1 <= n<= 10^5
 * 1 <= m <= 10^6
 */
public class S62 {
    public int lastRemaining(int n, int m) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            if (n - 1 - index > 0) {
                System.arraycopy(arr, index + 1, arr, index, n - 1 - index);
            }
            arr = Arrays.copyOf(arr, --n);
        }
        return arr[0];
    }

    public int lastRemaining2(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 然后我们从最后剩下的 3 倒着看，我们可以反向推出这个数字在之前每个轮次的位置。
     * 最后剩下的 3 的下标是 0。
     * 第四轮反推，补上 m 个位置，然后模上当时的数组大小 2，位置是(0 + 3) % 2 = 1。
     * 第三轮反推，补上 m 个位置，然后模上当时的数组大小 3，位置是(1 + 3) % 3 = 1。
     * 第二轮反推，补上 m 个位置，然后模上当时的数组大小 4，位置是(1 + 3) % 4 = 0。
     * 第一轮反推，补上 m 个位置，然后模上当时的数组大小 5，位置是(0 + 3) % 5 = 3。
     * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
     * 总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
     * <p>
     * 就是反向推导最后的结果最初开始的位置
     */
    public int lastRemaining3(int n, int m) {
        // 最后面剩下的数字的下标为0,只有一个数字了
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public int lastRemaining4(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}
