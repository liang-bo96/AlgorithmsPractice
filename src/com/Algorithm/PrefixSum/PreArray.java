package com.Algorithm.PrefixSum;

import java.util.HashMap;

/*
*
* 560. 和为K的子数组
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
* */
public class PreArray {
    public static void main(String[] args) {

    }
    public int subarraySum(int[] nums, int k) {
        int[] ref = new int[nums.length];
        ref[0] = nums[0];
        for(int i = 1 ; i < ref.length; i++){
            ref[i] = ref[i-1] + nums[i];
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for( int j = i; j < nums.length;j++){
                int tem = i == 0 ? ref[j] : ref[j] - ref[i - 1];
                if(tem == k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0,pre = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0 ; i < nums.length; i++){
            pre += nums[i];
            if(map.get(pre - k) != null){
                count += map.get(pre - k);
            }
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return count;
    }
}
