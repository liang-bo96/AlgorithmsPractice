package com.company.BackTracking;

import java.util.HashMap;

/*
假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
如果机器人来到1位置，那么下一步只能往右来到2位置；
如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
如果机器人来到中间位置，那么下一步可以往左走或者往右走；
规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
给定四个参数 N、M、K、P，返回方法数。

* */
public class RobotWalk {
    public static void main(String[] args) {
        System.out.println(robotWalk(5, 2, 6, 4,new HashMap<>()));
    }

    public static int robotWalk(int N, int M, int K, int P, HashMap<String,Integer> map) {
        if(map.containsKey(M+"-"+K)){
            return map.get(M+"-"+K);
        }
        if (K == 0) {
            map.put(M+"-"+K,M == P ? 1 : 0);
            return M == P ? 1 : 0;
        }
        if (M == 1) {
            int i = robotWalk(N, M + 1, K - 1, P,map);
            map.put(M+"-"+K,i);
            return i;
        }
        if (M == N) {
            int i = robotWalk(N, M - 1, K - 1, P,map);
            map.put(M+"-"+K,i);
            return i;
        }
        int i = robotWalk(N, M + 1, K - 1, P,map) + robotWalk(N, M - 1, K - 1, P,map);
        map.put(M+"-"+K,i);
        return i;
    }
}
