package com.Algorithm.Sort;

public class Father {
    {
        System.out.println("father non static");
    }
    static {
        System.out.println("father static");
    }

    public static void main(String[] args) {
        new Son();
    }
}
class Son extends Father{
    {
        System.out.println("son non static");
    }
    static {
        System.out.println("Son static");
    }
}
