package com.Algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 */
public class N3_StringNoRepeat {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        while(right < s.length()){
            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            result = Math.max(result,right - left);
            set.remove(s.charAt(left++));
        }
        return result;
    }
    //练习
    public static int lengthOfLongestSubstring1(String s) {
        char[] array = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < array.length){
            map.put(array[right],map.getOrDefault(array[right],0) + 1);
            while(map.get(array[right]) > 1){
                map.put(array[left],map.get(array[left]) - 1);
                left++;
            }
            right++;
            result = Math.max(result,right - left);
        }
        return result;
    }
}
