package com.company.PddTest;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        long tem = bi2de(num);
        int k = sc.nextInt();
        for(long i = tem+1; i <Long.MAX_VALUE;i++){
            if(help(de2bi(i)) == k){
                System.out.println(de2bi(i));
                break;
            }
        }
    }

    public static int help(String k){
        int result = 0;
        char[] t = k.toCharArray();
        for(char tt: t){
            if(tt == '1'){
                result++;
            }
        }
        return result;
    }
    public static String de2bi(long de){
        String s= "";
        while(de > 0){
            long res = de % 2;
            s = res + s;
            de = de/2;
        }
        return s;
    }
    public static long bi2de(String bi){
        String str = bi;
        Long sum = 0l;
        int len = str.length();
        for(int i = 1 ; i <=len;i++){
            int dt = Integer.parseInt(str.substring(i-1,i));
            sum += (int)Math.pow(2,len-i)*dt;
        }
        return sum;
    }
}
