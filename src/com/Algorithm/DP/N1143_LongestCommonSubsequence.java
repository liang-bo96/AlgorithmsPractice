package com.Algorithm.DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1143. �����������
 * ���������ַ��� text1 �� text2�������������ַ������ ���������� �ĳ��ȡ���������� ���������� ������ 0 ��
 *
 * һ���ַ����� ������ ��ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 *
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
 * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺text1 = "abcde", text2 = "ace"
 * �����3
 * ���ͣ�������������� "ace" �����ĳ���Ϊ 3 ��
 * ʾ�� 2��
 *
 * ���룺text1 = "abc", text2 = "abc"
 * �����3
 * ���ͣ�������������� "abc" �����ĳ���Ϊ 3 ��
 * ʾ�� 3��
 *
 * ���룺text1 = "abc", text2 = "def"
 * �����0
 * ���ͣ������ַ���û�й��������У����� 0 ��
 */
public class N1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(new N1143_LongestCommonSubsequence().longestCommonSubsequence(
                "ylqpejqbalahwr",
                "yrkzavgdmdgtqpg",
                new HashMap<>()));
        System.out.println(new N1143_LongestCommonSubsequence().longestCommonSubsequence(
                "ylqpejqbalahwr",
                "yrkzavgdmdgtqpg"));
    }
    //��ʱ---------������
    public int longestCommonSubsequence(String text1, String text2, HashMap<String, Integer> map) {
        if(map.containsKey(text1+"-"+text2)){
            return map.get(text1+"-"+text2);
        }
        if(text1.length() == 0 || text2.length() == 0){
            map.put(text1+"-"+text2,0);
            return 0;
        }
        if(text1.charAt(0) == text2.charAt(0)){
            int re =  1 + longestCommonSubsequence(text1.substring(1),text2.substring(1),map);
            map.put(text1+" -"+text2,re);
            return re;
        }else{
            int re =  Math.max(longestCommonSubsequence(text1.substring(1),text2,map),
                    longestCommonSubsequence(text1,text2.substring(1),map));
            map.put(text1+"-"+text2,re);
            return re;
        }
    }
    //������
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        //���ںţ�����������������������
        for (int i = 1; i <= text1.length(); i++) {
            //���ںţ�����������������������
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i -1][j -1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    /**
     * �Ӵ�
     */
    public int longestCommonSubstring(String s1,String s2){
        //dp��ʾs1��i��β��s2��j��β��������Ӵ�
        int[][]dp = new int[s1.length() + 1][s2.length() + 1];
        int res = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }
}
