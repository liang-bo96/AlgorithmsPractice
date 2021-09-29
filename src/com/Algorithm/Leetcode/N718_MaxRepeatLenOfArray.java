package com.Algorithm.Leetcode;

import java.util.Arrays;

/**
 * 718. ��ظ�������
 * �������������� A �� B ���������������й����ġ��������������ĳ��ȡ�
 *
 *
 *
 * ʾ����
 *
 * ���룺
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * �����3
 * ���ͣ�
 * ������Ĺ����������� [3, 2, 1] ��
 */
public class N718_MaxRepeatLenOfArray {
    public static void main(String[] args) {
        System.out.println(new N718_MaxRepeatLenOfArray().findLength1(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
    //��ʱ
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = i + 1; j <= nums1.length; j++){
                int[] tem = Arrays.copyOfRange(nums1,i,j);
                if(judge(tem,nums2)){
                    res = Math.max(res, tem.length);
                }
            }
        }
        return res;
    }
    public static boolean judge(int[] nums1, int[] nums2){
        for(int i = 0; i <= nums2.length - nums1.length; i++){
            for(int j = 0; j < nums1.length; j++){
                if(nums1[j] != nums2[i + j]){
                    break;
                }
                if(j == nums1.length - 1){
                    return true;
                }
            }
        }
        return false;
    }
    //
    public int findLength1(int[] s1, int[] s2) {
        int[][]dp = new int[s1.length + 1][s2.length + 1];
        int res = 0;
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }
    //dp��ʾs1��i��β��s2��j��β��������Ӵ�
}
