package com.Algorithm.DFS;

/**
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 */
public class N695_maxAreaOfIsland {
    public static void main(String[] args) {
//        System.out.println(maxAreaOfIsland(
//                new int[][]{
//                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
//        ));
        System.out.println(maxAreaOfIsland(
                new int[][]{
                        {1, 1},
                        {1, 1}}
        ));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, i, j, new boolean[grid.length][grid[0].length]));
                }
            }
        }
        return result;
    }

    public static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        int re = 1;
        //使用visited 是错误的方法，比如[[1,1],[1,1]],结果为7，原因是坐标0,1 和 1,0 两次重复统计了节点数量（还原现场（回溯法特点）），导致结果出错，
        // 正确的方法是访问过的节点置为标志位
//        visited[i][j] = true;
        grid[i][j] = 0;
        re += dfs(grid, i - 1, j, visited);
        re += dfs(grid, i + 1, j, visited);
        re += dfs(grid, i, j - 1, visited);
        re += dfs(grid, i, j + 1, visited);
//        visited[i][j] = false;
        return re;
    }
}
