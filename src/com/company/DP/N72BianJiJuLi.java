package com.company.DP;

public class N72BianJiJuLi {
    public static void main(String[] args) {
        System.out.println(new N72BianJiJuLi().minDistance("dizine","aczine"));
        int[][] dp = new int[10][10];
        System.out.println(new N72BianJiJuLi().minDistance2("dizine","aczine",dp));
    }

    public int minDistance2(String word1, String word2,int[][] dp){

        int i = word1.length()-1;
        int j = word2.length()-1;
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(i == 0) {
            dp[i][j] = j;
            return dp[i][j];
        }
        if(j == 0) {
            dp[i][j] = i;
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = minDistance2(word1.substring(0,i),word2.substring(0,j),dp);
            return dp[i][j];
        }
        else{
            dp[i][j] = 1+Math.min(minDistance2(word1,word2.substring(0,j),dp)
                    ,Math.min(minDistance2(word1.substring(0,i),word2,dp),
                            minDistance2(word1.substring(0,i),word2.substring(0,j),dp)));
            return dp[i][j];
        }
    }


    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length()==0){

            return word1.length()== 0 ? word2.length() : word1.length();
        }
        if(word1.charAt(0) == word2.charAt(0)){
            return minDistance(word1.substring(1),word2.substring(1));
        }
        else{
            return 1+Math.min(minDistance(word1,word2.substring(1))
                    ,Math.min(minDistance(word1.substring(1),word2),
                            minDistance(word1.substring(1),word2.substring(1))));
        }
    }
}
