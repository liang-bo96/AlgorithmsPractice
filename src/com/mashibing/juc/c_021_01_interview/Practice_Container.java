package com.mashibing.juc.c_021_01_interview;
/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 *
 * @author mashibing
 */
import java.util.ArrayList;
import java.util.List;

public class Practice_Container {
    public static void main(String[] args) {
        Container container = new Container(new ArrayList<>(),10);
        Thread[] generter = new Thread[2];
        Thread[] consumer = new Thread[10];
        for(int i = 0; i < 2;i++){
            generter[i] = new Thread(()->{
                try {
                    for (int j = 0; j < 10; j++) {
                        container.put();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"generator" +i);
        }
        for(Thread t : generter){
            t.start();
        }
        for(int i = 0; i <10;i++){
            consumer[i] = new Thread(()->{
                try {
                    for (int j = 0; j < 2; j++) {
                        container.get();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"consumer" +i);
        }
        for(Thread t : consumer){
            t.start();
        }
    }
}
class Container{
    List<Object> list;
    int count;

    public Container(List<Object> list, int count) {
        this.list = list;
        this.count = count;
    }

    public synchronized void get() throws InterruptedException {
        //while------------------------不是if
        while(list.size()  == 0 ){
            this.wait();
        }
        list.remove(0);
        System.out.println("get"+Thread.currentThread().getName()+"size"+ list.size());
        this.notify();
    }

    public synchronized void put() throws InterruptedException {
        while (list.size() >= count){
            this.wait();
        }
        list.add(new Object());
        System.out.println("put"+Thread.currentThread().getName() + "size"+list.size());
        this.notify();
    }


}
