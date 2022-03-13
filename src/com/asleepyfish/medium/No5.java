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
    /**
     * 使用动态规划或者中心扩散法解决本题
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(test("babad"));
    }

    public static String test(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int begin = 0;
        int end = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i  > end - begin) {
                    begin = i;
                    end = j;
                }
            }
        }
        return s.substring(begin, end + 1);
    }
    /**
     * 动态规划（从外向里）
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        // 特殊用例判断
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 把字符串小于0的先判断完，剩下的字符串中第一个字母一定是回文
        int maxLen = 1;
        // 定义起始点
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        // 初始化数组为false，为了逻辑上的正确性，单个字符一定是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 二维表图一个位置dp[i][j]是否是回文串在间距大于2的情况下取决于dp[i + 1][j - 1]，也就是二维表图中左下方区域，所以从列开始便历
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 不相等的话直接不用比了，当前不为回文串
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等，且中间没有数字或只有一个数字的情况下，为回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散法（从里向外）
     *
     * @param s
     * @return
     */
    public static String longestPalindrome6(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = getMaxLength(s, i, i);
            int evenLen = getMaxLength(s, i, i + 1);
            int maxLen = Math.max(oddLen, evenLen);
            if (maxLen > end - begin + 1) {
                begin = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        String res = s.substring(0, 1);
        int longest = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    if ((j - i) > longest) {
                        res = substring;
                        longest = j - i;
                    }
                }
            }
        }
        return res;
    }

    public static String longestPalindrome2(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        // 初始时候赋值
        String res = s.substring(0, 1);
        int longest = 1;
        int distance = 1;
        int left = 0;
        while (left + distance != length + 1) {
            String substring = s.substring(left, left + distance);
            if (isPalindrome(substring)) {
                if (distance > longest) {
                    res = substring;
                    longest = distance;
                }
            }
            distance++;
            if (left + distance == length + 1) {
                left++;
                distance = 1;
            }
        }
        return res;
    }

    private static int getMaxLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
