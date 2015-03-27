package org.waspec.leetcode.question047;

import java.util.*;

/**
 * Created by Timothy on 3/27/2015.
 */
public class Solution001 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 2};
        Solution001 solution001 = new Solution001();
        List<List<Integer>> result = solution001.permuteUnique(numbers);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print("->");
            }
            System.out.println();
        }
    }

    //=======================================

    public List<List<Integer>> permuteUnique(int[] numbers) {
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        Stack<Integer> path = new Stack<Integer>();
        List<Integer> availableNumbers = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            availableNumbers.add(numbers[i]);
        }

        backtracking(result, path, availableNumbers);
        return new ArrayList<List<Integer>>(result.values());
    }

    public void backtracking(Map<String, List<Integer>> bag, Stack<Integer> path, List<Integer> availbleNumbers) {
        if (availbleNumbers.size() == 0) {
            List<Integer> oneResult = new ArrayList<Integer>(path);
            String key = getKeyFromList(oneResult);
            if (!bag.containsKey(key)){
                bag.put(key, oneResult);
            }
        } else {
            for (int i = 0; i < availbleNumbers.size(); i++) {
                path.push(availbleNumbers.get(i));
                availbleNumbers.remove(i);
                backtracking(bag, path, availbleNumbers);
                Integer value = path.pop();
                availbleNumbers.add(i, value);
            }
        }
    }

    public String getKeyFromList(List<Integer> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i : list){
            stringBuilder.append(i);
            stringBuilder.append('-');
        }

        return stringBuilder.toString();
    }

    /**
     * 1. 这种方法虽然保险，但是timeout了 :(
     * */
}
