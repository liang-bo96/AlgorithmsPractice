package com.Algorithm.TargetingOffer;

import java.util.Stack;

public class Number31 {

        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> s = new Stack<>();
            int j = 0;
            for(int i = 0; i < popA.length; i++){
                if(!s.isEmpty() && s.peek() != popA[i]){
                    while(pushA[j] != popA[i]){
                        s.push(pushA[j]);
                        j++;
                        if(j == pushA.length){
                            return false;
                        }
                    }
                }else if(s.isEmpty()){

                    while(pushA[j] != popA[i]){
                        s.push(pushA[j]);
                        j++;
                        if(j == pushA.length){
                            return false;
                        }
                    }
                }
                else if(s.peek() == popA[i]){
                    s.pop();
            }
        }
            return true; }

            public static void main(String[] args) {
        Number31 number31 = new Number31();
                System.out.println(number31.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
//                new ArrayList
            }}
