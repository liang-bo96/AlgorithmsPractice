package com.Algorithm.DoublePointer;

import java.util.Arrays;

public class N167_twoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N167_twoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left <right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1,right + 1};
            }else if (sum < target){
                left++;
            }else {
                right--;
            }
        }
        return new int[0];
    }
}
