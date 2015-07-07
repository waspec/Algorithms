package org.waspec.leetcode.question088;

/**
 * Merge Sorted Array
 */
public class Solution001 {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0; // Pointer index of nums1
        int p2 = 0; // Pointer index of nums2
        int boundary = m;
        while (p1 < boundary || p2 < n) {
            while (nums1[p1] < nums2[p2])
                p1++;

            for (int i = boundary; i >p1; i--) {
                nums1[i] = nums1[i-1];
            }

            boundary++;
            nums1[p1] = nums2[p2];
            p2++;
        }
    }
}

/**
 * 提示：本题的题目具有迷惑性——不是通常意义上的合并已排序数组
 */
