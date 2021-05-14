package com.company.TargetingOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class N44 {
        public static int findNthsDigit(int n) {
            String s = "0asdasd";
            int i = 1;
            while(s.length()<=n){
                s = s+String.valueOf(i);
                i++;
            }
            char[] r = s.toCharArray();
            return Integer.parseInt(String.valueOf(r[n]));
//            s.toCharArray();
//            int k = r[1] - r[0] ;
//            System.out.println();

        }
    public static int findNthDigit(int n) {
        // String s = "0";
        // int i = 1;
        // while(s.length()<=n){
        //     s = s+String.valueOf(i);
        //     i++;
        // }
        // char[] r = s.toCharArray();
        // return Integer.parseInt(String.valueOf(r[n]));
        int di = 1;
        int start = 1;
        int count = 9 * start;
        n--;
        while(n > count){
            n = n - count;
            di++;
            start = start*10;
            count = 9*start*di;
        }
        int i = n % di;
        int j = n / di;
        int num = start+j;
        int re = 0;
        while(di-i>0){
            re = num%10;
            i++;
            num /= 10;
        }
        return re;

    }

    public static void main(String[] args) {
            for (int i=0; i<60;i++){

                System.out.print(findNthDigit(i));
            }
            new HashMap<>();
            Integer[] n = {1,23,45,5,6,21,3};
        Comparator<Integer> comparator = (Integer o1, Integer o2) -> o2-o1;
        Arrays.sort(n,comparator);
        for(int i = 0;i<n.length;i++){
            System.out.println(n[i]);
        }
        System.out.println("1".compareTo("2"));
        char q = '1';
        char b = '2';
        System.out.println("a+b= "+(q+b));
    }

}
