package org.waspec.leetcode.question022;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timothy on 3/22/2015.
 */
public class Solution001 {

    public static void main(String[] args){
        Solution001 solution001 = new Solution001();
        List<String> result = solution001.generateParenthesis(3);
        for (String item: result){
            System.out.println(item);
        }
    }

    /***********************************************/

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder pathBase = new StringBuilder();
        backtracking(result, pathBase, n, 0, 0);
        return result;
    }

    public void backtracking(List<String> bag, StringBuilder pathBase, int max, int currentLeftParenthesisCount, int currentRightParenthesisCount) {

        // 如果串的长度是max的2倍，说明已经满了
        if (pathBase.length() == max * 2) {
            bag.add(pathBase.toString());
        } else {
            // 题眼：下面的两组if相当于向不同方向发展的两个策略（可能性）。如果未来有多方向/策略的题，那么只需要加if就可以。

            if (currentLeftParenthesisCount < max) { // 如果没有这个条件，那么'('会超过max个，结果中会出现"((((((()"等
                pathBase.append('(');
                backtracking(bag, pathBase, max, currentLeftParenthesisCount + 1, currentRightParenthesisCount);
                pathBase.deleteCharAt(pathBase.length() - 1);
            }

            if (currentRightParenthesisCount < currentLeftParenthesisCount) { // 加这个条件是为了防止右括号的数量超过左括号
                pathBase.append(')');
                backtracking(bag, pathBase, max, currentLeftParenthesisCount, currentRightParenthesisCount + 1);
                pathBase.deleteCharAt(pathBase.length() - 1);
            }
        }
    }
}

/*********
 * 1. 直接能想到会用到stack，但不知道怎么用
 * 2. 最明显的思路是把数字的组合先找出来，然后再解析成括号的组合，结果证明是在浪费时间！
 * 3. 一上来多想了一个“括号交叉”的问题——因为都是小括号，所以不存在交叉问题！（傻了……）
 * 4. 最终想明白一点：n的用处在于——最多可以有多对括号-->最多有多少个左括号-->最多有多少个右括号
 * 5. 难点：也是题眼，如果没有经过训练，很难想到这种“多递归”（方法多次调用自己）的策略。其实“多递归”在书里有讲，属于理论知识
 * 6. 难点：两个if条件，应该相当于“剪枝”——封死不能去的方向
 * *********/