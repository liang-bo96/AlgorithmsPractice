package com.Algorithm.AAA;

import java.time.LocalDateTime;

public class A {
    private B b = initb();
    private B initb(){
        return new B();
    }

    public LocalDateTime help(){
        return b.name;
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.help());
        A a1 = new A();
        System.out.println(a1.help());
    }
}
class B{
    public LocalDateTime name = LocalDateTime.now();
}
