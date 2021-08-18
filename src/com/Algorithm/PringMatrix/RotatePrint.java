package com.Algorithm.PringMatrix;

public class RotatePrint {
    public static void main(String[] args) {
        PringMatrix(new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } });
    }
    public static void PringMatrix(int[][] arr){
        int height = arr.length - 1;
        int width = arr[0].length - 1;
        int ax = 0;
        int ay = 0;
        int bx = height;
        int by = width;
        while(ax <= bx && ay <= by){
            rotate(arr,ax++,ay++,bx--,by--);
        }
    }
    public static void rotate(int[][] arr,int ax, int ay, int bx,int by){
        if(ax == bx){
            for (int i = ay; i <= by ; i++) {
                System.out.println(arr[ax][i]);
            }
        }else if(ay == by){
            for (int i = ax; i <= bx ; i++) {
                System.out.println(arr[i][ay]);
            }
        }else{
            int curx = ax;
            int cury = ay;
            while(cury < by){
                System.out.println(arr[curx][cury]);
                cury++;
            }
            while(curx < bx){
                System.out.println(arr[curx][cury]);
                curx++;
            }
            while(cury > ay){
                System.out.println(arr[curx][cury]);
                cury--;
            }
            while(curx > ax){
                System.out.println(arr[curx][cury]);
                curx--;
            }
        }
    }
}
