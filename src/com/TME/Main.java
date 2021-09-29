package com.TME;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "0001";
        System.out.println(maxLexicographical(s));
        System.out.println(maxLexicographical1(s));
    }
    public static String maxLexicographical (String num) {
        char[] array = num.toCharArray();
        String s= "";
        boolean flag = false;
        for (int i = 0; i < num.length(); i++) {
            if(array[i] == '1' && flag){
                break;
            }
            if(array[i] == '0'){
                array[i] = '1';
                flag = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: array){
            sb.append(c);
        }
        return sb.toString();
    }
    public static String maxLexicographical1 (String num) {
        // write code here
        String re = num;
//        if(num.charAt(0) != '-'){
        for (int i = 0; i < num.length(); i++) {
            for (int j = i; j < num.length(); j++) {
                String tem = converse(num,i,j);
                if(tem.compareTo(re) > 0){
                    re = tem;
                }
            }
        }
        return re;
//        }
    }
    public static String converse(String num,int left,int right){
        String re = "";
        for (int i = 0; i < left; i++) {
            re += num.charAt(i);
        }
        for (int i = left; i <= right ; i++) {
            if(num.charAt(i) == '1'){
                re += "0";
            }else{
                re += "1";
            }
        }
        for (int i = right + 1; i < num.length(); i++) {
            re += num.charAt(i);
        }
        return re;
    }
}
