package org.waspec.leetcode.question015;

import java.util.*;

public class Solution001 {
    public static void main(String[] args) {
        int[] numbers = new int[]{-1, 0, 1, 2, -1, -4};
        Solution001 solution = new Solution001();
        List<List<Integer>> result = solution.threeSum(numbers);
        System.out.println(result.size());
    }

    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers); // 题眼：保证非增序
        List<List<Integer>> bag = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<Integer>();
        backtracking(bag, path, 0, numbers, 0, 3, 0);
        return bag;
    }

    public void backtracking(List<List<Integer>> bag, Stack<Integer> path, int sumOfPath, int[] numbers, int index, int targetLength, int target) {

    }
}

/**
 * 1. 首先想到的是backtracking，tag是双指针
 * 2. 类似于“n皇后问题”，
 */
