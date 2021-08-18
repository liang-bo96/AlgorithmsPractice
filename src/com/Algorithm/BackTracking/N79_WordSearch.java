package com.Algorithm.BackTracking;

import java.util.HashMap;
import java.util.Map;

/*79. 单词搜索
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true
示例 3：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false*/
public class N79_WordSearch {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new N79_WordSearch().exist(chars, "ABCESEEEFS"));
    }

    //-----------------------------------超时---------------------------------------------------
    public boolean exist(char[][] board, String word) {
        int length = board.length;
        int width = board[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                boolean[][] visited = new boolean[length][width];
                if (dfs(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int x, int y, int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x >= board.length ||
                x < 0 ||
                y >= board[0].length ||
                y < 0 ||
                board[x][y] != word.charAt(index) ||
                visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        boolean t = dfs(board, x + 1, y, index + 1, word, visited) ||
                dfs(board, x - 1, y, index + 1, word, visited) ||
                dfs(board, x, y + 1, index + 1, word, visited) ||
                dfs(board, x, y - 1, index + 1, word, visited);
        //记得清理掉访问过的痕迹
        visited[x][y] = false;
        return t;
    }


}
