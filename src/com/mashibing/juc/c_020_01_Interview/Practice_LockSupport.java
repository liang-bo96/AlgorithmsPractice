package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class Practice_LockSupport {
    static Thread t1;
    static Thread t2;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        t2 = new Thread(()->{
            LockSupport.park();
            System.out.println("t2-----");
            LockSupport.unpark(t1);
        },"t2");
        t2.start();

        t1 = new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    list.add(1);
                    System.out.println(list.size());
                    if(list.size() == 5){
                        LockSupport.unpark(t2);
                        LockSupport.park();
                    }
                }

        });
        t1.start();
    }
}
