package com.Algorithm.Leetcode;

/**
 * 169. ����Ԫ��
 * ����һ����СΪ n �����飬�ҵ����еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
 * <p>
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[3,2,3]
 * �����3
 * ʾ�� 2��
 * <p>
 * ���룺[2,2,1,1,1,2,2]
 * �����2
 */
public class N169_MostNum_moertoupiao {
    //�ӵ�һ������ʼcount=1��������ͬ�ľͼ�1��������ͬ�ľͼ�1������0�����»�������ʼ�����������ҵ������Ǹ�
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int count = 0;
        int tem = nums[0];
        for (int i : nums) {
            if (count == 0) {
                tem = i;
            }
            if (i != tem) {
                count--;
            } else {
                count++;
            }
        }
        return tem;
    }
}
