package com.BiliBili;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int monster = sc.nextInt();
        int[][] arr = new int[monster][2];
        for (int i = 0; i < monster; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(monster);
    }
}
