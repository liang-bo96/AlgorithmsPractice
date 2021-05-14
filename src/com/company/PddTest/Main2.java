package com.company.PddTest;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] tem = new int[len];
        for(int i = 0; i < len;i++){
            tem[i] = sc.nextInt();
        }
        int result = 0;
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < len ;i++){
            for(int j = i ; j < len ; j++){
                int tt = 0;
                for(int k = i ; k < j ; k++){
                    if(tem[k] > 0){
                        tt--;
                    }else{
                        tt++;
                    }
                }
                if(tt > result){
                    result = tt;
                    left = i;
                    right = j;
                }
            }
        }
        for(int i = 0 ; i < left;i++){
            if(tem[i] == 1){
                result++;
            }
        }
        for(int i = right ; i < len;i++){
            if(tem[i] == 1){
                result++;
            }
        }
        if(result == len){
            result--;
        }
        System.out.println(result);
    }
}
