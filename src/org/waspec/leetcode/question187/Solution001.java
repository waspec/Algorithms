package org.waspec.leetcode.question187;

import java.util.*;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        String rawString = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solution001.findRepeatedDnaSequences(rawString);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = findPattern(s, 10);
        return result;
    }

    public List<String> findPattern(String rawString, int patternLength) {
        Map<String, Integer> patternCounterMap = new HashMap<String, Integer>();
        if (rawString.length() >= patternLength) {
            for (int i = 0; i < rawString.length() - patternLength; i++) {
                String piece = rawString.substring(i, i + patternLength); // 坑：是i+patternLength，不是i+patternLength-1
                if (patternCounterMap.containsKey(piece)) {
                    patternCounterMap.put(piece, patternCounterMap.get(piece) + 1);
                } else {
                    patternCounterMap.put(piece, 1);
                }
            }
        }

        List<String> result = new ArrayList<String>();
        for (String key : patternCounterMap.keySet()) {
            if (patternCounterMap.get(key) > 1)
                result.add(key);
        }

        return result;
    }
}

/**
 * 1. 这是一个很朴素的解法，但因为使用的是String，所以得到Memory Limit Exceeded的结果也是很正常的。
 * */
