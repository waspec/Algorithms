package org.waspec.leetcode.question040;

import java.util.*;

/**
 * Created by Timothy on 3/26/2015.
 */
public class Solution002 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        Solution002 solution002 = new Solution002();
        List<List<Integer>> result = solution002.combinationSum2(candidates, target);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print("->");
            }
            System.out.println();
        }
    }

    //=======================================//

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        Stack<Integer> path = new Stack<Integer>();
        Arrays.sort(candidates); // 保证非降序
        backtracking(candidates, target, result, path, 0, 0);
        return new ArrayList<List<Integer>>(result.values());
    }

    public void backtracking(int[] candidates, int target, Map<String, List<Integer>> bag, Stack<Integer> path, int currentSumOfPath, int currentIndex) {
        for (int i = currentIndex; i < candidates.length; i++) {
            int sum = currentSumOfPath + candidates[i];
            if (sum == target) {
                List<Integer> oneResult = new ArrayList<Integer>(path);
                oneResult.add(candidates[i]);
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer element : oneResult) {
                    stringBuilder.append(element);
                    stringBuilder.append('-');
                }

                String key = stringBuilder.toString();

                if (!bag.containsKey(key)) {
                    bag.put(key, oneResult);
                }

                // 没有没有push操作，所以也不用pop
            } else if (sum < target) {
                path.push(candidates[i]); // 坑：一开始这里把i错写成了currentIndex，脑子要清醒啊！
                backtracking(candidates, target, bag, path, sum, i + 1); // 题眼：保证不重用当前数组元素，而是从“下一个”开始
                path.pop();
            } // 不用考虑sum>target的情况
        }
    }
}

/**
 * 1. 掉进一个“大坑”！Deque和Stack中元素存储的顺序是不一样的！同样是push(1)->push(2)，在Deque里的顺序是[2,1]，在Stack里的顺序是[1,2]
 * */