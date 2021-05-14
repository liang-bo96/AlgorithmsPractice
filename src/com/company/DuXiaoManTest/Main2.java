package com.company.DuXiaoManTest;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        String[] t = new String[total];
        for(int i = 0; i < total; i++){
            t[i] = sc.next();
        }
        judge(t);
    }
    public static void judge(String[] t){
        for(String s: t){
            if(s.length() % 3 != 0){
                System.out.println("NO");
                return;
            }
            int len = s.length() / 3;
            String[] tem = new String[len];
            for(int i = 1; i <= len;i++){
                tem[i-1] = s.substring(3*(i-1),3*i);
            }
            if(judge2(tem)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean judge2(String[] tem){
        int ref = 0;
        for(int i =0 ; i <3;i++){
            int count = 0;
            for(int j = 1 ; j <tem.length ;j++){
                if(tem[j].charAt(i) == tem[j-1].charAt(i)){
                    count++;
                }
            }
            if(count == tem.length-1){
                ref++;
            }
        }
        return ref == 2 || ref == 3;
    }
}
