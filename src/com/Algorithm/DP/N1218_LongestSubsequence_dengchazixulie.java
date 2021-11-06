package com.Algorithm.DP;

import java.util.HashMap;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 */
public class N1218_LongestSubsequence_dengchazixulie {
    public int longestSubsequence(int[] arr, int difference) {
        int result = 0;
        //dp[i]表示以当前位置结尾的最长等差子序列
        int[] dp = new int[arr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            //找之前是否出现过满足当前位置数值减去difference的数值，有的话就在之前的基础上加一
            dp[i] = Math.max(dp[i],map.getOrDefault(arr[i] - difference,0) + 1);
            map.put(arr[i],dp[i]);
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
