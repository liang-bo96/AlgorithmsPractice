package com.Algorithm.DP;

/**
 * ����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
 *
 * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
 *
 * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
 *
 * ʾ�� 1��
 * ���룺[7,1,5,3,6,4]
 * �����5
 * ���ͣ��ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
 *
 * ʾ�� 2��
 * ���룺prices = [7,6,4,3,1]
 * �����0
 * ���ͣ������������, û�н������, �����������Ϊ 0��
 */
public class GuPiao {
    //����һ��
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[][] dp = new int[prices.length][2];
        //1 û�й�Ʊ
        //0 �й�Ʊ
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return dp[len - 1][1];
    }
    //���޴���
    public int maxProfitn(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[][] dp = new int[prices.length][2];
        //1 û�й�Ʊ
        //0 �й�Ʊ
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return dp[len - 1][1];
    }
    //����
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        /*
         * ���� 5 ��״̬:
         * 0: û�в���, 1: ��һ������, 2: ��һ������, 3: �ڶ�������, 4: �ڶ�������
         */
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
    //k��
    public int maxProfitk(int k, int[] prices) {

        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }
        for (int i = 1;i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }

}
