package com.mashibing.juc.c_024_FromVectorToQueue;

import com.mashibing.juc.c_001.T;
import edu.princeton.cs.algs4.In;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 *
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？*/
public class Practice_TicektSeller {
    public static void main(String[] args) {

        Thread[] sellers = new Thread[10];
        for (int i = 0; i < 10; i++) {
            sellers[i] = new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    TicketSeller.sell();
                }
            },"Thread"+i);
        }
        for(Thread t: sellers){
            t.start();
        }
    }
    public static class TicketSeller{
        static BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        static {
            for (int i = 0; i < 100; i++) {
                queue.add(i);
            }
        }
        public static void sell(){
            System.out.println(Thread.currentThread().getName()+"--"+queue.poll());
        }
    }
}
