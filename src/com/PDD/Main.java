package com.PDD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        for (int i = 0; i < total; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int[][] ma = new int[m][2];
            for (int j = 0; j < m; j++) {
                ma[j][0] = sc.nextInt();
                ma[j][1] = sc.nextInt();
            }
            for (int[] t : ma) {
                int tx = t[0];
                int ty = t[1];
                for (int k : arr) {
                    if (k == 1) {
                        if (tx == 1 ) {
                            continue;
                        } else {
                            tx--;
                        }
                    } else if (k == 2|| ty == y) {
                        if (ty == 1) {
                            continue;
                        } else {
                            ty--;
                        }
                    } else if (k == 3) {
                        if ( tx == x) {
                            continue;
                        } else {
                            tx++;
                        }
                    } else if (k == 4) {
                        if ( ty == y) {
                            continue;
                        } else {
                            ty++;
                        }
                    }
                }
                System.out.print(tx + " ");
                System.out.println(ty);
            }
        }
    }
}
