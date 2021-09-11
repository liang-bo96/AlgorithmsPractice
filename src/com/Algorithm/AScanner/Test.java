package com.Algorithm.AScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
4
4
0 0 0 0
0 1 0 0
0 0 1 0
0 0 1 0
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int[][] matrix = new int[height][width];
        for(int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] == 1){
                    l.add(new int[]{i,j});
                }
            }
        }
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] arr : l){
            boolean[][] visited = new boolean[height][width];
            dfs(arr[0],arr[1],matrix,0,visited);
        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width - 1; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println(matrix[i][width - 1]);
        }
    }

    public static void dfs(int x,int y,int[][]matrix,int len,boolean[][]visited){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y]){
            return;
        }
        if(matrix[x][y] > len){
            matrix[x][y] = len;
        }
        visited[x][y] = true;
        dfs(x + 1,y,matrix,len + 1,Arrays.copyOf(visited,visited.length));
        dfs(x - 1,y,matrix,len + 1, Arrays.copyOf(visited,visited.length));
        dfs(x,y + 1,matrix,len + 1, Arrays.copyOf(visited,visited.length));
        dfs(x,y - 1,matrix,len + 1,Arrays.copyOf(visited,visited.length));
        visited[x][y] = false;
    }
}
