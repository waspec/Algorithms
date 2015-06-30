package org.waspec.leetcode.question009;

/**
 * Palindrome Number （回文整数）
 */
public class Solution001 {
    public boolean isPalindrome(int x) {
        if (x >= 0 && x <= 9)
            return true;

        if (x % 10 == 0 || x < 0) // 数字开头不可能为0，10的倍数结尾为0
            return false;

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x %= div; // 去掉最高位
            x /= 10; // 去掉最低位
            div /= 100; // 每次去掉两个数字
        }

        return true;
    }
}

/**
 * 1. 一开始把x<0的负数情况给忘了！
 */