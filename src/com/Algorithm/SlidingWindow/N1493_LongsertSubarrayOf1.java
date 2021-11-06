package com.Algorithm.SlidingWindow;

/**
 * 1493. ɾ��һ��Ԫ���Ժ�ȫΪ 1 ���������
 * ����һ������������ nums ������Ҫ����ɾ��һ��Ԫ�ء�
 *
 * ������ɾ��Ԫ�صĽ�������У����������ֻ���� 1 �ķǿ�������ĳ��ȡ�
 *
 * ��������������������飬�뷵�� 0 ��
 *
 *
 *
 * ��ʾ 1��
 *
 * ���룺nums = [1,1,0,1]
 * �����3
 * ���ͣ�ɾ��λ�� 2 ������[1,1,1] ���� 3 �� 1 ��
 * ʾ�� 2��
 *
 * ���룺nums = [0,1,1,1,0,1,1,0,1]
 * �����5
 * ���ͣ�ɾ��λ�� 4 �����ֺ�[0,1,1,1,1,1,0,1] ���ȫ 1 ������Ϊ [1,1,1,1,1] ��
 * ʾ�� 3��
 *
 * ���룺nums = [1,1,1]
 * �����2
 * ���ͣ������Ҫɾ��һ��Ԫ�ء�
 */
public class N1493_LongsertSubarrayOf1 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
    }
    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        while(right < nums.length){
            if (nums[right] == 0){
                count++;
            }
            while(count > 1){
                if (nums[left] == 0){
                    count--;
                }
                left++;
            }
            result = Math.max(result,right - left + 1);
            right++;
        }
        return result - 1;
    }
}
