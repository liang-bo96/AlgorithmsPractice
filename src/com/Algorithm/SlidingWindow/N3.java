package com.Algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
/*
* 3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0
* */
public class N3 {
    public static void main(String[] args) {
        System.out.println(get("tmmzuxt"));
        System.out.println(get2("tmmzuxt"));
    }
    public static int get(String s){
        if(s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                while(right < s.length() && !set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    result = Math.max(result,right-left+ 1);
                    right++;
                }
            }
            else{
                while(right < s.length() && s.charAt(left) != s.charAt(right )){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }
    public static int get2(String s){
        if(s.length() == 0) return 0;
        int left = 0, right = 0,len = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c) > 1){
                char d = s.charAt(left);
                left++;
                map.put(d,map.get(d)-1);
            }
            len = Math.max(len,right - left + 1);
            right++;
        }
        return len;


    }
}
