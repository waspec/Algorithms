package org.waspec.leetcode.question190;

public class Solution001 {

    public static void main(String[] args) {
        int result = 0;
        Solution001 solution001 = new Solution001();
        result = solution001.reverseBits(Integer.MIN_VALUE); // 1后面31个0，结果应该是1
        System.out.println(result);
        result = solution001.reverseBits(-1); // 全是1，结果应该还是-1
        System.out.println(result);
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >>> i & 1) == 1) {
                result |= 1 << (31 - i);
            }
        }

        return result;
    }
}
