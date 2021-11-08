package com.Algorithm.DP;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1690
 */
public class N264_UglyNum {
    //求第n小的丑数
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //初始化三个指针
        int n2 = 1;
        int n3 = 1;
        int n5 = 1;
        for(int i = 2; i < n + 1; i++){
            //目前最小的丑数分别乘上 2 3 5
            int num2 = dp[n2] * 2;
            int num3 = dp[n3] * 3;
            int num5 = dp[n5] * 5;
            //选取最小的丑数
            dp[i] = Math.min(Math.min(num2,num3),num5);
            //选取成功的指针进行右移
            if(num2 == dp[i]){
                n2++;
            }
            if(num3 == dp[i]){
                n3++;
            }
            if(num5 == dp[i]){
                n5++;
            }
        }
        return dp[n];
    }
    // practice:
    public int nthUglyNumber1(int n) {
        int count = 0;
        Queue<Long> q = new PriorityQueue<>();
        q.add(1L);
        HashSet<Long> set= new HashSet<>();
        long result = 0;
        while(count < n){
            long poll = q.poll();
            count++;
            result = poll;
            if(!set.contains(poll * 2)){
                q.add(poll * 2);
                set.add(poll * 2);
            }
            if(!set.contains(poll * 3)){
                q.add(poll * 3);
                set.add(poll * 3);
            }
            if(!set.contains(poll * 5)){
                q.add(poll * 5);
                set.add(poll * 5);
            }
        }
        return (int)result;
    }
}
