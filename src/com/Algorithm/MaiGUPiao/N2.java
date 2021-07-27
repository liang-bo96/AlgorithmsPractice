package com.Algorithm.MaiGUPiao;

public class N2 {
    public static void main(String[] args) {
//        System.out.println(new N2().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new N2().maxProfit1(new int[]{1,2,3,4,5}));
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for(int i = 1; i <= len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[len][0];
    }
        public int maxProfit1(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }


}
