package com.Algorithm.SubArraySum;

import java.util.HashMap;

/*
给定一个整数组成的无序数组arr，值可能正、可能负、可能0
给定一个整数值K
找到arr的所有子数组里，哪个子数组的累加和等于K，并且是长度最大的
返回其长度
*/
public class LongestSubSumArrayLength{
    public static void main(String[] args) {
        System.out.println(LongestSubArrayLength(new int[]{-1, -2, 3, 7, 1, 1, 1, 1, 1, 1, 1, -1, 1}, 7));
    }
    public static int LongestSubArrayLength(int[]arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            if(map.containsKey(sum - target)){
                len = Math.max(len,i - map.get(sum - target));
            }
        }
        return len;
    }

}
