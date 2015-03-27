package org.waspec.leetcode.question039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Timothy on 3/26/2015.
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
        Arrays.sort(candidates); // 能不能调用类库方法需要问考官
        backtracking(candidates, target, result, stack, 0, 0);
        return result;
    }

    // 无重复
    public void backtracking(int[] candidates, int target, List<List<Integer>> bag, Stack<Integer> stack, int sumOfStack, int currentIndex) {

        // 不用判断currentIndex是否越界，for本身包含这个功能
        for (int i = currentIndex; i < candidates.length; i++) {
            int currentSum = sumOfStack + candidates[i];
            if (currentSum == target) {
                List<Integer> oneResult = new ArrayList<Integer>(stack);
                oneResult.add(candidates[i]);
                bag.add(oneResult);
            } else if (currentSum < target) {
                stack.push(candidates[i]);
                backtracking(candidates, target, bag, stack, currentSum, i); // 题眼：为了不跟“前面的”组合，需要之与“此后的”组合 //注意就i而不是currentIndex+1
                stack.pop();
            }
        }
    }

    // 用重复
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

/****************
 * 1. 经过一段时间训练，感觉毫无难度，但太自信了，连条件都没看
 * 2. 题眼：如何无重复？一开始会想到排序，坑也
 * 3. 题眼：如何让结果非降序排列？这次是排序
 * ***************/