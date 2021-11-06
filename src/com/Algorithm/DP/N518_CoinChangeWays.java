package com.Algorithm.DP;

/**
 * 518. ��Ǯ�һ� II
 * ����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�
 *
 * ������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��
 *
 * ����ÿһ������Ӳ�������޸���
 *
 * ��Ŀ���ݱ�֤������� 32 λ������������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺amount = 5, coins = [1, 2, 5]
 * �����4
 * ���ͣ������ַ�ʽ���Դճ��ܽ�
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class N518_CoinChangeWays {
    public static void main(String[] args) {
        System.out.println(new N518_CoinChangeWays().change(5, new int[]{1, 2, 5}));
    }
    /**
     * �������Ϊ coin ��Ӳ�ң��� coin��i��amount ʱ���������һ��Ӳ����ϵĽ��֮�͵���i?coin��
     * ���ڸ�Ӳ�����������һ�����Ϊ coin ��Ӳ�ң����ɵõ�һ�ֽ��֮�͵��� ii ��Ӳ����ϡ�
     * �����Ҫ����coins���������е�ÿһ������Ӳ�ң��������� dp �е�ÿ�����ڻ���ڸ�����Ԫ�ص�ֵ��
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
