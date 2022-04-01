package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-31 22:31
 * @Description: 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class S58I {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] split = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i > 0; i--) {
            sb.append(split[i]).append(" ");
        }
        sb.append(split[0]);
        return sb.toString();
    }

    public String reverseWords2(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                // 搜索首个空格
                i--;
            }
            // 添加单词
            res.append(s, i + 1, j + 1).append(" ");
            while(i >= 0 && s.charAt(i) == ' ') {
                i--; // 跳过单词间空格
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }
}
