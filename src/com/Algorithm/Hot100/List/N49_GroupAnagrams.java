package com.Algorithm.Hot100.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. ��ĸ��λ�ʷ���
 * ����һ���ַ������飬���㽫 ��ĸ��λ�� �����һ�𡣿��԰�����˳�򷵻ؽ���б�
 *
 * ��ĸ��λ�� ������������Դ���ʵ���ĸ�õ���һ���µ��ʣ�����Դ�����е���ĸ��ǡ��ֻ��һ�Ρ�
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * ���: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * ʾ�� 2:
 *
 * ����: strs = [""]
 * ���: [[""]]
 * ʾ�� 3:
 *
 * ����: strs = ["a"]
 * ���: [["a"]]
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
