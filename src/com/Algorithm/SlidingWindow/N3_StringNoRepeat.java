package com.Algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 3. ���ظ��ַ�����Ӵ�
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 *
 * ʾ�� 1:
 *
 * ����: s = "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 *
 * ����: s = "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 *
 * ����: s = "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
 *      ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 * ʾ�� 4:
 *
 * ����: s = ""
 * ���: 0
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
    //��ϰ
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
