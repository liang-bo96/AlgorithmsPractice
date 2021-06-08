package com.company.DoublePointer;

import java.util.*;

/*15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]

* */
public class N15ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return  result;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        if(nums[i] > 0 || nums[j] < 0){
            return result;
        }
        for (int k =0; k < nums.length; k++) {
            if(k > 0 && nums[k] == nums[k - 1])continue;
            int left = k +1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[k] + nums[left] + nums[right] == 0){
                    result.add(Arrays.asList(nums[k],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }else if(nums[k] + nums[left] + nums[right] < 0){
                    while(left < right && nums[left] == nums[++left]);
                }else{
                    while(left < right && nums[right] == nums[--right]);
                }
            }
        }
        return result;
    }

}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int left = k + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[k] + nums[left] + nums[right];
                if(sum < 0){
                    while(left < right && nums[left] == nums[++left]);
                } else if (sum > 0) {
                    while(left < right && nums[right] == nums[--right]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }
            }
        }
        return res;
    }
}
