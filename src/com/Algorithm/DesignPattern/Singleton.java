package com.Algorithm.DesignPattern;

public class Singleton {

    public static void main(String[] args) {
        new Singleton();
    }


    private Singleton() {
    }

    private static class  InnerSingleton{
        private static final Singleton Instances = new Singleton();
    }

    public Singleton getInstance(){
        return InnerSingleton.Instances;
    }
}
