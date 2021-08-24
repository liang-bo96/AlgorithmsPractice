package com.Algorithm.Leetcode;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class N14_Longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 ){
            return null;
        }
        if(strs.length == 1){
            return strs[0];
        }
        int index = 0;
        while(index < strs[0].length()){
            if(strs[0].length() == 0){
                return "";
            }
            String substring = strs[0].substring(0, index + 1);
            if(judge(strs,substring)){
                index++;
            }else{
                break;
            }
        }
        return strs[0].substring(0,index);
    }
    public static boolean judge(String[] strs,String substring){
        for (int i = 0; i < strs.length; i++) {
            if(!judgesubstring(strs[i],substring)){
                return false;
            }
        }
        return true;
    }

    public static boolean judgesubstring(String s1, String s2){
        for(int i = 0 ; i < s2.length(); i++){
            if(i >= s1.length() || s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 横向扫描
     * 维持一个最长公共前缀子串
     */
    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        if(strs.length == 1) return strs[0];
        String prefix = help(strs[0],strs[1]);
        for (int i = 0; i < strs.length; i++) {
            prefix = help(strs[i],prefix);
        }
        return prefix;
    }
    public static String help(String s1, String s2){
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(i >= s2.length() || s1.charAt(i) != s2.charAt(i)){
                break;
            }
            index++;
        }
        return s1.substring(0,index);
    }

    /**
     * 纵向扫描
     * 所有字符串依次比较前n个字母是否一致
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        int index = 0;
        while(index < strs[0].length()){
            boolean flag = false;
            for (int i = 0; i < strs.length - 1; i++) {
                if(index >= strs[i].length() || index >= strs[i+1].length()
                        || strs[i].charAt(index) != strs[i + 1].charAt(index)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
            index++;
        }
        return strs[0].substring(0,index);
    }

    public static void main(String[] args) {
        System.out.println(new N14_Longest_common_prefix().longestCommonPrefix2(new String[]{"flower","flo","flower","flower"}));
    }
}
