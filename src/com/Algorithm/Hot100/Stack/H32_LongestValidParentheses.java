package com.Algorithm.Hot100.Stack;

import java.util.Stack;

/*
* 32. 最长有效括号
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

示例 1：

输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
示例 2：

输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
示例 3：

输入：s = ""
输出：0
*
* */
public class H32_LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new H32_LongestValidParentheses().longestValidParentheses("()(()"));
    }
    //建立标记数组，先将能匹配的设为0，其余位置设为1，问题就变成寻找最长的0子数组长度
    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        //栈内存的是下标
        Stack<Integer> stack = new Stack<>();
        int[] mark = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    mark[i] = 1;
                }
            }
        }
        while(!stack.isEmpty()){
            mark[stack.pop()] = 1;
        }
        //寻找最长0数组
        int result = 0;
        int len= 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 1){
                len = 0;
                continue;
            }
            len++;
            result = Math.max(result,len);
        }
        return result;
    }
    // for practice
    public int longestValidParentheses1(String s) {
        char[] array = s.toCharArray();
        int[] ref = new int[array.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '('){
                stack.push(new int[]{1,i});
            }else{
                if(!stack.isEmpty() && stack.peek()[0] == 1){
                    ref[i] = 1;
                    ref[stack.pop()[1]] = 1;
                }else{
                    stack.push(new int[]{0,i});
                }
            }
        }
        int res = 0;
        int len = 0;
        for (int i = 0; i < ref.length; i++) {
            if(ref[i] == 1){
                len ++;
            }else{
                len = 0;
            }
            res = Math.max(res,len);
        }
        return res;
    }
}
