package com.Algorithm.DP;

public class N516 {
    public int longestPalindromeSubseq(String s) {
        // int len = s.length();
        // int[][] dp = new int[len][len];
        // for(int i = 0;i < len; i++){
        //     dp[i][i] = 1;
        // }
        // for(int i = len-1 ; i >=0; i--){
        //     for(int j = i + 1; j < len; j++){
        //         if(s.charAt(i) == s.charAt(j)){
        //             dp[i][j] = dp[i+1][j-1] + 2;
        //         }else{
        //             dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
        //         }
        //     }
        // }
        // return dp[0][len-1];

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

    public static void main(String[] args) {
        System.out.println(new N516().longestPalindromeSubseq("bbbab"));
    }
}
