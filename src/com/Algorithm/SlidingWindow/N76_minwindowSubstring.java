package com.Algorithm.SlidingWindow;

import java.util.HashMap;

/*
*
*给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
示例 2：

输入：s = "a", t = "a"
输出："a"

提示：

1 <= s.length, t.length <= 105
s 和 t 由英文字母组成
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class N76_minwindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow2("aa", "aa"));
        System.out.println(minWindow2("ADOBECODEBANCD", "ABC"));
        System.out.println(minWindow_labuladong("aa", "aa"));
    }

    public static String minWindow(String s, String t) {
        if (s.length() == 1) return s;
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        String result = "";
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (!contain(map, t)) {
                map.put(s.charAt(right), right);
                right++;
            }
            if (contain(map, t)) {
                while (contain(map, t)) {
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        result = s.substring(left, right);
                    }
                    if (map.get(s.charAt(left)) == left) {
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
            }
        }
        return result;
    }

    public static boolean contain(HashMap<Character, Integer> map, String t) {
        int len = t.length();
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(t.charAt(i))) {
                flag = false;
                return false;
            }
        }
        return flag;
    }

    public static String minWindow1(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                ////这个得改成equals
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    //这个得改成equals
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static String minWindow_labuladong(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char tem : t.toCharArray()) {
            need.put(tem, need.getOrDefault(tem, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
//                right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left + 1;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    //for practice
    //超时
    public static String minWindow2(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int len = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s2){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        while(right < s1.length){
            map.put(s1[right],map.getOrDefault(s1[right],0) - 1);
            while(judge(map,s2)){
                if(right - left + 1< len){
                    start = left;
                    len = right - left + 1;
                }
                map.put(s1[left],map.getOrDefault(s1[left],0) + 1);
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "":s.substring(start,start + len);
    }
    public static boolean judge(HashMap<Character,Integer> map,char[] arr){
        for(char c : arr){
            if(map.get(c) > 0){
                return false;
            }
        }
        return  true;
    }

}
