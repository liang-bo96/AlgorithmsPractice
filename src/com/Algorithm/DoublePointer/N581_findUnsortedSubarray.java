package com.Algorithm.DoublePointer;

import edu.princeton.cs.algs4.In;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 */
public class N581_findUnsortedSubarray {
    public static void main(String[] args) {
        System.out.println(new N581_findUnsortedSubarray().findUnsortedSubarray(new int[]{1,3,2,3,3}));
    }
    //references
    public int findUnsortedSubarray1(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        //找到最右侧小于max的节点，该节点右侧就是有序递增数组
        for (int i = 0; i < arr.length; i++) {
            if(max > arr[i]) {
                R = i;
            }
            max = Math.max(max, arr[i]);
        }
        //找到最左侧大于min的节点，该节点左侧是递减数组
        for (int i = arr.length - 1; i >= 0; i--) {
            if(min < arr[i]) {
                L = i;
            }
            min = Math.min(min, arr[i]);
        }
        return R == L ? 0 : R - L + 1;
    }
    //暴力方法 超时
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (judge(nums, 0, nums.length - 1, j, i)) {
                    min = Math.min(min, i - j + 1);
                }
            }
        }
        return min == 1 ? 0 :min;
    }

    public static boolean judge(int[] arr, int start, int end, int left, int right) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (left == start && right == end) {
            return true;
        } else if (left == start) {
            return max <= arr[right + 1] && Sorted(arr, right + 1, end);
        } else if (right == end) {
            return min >= arr[left - 1] && Sorted(arr, start, left - 1);
        } else {
            return Sorted(arr, start, left - 1) &&
                    Sorted(arr, right + 1, end) &&
                    max <= arr[right + 1] && min >= arr[left - 1];
        }
    }

    public static boolean Sorted(int[] arr, int left, int right) {
        if(right <= left){
            return true;
        }
        for (int i = left + 1; i <= right; i++) {
            if(arr[i] < arr[i - 1]){
                return false;
            }
        }
        return true;
    }
}
