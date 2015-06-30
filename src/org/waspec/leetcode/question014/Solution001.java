package org.waspec.leetcode.question014;

/**
 * Longest Common Prefix
 */
public class Solution001 {
    public static void main(String args[]){
        String result = null;
        String[] array = {"aaab", "aaac","aa"};
        Solution001 solution001 = new Solution001();
        result = solution001.longestCommonPrefix(array);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            int strLength = strs[i].length();
            minLength = strLength < minLength ? strLength : minLength;
        }

        if (minLength == 0)
            return "";

        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    if (i == 0)
                        return "";
                    else
                        return str.substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLength);
    }
}

/**
 * 1. 本题对“无common prefix时应该返回什么”没有定义，试错一次后得出应该返回""
 * 2. 一开始犯傻，把minLength设为了0……
 */