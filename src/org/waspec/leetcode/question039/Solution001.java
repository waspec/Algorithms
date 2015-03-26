package org.waspec.leetcode.question039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Timothy on 3/25/2015.
 */
public class Solution001 {

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 5, 2, 4, 3};
        int target = 6;
        Solution001 solution001 = new Solution001();
        List<List<Integer>> result = solution001.combinationSum(candidates, target);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print("->");
            }

            System.out.println();
        }
    }

    /**
     * *******************
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.sort(candidates); // ??????????????????????????
        backtracking(candidates, target, result, stack, 0, 0);
        return result;
    }

    // ???
    public void backtracking(int[] candidates, int target, List<List<Integer>> bag, Stack<Integer> stack, int sumOfStack, int currentIndex) {

        // ????currentIndex???for??????
        for (int i = currentIndex; i < candidates.length; i++) {
            int currentSum = sumOfStack + candidates[i];
            if (currentSum == target) {
                List<Integer> oneResult = new ArrayList<Integer>(stack);
                oneResult.add(candidates[i]);
                bag.add(oneResult);
            } else if (currentSum < target) {
                stack.push(candidates[i]);
                backtracking(candidates, target, bag, stack, currentSum, i); // ????????????????? //????currentIndex+1
                stack.pop();
            }
        }
    }

    // ???
    public void backtracking(int[] candidates, int target, List<List<Integer>> bag, Stack<Integer> stack, int sumOfStack) {
        for (int i = 0; i < candidates.length; i++) {
            int currentSum = sumOfStack + candidates[i];
            if (currentSum == target) {
                List<Integer> oneResult = new ArrayList<Integer>(stack);
                oneResult.add(candidates[i]);
                bag.add(oneResult);
            } else if (currentSum < target) {
                stack.push(candidates[i]);
                backtracking(candidates, target, bag, stack, currentSum);
                stack.pop();
            }
        }
    }
}

/**
 * ***************
 * 1. ????????????????
 * 2. ?????????List<Integer>? ????????-->????
 * ****************
 */