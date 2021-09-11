package com.mashibing.juc.c_025;

import edu.princeton.cs.algs4.In;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T07_01_PriorityQueque {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }
}
