package com.Algorithm.DP;

import java.util.*;

public class N397 {
    public static void main(String[] args) {
        for (int i = 30; i < 1000000; i++) {
            int n1 = new N397().integerReplacement(i);
            int n2 = new N397().integerReplacement1(i);
            if(n1 !=n2){
                System.out.println(i);
                System.out.println(n1);
                System.out.println(n2);
                System.out.println("-----------------------------");
            }
        }

    }

    public int integerReplacement1(int n) {
        long[] dp = new long[n + 10];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i < n + 10; i++) {
            if (i + 1 < n + 10) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
            if ((i-1) * 2 < n + 10) {
                dp[(i - 1) * 2] = Math.min(dp[(i - 1) * 2], dp[i- 1] + 1);
            }
        }
        return (int)dp[n];
    }
    public int integerReplacement(int n) {
        LinkedList<long[]> queue=new LinkedList<>();
        Set<Long> set=new HashSet<>();
        queue.offer(new long[]{n,0});
        set.add((long)n);
        while(!queue.isEmpty()){
            long[] cur=queue.poll();
            long num=cur[0];
            long step=cur[1];
            if(num==1){
                return (int)step;
            }
            if(num%2==0){
                if(!set.contains(num/2)){
                    set.add(num/2);
                    queue.offer(new long[]{num/2,step+1});
                }

            }
            else{
                if(!set.contains(num+1)){
                    set.add(num+1);
                    queue.offer(new long[]{num+1,step+1});
                }
                if(!set.contains(num-1)){
                    set.add(num-1);
                    queue.offer(new long[]{num-1,step+1});
                }
            }
        }
        return -1;
    }

}
