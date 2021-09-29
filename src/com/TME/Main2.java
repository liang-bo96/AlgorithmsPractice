package com.TME;

import java.util.HashMap;

public class Main2 {
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(new Main2().minM(10, 10));
        System.out.println(1<<1);
    }

    public long minM(int n, int k) {
        // write code here
        int count = 0;
        for (long i = 1; i < Long.MAX_VALUE; i++) {

            if(map.containsKey(k+"-"+i)){
                count += map.get(k+"-"+i);
            }else{
                long haha =  help(k,i);
                count += haha;
                map.put(k+"-"+i,count);
            }
            if (count >= n){
                return i;
            }
        }
        return 0;
    }

    public static long help(int k, long n) {
        long count = 0;
        while (n != 0) {
            if (n % k == 1) {
                count++;
            }
            n /= k;
        }
        return count;
    }
}
