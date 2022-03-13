package com.asleepyfish.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-07 20:12
 * @Description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * 
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * 
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * 
 * 输入：s = "{[]}"
 * 输出：true
 */
public class No20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(3) {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !stack.peek().equals(map.get(s.charAt(i)))) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(3) {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || map.get(stack.peek()) != s.charAt(i)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
