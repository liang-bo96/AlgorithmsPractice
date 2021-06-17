package com.company.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：答案中不可以包含重复的四元组。

示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [], target = 0
输出：[]


提示：

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109*/
public class N18FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> threeSum = ThreeSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
            if (threeSum != null) {
                for (List<Integer> tem : threeSum) {
                    tem.add(nums[i]);
                    list.add(tem);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> ThreeSum(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    List<Integer> temlist = new ArrayList<Integer>(Arrays.asList(arr[i], arr[left], arr[right]));
                    result.add(temlist);
                    while (left < right && arr[left] == arr[++left]) ;
                    while (left < right && arr[right] == arr[--right]) ;
                } else if (sum < target) {
                    while (left < right && arr[left] == arr[++left]) ;
                } else {
                    while (left < right && arr[right] == arr[--right]) ;
                }
            }
        }
        return result;
    }


}
