//package com.Algorithm.DP;
//
///**
// * 85. ������
// * ����һ�������� 0 �� 1 ����СΪ rows x cols �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ��������������
// *
// *
// *
// * ʾ�� 1��
// *
// *
// * ���룺matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// * �����6
// * ���ͣ�����������ͼ��ʾ��
// * ʾ�� 2��
// *
// * ���룺matrix = []
// * �����0
// * ʾ�� 3��
// *
// * ���룺matrix = [["0"]]
// * �����0
// * ʾ�� 4��
// *
// * ���룺matrix = [["1"]]
// * �����1
// * ʾ�� 5��
// *
// * ���룺matrix = [["0","0"]]
// * �����0
// */
//public class N85_MaxRectangle {
//    public int maximalRectangle(char[][] matrix) {
//        int height = matrix.length;
//        int width = matrix[0].length;
//        int[][] arr = new int[height][width];
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                arr[i][j] = matrix[i][j] - '0';
//            }
//        }
//        int[][] dp = new int[height][width];
//        int result = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if(arr[i][j] == 1){
//                    dp[i][j] = Math.max(1,dp[])
//                }
//            }
//        }
//    }
//}
