package com.Algorithm.DP;
//最长回文子序列
public class N516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(new N516_LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s) {
        String s1 = reverse(s);
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(s.charAt(i-1) == s1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][s1.length()];
    }
    public static String reverse(String s){
        String re = "";
        for(int i = s.length() - 1; i >= 0; i--){
            re += String.valueOf(s.charAt(i));
        }
        return re;
    }


    //递归写法
    public int longestPalindromeSubseq1(String s) {
        return recursive(s,0,s.length()-1);
    }
    public int recursive(String s,int i,int j){
        if(i >=j){
            return 0;
        }
        if(s.charAt(i) == s.charAt(j)){
            return recursive(s,i+1,j-1)+2;
        }else{
            return Math.max(recursive(s,i+1,j),recursive(s,i,j-1));
        }
    }
}
