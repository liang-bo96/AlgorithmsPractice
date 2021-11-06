package com.Algorithm.Leetcode;

import java.util.Arrays;

/**
 * 152. �˻����������
 * ����һ���������� nums �������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [2,3,-2,4]
 * ���: 6
 * ����: ������ [2,3] �����˻� 6��
 * ʾ�� 2:
 * <p>
 * ����: [-2,0,-1]
 * ���: 0
 * ����: �������Ϊ 2, ��Ϊ [-2,-1] ���������顣
 * ͨ������187,960�ύ����445,906
 */
public class N152_MaxMultiplySubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct1(new int[]{-2, 0, -1}));
    }
    public static int maxProduct1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int tem_max = 1;
        int tem_min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tem = tem_max;
                tem_max = tem_min;
                tem_min = tem;
            }
            tem_max = Math.max(nums[i], tem_max * nums[i]);
            tem_min = Math.min(nums[i], tem_min * nums[i]);

            result = Math.max(result,tem_max);
        }
        return result;
    }

    //��ʱ
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tem = 1;
                for (int k = i; k <= j; k++) {
                    tem *= nums[k];
                }
                result = Math.max(result, tem);
            }
        }
        return result;
    }
}
