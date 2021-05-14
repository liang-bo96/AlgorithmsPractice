package com.company.Leetcode;

import java.util.Stack;

public class N20 {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] tem = s.toCharArray();
        boolean flag = true;
        for(int i = 0; i < tem.length;i++){
            if(tem[i]==')' ){
                flag = stack.pop() == '(' ? true : false;
                if(!flag) return false;
                break;
            }
            if(tem[i]==']' ){
                flag = stack.pop() == '[' ? true : false;
                if(!flag) return false;
                break;
            }
            if(tem[i]=='}' ){
                flag = stack.pop() == '{' ? true : false;
                if(!flag) return false;
                break;
            }
            stack.push(tem[i]);
        }
        return stack.isEmpty();
    }
    double me(byte x , double y){
        return x/y*2;
    }
}
