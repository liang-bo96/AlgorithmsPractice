package com.company.TargetingOffer;

import java.util.Stack;

public class N49 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1325));
    }
    public static int nthUglyNumber(int n) {
        Stack<Integer> re = new Stack<>();
        int i = 1;
        while(re.size() != n){
            if(is(i)){
                re.push(i);
            }
            i++;
        }
        int a;
        return re.pop();
    }
   static  boolean is(int num){
        while(num % 2 == 0){
            num = num /2;
        }
        while(num % 3 == 0){
            num = num /3;
        }
        while(num % 5 == 0){
            num = num /5;
        }
        return num == 1 ;
    }
}
