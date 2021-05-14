package com.company.Leetcode;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class N415 {
    public static void main(String[] args) {
        System.out.println(new N415().addStrings("9", "99"));
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        Collections.reverse(l);
        System.out.println(l);
    }
        public String addStrings(String num1, String num2) {
            int len1 = num1.length()-1;
            int len2 = num2.length()-1;
            StringBuilder sb = new StringBuilder();
            boolean high = false;
            while(len1 != -1 || len2 != -1){
                int n1 = 0 ,n2 = 0;
                if(len1 >=0){
                    n1 = num1.charAt(len1) - '0';
                    len1 --;
                }
                if(len2 >=0){
                    n2 = num2.charAt(len2) - '0';
                    len2--;
                }
                int t = high ? n1 + n2 + 1: n1 + n2;
                sb.append(t%10);
                if(n1 + n2 > 10){
                    high = true;
                }else{
                    high = false;
                }
            }
            return sb.reverse().toString();
        }
    }

