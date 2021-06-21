package com.company.BackTracking;

import java.util.HashMap;

// 所有的货，重量和价值，都在w和v数组里
// 为了方便，其中没有负数
// bag背包容量，不能超过这个载重
// 返回：不超重的情况下，能够得到的最大价值
public class BagProblem {

    //Reference------------------------------------------


    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process(w, v, 0, bag,new HashMap<>());
    }

    // index 0~N
    // rest 负~bag
    public static int process(int[] w, int[] v, int index, int rest,HashMap<String,Integer> map) {
        if(map.containsKey(index +"-"+ rest)){
            return map.get(index +"-"+ rest);
        }
        if (rest < 0) {
            map.put(index +"-"+ rest,-1);
            return -1;
        }
        if (index == w.length) {
            map.put(index +"-"+ rest,0);
            return 0;
        }
        int p1 = process(w, v, index + 1, rest,map);
        int p2 = 0;
        int next = process(w, v, index + 1, rest - w[index],map);
        if (next != -1) {
            p2 = v[index] + next;
        }
        map.put(index +"-"+ rest, Math.max(p1, p2));
        return Math.max(p1, p2);
    }

    //自己的版本----------------------------------------------------------------------

    public static int maxValue2(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process(w, v, 0, 0, bag,new HashMap<>());
    }
    public static int process(int[] w, int[] v, int index, int total, int bag, HashMap<String,Integer> map){
//        if(map.containsKey(index +"-" + bag)){
//            return map.get(index +"-" + bag);
//        }
        if(bag == 0){
//            map.put(index +"-" + bag,total);
            return total;
        }
        if(index == w.length){
//            map.put(index +"-" + bag,total);
            return total;
        }
        int t1 = process(w,v,index + 1,total,bag,map);
        int t2 = 0;
        if( bag >= w[index]){
            t2 = process(w,v,index + 1,total + v[index],bag - w[index],map);
        }
//        map.put(index +"-" + bag,Math.max(t1,t2));
        return Math.max(t1,t2);
    }

    //dp----------------------------------------------------------------------------------

    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 ,4,5,6,7,8,9,1,2,3,4,4,5,6,7};
        int[] values = { 5, 6, 3, 19, 12, 4, 2 ,6,5,4,3,2,1,8,7,6,5,4,5,6,7};
        int bag = 15;
        System.out.println("test begin");
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 600; i++) {
            if(maxValue2(weights, values, i) != dp(weights, values, i)){
                System.out.println(11);
            }
//            System.out.println(maxValue2(weights, values, i));
//            System.out.println(dp(weights, values, i));
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1)/1000);
        System.out.println("test end");
    }
}
