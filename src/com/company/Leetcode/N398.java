package com.company.Leetcode;

import java.util.Random;

public class N398 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(++i));
        }

    }
}
