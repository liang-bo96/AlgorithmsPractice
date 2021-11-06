package com.Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. �ҵ�������������ʧ������
 * ����һ���� n ������������ nums ������ nums[i] ������ [1, n] �ڡ������ҳ������� [1, n] ��Χ�ڵ�û�г����� nums �е����֣�
 * �����������ʽ���ؽ����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,3,2,7,8,2,3,1]
 * �����[5,6]
 * ʾ�� 2��
 *
 * ���룺nums = [1,1]
 * �����[2]
 *
 */
public class N448_FindMissingNum {
    //�������飬��ֵ��Ӧλ���±������Ϊ���� Ȼ��������飬��������δ���ֵ�����
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i : nums){
            if(nums[Math.abs(i) - 1] > 0){
                nums[Math.abs(i) - 1] *= -1;
            }
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                l.add(i + 1);
            }
        }
        return l;
    }
}
