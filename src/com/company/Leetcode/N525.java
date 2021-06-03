package com.company.Leetcode;

import static com.company.SubArraySum.LongestSubSumArrayLength.LongestSubArrayLength;

/*
*525. 连续数组
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
示例 1:

输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
示例 2:

输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。


提示：

1 <= nums.length <= 105
nums[i] 不是 0 就是 1
* */
public class N525 {
    public static void main(String[] args) {
        int [] arr = new int[]{0,1,0,1};
        System.out.println(findMaxLength(arr));
        //等价于0变为-1，1不变，求和为0的最长子数组
        int[] newarr = new int[arr.length];
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 0){
                newarr[i] = -1;
            }else{
                newarr[i] = arr[i];
            }
        }
        System.out.println(LongestSubArrayLength(newarr, 0));
    }
    //超时
    public static int findMaxLength(int[] nums) {
        int[][] tem = new int[2][nums.length + 1];
        tem[0][0] = 0;
        tem[0][1] = 0;
        int n0 = 0;
        int n1 = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                n0++;
            }
            if(nums[i] == 1){
                n1++;
            }
            tem[0][i + 1] = n0;
            tem[1][i + 1] = n1;
            for (int j = 0; j < i; j++) {
                if(tem[0][j] -n0
                        == tem[1][j] - n1){
                    len = Math.max(len,i + 1 - j);
                }
            }
        }
        return len;
    }
}
