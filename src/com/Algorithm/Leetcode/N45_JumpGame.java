package com.Algorithm.Leetcode;

/**
 * 45. ��Ծ��Ϸ II
 * ����һ���Ǹ��������� nums �������λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 *
 * ���������ǿ��Ե�����������һ��λ�á�
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: nums = [2,3,1,1,4]
 * ���: 2
 * ����: �������һ��λ�õ���С��Ծ���� 2��
 *      ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
 * ʾ�� 2:
 *
 * ����: nums = [2,3,0,1,4]
 * ���: 2
 */
public class N45_JumpGame {
    public static void main(String[] args) {
        System.out.println(new N45_JumpGame().jump(new int[]{2, 3, 1, 1, 4}));
    }
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for(int i = 0;i<nums.length;i++){
            //�������λ��
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= nums.length-1) {
                return (step+1);
            }
            //�Ѿ��ߵ���һ�����ߵ�����Զλ�ã���Ҫ������һ�����ߵ�����Զλ��
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
