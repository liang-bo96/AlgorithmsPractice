package com.Algorithm.DoublePointer;

import java.util.Arrays;

/*
* 75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]
示例 3：

输入：nums = [0]
输出：[0]
示例 4：

输入：nums = [1]
输出：[1]

提示：

n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2
* */
public class N75_sort_color {
    public static void main(String[] args) {
        int[] tem = new int[]{2,0,1};
        new N75_sort_color().sortColors(tem);
        System.out.println(Arrays.toString(tem));
    }
    public void sortColors(int[] nums) {
        if(nums.length == 1) return;
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i <= right ; i++){
            if(nums[i] == 0){
                swap(nums,i,left);
                left++;
            }
            if(nums[i] == 2){
                swap(nums,i,right);
                right--;
                if(nums[i] != 1){
                    i--;
                }
            }
        }
    }
    public static void swap(int[] nums,int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
