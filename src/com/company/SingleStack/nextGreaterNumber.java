package com.company.SingleStack;

import java.util.Stack;

public class nextGreaterNumber {
    public static void main(String[] args) {
        System.out.println(new nextGreaterNumber().NextGreaterNumber(new int[]{2, 1, 2, 4, 3}));
        System.out.println(new nextGreaterNumber().nextGreaterCircleNumber(new int[]{2, 1, 2, 4, 3}));
    }
    //返回后面比自己大的元素，没有返回-1
    public static int[] nextGreaterNumber(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i >=0 ;i--){
            while(!stack.isEmpty() && nums[i] >= stack.peek()){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }


    public static int[] NextGreaterNumber(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (stack.isEmpty()){
                result[i] = -1;
                stack.push(nums[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() <= nums[i]){
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
        }
        return result;
    }
    //返回后面比自己大的元素，没有返回-1（环形数组）
    //方法是将原始数组翻倍后求解
    public static int[] nextGreaterCircleNumber(int[] nums){
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2 * len -1; i >=0 ;i--){
            while(!stack.isEmpty() && nums[i % len] >= stack.peek()){
                stack.pop();
            }
            result[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i% len]);
        }
        return result;
    }
}
