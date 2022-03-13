package com.asleepyfish.easy;

/**
 * @Author: asleepyfish
 * @Date: 2022-03-05 22:38
 * @Description: 罗马数字转整数
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 *
 * 示例1:
 * 输入:s = "III"
 * 输出: 3
 * 示例2:
 * 输入:s = "IV"
 * 输出: 4
 * 示例3:
 * 输入:s = "IX"
 * 输出: 9
 * 示例4:
 * 输入:s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例5:
 * 输入:s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class No13 {
    /**
     * 小数字在大数字前面需要减，同时需要注意数据越界问题
     */
    public static void main(String[] args) {
        System.out.println(romanToInt2("IV"));
        System.out.println(romanToInt2("IX"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt2("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if ((i + 1) < length) {
                        char c1 = s.charAt(i + 1);
                        if (c1 == 'V') {
                            sum += 4;
                            i++;
                        } else if (c1 == 'X') {
                            sum += 9;
                            i++;
                        } else {
                            sum += 1;
                        }
                    } else {
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if ((i + 1) < length) {
                        char c2 = s.charAt(i + 1);
                        if (c2 == 'L') {
                            sum += 40;
                            i++;
                        } else if (c2 == 'C') {
                            sum += 90;
                            i++;
                        } else {
                            sum += 10;
                        }
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if ((i + 1) < length) {
                        char c3 = s.charAt(i + 1);
                        if (c3 == 'D') {
                            sum += 400;
                            i++;
                        } else if (c3 == 'M') {
                            sum += 900;
                            i++;
                        } else {
                            sum += 100;
                        }
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    break;
            }
        }
        return sum;
    }

    public static int romanToInt2(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && charToInt(s.charAt(i)) < charToInt(s.charAt(i + 1))) {
                sum -= charToInt(s.charAt(i));
            } else {
                sum += charToInt(s.charAt(i));
            }
        }
        return sum;
    }

    public static int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
