package com.company.BinarySearch;

public class LeftBound {
    public static void main(String[] args) {
        System.out.println(binarysearch(new int[]{1, 2, 2,2,2,2,2,2, 25}, 2));
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
                right = mid - 1;//右侧减一
            }
        }
        //检查越界
        if(left >= s.length || s[left] != target){
            return  -1;
        }
        return left;//返回左边界
    }
}
