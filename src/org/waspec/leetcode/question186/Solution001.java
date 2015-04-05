package org.waspec.leetcode.question186;

public class Solution001 {

    public static void main(String[] args) {
        char[] s = "this is a black cat".toCharArray();
        Solution001 solution001 = new Solution001();
        solution001.reverseWords(s);
        System.out.println(new String(s));
    }

    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        revertCharArray(s, 0, s.length - 1);
        int p = 0;
        int q = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') { // 坑：思维定势
                q = i - 1;
                revertCharArray(s, p, q);
                p = q = i + 1;
            } else if (i == s.length - 1) { // 试错后补充上的
                q = i;
                revertCharArray(s, p, q);
            }
        }
    }

    public void revertCharArray(char[] array, int startIndex, int endIndex) {
        int p = startIndex;
        int q = endIndex;
        char temp;
        while (p < q) {
            temp = array[p];
            array[p] = array[q];
            array[q] = temp;
            p++;
            q--;
        }
    }
}
