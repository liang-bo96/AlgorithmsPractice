package com.mashibing.juc.c_026_00_interview.A1B2C3;

public class Practice_Syn {
    public static void main(String[] args) {
        char[] num = "12345".toCharArray();
        char[] cha = "abcde".toCharArray();
        Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < num.length; i++) {
                    System.out.println(num[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();

        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < cha.length; i++) {
                    System.out.println(cha[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
