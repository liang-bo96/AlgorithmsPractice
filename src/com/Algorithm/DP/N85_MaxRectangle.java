package com.Algorithm.DP;

import static com.Algorithm.SingleStack.N84_LargestRectangle.largestRectangleArea1;

/**
 * 85. ������
 * ����һ�������� 0 �� 1 ����СΪ rows x cols �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ��������������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * �����6
 * ���ͣ�����������ͼ��ʾ��
 * ʾ�� 2��
 * <p>
 * ���룺matrix = []
 * �����0
 * ʾ�� 3��
 * <p>
 * ���룺matrix = [["0"]]
 * �����0
 * ʾ�� 4��
 * <p>
 * ���룺matrix = [["1"]]
 * �����1
 * ʾ�� 5��
 * <p>
 * ���룺matrix = [["0","0"]]
 * �����0
 */
public class N85_MaxRectangle {
    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'},
                }
        ));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] arr = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = matrix[i][j] - '0';
            }
        }
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] heights = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k <= i; k++) {
                    if(arr[k][j] == 1){
                        heights[j]++;
                    }else{
                        heights[j] = 0;
                    }
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea1(heights));
        }
        return maxArea;
    }

    //�����ⷨ
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //�����Ե�ǰ���ֽ�β������ 1 �ĸ���
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        //����ÿһ��
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //���� width
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //��¼����������С����
                int minWidth = width[row][col];
                //������չ��
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //����С������Ϊ����Ŀ�
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    //�������
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }
}
