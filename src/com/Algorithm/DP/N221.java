package com.Algorithm.DP;

/**
 * 221. ���������
 * ��һ���� '0' �� '1' ��ɵĶ�ά�����ڣ��ҵ�ֻ���� '1' ����������Σ��������������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺matrix =
 * [["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]]
 * �����4
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺matrix = [["0","1"],["1","0"]]
 * �����1
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
     * 1277. ͳ��ȫΪ 1 ���������Ӿ���
     * ����һ�� m * n �ľ��󣬾����е�Ԫ�ز��� 0 ���� 1������ͳ�Ʋ�����������ȫ�� 1 ��ɵ� ������ �Ӿ���ĸ�����
     * <p>
     * <p>
     * <p>
     * ʾ�� 1��
     * <p>
     * ���룺matrix =
     * [
     * [0,1,1,1],
     * [1,1,1,1],
     * [0,1,1,1]
     * ]
     * �����15
     * ���ͣ�
     * �߳�Ϊ 1 ���������� 10 ����
     * �߳�Ϊ 2 ���������� 4 ����
     * �߳�Ϊ 3 ���������� 1 ����
     * �����ε����� = 10 + 4 + 1 = 15.
     * ʾ�� 2��
     * <p>
     * ���룺matrix =
     * [
     * [1,0,1],
     * [1,1,0],
     * [1,1,0]
     * ]
     * �����7
     * ���ͣ�
     * �߳�Ϊ 1 ���������� 6 ����
     * �߳�Ϊ 2 ���������� 1 ����
     * �����ε����� = 6 + 1 = 7.
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
