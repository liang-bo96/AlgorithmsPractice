package com.Algorithm.BinarySearch;

public class LeftBound {
    public static void main(String[] args) {
        System.out.println(leftSearch(new int[]{1, 2, 2,2,2,2,2,2, 25}, 2));
        System.out.println(rightSearch(new int[]{1, 2, 2,2,2,2,2,2, 25}, 2));

    }
    public static int leftSearch(int[]arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) /2;
            if(arr[mid] == target){
                right = mid - 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target) {
                left = mid + 1;
            }
        }
        if(left >= arr.length || arr[left] != target){
            return -1;
        }
        return left;
    }
    public static int rightSearch(int[]arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) /2;
            if(arr[mid] == target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }
        }
        if(right < 0 || arr[right] != target){
            return -1;
        }
        return right;
    }
}
