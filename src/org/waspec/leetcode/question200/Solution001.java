package org.waspec.leetcode.question200;

public class Solution001 {

    public static void main(String[] args) {
        char[][] sea = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '0', '1', '1'}
        };

        Solution001 solution001 = new Solution001();
        int result = solution001.numIslands(sea);
        System.out.println(result);
    }

    public int numIslands(char[][] sea) {
        if (sea == null)
            return 0;
        int height = sea.length;
        if (height == 0)
            return 0;
        int width = sea[0].length;
        if (width == 0)
            return 0;

        boolean[][] accessRecord = new boolean[height][width];
        int counter = 0;
        for (int y = 0; y < height; y++) { // 题眼：整个循环和里面的mark
            for (int x = 0; x < width; x++) {
                if (accessRecord[y][x] == true)
                    continue;
                else if (sea[y][x] == '0')
                    accessRecord[y][x] = true;
                else {
                    mark(sea, accessRecord, height, width, y, x);
                    counter++;
                }
            }
        }

        return counter;
    }

    public void mark(char[][] sea, boolean[][] accessRecord, int height, int width, int y, int x) {
        if (y >= 0 && y < height && x >= 0 && x < width && sea[y][x] == '1' && accessRecord[y][x] == false) { // 坑：如果没有accessRecord[y][x] == false就会爆栈
            accessRecord[y][x] = true;
            mark(sea, accessRecord, height, width, y - 1, x); // Up
            mark(sea, accessRecord, height, width, y + 1, x); // Down
            mark(sea, accessRecord, height, width, y, x - 1); // Left
            mark(sea, accessRecord, height, width, y, x + 1); // Right
        }
    }
}
