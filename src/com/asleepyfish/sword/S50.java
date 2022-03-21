package com.asleepyfish.sword;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zhoujh42045
 * @Date: 2022/3/17 20:00
 * @Description: 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 * 限制：
 * 0 <= s 的长度 <= 50000
 */
public class S50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char res = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }
}
