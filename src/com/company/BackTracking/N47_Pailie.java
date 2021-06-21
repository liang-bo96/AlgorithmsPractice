package com.company.BackTracking;

import com.company.Leetcode.N46;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.company.Leetcode.N46.swap;

public class N47_Pailie {
    public static void main(String[] args) {
        System.out.println(new N47_Pailie().permuteUnique(new int[]{1, 1, 2}));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums);
    }
    static List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        process(nums,0);
        return result;
    }
    public static void process(int[] nums,int tem){
        if(tem == nums.length - 1){
            List<Integer> result1 = new ArrayList<>();
            for (int i : nums){
                result1.add(i);
            }
            result.add(result1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = tem ; i < nums.length ; i++){
            //进行剪枝
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                swap(nums,tem,i);
                process(nums,tem+1);
                swap(nums,i,tem);
            }

        }
    }

}
