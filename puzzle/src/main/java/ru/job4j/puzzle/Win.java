package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        if (horizontal(board) || vertical(board)) {
            return rsl;
        } else {
            rsl = false;
        }
        return rsl;
    }

    public static boolean horizontal(int[][] horiz) {
        boolean result = true;
        for (int i = 0; i < horiz.length; i++) {
            if (horiz[i][0] == 1) {
                for (int j = 0; j < horiz.length; j++) {
                    if (horiz[i][j] != 1) {
                        result = false;
                    } else {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public static boolean vertical(int[][] ver) {
        boolean result = true;
        for (int i = 0; i < ver.length; i++) {
            if (ver[0][i] == 1) {
                for (int j = 0; j < ver.length; j++) {
                    if (ver[j][i] != 1) {
                        result = false;
                    } else {
                        result = true;
                    }
                }
            }else {
                result = false;
            }
        }
        return result;
    }
}

