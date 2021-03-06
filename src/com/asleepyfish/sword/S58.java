package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-15 22:24
 * @Description: 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 * 限制：
 * 1 <= k < s.length <= 10000
 */
public class S58 {
    public String reverseLeftWords(String s, int n) {
        int move = n % s.length();
        char[] res = new char[s.length()];
        int j = 0;
        for (int i = move; i < s.length(); i++) {
            res[j++] = s.charAt(i);
        }
        for (int i = 0; i < move; i++) {
            res[j++] = s.charAt(i);
        }
        return new String(res, 0, j);
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
