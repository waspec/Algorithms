package org.waspec.leetcode.question020;

import java.util.*;

/**
 * Valid Parentheses
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        String input = "()[]{}";
        System.out.println(solution001.isValid(input));
        input = "(()){[()]()}";
        System.out.println(solution001.isValid(input));
    }

    public boolean isValid(String input) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (map.containsKey(currentChar)) {
                stack.push(currentChar);
            }else if (map.containsValue(currentChar)){
                if (stack.isEmpty())
                    return false; // 闭括号不能先于开括号
                Character temp = stack.pop();
                if (!map.get(temp).equals(currentChar))
                    return false;
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}

/**
 * 1. 原理：遇开括号push，遇闭括号pop。如果pop出来的与闭括号一直成对直到栈空，返回true。
 */
