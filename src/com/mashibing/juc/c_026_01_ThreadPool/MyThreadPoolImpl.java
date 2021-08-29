package com.mashibing.juc.c_026_01_ThreadPool;

import edu.princeton.cs.algs4.In;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolImpl implements MyThreadPool {
    public static void main(String[] args) throws InterruptedException {
        final int COUNT = 10000;
        MyThreadPool myThreadPool = new MyThreadPoolImpl();
        myThreadPool.execute(() -> {
            System.out.println(1);
        });

//        myThreadPool.execute(() -> {
//            for (int i = 0; i < COUNT; ++i) {
//                System.out.println("线程ID" + Thread.currentThread().getId() + ":" + i);
//            }
//        });

    }
    private static final int DEFAULT_SIZE = 10;

    private BlockingQueue<Runnable> workerQueue;
    private int corePoolSize = DEFAULT_SIZE;

    public MyThreadPoolImpl(int corePoolSize) {
        if (corePoolSize <= 0) {
            this.corePoolSize = this.DEFAULT_SIZE;
        } else {
            this.corePoolSize = corePoolSize;
        }

        this.workerQueue = new LinkedBlockingQueue<Runnable>();

        init();
    }

    public MyThreadPoolImpl() {
        this(DEFAULT_SIZE);
    }

    private void init() {
        // 初始化线程池时，启动corePoolSize个线程
        for (int i = 0; i < corePoolSize; ++i) {
            Worker w = new Worker();
            w.start();
        }
    }

    private final class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 启动时打印线程名字
                    System.out.println("线程ID" + Thread.currentThread().getId() + "已启动");

                    // 阻塞方法，从队列中取任务，并执行
                    Runnable r = workerQueue.take();
                    r.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void execute(Runnable r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
