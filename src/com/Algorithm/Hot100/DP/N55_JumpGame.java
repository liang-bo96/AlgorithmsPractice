package com.Algorithm.Hot100.DP;

/**
 * 55. ��Ծ��Ϸ
 * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
 * <p>
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * <p>
 * �ж����Ƿ��ܹ��������һ���±ꡣ
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [2,3,1,1,4]
 * �����true
 * ���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ
 * ʾ�� 2��
 * <p>
 * ���룺nums = [3,2,1,0,4]
 * �����false
 * ���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0 �� ������Զ�����ܵ������һ���±ꡣ
 */
public class N55_JumpGame {
    public static void main(String[] args) {
        System.out.println(new N55_JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < dp.length && dp[i]; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    dp[nums.length - 1] = true;
                } else {
                    dp[i + j] = true;
                }
                if (dp[nums.length - 1]) {
                    return true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    //    references
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
