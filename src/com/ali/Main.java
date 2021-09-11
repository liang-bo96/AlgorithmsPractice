package com.ali;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(times(a, b));;
        }
    }

    private static int times(int a, int b) {
        if(a == b){
            return 0;
        }
        // a是小的
        if(a > b){
            int temp = b;
            b = a;
            a = temp;
        }
        // 最大200次
        int maxTime = (b - a) * 2;
        // n(n - 1) / 2 == b - a

        return 0;
    }
}
