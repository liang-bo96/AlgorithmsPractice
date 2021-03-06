package com.Algorithm.DP;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class N518_CoinChangeWays {
    public static void main(String[] args) {
        System.out.println(new N518_CoinChangeWays().change(5, new int[]{1, 2, 5}));
    }
    /**
     * 对于面额为 coin 的硬币，当 coin≤i≤amount 时，如果存在一种硬币组合的金额之和等于i?coin，
     * 则在该硬币组合中增加一个面额为 coin 的硬币，即可得到一种金额之和等于 ii 的硬币组合。
     * 因此需要遍历coins，对于其中的每一种面额的硬币，更新数组 dp 中的每个大于或等于该面额的元素的值。
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
