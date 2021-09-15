package com.BiliBili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//

//
public class Main {
    public static void main(String[] args) {
        char a = '1';
        System.out.println(a);
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            int height = sc.nextInt();
//            int width = sc.nextInt();
//            if(height == -1 ||width == -1){
//                break;
//            }
//            int[][] arr = new int[height][width];
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    arr[i][j] = sc.nextInt();
//                }
//            }
//            help(arr);
//        }
    }
    public static void help(int[][]arr){
        int height = arr.length - 1;
        int width = arr[0].length - 1;
        int ax = 0;
        int ay = 0;
        int bx = height;
        int by = width;
        List<Integer> l = new ArrayList<>();
        while(ax <= bx && ay <= by){
            rotate(arr,ax++,ay++,bx--,by--,l);
        }
        for(int i = 0; i < l.size()-1; i++){
            System.out.print(l.get(i)+",");
        }
        System.out.println(l.get(l.size() - 1));
    }
    public static void rotate(int[][]arr, int ax, int ay, int bx, int by, List<Integer> l){
        if(ax == bx){
            for (int i = ay; i <=by ; i++) {
                l.add(arr[ax][i]);
            }
        }else if(ay == by){
            for (int i = ax; i <= bx; i++) {
                l.add(arr[i][ay]);
            }
        }else{
            int curx = ax;
            int cury = ay;
            while(cury < by){
                l.add(arr[curx][cury++]);
            }
            while(curx < bx){
                l.add(arr[curx++][cury]);
            }
            while(cury > ay){
                l.add(arr[curx][cury--]);
            }
            while(curx > ax){
                l.add(arr[curx--][cury]);
            }
        }
    }
}
