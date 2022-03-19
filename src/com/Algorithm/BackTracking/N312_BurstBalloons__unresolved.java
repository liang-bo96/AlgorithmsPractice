package com.Algorithm.BackTracking;

public class N312_BurstBalloons__unresolved {
    public static void main(String[] args) {
        System.out.println(new N312_BurstBalloons__unresolved().maxCoins(new int[]{2, 5}));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // ����һ���������飬������β�����1�����㴦��߽����
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        // len��ʾ�����䳤��
        for (int len = 3; len <= n + 2; len++) {
            // i��ʾ��������˵�
            for (int i = 0; i <= n + 2 - len; i++) {
                int res = 0;
                // kΪ�������ڵ�����
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + temp[i] * temp[k] * temp[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][n + 1];
    }
}
