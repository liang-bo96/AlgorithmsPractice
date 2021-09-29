package com.Algorithm.SingleStack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 *
 *
 *
 * 输入： heights = [2,4]
 * 输出： 4
 */
public class N84_LargestRectangle {
    public static void main(String[] args) {
        System.out.println(new N84_LargestRectangle().largestRectangleArea1(new int[]{2, 1, 5, 6, 2, 3}));
    }
    //超时
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i : heights) {
            max = Math.max(max, i);
        }
        int result = 0;
        for (int i = 0; i <= max; i++) {
            int tem = 0;
            int index = 0;
            while (index < heights.length) {
                if (heights[index] >= i) {
                    tem += i;
                    result = Math.max(result, tem);
                } else {
                    tem = 0;
                }
                index++;
            }
        }
        return result;
    }
    //单调栈
    public static int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        int res = 0;
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];
        //右边比我小的下标--没有补len
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            right[i] =  stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        //左边比我小的下标--没有补-1
        for(int i = 0; i < heights.length; i++){
            while(!stack1.isEmpty() && heights[i] <= heights[stack1.peek()]){
                stack1.pop();
            }
            left[i] =  stack1.isEmpty() ? -1 : stack1.peek();
            stack1.push(i);
        }
        //求结果
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res,heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
