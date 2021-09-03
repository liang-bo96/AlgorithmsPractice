package com.Algorithm.Graph;

/**
 * 200. ��������
 * ����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
 *
 * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
 *
 * ���⣬����Լ��������������߾���ˮ��Χ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * �����1
 * ʾ�� 2��
 *
 * ���룺grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * �����3
 *
 */
public class N200_NumberOfIsland {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        int height = grid.length;
        int width = grid[0].length;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void dfs(char[][]grid,int i, int j){
        if(i < 0 || i >= grid.length || j <0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i - 1,j);
        dfs(grid,i + 1,j);
        dfs(grid,i,j - 1);
        dfs(grid,i,j + 1);
    }
}
