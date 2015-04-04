package org.waspec.leetcode.question001;

import java.util.HashMap;
import java.util.Map;

public class Solution001 {

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 2, 4};
        int target = 6;
        Solution001 solution001 = new Solution001();
        int[] result = solution001.twoSum(numbers, target);
        System.out.printf("%d,%d\n", result[0], result[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            Integer company = target - numbers[i];
            Integer companyIndex = map.get(company);
            if (companyIndex == null) {
                map.put(numbers[i], i); // 题眼：数值作为key，数值在数组中的index作为value
            } else {
                return new int[]{companyIndex + 1, i + 1}; // 题眼：排在数组前面的先被扫描到，自然会先存，index也会比较小
            }
        }

        return null;
    }
}

/**
 * 1. “只有一对”是为了简化问题
 * 2. “非0基”仅仅是个干扰因素
 * 3. Index1必需小于index2见题眼
 */
