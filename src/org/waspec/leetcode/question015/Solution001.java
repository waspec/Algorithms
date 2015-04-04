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
        Stack<Integer> solution = new Stack<Integer>();
        backtracking(numbers, 3, 0, bag, solution, 0, 0);
        return bag;
    }

    public void backtracking(int[] numbers, int targetLength, int targetSum, List<List<Integer>> bag, Stack<Integer> solution, int solutionSum, int index) {
        for (int i = index; i < numbers.length; i++) {
//            while (i > 0 && i < numbers.length && numbers[i] == numbers[i - 1]) {
//                i++;
//            }

            solutionSum += solution.push(numbers[i]);
            if (solution.size() == targetLength && solutionSum == targetSum) {
                bag.add(new ArrayList<Integer>(solution)); // 坑：又忘了clone
            }

            if (solution.size() < targetLength) {
                backtracking(numbers, targetLength, targetSum, bag, solution, solutionSum, i + 1);
            }

            solutionSum -= solution.pop(); // 题眼：solution最后要能弹空，同时solutionSum也要恢复
        }
    }
}

/**
 * 1. 首先想到的是backtracking，tag是双指针
 * 2. 类似于“n皇后问题”
 * 3. 回溯的时候要做到能把当作solution的stack弹空，从“根”上“重新再来”。这时候，一个套在最外面的循环往往是逻辑运行的“主推动力”。
 * 4. 本方案目前有bug——数据源中的重复值导致有重复解[-1,0,1]。解开对while的注释后又会丢失[-1,-1,2]这组解。
 */
