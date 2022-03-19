package com.Algorithm.Graph;
/**
 * 329. �����е������·��
 * ����һ�� m x n �������� matrix ���ҳ����� �����·�� �ĳ��ȡ�
 *
 * ����ÿ����Ԫ����������ϣ��£������ĸ������ƶ��� �� ���� �� �Խ��� �������ƶ����ƶ��� �߽��⣨���������ƣ���
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * �����4
 * ���ͣ������·��Ϊ [1, 2, 6, 9]��
 * ʾ�� 2��
 *
 *
 * ���룺matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * �����4
 * ���ͣ������·���� [3, 4, 5, 6]��ע�ⲻ�����ڶԽ��߷������ƶ���
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
