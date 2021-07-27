package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N322_Coin_Change {
    public static void main(String[] args) throws InterruptedException {
        long t3 = System.currentTimeMillis();
        System.out.println(new N322_Coin_Change().coinChange2(new int[]{3, 7, 405, 436}, 30000));
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
        long t1 = System.currentTimeMillis();
        System.out.println(new N322_Coin_Change().coinChange(new int[]{3, 7, 405, 436}, 20000));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

    }


    //超时
    public int coinChange(int[] coins, int amount) {
        result = new ArrayList<>();
        process(coins,amount,0,new ArrayList<>());
        int re = Integer.MAX_VALUE;
        for(List<Integer> t : result){
            if(t.size() < re){
                re = t.size();
            }
        }
        return re == Integer.MAX_VALUE ? -1 : re;
    }
    static List<List<Integer>> result;
    public static void process(int[] coins,int amount,int location,List<Integer> tem_coins){
        if(location == coins.length){
            if(amount == 0){
                result.add(tem_coins);
            }
            return;
        }
        for (int i = 0; i * coins[location] <= amount; i++) {
            for (int j = 0; j < i; j++) {
                tem_coins.add(coins[location]);
            }
            process(coins, amount - i * coins[location], location + 1,new ArrayList<>(tem_coins));
            for (int j = 0; j < i; j++) {
                tem_coins.remove(tem_coins.size() - 1);
            }
        }
    }



    //
    public int coinChange2(int[] coins, int amount) {
        return process2(coins,amount,0,new HashMap<>());
    }

    public static int process2(int[] coins, int amount, int index, HashMap<String,Integer> map){
        if(map.containsKey(amount +"-"+index)){
            return map.get(amount +"-"+index);
        }
        if(index == coins.length){
            if(amount == 0){
                map.put(amount+"-"+index,0);
                return 0;
            }else{
                map.put(amount+"-"+index,999999);
                return 999999;
            }
        }
        if(amount == 0){
            map.put(amount+"-"+index,0);
            return 0;
        }
        int t2 = Integer.MAX_VALUE ;
        for(int num = 0; num * coins[index] <= amount;num++){
            t2 =Math.min(process2(coins, amount - num * coins[index], index + 1, map) +num,t2);
        }
        map.put(amount+"-"+index,t2);
        return t2;
    }

}
