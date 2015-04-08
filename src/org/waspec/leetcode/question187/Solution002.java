package org.waspec.leetcode.question187;

import java.util.*;

public class Solution002 {
    public static void main(String[] args) {
        Solution002 solution002 = new Solution002();
        String rawString = "GAGAGAGAGAGA";
        List<String> result = solution002.findRepeatedDnaSequences(rawString);
        System.out.println(result.size());
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = findPattern(s, 10);
        return result;
    }

    public List<String> findPattern(String rawString, int patternLength) {
        Map<Integer, Integer> patternCounterMap = new HashMap<Integer, Integer>();
        if (rawString.length() >= patternLength) {
            for (int i = 0; i <= rawString.length() - patternLength; i++) { // 坑：是i <= rawString.length() - patternLength，不是i < rawString.length() - patternLength
                String piece = rawString.substring(i, i + patternLength); // 坑：是i+patternLength，不是i+patternLength-1
                Integer key = pieceToInt(piece);
                if (patternCounterMap.containsKey(key)) {
                    patternCounterMap.put(key, patternCounterMap.get(key) + 1);
                } else {
                    patternCounterMap.put(key, 1);
                }
            }
        }

        List<String> result = new ArrayList<String>();
        for (Integer key : patternCounterMap.keySet()) {
            if (patternCounterMap.get(key) > 1)
                result.add(intToPiece(key, patternLength));
        }

        return result;
    }

    public int pieceToInt(String piece) { // A->00, G->01, C->10, T->11
        int result = 0;
        for (int i = 0; i < piece.length(); i++) {
            result <<= 2;
            switch (piece.charAt(i)) {
                case 'A': // 本分支可省略
                    result |= 0;
                    break;
                case 'G':
                    result |= 1;
                    break;
                case 'C':
                    result |= 2;
                    break;
                case 'T':
                    result |= 3;
                    break;
            }
        }

        return result;
    }

    public String intToPiece(int number, int pieceLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pieceLength; i++) {
            int code = number & 3;
            number >>>= 2;
            switch (code) {
                case 0:
                    stringBuilder.append('A');
                    break;
                case 1:
                    stringBuilder.append('G');
                    break;
                case 2:
                    stringBuilder.append('C');
                    break;
                case 3:
                    stringBuilder.append('T');
                    break;
            }
        }

        return stringBuilder.reverse().toString(); // 坑：别忘了反转！
    }
}

/**
 * 1. 压缩成long仍然Memory Limit Exceeded
 */
