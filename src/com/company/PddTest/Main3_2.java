package com.company.PddTest;

import java.util.Arrays;
import java.util.Scanner;

public class Main3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();
        char[] result = new char[num.length()+1];
        for(int i = 0 ; i < result.length; i++){
            result[i] = '0';
        }
        result[0] = '1';
        k--;
        for(int i = result.length-1; i >0 && k >0;i--){
            result[i] = '1';
            k--;
        }

//        String result = help(num,k);
        System.out.println(result);
    }
    public static String help(String s,int k){
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            int high = 1;
            for(int j = len-1; j >=0 && high == 1;j--){
                if(chars[j] == '1'){
                    chars[j] = '0';
                    high = 1;
                    if(j == 0){
                        char[] tem = chars;
                        chars = new char[len+1];

                        chars[0] = '1';
                        for(int l = 0;l < len;l++){
                            chars[l+1] = tem[l];
                        }
                        len++;
                    }
                }else{
                    chars[j] = '1';
                    high = 0;
                }
            }
            int count = 0;
            for(char c : chars){
                if(c == '1'){
                    count++;
                }
            }
            if(count == k){
                break;
            }
        }
        String s1 = "";
        for(char c : chars){
            s1 +=c;
        }
        return s1;
    }
}
