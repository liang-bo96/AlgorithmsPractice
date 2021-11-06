package com.Algorithm.Matrix;

/**
 * 73. ��������
 * ����һ�� m x n �ľ������һ��Ԫ��Ϊ 0 �����������к��е�����Ԫ�ض���Ϊ 0 ����ʹ�� ԭ�� �㷨��
 * <p>
 * ���ף�
 * <p>
 * һ��ֱ�۵Ľ��������ʹ��  O(mn) �Ķ���ռ䣬���Ⲣ����һ���õĽ��������
 * һ���򵥵ĸĽ�������ʹ�� O(m + n) �Ķ���ռ䣬������Ȼ������õĽ��������
 * �������һ����ʹ�ó����ռ�Ľ��������
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * �����[[1,0,1],[0,0,0],[1,0,1]]
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * �����[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class N75_SetMatrixZero {
    /**
     * ˼·:
     * ˼·һ: �� O(m+n)����ռ�
     *
     * ����ɨmatrix,��һ���ü��ϼ�¼��Щ��,��Щ����0;�ڶ�����0
     *
     * ˼·��: ��O(1)�ռ�
     *
     * �ؼ�˼��: ��matrix��һ�к͵�һ�м�¼���и����Ƿ���0,��Ϊ��־λ
     *
     * ���Ƕ��ڵ�һ��,�͵�һ��Ҫ����һ����־λ,Ϊ�˷�ֹ�Լ���һ��(һ��)Ҳ��0�����.���ñ�־λ��������
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        // ��һ���Ƿ�����
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }
        }
        // ��һ���Ƿ�����
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }
        }
        // �ѵ�һ�е�һ����Ϊ��־λ
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // ��0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

