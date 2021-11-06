package com.Algorithm.SlidingWindow;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 *
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 */
public class N1493_LongsertSubarrayOf1 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
    }
    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        while(right < nums.length){
            if (nums[right] == 0){
                count++;
            }
            while(count > 1){
                if (nums[left] == 0){
                    count--;
                }
                left++;
            }
            result = Math.max(result,right - left + 1);
            right++;
        }
        return result - 1;
    }
}
