package com.company.TargetingOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class N53 {
    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
        ArrayList<Integer> lsit = new ArrayList<Integer>();
        lsit.add(1);
        lsit.add(2);
        lsit.add(3);
        lsit.add(4);
        lsit.size();
        System.out.println(lsit.get(1));
        System.out.println(lsit.remove(0));
        System.out.println(lsit.remove(0));
        System.out.println(lsit.remove(0));
        System.out.println(lsit.remove(0));
//        System.out.println(lsit.remove(0));

    }
    public static int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start+end)/2;
        while(start <= end){
            if(mid > nums[mid]){
                end = mid - 1;
            }else if(mid == nums[mid]){
                start = mid + 1;
            }else{
                break;
            }
            mid = (start+end)/2;
        }
        return mid;
    }
}
