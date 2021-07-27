package com.Algorithm.SlidingWindow;
//求子数组累加和
public class PreHandleArray {
    public static void main(String[] args) {
        int[] tem = new int[]{1,2,3,4,5,6,7};
        int[] ref = new int[tem.length];
        ref[0] = tem[0];
        //求0-i的累加和
        //L-R的累加和就用ref[R] - ref[L-1]
        for(int i = 1 ; i < tem.length; i++){
            ref[i] = tem[i] + ref[i-1];
        }
    }
}
