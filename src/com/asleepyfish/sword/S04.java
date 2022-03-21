package com.asleepyfish.sword;

/**
 * @Author: zhoujh42045
 * @Date: 2022/3/17 19:58
 * @Description: 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class S04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //空数组判断
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        // 指向当前m行
        int i = 0;
        // 指向最大列
        int j = n;
        while (i <= m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int i = row;
        int j = 0;
        while (i >= 0 && j <= col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
