package org.waspec.leetcode.question028;

/**
 * Implement strStr()
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        String haystack = "mississippi";
        String needle = "issipi";
        int result = solution001.strStr(haystack, needle);
        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength)
            return -1;

        if (hLength == 0 && nLength == 0)
            return 0;

        for (int i = 0; i < hLength; i++) {
            int j;
            for (j = 0; j < nLength; j++) {
                if (i + j == hLength)
                    break;

                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }

            if (j == nLength)
                return i;
        }

        return -1;
    }
}

/**
 * 中弹：没有考虑needle比haystack长的情况
 * 中弹：没有考虑到haystack剩下的长度已经比needle短的情况（包含上面）
 * 中弹：没有考虑到两个都是""的时候应该返回0而不是-1
 * 中弹：此方案超时，把内层循环中的||拆成两个“及早return”后，超时解除
 */