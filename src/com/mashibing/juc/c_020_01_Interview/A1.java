package com.mashibing.juc.c_020_01_Interview;

public class A1 {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                try {
                    lock.wait(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(111);
            }

        }).start();

        new Thread(()->{
            synchronized (lock){
                System.out.println(123);
            }
        }).start();
    }
}