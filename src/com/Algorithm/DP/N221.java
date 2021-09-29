package com.Algorithm.DP;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix =
 * [["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 */
public class N221 {
    public static void main(String[] args) {
        System.out.println(new N221().maximalSquare(new char[][]{
                {'1', '1'},
                {'1', '1'}}));
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[i][j] = matrix[i][j] - '0';
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (arr[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        int min = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]);
                        arr[i][j] = min + 1;
                    }
                    res = Math.max(res, arr[i][j]);
                }
            }
        }
        return res * res;
    }


    /**
     * 1277. 统计全为 1 的正方形子矩阵
     * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix =
     * [
     * [0,1,1,1],
     * [1,1,1,1],
     * [0,1,1,1]
     * ]
     * 输出：15
     * 解释：
     * 边长为 1 的正方形有 10 个。
     * 边长为 2 的正方形有 4 个。
     * 边长为 3 的正方形有 1 个。
     * 正方形的总数 = 10 + 4 + 1 = 15.
     * 示例 2：
     * <p>
     * 输入：matrix =
     * [
     * [1,0,1],
     * [1,1,0],
     * [1,1,0]
     * ]
     * 输出：7
     * 解释：
     * 边长为 1 的正方形有 6 个。
     * 边长为 2 的正方形有 1 个。
     * 正方形的总数 = 6 + 1 = 7.
     */
    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        int min = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                        matrix[i][j] = min + 1;
                    }
                    res += matrix[i][j];
                }
            }
        }
        return res;
    }
}
