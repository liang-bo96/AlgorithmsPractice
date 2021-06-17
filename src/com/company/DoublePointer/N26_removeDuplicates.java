package com.company.DoublePointer;
/*
* 26. 删除有序数组中的重复项
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1：

输入：nums = [1,1,2]
输出：2, nums = [1,2]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。*/
public class N26_removeDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[left] == nums[right]){
                right++;
            }
            else {
                left++;
                nums[left] = nums[right];
                right++;
            }
        }
        return left +1;
    }
}
