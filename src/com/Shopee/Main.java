package com.Shopee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().minEffort(Arrays.asList(1,2,9)));

    }
    public String didYouMean(String[] commands, String input) {
        // write code here
        for(String s : commands){
            if(help(s,input) == 1){
                return s;
            }
        }
        return "";
    }
    public static int help(String s1, String s2){
        int len = s2.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return Math.abs(s2.length() - dp[s1.length()][s2.length()]) <= 1 ? 1 :2;
    }

    public int minEffort(List<Integer> cases) {
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i : cases){
            queue.add(i);
        }
        while(queue.size() > 1){
            int poll1 = queue.poll();
            int poll2 = queue.poll();
            count += poll1 + poll2;
            queue.add(poll1 + poll2);
        }
        return count;
    }

}
