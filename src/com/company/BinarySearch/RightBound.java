package com.company.BinarySearch;

public class RightBound {
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
                left = mid + 1;//左侧加一
            }
        }
        //检查越界
        if(right < 0 || s[right] != target){
            return  -1;
        }
        return right;//返回右边界
    }
}
