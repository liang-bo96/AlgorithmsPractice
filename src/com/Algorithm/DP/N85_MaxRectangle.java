//package com.Algorithm.DP;
//
///**
// * 85. 最大矩形
// * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
// *
// *
// *
// * 示例 1：
// *
// *
// * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// * 输出：6
// * 解释：最大矩形如上图所示。
// * 示例 2：
// *
// * 输入：matrix = []
// * 输出：0
// * 示例 3：
// *
// * 输入：matrix = [["0"]]
// * 输出：0
// * 示例 4：
// *
// * 输入：matrix = [["1"]]
// * 输出：1
// * 示例 5：
// *
// * 输入：matrix = [["0","0"]]
// * 输出：0
// */
//public class N85_MaxRectangle {
//    public int maximalRectangle(char[][] matrix) {
//        int height = matrix.length;
//        int width = matrix[0].length;
//        int[][] arr = new int[height][width];
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                arr[i][j] = matrix[i][j] - '0';
//            }
//        }
//        int[][] dp = new int[height][width];
//        int result = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if(arr[i][j] == 1){
//                    dp[i][j] = Math.max(1,dp[])
//                }
//            }
//        }
//    }
//}
