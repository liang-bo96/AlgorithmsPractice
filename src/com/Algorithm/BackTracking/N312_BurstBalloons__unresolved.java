package com.Algorithm.BackTracking;

public class N312_BurstBalloons__unresolved {
    public static void main(String[] args) {
        System.out.println(new N312_BurstBalloons__unresolved().maxCoins(new int[]{1,5}));
    }
    public int maxCoins(int[] nums) {
        process(nums,0,0);
        return result;
    }
    static int result;
    public static void process(int[]arr,int location,int total){
        if(location == arr.length){
            result = Math.max(result,total);
            return;
        }
        for (int i = location; i < arr.length; i++) {
            int tem =  cal(i,location,arr.length - 1,total,arr);
            swap(arr,i,location);
            process(arr,location + 1,tem + total);
            swap(arr,location,i);
        }
    }
    public static int cal(int tem_location,int left,int right,int total,int[]arr){
        int left_total = tem_location - 1 >= left ? arr[tem_location - 1] : 1;
        int right_total = tem_location + 1 <= right ? arr[tem_location + 1] : 1;
        return  arr[tem_location] * left_total * right_total;

    }
    public static void swap(int[]arr,int i, int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}
