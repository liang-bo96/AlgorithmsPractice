package com.company.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class N322_Coin_Change {
    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
//        System.out.println(new N322_Coin_Change().coinChange(new int[]{3, 7, 405, 436}, 8839));
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
        return 0;
    }

    public static int process2(int[] coins,int amount){
        return 1;


    }

}
