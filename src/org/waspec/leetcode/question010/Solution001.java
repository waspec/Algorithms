package org.waspec.leetcode.question010;

/**
 * Created by Timothy on 3/22/2015.
 */

public class Solution001 {

    public static void main(String[] args){
        Solution001 solution001 = new Solution001();
        boolean result = solution001.isMatch("ab", ".*");
        System.out.println(result);
    }

    /*****************************************/

    public boolean isMatch(String input, String pattern) {
        if (input == null || pattern == null) {
            return false;
        }

        if (pattern.length() == 0) {
            return input.length() == 0;
        }

        boolean result = isMatch(input, 0, pattern, 0, null);
        return result;
    }

    public boolean isMatch(String input, int cursorOfInpunt, String pattern, int cursorOfPattern, Character precedingOfAsterisk) {
        boolean result = true;
        if (cursorOfInpunt >= input.length() && cursorOfPattern <= pattern.length()) { // 坑
            return true;
        }

        if (cursorOfInpunt < input.length() - 1 && cursorOfPattern == pattern.length() - 1) {
            return false;
        }

        if (input.charAt(cursorOfInpunt) == pattern.charAt(cursorOfPattern)) {
            result = isMatch(input, cursorOfInpunt + 1, pattern, cursorOfPattern + 1, input.charAt(cursorOfInpunt));
        } else if (pattern.charAt(cursorOfPattern) == '.') {
            result = isMatch(input, cursorOfInpunt + 1, pattern, cursorOfPattern + 1, input.charAt(cursorOfInpunt)); // 理论上可以与上个分支合并
        } else if (pattern.charAt(cursorOfPattern) == '*') {

            // 坑：边循环边charAt()，一旦触底就会越界！
            while (pattern.charAt(cursorOfPattern) == '*') {
                cursorOfPattern++;
                if (cursorOfPattern==pattern.length()){
                    break;
                }
            }

            while (input.charAt(cursorOfInpunt) == precedingOfAsterisk) {
                cursorOfInpunt++;
                if (cursorOfInpunt==input.length()){
                    break;
                }
            }

            if (cursorOfInpunt>=input.length() && cursorOfPattern<=pattern.length()){
                return true;
            }

            result = isMatch(input, cursorOfInpunt, pattern, cursorOfPattern, input.charAt(cursorOfInpunt));
        }else{
            result = false;
        }

        return result;
    }
}

/***************
 * 1. 需要问有没有可能多个*相连
 * 2. 需要问如何对待空串和null串
 * 3. 本题不适用于讲课——未知条件太多 *
 ****************/