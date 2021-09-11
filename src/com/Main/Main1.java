package com.Main;

import java.util.*;

public class Main1 {
    static List<String> l;
    static HashSet<String> set;
    public static void main(String[] args) {
        l = new ArrayList<>();
        set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int len = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String str = scanner.next();
        process(0,len,"",str);
        int count = 0;
        for(String tem : l){
            if(judged(tem,k)){
                count++;
//                System.out.println(tem);
            }
        }
        System.out.println(count);
    }

    public static boolean judged(String s,int k){
        HashSet<Character> set = new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        return set.size() == k;
    }

    public static void process(int location,int len,String str,String std){
        if(location == len){
//            if(!set.contains(str)){
                l.add(str);
                set.add(str);
//            }
            return;
        }
        process(location + 1,len,str + std.charAt(location),std);
        process(location + 1,len,str,std);
    }
}
