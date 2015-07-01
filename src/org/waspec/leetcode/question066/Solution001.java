package org.waspec.leetcode.question066;

/**
 * Plus One
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        int[] input = {9, 9, 9, 9, 9};
        int[] output = solution001.plusOne(input);
        for (int i : output) {
            System.out.println(i);
        }
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + carry;
            carry = value / 10;
            digits[i] = value % 10;
        }

        if (carry == 0)
            return digits;
        else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }

            return result;
        }
    }
}

/**
 * 中弹：一上来逻辑就错了——成了每一位都加1 -->int value = digits[i] + 1 + carry;
 */
