package com.company.TrappingRainWater;

import java.util.Stack;

/*
* 42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



示例 1：

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9*/
public class trap {
    public static void main(String[] args) {
        System.out.println(new trap().trap2(new int[]{4,2,0,3,2,5}));
    }
    //i位置的水柱高度等于min(max(左边足底啊高度),max(右边最大高度)) - height[i]
    public int trap(int[] height) {
        int result = 0;
        for(int i = 1; i < height.length; i++){
            int leftheight = 0;
            for(int m = 0; m < i;m++){
                if(height[m] > leftheight){
                    leftheight = height[m];
                }
            }
            int rightheight = 0;
            for(int n = i + 1; n < height.length; n++){
                if(height[n] > rightheight){
                    rightheight = height[n];
                }
            }
            result += Math.max((Math.min(leftheight, rightheight) - height[i]), 0);
        }
        return result;
    }
    //将左右最大值用数组缓存
    public int trap2(int[] height) {
        int result = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for(int i = 1; i < left.length; i++){
            left[i] = Math.max(height[i-1],left[i-1]);
        }
        for(int i = right.length - 2; i >= 0 ;i--){
            right[i] = Math.max(height[i+1],right[i+1]);
        }
        for(int i = 1; i < height.length; i++){
            result += (Math.min(left[i],right[i]) - height[i]) > 0
                    ? Math.min(left[i],right[i]) - height[i] : 0;
        }
        return result;
    }



}
