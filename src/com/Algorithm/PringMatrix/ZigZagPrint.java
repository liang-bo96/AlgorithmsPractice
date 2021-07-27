package com.Algorithm.PringMatrix;

public class ZigZagPrint {
    public static void main(String[] args) {
        printZigZagMatrix(new int[][]{{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }});
    }
    public static void printZigZagMatrix(int[][] arr){
        int height = arr.length;
        int width = arr[0].length;
        int ax = 0;
        int ay = 0;
        int bx = 0;
        int by = 0;
        boolean flag = true;
        while(ax < height){
            process(arr,ax,ay,bx,by,flag);
            ax = ay == width - 1 ? ax + 1: ax;
            ay = ay == width - 1 ? ay  : ay + 1;
            by = bx == height - 1 ? by + 1 : by;
            bx = bx == height - 1 ? bx : bx + 1;
            flag = !flag;
        }
    }
    public static void process(int[][]arr, int ax, int ay, int bx, int by, boolean flag){
        if(flag){
            while(ax != bx + 1){
                System.out.println(arr[ax++][ay--]);
            }
        }else{
            while(bx != ax - 1){
                System.out.println(arr[bx--][by++]);
            }
        }
    }
}
