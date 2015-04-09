package org.waspec.leetcode.question003;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        String str = "aa";
        int result = solution001.lengthOfLongestSubstring(str);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String str) {
        boolean[] accessRecord = new boolean[26];
        int maxOffset = 0;
        int currentOffset = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            currentOffset = i - start;
            if (accessRecord[index]) {
                maxOffset = currentOffset - 1 > maxOffset ? currentOffset - 1 : maxOffset;
                start = i;
                accessRecord = new boolean[26]; // 可以清空
            } else {
                accessRecord[index] = true;
            }
        }

        maxOffset = currentOffset > maxOffset ? currentOffset : maxOffset; // 坑：循环到尾没有重复（即：最长的在末尾）

        return maxOffset + 1;
    }
}

/**
 * 1. 准确为变量命名的典型例子。变量名要精确反映“指针”之间的关系。变量要站在使用者角度去命名。不要把offset和length混在一起用！
 * 2. 适合粗心者常练。
 */