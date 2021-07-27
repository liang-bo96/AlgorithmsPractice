package com.mashibing.juc.c_026_00_interview.A1B2C3;


import java.util.concurrent.atomic.AtomicInteger;

public class T05_00_AtomicInteger_Test {

    static AtomicInteger threadNo = new AtomicInteger(0);
    static Integer num = 9;

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();


        new Thread(() -> {
                while (threadNo.get() == 0 && num != 0) {
                    threadNo.set(1);
                    System.out.println(num-- + Thread.currentThread().getName());
                    threadNo.set(0);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, "t1").start();

        new Thread(() -> {
            while (threadNo.get() == 0 && num != 0) {
                threadNo.set(1);
                System.out.println(num--+ Thread.currentThread().getName());
                threadNo.set(0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
        new Thread(() -> {
            while (threadNo.get() == 0 && num != 0) {
                threadNo.set(1);
                System.out.println(num--+ Thread.currentThread().getName());
                threadNo.set(0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t3").start();
    }
}


