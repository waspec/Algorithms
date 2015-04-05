package org.waspec.leetcode.question189;

public class Solution001 {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution001 solution001 = new Solution001();
        solution001.rotate(numbers, k);
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d->", numbers[i]);
        }
    }

    public void rotate(int[] numbers, int k) { // 问面试官：k>n、k<0、k==0时想要什么结果。
        rotateArray(numbers, 0, numbers.length - 1);
        rotateArray(numbers, 0, k - 1);
        rotateArray(numbers, k, numbers.length - 1);
    }

    public void rotateArray(int[] array, int startIndex, int endIndex) {
        int p = startIndex; // 这两个变量不是必需的，但代码比较好看
        int q = endIndex;
        int temp = 0;
        while (p < q) {
            temp = array[p];
            array[p] = array[q];
            array[q] = temp;
            p++;
            q--;
        }
    }
}

/**
 * 1. 此方案仍然有问题，还没有仔细考虑k<0, k==0, k==n, k>n的情况
 **/
