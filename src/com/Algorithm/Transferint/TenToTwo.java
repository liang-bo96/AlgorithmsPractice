package com.Algorithm.Transferint;

public class TenToTwo {
    public static void main(String[] args) {
        System.out.println(vers(transfer(12312132)));
        System.out.println(Long.MAX_VALUE);
    }
    // 10 -> 2
    public static String transfer(long num){
        String result = "";
        while (num != 0){
            result = num % 2 + result;
            num /= 2;
        }
        return result;
    }
    // 2 -> 10
    public static long vers(String s){
        char[] array = s.toCharArray();
        long result = 0;
        int k = 0;
        for(int i = array.length - 1; i >= 0; i--){
            result += Math.pow(2,k) * Integer.parseInt(String.valueOf(array[i]));
            k++;
        }
        return result;
    }
}
