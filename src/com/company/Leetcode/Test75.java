package com.company.Leetcode;

public class Test75 {
    public static void main(String[] args) {
        Test75 test75 = new Test75();
        test75.sortColors(new int[]{2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
        for( int i = 0; i<nums.length;i++){
            for(int j = 0;j<nums.length-i-1;j++){
                if (nums[j] >= nums[j+1]){
                    int tem = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tem;
                }
            }
        }
    }
}
