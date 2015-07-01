package org.waspec.leetcode.question026;

/**
 * Remove Duplicates from Sorted Array
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        int[] input1 = {1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 6};
        int result1 = solution001.removeDuplicates(input1);
        System.out.println(result1);

        int[] input2 = {1, 1};
        int result2 = solution001.removeDuplicates(input2);
        System.out.println(result2);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return 1;

        int counter = 1; // 永远注意初始值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                counter++;
                nums[counter - 1] = nums[i]; // 题眼：大胆覆盖即可
            }
        }

        return counter;
    }
}

/**
 * 1. 中弹：看到方法返回值是int，以为题目有错，结果发现是读题不仔细 >_<
 */
