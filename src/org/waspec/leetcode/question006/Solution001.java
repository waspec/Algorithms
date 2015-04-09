package org.waspec.leetcode.question006;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        String input = "PAYPALISHIRING";
        String output = solution001.convert(input, 3);
        System.out.println(output);
    }

    public String convert(String str, int n) {
        if (n <= 1)
            return str;

        StringBuilder[] stringBuilders = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        int steps = n - 2;
        int index = 0;
        boolean reachend = false;
        while (!reachend) {
            if (steps == n - 2) {
                steps = n;
                for (int i = 0; i < steps; i++) {
                    if (index == str.length()) {
                        reachend = true;
                        break;
                    } else {
                        stringBuilders[i].append(str.charAt(index));
                        index++;
                    }
                }
            } else {
                steps = n - 2;
                for (int i = 0; i < steps; i++) {
                    if (index == str.length()) {
                        reachend = true;
                        break;
                    } else {
                        stringBuilders[n - 2 - i].append(str.charAt(index));
                        index++;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : stringBuilders) {
            stringBuilder.append(sb.toString());
        }

        return stringBuilder.toString();
    }
}

/**
 * 1. 此题没有别的办法，就是找规律，属于智商题
 * 2. 如果是找行数的规律，那么两端的字符会比较难处理，最后发现可以“分段”——长度为n的一段，然后是长度为n-2的一段……直到结束
 * 3. 目前这个代码还比较乱，有提升余地
 */