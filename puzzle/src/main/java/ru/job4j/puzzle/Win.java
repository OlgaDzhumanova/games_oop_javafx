package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1 && (horizontal(board, index) || vertical(board, index))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean horizontal(int[][] board, int row) {
            boolean result = true;
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] != 1) {
                    result = false;
                }
            }
        return result;
        }

        public static boolean vertical(int[][] board, int column) {
            boolean result = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][column] != 1) {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }


