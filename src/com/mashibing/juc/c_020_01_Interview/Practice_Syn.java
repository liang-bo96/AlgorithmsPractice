package com.mashibing.juc.c_020_01_Interview;

import com.mashibing.juc.c_010.T;

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
//        new Practice_Syn().Practice1();
        new Practice_Syn().Practice2();
    }

    public void Practice2(){
        List<Integer> list = new ArrayList<>();

        new Thread(()->{
            synchronized (this){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("size = 5");
                this.notify();
            }
        }).start();

        new Thread(()->{
            synchronized (this){
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    if(i== 5){
                        this.notify();
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

    public void Practice1(){
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
