package com.asleepyfish.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: asleepyfish
 * @Date: 2022-04-13 23:17
 * @Description: 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class S17 {
    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers2(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!"0".equals(s)) {
                res[count++] = Integer.parseInt(s);
            }
            if (n - start == nine) {
                start--;
            }
            return;
        }
        for (char i : loop) {
            if (i == '9') {
                nine++;
            }
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    public int[] printNumbers3(int n) {
        int[] ans = new int[(int) (Math.pow(10, n)) - 1];
        Queue<String> q = new LinkedList<>();
        //将1~9加入队列
        for (int i = 1; i <= 9; i++) {
            q.offer(String.valueOf(i));
        }
        int index = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //将队列中的元素依次取出并加入答案
                String str = q.poll();
                ans[index++] = Integer.parseInt(str);
                //若当前元素长度不够n，则在末尾补充0~9，继续加入队列
                if (str.length() < n) {
                    for (int j = 0; j <= 9; j++) {
                        q.offer(str + j);
                    }
                }
            }
        }
        return ans;
    }
}