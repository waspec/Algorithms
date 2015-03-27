package org.waspec.leetcode.question046;

import java.util.*;

/**
 * Created by Timothy on 3/27/2015.
 */
public class Solution001 {

    public static void main(String[] args){
        int[] numbers = new int[]{1,2,3};
        Solution001 solution001 = new Solution001();
        List<List<Integer>> result = solution001.permute(numbers);
        for (List<Integer> list: result){
            for (Integer i : list){
                System.out.print(i);
                System.out.print("->");
            }
            System.out.println();
        }
    }

    //=======================================

    public List<List<Integer>> permute(int[] numbers) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<Integer>();
        List<Integer> availableNumbers = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            availableNumbers.add(numbers[i]);
        }

        backtracking(result, path, availableNumbers);
        return result;
    }

    public void backtracking(List<List<Integer>> bag, Stack<Integer> path, List<Integer> availbleNumbers){
        if (availbleNumbers.size()==0){
            bag.add(new ArrayList<Integer>(path));
        }else{
            for (int i = 0; i < availbleNumbers.size(); i++) {
                path.push(availbleNumbers.get(i));
                availbleNumbers.remove(i);
                backtracking(bag, path, availbleNumbers);
                Integer value = path.pop();
                availbleNumbers.add(i, value);
            }
        }
    }
}
