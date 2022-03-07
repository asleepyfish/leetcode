package com.asleepyfish.easy;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-02 23:29
 * @Description: 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome3(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = String.valueOf(x);
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int len = 0;
        int p = x;
        while (x != 0) {
            x /= 10;
            len++;
        }
        int[] arr = new int[len];
        int i = 0;
        while (p != 0) {
            arr[i++] = p % 10;
            p /= 10;
        }
        for (int i1 = 0; i1 < arr.length / 2; i1++) {
            if (arr[i1] != arr[arr.length - i1 - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int sum = 0;
        int y = x;
        while (y != 0) {
            sum = (y % 10) + sum * 10;
            y /= 10;
        }
        return sum == x;
    }
}
