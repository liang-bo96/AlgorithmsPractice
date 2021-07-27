package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * �����������⣺���Ա�����
 * ʵ��һ���������ṩ����������add��size
 * д�����̣߳��߳�1���10��Ԫ�ص������У��߳�2ʵ�ּ��Ԫ�صĸ�������������5��ʱ���߳�2������ʾ������
 *
 * �����������������������������
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
