package com.Algorithm.BinarySearch;
//求开方取整
public class N69_Sqrt {
    public static void main(String[] args) {

    }
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        int left = 0;
        int right = x;
        while(left <= right){
            int mid = (left + right) /2;
            if(mid == x /mid){
                return mid;
            }else if( mid > x / mid){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
