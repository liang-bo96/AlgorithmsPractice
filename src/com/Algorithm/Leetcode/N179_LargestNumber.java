package com.Algorithm.Leetcode;

import java.util.Arrays;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class N179_LargestNumber {
    public static void main(String[] args) {
        System.out.println(new N179_LargestNumber().largestNumber(new int[]{2, 10, 3,30}));
    }

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String res = "";
        for (String s : arr) {
            res += s;
        }
        if (res.charAt(0) == '0') {
            res = "0";
        }
        return res;
    }
}
