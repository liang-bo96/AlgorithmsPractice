package com.Algorithm.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarysearch(new int[]{1, 2, 5, 7, 9, 17, 25}, 17));
    }
    public static int binarysearch(int[] s,int target){
        int left = 0;
        int right = s.length - 1;//length - 1
        while(left <= right){//等于
            int mid = left + (right - left) / 2;
            if(target > s[mid]){
                left = mid +1;
            }else if(target < s[mid]){
                right = mid - 1;
            }else if(target == s[mid]){
                return mid;
            }
        }
        return -1;
    }
}
