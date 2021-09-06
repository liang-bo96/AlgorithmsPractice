package com.Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] ref = new int[10000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        String b = sc.nextLine();
        String[] aa = a.split(" ");
        String[] bb = b.split(" ");
        int[] arr = new int[num];
        int[] brr = new int[num];
        for(int i = 0 ;i < num; i++){
            arr[i] = Integer.parseInt(aa[i]);
        }
        for(int i = 0 ;i < num; i++){
            brr[i] = Integer.parseInt(bb[i]);
        }
        help();
        System.out.println(Arrays.toString(ref));
        int[] refa = new int[arr.length];
        for(int i = 0; i < num; i++){
            refa[i] = map.get(arr[i]) == null ? get(arr[i]) : map.get(arr[i]);
        }
        int[] refb = new int[arr.length];
        for(int i = 0; i < num; i++){
            refb[i] = map.get(brr[i]) == null ? get(brr[i]) : map.get(brr[i]);
        }
        Arrays.sort(refa);
        Arrays.sort(refb);
        int result = 0;
        for(int i = 0; i < num; i++){
            if(refa[num - i - 1] > refb[i]){
                result++;
            }
            if(refa[num - i - 1] < refb[i]){
                break;
            }
        }
        System.out.println(result);
    }
    public static void help(){
        for(int i = 1; i < 10000; i++){
            int count = 0;
            for(int j = 1; j <= i ;j++){
                if(i % j == 0){
                    count += 1;
                }
            }
            ref[i] = count;
        }
    }
    public static int get(int n){
            int count = 0;
            for(int j = 1; j <= n ;j++){
                if(n % j == 0){
                    count += 1;
                }
            }
            map.put(n,count);
        return count;
    }
}
