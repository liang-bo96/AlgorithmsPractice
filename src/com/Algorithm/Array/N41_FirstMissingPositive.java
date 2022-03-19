package com.Algorithm.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. ȱʧ�ĵ�һ������
 * ����һ��δ������������� nums �������ҳ�����û�г��ֵ���С����������
 *
 * ����ʵ��ʱ�临�Ӷ�Ϊ O(n) ����ֻʹ�ó����������ռ�Ľ��������
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,0]
 * �����3
 * ʾ�� 2��
 *
 * ���룺nums = [3,4,-1,1]
 * �����2
 * ʾ�� 3��
 *
 * ���룺nums = [7,8,9,11,12]
 * �����1
 */
public class N41_FirstMissingPositive {
    public static void main(String[] args) {

    }
    //hash ���
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i :nums){
            set.add(i);
        }
        for(int i = 1; i <= nums.length + 1; i++){
            int size = set.size();
            set.add(i);
            if(size != set.size()){
                return i;
            }
        }
        return -1;
    }
    //�ο���
    public int firstMissingPositive1(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // ������ָ����Χ�ڡ�����û�з�����ȷ��λ���ϣ��Ž���
                // ���磺��ֵ 3 Ӧ�÷������� 2 ��λ����
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // ����ȷ�򷵻����鳤�� + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
