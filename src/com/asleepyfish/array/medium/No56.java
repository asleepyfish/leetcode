package com.asleepyfish.array.medium;

/**
 * @Author: asleepyfish
 * @Date: 2022-05-18 22:02
 * @Description: 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class No56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int min = intervals[0][0];
        int max = intervals[0][1];
        int[][] res = new int[len][2];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= max) {
                max = Math.max(max, intervals[i][1]);
            } else {
                res[index][0] = min;
                res[index][1] = max;
                min = intervals[i][0];
                max = intervals[i][1];
                index++;
            }
        }
        res[index][0] = min;
        res[index][1] = max;
        return Arrays.copyOf(res, index + 1);
    }
}
