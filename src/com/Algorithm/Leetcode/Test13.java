package com.Algorithm.Leetcode;

import java.util.Stack;

public class Test13 {
    static int count = 0;
    public static void main(String[] args) {
        String s = "X,I,V";
        int[] value = {1,5,10,50,100};
        String[] split = s.split(",");
        Stack<String> stack = new Stack<>();
        for (String ss: split
             ) {
            if(stack.empty()){
                stack.push(ss);
            }
            else if(getloaction(stack.peek())<getloaction(ss)){
                    count = count-2*value[getloaction(stack.pop())];
                stack.push(ss);
            }else{
                stack.push(ss);
            }
            count = count + value[getloaction(ss)];
        }
        System.out.println(count);
    }
    static int getloaction(String s){
        String[] ss = {"I","V","X"};
        int [] a = {1,5,10};
        for (int i = 0; i < ss.length; i++) {
            if(s.equals(ss[i]) ){
                return i;
            }
        }
        return -1;
    }
}
