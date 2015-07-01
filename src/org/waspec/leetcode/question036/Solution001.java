package org.waspec.leetcode.question036;

/**
 * Valid Sudoku
 */
public class Solution001 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        if (areRowsValid(board) && areColumnsValid(board) && areBlocksValid(board))
            return true;
        else
            return false;
    }

    private boolean areRowsValid(char[][] board) {
        boolean[] record = null;
        for (int row = 0; row < 9; row++) {
            record = new boolean[9];
            for (int column = 0; column < 9; column++) {
                char c = board[row][column];
                if (c == '.')
                    continue;

                if (record[c - '1'] == true)
                    return false;
                else
                    record[c - '1'] = true;
            }
        }

        return true;
    }

    private boolean areColumnsValid(char[][] board) {
        boolean[] record = null;
        for (int column = 0; column < 9; column++) {
            record = new boolean[9];
            for (int row = 0; row < 9; row++) {
                char c = board[row][column];
                if (c == '.')
                    continue;

                if (record[c - '1'] == true)
                    return false;
                else
                    record[c - '1'] = true;
            }
        }

        return true;
    }

    private boolean areBlocksValid(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                if (!isBlockValid(board, row, column))
                    return false;
            }
        }

        return true;
    }

    private boolean isBlockValid(char[][] board, int row, int column) {
        boolean[] record = new boolean[9];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                char temp = board[row + r][column + c];
                if (temp == '.')
                    continue;

                if (record[temp - '1'] == true)
                    return false;
                else
                    record[temp - '1'] = true;
            }
        }

        return true;
    }
}

/**
 * 比较简单，一遍过
 * 技巧：boolean[]占内存小、效率高
 * */