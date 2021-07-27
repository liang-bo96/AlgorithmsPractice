package com.mashibing.juc.c_000;

public class Test {

    public int age = 0;

    public  void add(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        age++;
        System.out.println("add");
    }

    public  void de(){
        age--;
        System.out.println("de");
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(()->{
            test.add();
        });
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                test.de();
            }
        };
        t2.start();
        System.out.println(test.age);
    }
}
