package com.Algorithm.DoublePointer;

import java.util.Arrays;

/**
 * 31. ��һ������
 * ʵ�ֻ�ȡ ��һ������ �ĺ������㷨��Ҫ���������������������г��ֵ�������һ����������У�������ϳ���һ���������������
 *
 * �����������һ����������У��������������г���С�����У����������У���
 *
 * ���� ԭ�� �޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3]
 * �����[1,3,2]
 * ʾ�� 2��
 *
 * ���룺nums = [3,2,1]
 * �����[1,2,3]
 * ʾ�� 3��
 *
 * ���룺nums = [1,1,5]
 * �����[1,5,1]
 * ʾ�� 4��
 *
 * ���룺nums = [1]
 * �����[1]
 */
public class N31_NextPermutation {
    public static void main(String[] args) {
        new N31_NextPermutation().nextPermutation(new int[]{1,4,5,2,1});
    }
    public void nextPermutation(int[] nums) {
        int max = nums[nums.length - 1];
        int left = 0;
        boolean flag = false;
        //�ҵ����Խ��������λ��
        for(int i = nums.length - 1 ; i >= 0 ;i--){
            if(nums[i] < max){
                left = i;
                flag = true;
                break;
            }
            max = Math.max(nums[i],max);
        }
        //�ҵ����Խ������Ҳ�λ��
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
        //���λ���ұ����ִ��ڽ��򣬷�ת������
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
