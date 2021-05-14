package com.company.TargetingOffer;

import java.util.Arrays;

public class N46 {
    public static void main(String[] args) {
        N46 n46 = new N46();
        System.out.println(n46.translateNum(1));
        System.out.println("qweasd".substring(2));
        int[] t = {1,2,3,4,5,6};
//        System.out.println(Arrays.maximum);
        char q = 'a';
        char b = 'b';
        System.out.println(b-q);
//        System.out.println(is(8));
    }

    public int translateNum(int num) {
//        String tem = String.valueOf(num);
        String tem = "7210231231232031203123";
        char[] chars = tem.toCharArray();
        int result = 0;
        return f(chars, 0, chars.length);
    }


    public static int f(char[] chars,int start,int end){
        if(start == end){
            return 1;
        }
        if(chars [start] == '0'){
            return 0;
        }

        if(chars[start] == '1'){
            int result = f(chars, start+1, end);
            if(start +1<end){
                result += f(chars, start+2, end);
            }

            return result;
        }
        if(chars[start] == '2'){
            int result = f(chars, start+1, end);
            if( start +1<end && chars[start+1] <'7'){
                result += f(chars, start+2, end);
            }
            return result;
        }
        return f(chars, start+1, end);
    }
}
