package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author : qizidog
 * @date : 2021-01-18 16:19
 * @description :
 * ForkJoin使用
 **/

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = 0l; long end = 10_0000_0000L;
        test1(start, end);  // 直接计算，效率低
        test2(start, end);  // ForkJoin，效率相对高
        test3(start, end);  // 并行Stream，效率最优
    }
    
    public static Long test1(long start, long end){
        System.out.println("==========test1==========");
        // 直接计算
        long s = System.currentTimeMillis();  // start

        long sum = 0L;
        for (long i = start; i <= end; i++) {
            sum+=i;
        }

        long e = System.currentTimeMillis();  // end
        System.out.println(e-s + "<=时间|结果=>" + sum);
        System.out.println("==========test1==========");

        return sum;
    }

    public static Long test2(long start, long end) throws ExecutionException, InterruptedException {  // ForkJoin
        System.out.println("==========test2==========");
        long s = System.currentTimeMillis();  // start

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> myForkJoin = new MyForkJoin(start, end);
        ForkJoinTask<Long> submit = forkJoinPool.submit(myForkJoin);
        Long sum = submit.get();

        long e = System.currentTimeMillis();  // end
        System.out.println(e-s + "<=时间|结果=>" + sum);
        System.out.println("==========test2==========");

        return sum;
    }

    public static Long test3(long start, long end){
        System.out.println("==========test3==========");
        long s = System.currentTimeMillis();  // start

        // Stream并行流 range[), rangeClosed[]
        Long sum = LongStream.rangeClosed(start, end).parallel().reduce(0, Long::sum);

        long e = System.currentTimeMillis();  // end
        System.out.println(e-s + "<=时间|结果=>" + sum);
        System.out.println("==========test3==========");

        return sum;
    }
}

class MyForkJoin extends RecursiveTask<Long> {
    private long start;
    private long end;
    private long threshold = 1_0000L;

    public MyForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long compute(){
        long sum = 0L;
        // 如果小于阈值，直接计算
        if (end-start<=threshold){
            for (long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;
        }
        // 否则使用分支合并计算
        long middle = start + ((end-start)>>1);
        MyForkJoin fj1 = new MyForkJoin(start, middle);
        fj1.fork();  // 拆分任务，压入线程队列
        MyForkJoin fj2 = new MyForkJoin(middle + 1, end);
        fj2.fork();  // 拆分任务，压入线程队列

        return fj1.join()+fj2.join();
    }
}