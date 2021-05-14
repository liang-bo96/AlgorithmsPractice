package com.company;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        int target = 9;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String[] split = s.split(",");
        int[] aa = new int[split.length];
        for(int i = 0;i< split.length;i++){
            aa[i] = Integer.parseInt(split[i]);
        }
        for (int aaa:aa) {
            System.out.println(aaa);
        }
        System.out.println(check(aa, target)+"-----");

    }
    static int check(int[] a,int targrt){
        int end = a.length-1;
        int start = 0;
        while(a.length>0){
            int middle = (start+end)/2;
            if(a[middle]==targrt){

            }
            if(a[middle]<targrt){
                return check(a, targrt);
            }else if(a[middle]>targrt){
                end = middle-1;
            }
        }
        return -1;
    }
}
