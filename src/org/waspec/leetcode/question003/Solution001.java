package org.waspec.leetcode.question003;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        String str = "abcakm";
        int result = solution001.lengthOfLongestSubstring(str);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int[] accessRecord = getArray(); // 题眼：需要问是什么字符集
        int maxOffset = 0;
        int start = 0;
        int end = 0;
        while (end < str.length()) {
            int index = str.charAt(end);
            if (accessRecord[index] == -1) {
                accessRecord[index] = end;
                int offset = end - start;
                maxOffset = offset > maxOffset ? offset : maxOffset;
                end++;
            } else {
                start = accessRecord[index] + 1;
                end = start;
                accessRecord = getArray();
            }
        }

        return maxOffset + 1;
    }

    public int[] getArray() {
        int[] array = new int[256];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }

        return array;
    }
}

/**
 * 1. 准确为变量命名的典型例子。变量名要精确反映“指针”之间的关系。变量要站在使用者角度去命名。不要把offset和length混在一起用！
 * 2. 适合粗心者常练，专治各种没耐心和粗心大意。
 * 3. 此题难点（1）index的offset与length容易搞混（2）退出循环时的最后一段字符如何处理
 * 4. 这个题不是用boolean[256]就可以记录访问的
 * 5. 一开始肯定认为要用for循环，最后发现因为需要控制循环变量“倒退”而且for的i++会添麻烦，所以while循环才是最佳选择。结论：for循环相对于while循环，有些死板
 */