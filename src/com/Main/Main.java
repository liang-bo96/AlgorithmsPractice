package com.Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len ;i ++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++) {
                if(judge(arr,i,j)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean judge(int[]arr,int left, int right){
        if(right - left == 1){
            return true;
        }
        for(int i = left + 1; i <= right - 1; i++){
            if(arr[i] < arr[left] || arr[i] <arr[right]){
                return false;
            }
        }
        return true;
    }
}
