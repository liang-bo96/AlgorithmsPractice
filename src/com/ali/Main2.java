package com.ali;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long one = scanner.nextLong();
        long two = scanner.nextLong();
        long three = scanner.nextLong();
        long four = scanner.nextLong();
        long count = scanner.nextLong();
        long[][] nums = new long[][]{
            new long[]{one, two},
            new long[]{four, three}
        };
        for (long i = 0; i < count; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            System.out.println(getValue(x, y, nums));;
        }
    }

    private static long getValue(long x, long y, long[][] nums) {
        if(x <= 2 && y <= 2){
            return nums[(int)x - 1][(int)y - 1];
        }
        long max = Math.max(x, y);
        long value = 1;
        while(max > value){
            value <<= 1;
        }
        // 判断区域（abcd）
        long[] areaAndValue = getAreaAndValue(x, y, value, nums);
        return areaAndValue[0] + getValue(areaAndValue[1], areaAndValue[2], nums);
    }

    /**
     * @return 第一个为ABCD的选择值，2,3个为新的x,y
     */
    private static long[] getAreaAndValue(long x, long y, long value, long[][] nums) {
        long lowBound = value / 2;
        if(x == y){
            return new long[]{nums[1][1], x - lowBound, y - lowBound};
        }
        if(x < y){
            if(x <= lowBound){
                return new long[]{nums[0][1], x, y - lowBound};
            }else {
                return new long[]{nums[1][1], x - lowBound, y - lowBound};
            }
        }else {
            if(y <= lowBound){
                return new long[]{nums[1][0], x - lowBound, y};
            }else {
                return new long[]{nums[1][1], x - lowBound, y - lowBound};
            }
        }
    }
}
