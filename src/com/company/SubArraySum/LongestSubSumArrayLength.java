package com.company.SubArraySum;
/*
给定一个   正整数   组成的无序数组arr，给定一个正整数值K
找到arr的所有子数组里，哪个子数组的累加和等于K，并且是长度最大的
返回其长度
*/
public class LongestSubSumArrayLength {
    public static void main(String[] args) {
//        System.out.println(getMaxLength(new int[]{1, 2, 3, 7, 1, 1, 1, 1, 1, 1, 1}, 7));
        System.out.println(getSubArraylength(new int[]{1, 2, 3, 7, 1, 1, 1, 1, 1, 1, 1}, 7));
    }

    public static int getSubArraylength(int[]arr, int target){
        int start = 0;
        int end = 0;
        int len = 0;
        int sum = arr[0];
        while(end < arr.length){
            if(sum < target){
                end++;
                if(end >= arr.length){
                    break;
                }
                sum += arr[end];
            }else if(sum > target){
                sum -= arr[start++];
            }else if(sum == target){
                len = Math.max(len,end - start + 1);
                sum -= arr[start++];
//                if(++end == arr.length){
//                    break;
//                }
//                sum +=arr[end];
            }
        }
        return len;
    }
    //standard
    public static int getMaxLength(int[] arr, int K) {
        if (arr == null || arr.length == 0 || K <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == K) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < K) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }
}
