package com.company.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class N78_SubSet {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(new N78_SubSet().subsets(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        process(nums,0,new ArrayList<>());
        return result;
    }
    public static void process(int[] nums,int location,List<Integer> list){
        if(location == nums.length){
            result.add(list);
            return;
        }
        List<Integer> in = new ArrayList<>(list);
        in.add(nums[location]);
        process(nums,location + 1,in);
        process(nums, location + 1, new ArrayList<>(list));
    }
}
