package com.asleepyfish.sword;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-15 22:24
 * @Description: 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
public class S05 {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
