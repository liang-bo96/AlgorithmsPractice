package com.Algorithm.BackTracking;

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
        System.out.println(robotMove(5, 2, 6, 4));
    }

    public static int robotWalk(int location, int tem_location, int left, int destination, HashMap<String,Integer> map) {
        if(map.containsKey(tem_location+"-"+left)){
            return map.get(tem_location+"-"+left);
        }
        if (left == 0) {
            map.put(tem_location+"-"+left,tem_location == destination ? 1 : 0);
            return tem_location == destination ? 1 : 0;
        }
        if (tem_location == 1) {
            int i = robotWalk(location, tem_location + 1, left - 1, destination,map);
            map.put(tem_location+"-"+left,i);
            return i;
        }
        if (tem_location == location) {
            int i = robotWalk(location, tem_location - 1, left - 1, destination,map);
            map.put(tem_location+"-"+left,i);
            return i;
        }
        int i = robotWalk(location, tem_location + 1, left - 1, destination,map) + robotWalk(location, tem_location - 1, left - 1, destination,map);
        map.put(tem_location+"-"+left,i);
        return i;
    }

    /**
     * lianxi
     */
    public static int robotMove(int location, int tem_location, int left, int destination){
        if(left == 0){
            return tem_location == destination ? 1:0;
        }
        if(tem_location == 1){
            return robotMove(location,tem_location + 1,left - 1,destination);
        }
        if(tem_location == location){
            return robotMove(location,tem_location - 1,left - 1,destination);
        }
        return robotMove(location,tem_location - 1,left - 1,destination) +
                robotMove(location,tem_location + 1,left - 1,destination);
    }








































}
