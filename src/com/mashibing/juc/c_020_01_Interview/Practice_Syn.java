package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * 分析下面这个程序，能完成这个功能吗？
 * @author mashibing
 */
public class Practice_Syn {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Object lock = new Object();

        new Thread(()->{
            synchronized (lock){
                if(list.size() != 5){
                    try {
                        lock.wait();
                        System.out.println("T2 notify");
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t2").start();

        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 9; i++) {
                    list.add(1);
                    System.out.println(list.size());
                    if(list.size() == 5){
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
