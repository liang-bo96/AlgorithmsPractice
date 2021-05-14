package com.company.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N15 {
    public static void main(String[] args) {
        List<List<Integer>> l = new N15().threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(l);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i =0; i < nums.length;i++){
            for(int j = i+1 ; j <nums.length;j++){
                map.put(nums[i]+nums[j],new int[]{i,j});
            }
        }
        for(int i = 0; i < nums.length; i++){
            List<Integer> tem = new ArrayList<>();
            if(map.get(-nums[i])!= null && map.get(-nums[i])[0]!= i && map.get(-nums[i])[1] != i){
                tem.add(nums[i]);
                tem.add(nums[map.get(-nums[i])[0]]);
                tem.add(nums[map.get(-nums[i])[1]]);
                result.add(tem);
            }
        }
        return result;
    }
}
