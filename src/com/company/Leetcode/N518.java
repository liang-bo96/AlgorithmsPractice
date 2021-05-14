package com.company.Leetcode;

public class N518 {
    public int change(int amount, int[] coins) {
        // if(amount == 0 || coins.length == 0){
        //     return 0;
        // }
        return process(coins,0,amount);
    }
    public int process(int[] coins,int index,int rest){
        if(index == coins.length-1){
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for(int num = 0;num*coins[index] <= rest; num++){
            ways += process(coins,index+1,rest-num*coins[index]);
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(new N518().change(5, new int[]{1, 2, 5}));
    }
}
