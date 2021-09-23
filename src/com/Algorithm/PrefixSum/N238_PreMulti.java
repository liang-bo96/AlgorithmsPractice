package com.Algorithm.PrefixSum;

import java.util.Arrays;

/**
 * 238. ��������������ĳ˻�
 * ����һ������Ϊ n ���������� nums������ n > 1������������� output ������ output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���
 *
 *
 *
 * ʾ��:
 *
 * ����: [1,2,3,4]
 * ���: [24,12,8,6]
 */
public class N238_PreMulti {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for(int i = 1; i < pre.length; i++){
            pre[i] = pre[i-1] * nums[i];
        }
        int[] pos = new int[nums.length];
        pos[pos.length - 1] = nums[pos.length - 1];
        for(int i = pos.length - 2; i >= 0; i--){
            pos[i] = pos[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        result[0] = pos[1];
        for(int i = 1 ; i < nums.length - 1; i++){
            result[i] = pre[i-1] * pos[i+1];
        }
        result[nums.length - 1] = pre[nums.length - 2];
        return result;
    }
}
