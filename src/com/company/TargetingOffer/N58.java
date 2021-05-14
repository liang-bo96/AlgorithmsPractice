package com.company.TargetingOffer;

import java.util.Arrays;

public class N58 {
    public static void main(String[] args) {
        String s = "  weqwe   qweq  ";
        char[] chars = s.trim().toCharArray();
        System.out.println(chars);
        if(chars[5]==' ') System.out.println("asd");
        chars.toString();

        int[] a = new int[]{4,3,2,1};
        Arrays.sort(a);
        System.out.println(a);
//        String[] s1 = s.trim().split(" ");
//        for (String ss:s1 ) {
////            System.out.println(ss);
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = s1.length-1;i>=0;i--){
//            if(s1[i].equals(" ")) continue;
//            stringBuilder.append(s1[i]+" ");
//        }
//        String s2 = stringBuilder.toString();
//        System.out.println(s2);
    }

}
