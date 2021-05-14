package com.company.DP;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        Set<String> abc = getSubsequences("aaaa");
        System.out.println(abc);
    }
    public static Set<String> getSubsequences(String s){
        char[] chars = s.toCharArray();
        int index = 0;
        HashSet<String> l = new HashSet<>();
        String path = "";
        process(chars,index,l,path);
        return l;
    }

    public static void process(char @NotNull [] chars, int index, HashSet<String> l, String path){
        if(index == chars.length){
            l.add(path);
            return;
        }
        String no = path;
        process(chars,index+1,l,no);
        String yes = path+chars[index];
        process(chars,index+1,l,yes);
    }

}
