package org.waspec.leetcode.question231;

/**
 * Power of Two
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        System.out.println(solution001.isPowerOfTwo(0));
        System.out.println(solution001.isPowerOfTwo(1));
        System.out.println(solution001.isPowerOfTwo(2));
        System.out.println(solution001.isPowerOfTwo(3));
        System.out.println(solution001.isPowerOfTwo(4));
        System.out.println(solution001.isPowerOfTwo(5));
        System.out.println(solution001.isPowerOfTwo(6));
        System.out.println(solution001.isPowerOfTwo(8));
    }

    public boolean isPowerOfTwo(int n) {
        int x = 1;
        for (int i = 0; i < 31; i++) {
            if (n==x<<i){
                return true;
            }
        }

        return false;
    }
}

/**
 * 提示：多思路互相干扰的典型
 * 原理：暴力法——从1开始，连续x2，比较是否相等
 * 原理：2的次方，其二进制位上只能有一个1
 */
