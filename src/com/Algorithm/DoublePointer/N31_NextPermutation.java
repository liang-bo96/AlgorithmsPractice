package com.Algorithm.DoublePointer;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 */
public class N31_NextPermutation {
    public static void main(String[] args) {
        new N31_NextPermutation().nextPermutation(new int[]{1,4,5,2,1});
    }
    public void nextPermutation(int[] nums) {
        int max = nums[nums.length - 1];
        int left = 0;
        boolean flag = false;
        //找到可以交换的左侧位置
        for(int i = nums.length - 1 ; i >= 0 ;i--){
            if(nums[i] < max){
                left = i;
                flag = true;
                break;
            }
            max = Math.max(nums[i],max);
        }
        //找到可以交换的右侧位置
        for(int i = nums.length - 1; i > left; i--){
            if(nums[i] > nums[left]){
                int tem = nums[i];
                nums[i] = nums[left];
                nums[left] = tem;
                break;
            }
        }
        if(!flag){
            left = -1;
        }
        //左侧位置右边数字处于降序，反转成升序
        reverse(nums,left + 1);
        System.out.println(Arrays.toString(nums));
    }
    public  static void reverse(int[]arr,int left){
        int right = arr.length - 1;
        while(left < right){
            int tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;
            left++;
            right--;
        }
    }
}
