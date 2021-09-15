package com.Algorithm.Leetcode;

import java.util.Stack;

public class N121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int result = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] < prices[i]) {
                    result = Math.max(result, prices[i] - prices[i]);
                }
            }
        }
        return result;
    }

    //for practice
//    public static int maxProfit1(int[] prices) {
//
//    }
}
