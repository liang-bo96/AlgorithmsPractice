package com.Algorithm.Leetcode;

import java.util.Arrays;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 通过次数187,960提交次数445,906
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

    //超时
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
