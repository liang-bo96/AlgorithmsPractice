package com.Algorithm.TargetingOffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AA {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        char[] a = "abcd".toCharArray();
        char[] b = "1234".toCharArray();
        char[] c = "ABCD".toCharArray();


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for(char s: a){
                    System.out.println(s);
                    try {
                        c2.signal();
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c2.signal();
                lock.unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for(char s: b){
                    System.out.println(s);
                    try {
                        c3.signal();
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c3.signal();
                lock.unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for(char s: c){
                    System.out.println(s);
                    try {
                        c1.signal();
                        c3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c1.signal();
                lock.unlock();
            }
        }).start();
    }
}
