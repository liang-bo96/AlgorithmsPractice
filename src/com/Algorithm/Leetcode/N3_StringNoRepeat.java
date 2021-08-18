package com.Algorithm.Leetcode;

import java.util.HashMap;

public class N3_StringNoRepeat {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        char[] arr = s.toCharArray();
        int result = 0;
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right < arr.length){
            if(map.get(arr[right]) == null){
                map.put(arr[right],1);
            }else{
                map.put(arr[right],map.get(arr[right]) + 1);
            }

            while(map.get(arr[right]) > 1){
                map.put(arr[left],map.get(arr[left]) - 1);
                left++;
            }
            result = Math.max(result,right - left + 1);
            right++;
        }
        return result;
    }
}
