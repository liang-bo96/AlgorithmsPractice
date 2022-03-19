package com.Algorithm.Graph;
/**
 * 329. 矩阵中的最长递增路径
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 *
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */

import java.util.HashMap;

public class N329_LongestIncreasingPath {
    public static void main(String[] args) {
        System.out.println(new N329_LongestIncreasingPath().longestIncreasingPath(new int[][]{{9,9,4}, {6,6,8}, {2,1,1}}));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result,dfs(matrix,i,j,Integer.MIN_VALUE,map));
            }
        }
        return result;
    }
    public static int dfs(int[][]matrix, int x, int y, int tem, HashMap<String, Integer> map){
        if(x < 0 ||x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= tem){
            return 0;
        }
        if(map.containsKey(x + "-" + y)){
            return map.get(x + "-" + y);
        }
        int result = 0;
        result = Math.max(dfs(matrix,x + 1,y,matrix[x][y],map) + 1,result);
        result = Math.max(dfs(matrix,x - 1,y,matrix[x][y],map) + 1,result);
        result = Math.max(dfs(matrix,x,y + 1,matrix[x][y],map) + 1,result);
        result = Math.max(dfs(matrix,x,y - 1,matrix[x][y],map) + 1,result);
        map.put(x + "-" + y,result);
        return result;
    }
}
