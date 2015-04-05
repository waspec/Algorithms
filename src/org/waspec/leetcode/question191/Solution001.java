package org.waspec.leetcode.question191;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        int result = solution001.hammingWeight(-1);
        System.out.println(result);
        result = solution001.hammingWeight(Integer.MIN_VALUE);
        System.out.println(result);
    }

    public int hammingWeight(int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >>> i & 1) == 1)
                counter++;
        }

        return counter;
    }
}
