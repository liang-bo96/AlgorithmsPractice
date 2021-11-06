package com.Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，
 * 并以数组的形式返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 */
public class N448_FindMissingNum {
    //遍历数组，把值对应位置下标的数变为负数 然后遍历数组，正数就是未出现的数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i : nums){
            if(nums[Math.abs(i) - 1] > 0){
                nums[Math.abs(i) - 1] *= -1;
            }
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                l.add(i + 1);
            }
        }
        return l;
    }
}
