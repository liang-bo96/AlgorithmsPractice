package com.Algorithm.Leetcode;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class N459_RepeatSubString {
    public static void main(String[] args) {
        System.out.println(new N459_RepeatSubString().repeatedSubstringPattern("aabaaba"));
    }
    //符合条件下的话，子串必是总串的前缀，然后依次比较总串和子串对应位置是否相等
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            String tem = s.substring(0,i );
            if(s.length() % tem.length() == 0){
                boolean flag = true;
                for (int j = 0; j < s.length(); j++) {
                    if(s.charAt(j) != tem.charAt(j % tem.length())){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

        //暴力-超时
    public boolean repeatedSubstringPattern1(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        for(int i = 0; i <= s.length(); i++){
            for (int j = i + 1; j < s.length(); j++) {
                if(judge(s,s.substring(i,j))){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean judge(String s1, String s2){
        int n = s1.length()/ s2.length();
        if(n < 1){
            return false;
        }
        String tem = "";
        for (int i = 0; i < n; i++) {
            tem += s2;
        }
        if(tem.equals(s1)){
            return true;
        }
        return false;
    }
}
