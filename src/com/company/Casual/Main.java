package com.company.Casual;

import java.math.BigInteger;
import java.util.*;
public class Main{
    public static void main(String args[]) {
//        BigInteger a = new BigInteger("9999999999999999999999999999999");
//        BigInteger b = new BigInteger("8888888888888888888888888");
//        System.out.println(a.subtract(b).compareTo(BigInteger.valueOf(0))<0);
        Runnable a=  new T();
        Thread t = new Thread(a);
        t.start();
    }
}
class T implements Runnable{

    @Override
    public void run() {
        System.out.println(1);
    }
}