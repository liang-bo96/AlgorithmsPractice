package com.Algorithm.DP;

/*
*
* 5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。



示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
示例 4：

输入：s = "ac"
输出："a"


提示：

1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成*/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "asdasdsasdasdasdasd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome1(s));
    }
    public static String longestPalindrome(String s) {
         int len = s.length();
         boolean[][] dp = new boolean[len][len];
         for(int i = 0; i < len; i++){
             dp[i][i] = true;
         }

         int begin = 0;
         int maxLen = 1;
         for(int i = len-2 ; i >= 0; i--){
             for( int j = i + 1; j < len;j++){
                 if(s.charAt(i) != s.charAt(j)){
                     dp[i][j] = false;
                 }else{
                     if(j-i+1 < 3){
                         dp[i][j] = true;
                     }else{
                         dp[i][j] = dp[i+1][j-1];
                     }
                 }
                 if(dp[i][j] == true){
                     if(j-i+1 > maxLen){
                         maxLen = j-i+1;
                         begin = i;
                     }
                 }
             }
         }
         return s.substring(begin,begin+maxLen);
    }
    public static String longestPalindrome1(String s) {
        String result = "";
        for(int i = 0 ; i < s.length(); i++){
            String tem1 = getSubString(s,i,i);
            String tem2 = getSubString(s,i,i+1);
            int max = Math.max(Math.max(tem1.length(),tem2.length()),result.length());
            if(max == tem1.length()){
                result = tem1;
            }else if(max == tem2.length()){
                result = tem2;
            }
        }
        return result;

    }
    public static String getSubString(String s,int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

}
