package org.waspec.leetcode.question198;

public class Solution002 {
    public static void main(String[] args) {
        int[] numbers = new int[]{5, 3, 7, 3};
        Solution002 solution002 = new Solution002();
        int result = solution002.rob(numbers);
        System.out.println(result);
    }

    public int rob(int[] numbers) {
        int result = 0;
        if (numbers == null || numbers.length == 0)
            return result;
        int[] cache = new int[numbers.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }

        result = rob(numbers, cache, 0);
        return result;
    }

    public int rob(int[] numbers, int[] cache, int robTarget) {
        if (cache[robTarget] != -1) { // 检索缓存
            return cache[robTarget];
        }

        if (robTarget == numbers.length - 1) {
            return numbers[robTarget];
        } else {
            int plan1 = 0;
            if (robTarget + 2 <= numbers.length - 1) {
                plan1 = numbers[robTarget] + rob(numbers, cache, robTarget + 2);
            } else {
                plan1 = numbers[robTarget];
            }

            int plan2 = rob(numbers, cache, robTarget + 1);
            cache[robTarget] = plan1 > plan2 ? plan1 : plan2; // 缓存结果
            return cache[robTarget];
        }
    }
}
