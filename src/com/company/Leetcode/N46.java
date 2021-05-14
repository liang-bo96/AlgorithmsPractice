package com.company.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2,3}).size());
        System.out.println(1);
    }
    public static List<List<Integer>> permute(int[] nums) {
        process(nums,0);
        return result;
    }
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    public static void process(int[] nums,int tem){
        if(tem == nums.length ){
            List<Integer> result1 = new ArrayList<>();
            for (int i : nums){
                result1.add(i);
            }
            result.add(result1);
        }
        for(int i = tem ; i < nums.length ; i++){
            swap(nums,tem,i);
            process(nums,tem+1);
            swap(nums,i,tem);
        }
    }
    public static void swap(int[] nums,int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

}
