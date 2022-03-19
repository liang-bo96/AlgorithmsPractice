package com.Algorithm.BackTracking;

import java.util.*;

/**
 * 279. ��ȫƽ����
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * <p>
 * ����һ������ n �����غ�Ϊ n ����ȫƽ������ �������� ��
 * <p>
 * ��ȫƽ���� ��һ����������ֵ������һ��������ƽ�������仰˵����ֵ����һ�������Գ˵Ļ������磬1��4��9 �� 16 ������ȫƽ�������� 3 �� 11 ���ǡ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 12
 * �����3
 * ���ͣ�12 = 4 + 4 + 4
 * ʾ�� 2��
 * <p>
 * ���룺n = 13
 * �����2
 * ���ͣ�13 = 4 + 9
 */
public class N279_PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new N279_PerfectSquares().numSquares2(12));
    }
    //dp--references
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n+ 1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
