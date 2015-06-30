package org.waspec.leetcode.question008;

/**
 * String to Integer (atoi)
 */

public class Solution001 {
    public int myAtoi(String str) {

        if (str == null)
            return 0;

        str = str.trim();
        if (str.length()==0)
            return 0;

        char flag = '+';

        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        int result = 0;

        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < (str.charAt(i) - '0')))
                return flag == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        return result;
    }
}

/**
 * 1. 因为已经比较有经验了（之前应该也做过这道题），所以一上来就意识到本题就是靠细心
 * 2. 题眼：考虑“整数”的各种形态，包括正数、负数、千位逗号等等
 * 3. 题眼：考虑String的各种情况，包括+、-开头，可不可以用空格开头结尾等等
 * 4. 题眼：考虑整数的最大正值、最小负值
 * 5. 长时间不写程序，竟然想不起来'0'是排在前面还是后面了……
 * 6. 注意：此题有很多未交待清楚的地方
 * 有非法字符怎么办？看了讨论之后，发现OJ接受return 0。
 * 而且竟然还可以先调用trim()方法
 * 甚至允许调用parse方法
 * 7. 心得：多个维度的if...else...组合的时候，选择if...else...的层级是很重要的
 */