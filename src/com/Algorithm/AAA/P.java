package com.Algorithm.AAA;

import java.util.HashMap;

public class P {
    void f(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {
        P x = new Q();
        Q y = new Q();
        P z = new Q();
        x.f(1);
        y.f(1);
        z.f(1);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        System.out.println(map.get(2));
    }
}
class Q extends P{
    @Override
    void f(int i) {
        System.out.println(i*2);
    }
}
