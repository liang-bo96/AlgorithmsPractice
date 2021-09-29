package com.Algorithm.DP;

/**
 * 64. ��С·����
 * ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 *
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺grid =
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * �����7
 * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 */
public class N64_MinimumPathSum {
    public static void main(String[] args) {

    }
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = grid[0][i] + grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
