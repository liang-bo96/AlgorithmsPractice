package com.Algorithm.Leetcode;

import java.util.Arrays;

public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0;
        int total = nums1.length + nums2.length;
        int[] tem = new int[total];
        for(int i = 0 ; i < nums1.length ; i++){
            tem[i] = nums1[i];
        }
        for(int j = nums1.length ; j < total ; j ++){
            tem[j] = nums2[j - nums1.length];
        }
        Arrays.sort(tem);
        if(total % 2 == 0){
            return ((double) tem[total/2] + (double)tem[total/2 - 1]) / 2;
        }else{
            return tem[total/2];
        }
    }
}
