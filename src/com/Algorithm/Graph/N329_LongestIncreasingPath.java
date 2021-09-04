package com.Algorithm.Graph;

import com.Algorithm.Graph.GraphGenerator;

public class N329_LongestIncreasingPath {
    public static void main(String[] args) {
        System.out.println(new N329_LongestIncreasingPath().longestIncreasingPath(new int[][]{{3,4,5}, {3,2,6}, {2,2,1}}));
    }
    //³¬Ê±
    static int result;
    public int longestIncreasingPath(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix,i,j,Integer.MIN_VALUE,1);
            }
        }
        return result;
    }
    public static void dfs(int[][]matrix,int x, int y,int tem,int location){
        if(x < 0 ||x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= tem){
            return;
        }
        result = Math.max(result,location);
        dfs(matrix,x + 1,y,matrix[x][y],location + 1);
        dfs(matrix,x - 1,y,matrix[x][y],location + 1);
        dfs(matrix,x,y + 1,matrix[x][y],location + 1);
        dfs(matrix,x,y - 1,matrix[x][y],location + 1);
    }
}
