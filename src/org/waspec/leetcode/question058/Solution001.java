package org.waspec.leetcode.question058;

/**
 * Length of Last Word
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        System.out.println(solution001.lengthOfLastWord(null));
        System.out.println(solution001.lengthOfLastWord(""));
        System.out.println(solution001.lengthOfLastWord(" "));
        System.out.println(solution001.lengthOfLastWord("A"));
        System.out.println(solution001.lengthOfLastWord("Hello,World"));
        System.out.println(solution001.lengthOfLastWord("Hello, World"));
        System.out.println(solution001.lengthOfLastWord("Hello, World "));
    }

    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;

        s = s.trim(); // 耍赖哦！

        int length = s.length();
        if (length == 0)
            return 0;

        int i;
        for (i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;
        }

        return length-1-i;
    }
}

/**
 * 中弹：题目定义模糊不清——结尾是空格怎么办？
 * */