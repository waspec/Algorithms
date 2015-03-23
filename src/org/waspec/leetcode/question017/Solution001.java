package org.waspec.leetcode.question017;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timothy on 3/22/2015.
 */
public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        List<String> result = solution001.letterCombinations("k");
        for (String combination : result) {
            System.out.println(combination);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits==""){
            return new ArrayList<String>();
        }

        String[] charDictionary = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();
        StringBuilder combinationSoFar = new StringBuilder();
        backtracking(charDictionary, digits, result, combinationSoFar, 0);
        return result;
    }

    public void backtracking(String[] dictionary, String rawDigitString, List<String> combinationBag, StringBuilder combinationSoFar, int currentIndexOfRawString) {

        char[] characters = dictionary[rawDigitString.charAt(currentIndexOfRawString) - '0'].toCharArray();

        // 题眼：何时加入结果集？
        if (currentIndexOfRawString == rawDigitString.length() - 1) {
            for (char c : characters) {
                combinationBag.add(combinationSoFar.append(c).toString());
                combinationSoFar.deleteCharAt(combinationSoFar.length() - 1); // 难点：为什么要把末尾一个字符删除？
            }
        } else {
            for (char c : characters) {
                combinationSoFar.append(c);
                backtracking(dictionary, rawDigitString, combinationBag, combinationSoFar, currentIndexOfRawString + 1);
                combinationSoFar.deleteCharAt(combinationSoFar.length() - 1); // 难点：为什么要把末尾一个字符删除？
            }
        }
    }
}
