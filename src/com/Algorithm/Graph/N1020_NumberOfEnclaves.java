package com.Algorithm.Graph;

public class N1020_NumberOfEnclaves {
    public static void main(String[] args) {
        numEnclaves(new int[][]{
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1}});
        System.out.println(result);
    }

    static int result;

    public static int numEnclaves(int[][] grid) {
        result = 0;
        for (int i = 0; i < grid.length; i++) {
            effect(grid, i, 0, 0);
            effect(grid, i, grid[0].length - 1, 0);
        }
        for (int i = 0; i < grid[0].length; i++) {
            effect(grid, 0, i, 0);
            effect(grid, grid.length - 1, i, 0);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void effect(int[][] grid, int x, int y, int target) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = target;
        effect(grid, x + 1, y, target);
        effect(grid, x - 1, y, target);
        effect(grid, x, y + 1, target);
        effect(grid, x, y - 1, target);
    }
}
