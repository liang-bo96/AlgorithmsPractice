package com.Algorithm.DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
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
    //超时---------子序列
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
    //子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        //等于号！！！！！！！！！！！！
        for (int i = 1; i <= text1.length(); i++) {
            //等于号！！！！！！！！！！！！
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
     * 子串
     */
    public int longestCommonSubstring(String s1,String s2){
        //dp表示s1以i结尾和s2以j结尾的最长公共子串
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
