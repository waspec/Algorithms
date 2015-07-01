package org.waspec.leetcode.question067;

import java.util.Stack;

/**
 * Add Binary
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        System.out.println(solution001.addBinary("1111","1111"));
        System.out.println(solution001.addBinary("1100","0011"));
        System.out.println(solution001.addBinary("11","1111"));
        System.out.println(solution001.addBinary("100","1111"));
    }

    public String addBinary(String a, String b) {
        if (a == null && b == null)
            return null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        int aLength = a.length();
        int bLength = b.length();
        int maxLength = aLength > bLength ? aLength : bLength;
        if (maxLength == 0)
            return "";

        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        char carry = '0';
        Stack<Character> stack = new Stack<Character>();

        char aChar = '0';
        char bChar = '0';
        while (aIndex >= 0 || bIndex >= 0) { // 至少有一个没有扫描完
            if (aIndex >= 0)
                aChar = a.charAt(aIndex--); // 技巧：不想写两行，所以用了--
            else
                aChar = '0';

            if (bIndex >= 0)
                bChar = b.charAt(bIndex--);
            else
                bChar = '0';

            int r = (aChar - '0') + (bChar - '0') + (carry - '0');
            carry = r / 2 > 0 ? '1' : '0';
            stack.push(r % 2 == 1 ? '1' : '0');
        }

        if (carry=='1') // 提示：别忘了进位
            stack.push('1');

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty())
            stringBuilder.append(stack.pop());

        return stringBuilder.toString();
    }
}
