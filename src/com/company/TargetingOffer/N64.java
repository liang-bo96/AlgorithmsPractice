package com.company.TargetingOffer;

public class N64 {
    static int total;
    public static void main(String[] args) {
        System.out.println(getSum(3));
    }

    public static int getSum(int n){
        if(n == 1) return 1;
        n += getSum(n-1);
        return n;
    }
}
