package com.company.BackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
*
*  131. 分割回文串
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]


提示：

1 <= s.length <= 16
s 仅由小写英文字母组成*/
public class N131_PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(new N131_PalindromePartitioning().partition("abc"));
    }
    public List<List<String>> partition(String s) {
        result = new LinkedList<>();
        process(s,0,new LinkedList<>());
        List<List<String>> r = new LinkedList<>();
        for(List<String> list : result){
            if(judge(list)){
                r.add(list);
            }
        }
        return r;
    }
    static List<List<String>> result;

    public static void process(String s,int index,List<String> path){
        if(index == s.length()){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            path.add(s.substring(index,i + 1));
            process(s, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
    public static boolean judge(List<String> list){
        for(String s : list){
            if(!judgeString(s)){
                return false;
            }
        }
        return true;
    }

    public static boolean judgeString(String s){
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : array){
            stack.push(c);
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] != stack.pop()){
                return false;
            }
        }
        return true;
    }
}
