package org.waspec.leetcode.question037;

import java.util.*;

/**
 * Created by v-timliu on 4/1/2015.
 */
public class Solution001 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution001 solution001 = new Solution001();
        solution001.solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        List<char[][]> solutions = new ArrayList<char[][]>();
        backtracking(solutions, board, 0, 0);
        board = solutions.get(0);
    }

    public void backtracking(List<char[][]> bag, char[][] board, int y, int x) {
        List<Character> availableChars = getAvailableChars(board, y, x); // 这一句是后提出来的，被公用
        if (y == 8 && x == 8) { // 题眼+难点：终止条件是什么？一上来很容易写成y == 8 && x == 8
            for (Character c : availableChars) {
                char[][] result = copyBoard(board);
                result[y][x] = c;
                bag.add(result);
            }
        } else {
            char cache = board[y][x];

            for (Character c : availableChars) {
                board[y][x] = c;
                if (y < 8) {
                    backtracking(bag, board, y + 1, x);
                }

                if (x < 8) {
                    backtracking(bag, board, y, x + 1);
                }
            }

            board[y][x] = cache;
        }
    }


    public List<Character> getAvailableChars(char[][] board, int y, int x) {
        List<Character> result = null;

        if (board[y][x] != '.') {
            result = new ArrayList<Character>();
            result.add(board[y][x]);
            return result;
        } else {
            result = getOneToNineCharList();
            for (int i = 0; i <= 8; i++) {
                removeCharFromList(result, board[y][i]);
            }

            for (int i = 0; i <= 8; i++) {
                removeCharFromList(result, board[i][x]);
            }

            int areaStartY = y / 3 * 3;
            int areaStartX = x / 3 * 3;
            for (int i = areaStartY; i <= areaStartY + 2; i++) {
                for (int j = areaStartX; j <= areaStartX + 2; j++) {
                    removeCharFromList(result, board[i][j]);
                }
            }
        }

        return result;
    }

    public List<Character> getOneToNineCharList() {
        List<Character> result = new ArrayList<Character>();
        for (int i = 1; i <= 9; i++) {
            result.add(Character.forDigit(i, 10));
        }

        return result;
    }

    public void removeCharFromList(List<Character> list, Character target) {
        int i = 0;
        for (i = 0; i < list.size(); i++) { // 坑： 外部循环变量，如果没break一直加到头了就会越界
            if (list.get(i).equals(target))
                break;
        }

        if (i < list.size()) {
            list.remove(i);
        }
    }

    public char[][] copyBoard(char[][] board) {
        char[][] result = new char[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                result[y][x] = board[y][x];
            }
        }

        return result;
    }
}
