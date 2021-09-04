package com.Algorithm.TargetingOffer;

import java.util.HashSet;

public class N12 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                set = new HashSet<>();
                if (dfs(board, i, j, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static HashSet<String> set;

    public static boolean dfs(char[][] board, int x, int y, char[] arr, int index) {
        if (index == arr.length) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != arr[index] || set.contains(x+"-"+y)) {
            return false;
        }
        set.add(x+"-"+y);
        boolean flag =
                dfs(board, x + 1, y, arr, index + 1) ||
                dfs(board, x - 1, y, arr, index + 1) ||
                dfs(board, x, y + 1, arr, index + 1) ||
                dfs(board, x, y - 1, arr, index + 1);
        set.remove(x+"-"+y);
        return flag;
    }
}
