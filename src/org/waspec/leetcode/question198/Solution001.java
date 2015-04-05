package org.waspec.leetcode.question198;

public class Solution001 {

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 3, 7, 3};
        Solution001 solution001 = new Solution001();
        int result = solution001.rob(numbers);
        System.out.println(result);
    }

    public int rob(int[] numbers) {
        int result = 0;
        if (numbers == null || numbers.length == 0)
            return result;
        result = rob(numbers, 0);
        return result;
    }

    public int rob(int[] numbers, int robTarget) {
        if (robTarget == numbers.length - 1) {
            return numbers[robTarget];
        } else {
            int plan1 = 0;
            if (robTarget + 2 <= numbers.length - 1) {
                plan1 = numbers[robTarget] + rob(numbers, robTarget + 2);
            } else {
                plan1 = numbers[robTarget];
            }

            int plan2 = rob(numbers, robTarget + 1);
            return plan1 > plan2 ? plan1 : plan2;
        }
    }

    /**
     * 1. 此方案是正确的，适用于讲课，但提交时会超时。DP的关键就是：缓存。带缓存的版本请见Solution002
     * */
}
