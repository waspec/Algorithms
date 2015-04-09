package org.waspec.leetcode.question005;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        String string = "abccbaclabcba";
        String result = solution001.longestPalindrome(string);
        System.out.println(result);
    }

    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0)
            return str;

        String result = null; // 坑：凡设了null的地方，后面都要考虑null引用的问题——细节是魔鬼。一个人的算法不好，往往是因为细节的功夫不行。
        for (int i = 0; i < str.length(); i++) {
            String temp = Character.toString(str.charAt(i));
            if (result==null || result.length()<temp.length())
                result = temp;
            temp = getPalindromeSubstring(str, i, i + 1);
            if (temp != null && temp.length() > result.length())
                result = temp;
            temp = getPalindromeSubstring(str, i, i + 2);
            if (temp != null && temp.length() > result.length())
                result = temp;
        }

        return result;
    }

    public String getPalindromeSubstring(String rawStr, int start, int end) {
        String result = null;
        int startCache = -1;
        int endCache = -1;
        while (start >= 0 && end < rawStr.length() && rawStr.charAt(start) == rawStr.charAt(end)) { // 充分利用逻辑运算符的短路特性
            startCache = start;
            endCache = end;
            start--;
            end++;
        }

        if (startCache != -1)
            result = rawStr.substring(startCache, endCache + 1); // Java的特点是不截取endIndex的那个字符
        return result;
    }
}

/**
 * 1. 首先需要问面试官“回文”的定义：abcba算不算？abccba算不算？我们按两种都算来解题
 * 2. 做题时会发现：如果有等长的回文子串，取哪个？
 */