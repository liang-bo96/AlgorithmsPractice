package com.Algorithm.DP;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 264. ���� II
 * ����һ������ n �������ҳ������ص� n �� ���� ��
 *
 * ���� ����ֻ���������� 2��3 ��/�� 5 ����������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺n = 10
 * �����12
 * ���ͣ�[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] ����ǰ 10 ��������ɵ����С�
 * ʾ�� 2��
 *
 * ���룺n = 1
 * �����1
 * ���ͣ�1 ͨ������Ϊ������
 *
 *
 * ��ʾ��
 *
 * 1 <= n <= 1690
 */
public class N264_UglyNum {
    //���nС�ĳ���
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //��ʼ������ָ��
        int n2 = 1;
        int n3 = 1;
        int n5 = 1;
        for(int i = 2; i < n + 1; i++){
            //Ŀǰ��С�ĳ����ֱ���� 2 3 5
            int num2 = dp[n2] * 2;
            int num3 = dp[n3] * 3;
            int num5 = dp[n5] * 5;
            //ѡȡ��С�ĳ���
            dp[i] = Math.min(Math.min(num2,num3),num5);
            //ѡȡ�ɹ���ָ���������
            if(num2 == dp[i]){
                n2++;
            }
            if(num3 == dp[i]){
                n3++;
            }
            if(num5 == dp[i]){
                n5++;
            }
        }
        return dp[n];
    }
    // practice:
    public int nthUglyNumber1(int n) {
        int count = 0;
        Queue<Long> q = new PriorityQueue<>();
        q.add(1L);
        HashSet<Long> set= new HashSet<>();
        long result = 0;
        while(count < n){
            long poll = q.poll();
            count++;
            result = poll;
            if(!set.contains(poll * 2)){
                q.add(poll * 2);
                set.add(poll * 2);
            }
            if(!set.contains(poll * 3)){
                q.add(poll * 3);
                set.add(poll * 3);
            }
            if(!set.contains(poll * 5)){
                q.add(poll * 5);
                set.add(poll * 5);
            }
        }
        return (int)result;
    }
}
