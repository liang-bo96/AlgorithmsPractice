package com.Algorithm.SlidingWindow;

/**
 * 209. ������С��������
 * ����һ������ n ���������������һ�������� target ��
 *
 * �ҳ���������������� �� target �ĳ�����С�� ���������� [numsl, numsl+1, ..., numsr-1, numsr] ���������䳤�ȡ���������ڷ��������������飬���� 0 ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺target = 7, nums = [2,3,1,2,4,3]
 * �����2
 * ���ͣ������� [4,3] �Ǹ������µĳ�����С�������顣
 * ʾ�� 2��
 *
 * ���룺target = 4, nums = [1,4,4]
 * �����1
 * ʾ�� 3��
 *
 * ���룺target = 11, nums = [1,1,1,1,1,1,1,1]
 * �����0
 */
public class N209_minArray {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while(right <nums.length){
            sum += nums[right];
            while(sum >= target){
                len = Math.min(len,right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}
