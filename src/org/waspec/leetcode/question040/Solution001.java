package org.waspec.leetcode.question040;

import java.util.*;

/**
 * Created by Timothy on 3/26/2015.
 */
public class Solution001 {

    public static void main(final String[] args) {
        int[] candidates = new int[]{8,7,4,3};
        int target = 11;
        Solution001 solution001 = new Solution001();
        List<List<Integer>> result = solution001.combinationSum2(candidates, target);
        for (List<Integer> list: result){
            for (Integer i : list){
                System.out.print(i);
                System.out.print("->");
            }
            System.out.println();
        }
    }

    //=======================================//

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<Integer>();
        Arrays.sort(candidates); // 保证非降序
        backtracking(candidates, target, result, path, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, List<List<Integer>> bag, Stack<Integer> path, int currentSumOfPath, int currentIndex) {
        for (int i = currentIndex; i < candidates.length; i++) {
            int sum = currentSumOfPath + candidates[i];
            if (sum == target) {
                List<Integer> oneResult = new ArrayList<Integer>(path);
                oneResult.add(candidates[i]);
                bag.add(oneResult);
                // 没有没有push操作，所以也不用pop
            } else if (sum < target) {
                path.push(candidates[i]);
                backtracking(candidates, target, bag, path, sum, i + 1); // 题眼：保证不重用当前数组元素，而是从“下一个”开始
                path.pop();
            } // 不用考虑sum>target的情况
        }
    }
}

/**
 * 1. 因为刚刚做完039，所以立刻就破解了变化过的题眼——每次取数、进入下一层的时候，不重复使用当前的index就可以了，也就是i+1
 * 2. 本solution是有错误的——不能对付cadidates为[1,1]、target为1的情况，因为结果中会出现两个[1]。所以升级为solution002，使用Map来保存结果
 */
