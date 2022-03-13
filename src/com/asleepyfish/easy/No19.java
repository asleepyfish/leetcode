package com.asleepyfish.easy;


/**
 * @Author: asleepyfish
 * @Date: 2022-03-06 22:46
 * @Description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class No19 {
    /**
     * 一个个比，第一个和第二个求出最短前缀，接着往后
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "flower";
        strs[1] = "flow";
        strs[2] = "flight";
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(ans)) {
                //公共前缀不匹配就让它变短！
                ans = ans.substring(0, ans.length() - 1);
            }
        }
        return ans;
    }
}