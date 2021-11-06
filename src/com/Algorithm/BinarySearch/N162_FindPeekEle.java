package com.Algorithm.BinarySearch;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 */
public class N162_FindPeekEle {
    public static void main(String[] args) {
        System.out.println(new N162_FindPeekEle().findPeakElement1(new int[]{1}));
    }
    //数组两侧都是负无穷，要寻找峰值就每次选取相邻两个数值，左边大就说明左边必有山峰（负无穷-（左）高-（右）低），
    // 右边大说明右边必有山峰（（左）低-（右）高-负无穷）
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int findPeakElement1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
