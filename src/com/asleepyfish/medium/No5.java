package com.asleepyfish.medium;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-10 22:00
 * @Description: 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No5 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int longest = 1;
        String res = "";
        int left = 0;
        while (left < s.length()) {
            // if (s.substring())
        }
        return null;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
