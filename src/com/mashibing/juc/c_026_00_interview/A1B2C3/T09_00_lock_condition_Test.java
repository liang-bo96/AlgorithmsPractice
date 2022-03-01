/*
Condition本质是锁资源上不同的等待队列
 */
package com.mashibing.juc.c_026_00_interview.A1B2C3;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T09_00_lock_condition_Test {
    static int a = 9;
    public static void main(String[] args) {


        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition();
        Condition conditionT2 = lock.newCondition();
        Condition conditionT3 = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();

                while(a != 0) {
                    System.out.println(Thread.currentThread().getName()+"--"+a--);
                    conditionT2.signal();
                    conditionT1.await();
                }

                conditionT2.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1").start();

        new Thread(()->{
            try {
                lock.lock();

                while(a != 0) {
                    System.out.println(Thread.currentThread().getName()+"--"+a--);
                    conditionT3.signal();
                    conditionT2.await();
                }

                conditionT3.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t2").start();

        new Thread(()->{
            try {
                lock.lock();

                while(a != 0) {
                    System.out.println(Thread.currentThread().getName()+"--"+a--);
                    conditionT1.signal();
                    conditionT3.await();
                }
                System.out.println("数字为0，结束递减");

                conditionT1.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t3").start();
    }
}


