package com.Algorithm.DFS;

/**
 * 695. �����������
 * ����һ����СΪ m x n �Ķ����ƾ��� grid ��
 * <p>
 * ���� ����һЩ���ڵ� 1 (��������) ���ɵ���ϣ�����ġ����ڡ�Ҫ������ 1 ������ ˮƽ������ֱ���ĸ������� ���ڡ�����Լ��� grid ���ĸ���Ե���� 0������ˮ����Χ�š�
 * <p>
 * ���������ǵ���ֵΪ 1 �ĵ�Ԫ�����Ŀ��
 * <p>
 * ���㲢���� grid �����ĵ�����������û�е��죬�򷵻����Ϊ 0 ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * �����6
 * ���ͣ��𰸲�Ӧ���� 11 ����Ϊ����ֻ�ܰ���ˮƽ��ֱ���ĸ������ϵ� 1 ��
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
        //ʹ��visited �Ǵ���ķ���������[[1,1],[1,1]],���Ϊ7��ԭ��������0,1 �� 1,0 �����ظ�ͳ���˽ڵ���������ԭ�ֳ������ݷ��ص㣩�������½������
        // ��ȷ�ķ����Ƿ��ʹ��Ľڵ���Ϊ��־λ
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
