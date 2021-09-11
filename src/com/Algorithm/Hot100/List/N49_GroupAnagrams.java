package com.Algorithm.Hot100.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class N49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] ref = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            ref[i] = help(strs[i]);
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i <strs.length; i++){
            if(map.get(ref[i]) == null){
                map.put(ref[i],new ArrayList<>());
            }
            map.get(ref[i]).add(strs[i]);
        }
        List<List<String>> l = new ArrayList<>();
        for(String s : map.keySet()){
            l.add(map.get(s));
        }
        return l;
    }
    public static String help(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return Arrays.toString(array);
    }
}
