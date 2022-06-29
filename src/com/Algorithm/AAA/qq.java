package com.Algorithm.AAA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class qq {
    public static void main(String[] args) {
        System.out.println(Greater("aaaaaaaaaaaaabbbccccaccccccdddddddd"));

        HashMap<String, String> map = new HashMap<>();
        map.put("!","1");
        map.put(null,"2");
        map.put(null,"123");
        System.out.println(map.get("!"));
        System.out.println(map.get(null));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(67868);
    }
    public static String  Greater(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int len = 0;
        int start = 0;
        int result = 0;
        char c = s.charAt(0);
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != c){
                len = 0;
                c = s.charAt(i);
                t = i;
            }
            len++;
            if(len > result){
                result = len;
                start = t;
            }
        }
        return s.substring(start,start + result);
    }
}
