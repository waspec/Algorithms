package org.waspec.leetcode.question187;

import java.util.*;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 solution002 = new Solution002();
        String rawString = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solution002.findRepeatedDnaSequences(rawString);
        System.out.println(result.size());
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = findPattern(s, 10);
        return result;
    }

    public List<String> findPattern(String rawString, int patternLength) {
        Map<Long, Integer> patternCounterMap = new HashMap<Long, Integer>();
        if (rawString.length() >= patternLength) {
            for (int i = 0; i < rawString.length() - patternLength; i++) {
                String piece = rawString.substring(i, i + patternLength); // 坑：是i+patternLength，不是i+patternLength-1
                Long key = pieceToLong(piece);
                if (patternCounterMap.containsKey(key)) {
                    patternCounterMap.put(key, patternCounterMap.get(key) + 1);
                } else {
                    patternCounterMap.put(key, 1);
                }
            }
        }

        List<String> result = new ArrayList<String>();
        for (Long key : patternCounterMap.keySet()) {
            if (patternCounterMap.get(key) > 1)
                result.add(longToPiece(key));
        }

        return result;
    }

    public long pieceToLong(String piece) { // A->1, G->2, C->3, T->4
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < piece.length(); i++) {
            switch (piece.charAt(i)) {
                case 'A':
                    stringBuilder.append('1');
                    break;
                case 'G':
                    stringBuilder.append('2');
                    break;
                case 'C':
                    stringBuilder.append('3');
                    break;
                case 'T':
                    stringBuilder.append('4');
                    break;
            }
        }

        return Long.parseLong(stringBuilder.toString());
    }

    public String longToPiece(Long integer) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = integer.toString();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '1':
                    stringBuilder.append('A');
                    break;
                case '2':
                    stringBuilder.append('G');
                    break;
                case '3':
                    stringBuilder.append('C');
                    break;
                case '4':
                    stringBuilder.append('T');
                    break;
            }
        }

        return stringBuilder.toString();
    }
}

/**
 * 1. 压缩成long仍然Memory Limit Exceeded
 * */
