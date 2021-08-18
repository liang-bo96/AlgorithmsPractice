package com.Algorithm.BackTracking;

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
        return process1(w, v, 0, bag,new HashMap<>());
    }

    // index 0~N
    // rest 负~bag
    public static int process1(int[] w, int[] v, int index, int rest,HashMap<String,Integer> map) {
        if(map.containsKey(index +"-"+ rest)){
            return map.get(index +"-"+ rest);
        }
        if (index == w.length) {
            map.put(index +"-"+ rest,0);
            return 0;
        }
        int p1 = process1(w, v, index + 1, rest,map);
        int p2 = 0;
        if(rest >= w[index]){
            p2 = process1(w, v, index + 1, rest - w[index],map) + v[index];
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
        return process(w, v, 0,  bag,new HashMap<>());
    }
    public static int process(int[] w, int[] v, int index, int rest,HashMap<String,Integer> map){
        if(map.containsKey(index +"-" + rest)){
            return map.get(index +"-" + rest);
        }
        if(rest == 0){
            map.put(index +"-" + rest,0);
            return 0;
        }
        if(index == w.length){
            map.put(index +"-" + rest,0);
            return 0;
        }
        int t1 = process(w,v,index + 1,rest,map);
        int t2 = 0;
        if( rest >= w[index]){
            t2 = process(w,v,index + 1,rest - w[index],map) + v[index];
        }
        map.put(index +"-" + rest,Math.max(t1,t2));
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

    /**
     * 练习1
     */
    static int result;
    public static int maxValue_practice1(int[] w, int[] v, int bag){
        process1(w,v,bag,0,0,0);
        return result;
    }

    public static void process1(int[] w, int[] v, int bag,int totalValue,int totalWeight,int location){
        if(location == w.length || totalWeight == bag){
            result = Math.max(result,totalValue);
            return;
        }
        process1(w,v,bag,totalValue,totalWeight,location+1);
        if(totalWeight + w[location] <= bag){
            process1(w,v,bag,totalValue + v[location],totalWeight + w[location],location + 1);
        }
    }

    /**
     *
     * 练习2
     */
    public static int maxValue_practice2(int[] w, int[] v, int bag){
        return process2(w,v,bag,0);
    }

    public static int process2(int[] w, int[] v, int bag,int location){
        if(location == w.length || 0 == bag){
            return 0;
        }
        int no = process2(w,v,bag,location+1);
        int yes = 0;
        if( w[location] <= bag){
            yes = process2(w,v,bag - w[location],location + 1) + v[location];
        }
        return Math.max(yes,no);
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2,4,8,3, 2,4,8,3, 2,4,8};
        int[] values = { 5, 6,5,7,5, 6,5,7,5, 6,5,7};
        int bag = 15;
        System.out.println("test begin");
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 600; i++) {
            if(maxValue_practice2(weights, values, i) != dp(weights, values, i)){
                System.out.println(i);
                System.out.println(maxValue_practice1(weights, values, i));
                System.out.println(dp(weights, values, i));
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1)/1000);
        System.out.println("test end");
    }
}
