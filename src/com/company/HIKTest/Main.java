package com.company.HIKTest;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new H()).start();
        }
    }
}
class H implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 2;) {
            System.out.println(1);
        }
    }
}
