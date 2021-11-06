package com.Algorithm.Matrix;

/**
 * ����һ�� n?��?n �Ķ�ά����?matrix ��ʾһ��ͼ�����㽫ͼ��˳ʱ����ת 90 �ȡ�
 *
 * ������� ԭ�� ��תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫ ʹ����һ����������תͼ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 *
 * ���룺matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * �����[[7,4,1],[8,5,2],[9,6,3]]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rotate-image
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class N48_RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
