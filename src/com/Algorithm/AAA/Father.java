package com.Algorithm.AAA;

public class Father {
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.haha();
        son.haha();
    }
    public static void haha(){
        System.out.println("111");
    }
    public void hehe(){
        System.out.println("111");
    }
}
class Son extends Father{
    public static void haha(){
        System.out.println("2221");
    }
}
