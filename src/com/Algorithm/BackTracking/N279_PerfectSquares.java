package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N279_PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new N279_PerfectSquares().numSquares(16));
    }

    static List<Integer> l;

    public int numSquares(int n) {
        l = new ArrayList<>();

        int i = 1;
        while (Math.pow(i, 2) <= n) {
            l.add((int) Math.pow(i, 2));
            i++;
        }


        return process(n, l, 0, 0,new HashMap<String,Integer>());
    }

    public static int process(int n, List<Integer> l, int location, int tem,HashMap<String, Integer> map) {
        if(map.containsKey(location+"-"+tem)){
            return map.get(location+"-"+tem);
        }
        if (location == l.size()) {
            if (tem == n) {
                map.put(location+"-"+tem,0);
                return 0;
            }
            map.put(location+"-"+tem,99999999);
            return 99999999;
        }
        int t = Integer.MAX_VALUE;
        for (int i = 0; i * l.get(location) + tem <= n; i++) {
            t = Math.min(process(n, l, location + 1, tem + i * l.get(location),map) + i, t);
        }
        map.put(location+"-"+tem,t);
        return t;
    }
}
