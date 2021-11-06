package com.Algorithm.DP;

import java.util.HashMap;

/**
 * 1218. �����������
 * ����һ���������� arr ��һ������ difference�������ҳ������� arr ����Ȳ������еĳ��ȣ���������������Ԫ��֮��Ĳ���� difference ��
 *
 * ������ ��ָ�ڲ��ı�����Ԫ��˳�������£�ͨ��ɾ��һЩԪ�ػ�ɾ���κ�Ԫ�ض��� arr �������������С�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺arr = [1,2,3,4], difference = 1
 * �����4
 * ���ͣ���ĵȲ��������� [1,2,3,4]��
 * ʾ�� 2��
 *
 * ���룺arr = [1,3,5,7], difference = 1
 * �����1
 * ���ͣ���ĵȲ������������ⵥ��Ԫ�ء�
 * ʾ�� 3��
 *
 * ���룺arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * �����4
 * ���ͣ���ĵȲ��������� [7,5,3,1]��
 */
public class N1218_LongestSubsequence_dengchazixulie {
    public int longestSubsequence(int[] arr, int difference) {
        int result = 0;
        //dp[i]��ʾ�Ե�ǰλ�ý�β����Ȳ�������
        int[] dp = new int[arr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            //��֮ǰ�Ƿ���ֹ����㵱ǰλ����ֵ��ȥdifference����ֵ���еĻ�����֮ǰ�Ļ����ϼ�һ
            dp[i] = Math.max(dp[i],map.getOrDefault(arr[i] - difference,0) + 1);
            map.put(arr[i],dp[i]);
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
