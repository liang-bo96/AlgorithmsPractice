package com.Algorithm.MergerInterval;

/**
 * ���룺timeSeries = [1,4], duration = 2
 * �����4
 * ���ͣ���Ī�����԰�ϣ��Ӱ�����£�
 * - �� 1 �룬��Ī������ϣ��ʹ�������ж����ж�״̬��ά�� 2 �룬���� 1 ��͵� 2 �롣
 * - �� 4 �룬��Ī�ٴι�����ϣ����ϣ�ж�״̬�ֳ��� 2 �룬���� 4 ��͵� 5 �롣
 * ��ϣ�ڵ� 1��2��4��5 �봦���ж�״̬���������ж������� 4 ��
 * ʾ�� 2��
 *
 * ���룺timeSeries = [1,2], duration = 2
 * �����3
 * ���ͣ���Ī�����԰�ϣ��Ӱ�����£�
 * - �� 1 �룬��Ī������ϣ��ʹ�������ж����ж�״̬��ά�� 2 �룬���� 1 ��͵� 2 �롣
 * - �� 2 �룬��Ī�ٴι�����ϣ���������ж���ʱ������ϣ�ж�״̬��Ҫ���� 2 �룬���� 2 ��͵� 3 �롣
 * ��ϣ�ڵ� 1��2��3 �봦���ж�״̬���������ж������� 3 ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/teemo-attacking
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class N495_mergeInterval_simple {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int expire = 0;
        //����ǰ��ʼ��ʱ����Ƿ����ж�������
        //���ڵĻ�ֱ�Ӽ���duration
        //�ڵĻ����ϵ�ǰʱ��Ľ���ʱ���ȥ֮���ж��Ľ�����
        for(int i = 0; i < timeSeries.length; i++){
            if(timeSeries[i] > expire){
                ans += duration;
            }else{
                ans += timeSeries[i] + duration - expire;
            }
            expire = timeSeries[i] + duration;
        }
        return ans;
    }
}
