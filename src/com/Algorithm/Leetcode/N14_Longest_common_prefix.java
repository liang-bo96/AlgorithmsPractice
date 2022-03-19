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
        String re = "";
        for(int i = 0; i < strs[0].length(); i++){
            if(!judge(strs,i)){
                break;
            }
            re = strs[0].substring(0,i + 1);
        }
        return re;
    }
    public static boolean judge(String[] strs,int location){
        char tem = strs[0].charAt(location);
        for(String str : strs){
            if(location >= str.length() || str.charAt(location) != tem){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new N14_Longest_common_prefix().longestCommonPrefix(new String[]{"flower","flo","flower","flower"}));
    }
}
