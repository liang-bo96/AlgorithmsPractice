package com.Algorithm.SingleStack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        for(int i : new DailyTemperatures().dailyTemperatures(new int[]{73, 73, 75, 71, 69, 72, 76, 73})){
            System.out.println(i);
        }
    }
    public static int[] dailyTemperatures(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i >=0 ;i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
