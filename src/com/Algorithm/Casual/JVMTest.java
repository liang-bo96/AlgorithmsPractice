package com.Algorithm.Casual;

public class JVMTest {
    public static void main(String[] args) {
        Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"start");
                DeadThread deadThread = new DeadThread();
                System.out.println(Thread.currentThread().getName()+"end");
            }
        };
        Thread t1 = new Thread(a,"no1");
        Thread t2 = new Thread(a,"nod2");
        t1.start();
        t2.start();
    }
}
class DeadThread{
    static {
        System.out.println("dead thread");
        if(true){
            while(true){
                try {
                    Thread.sleep(1000);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
