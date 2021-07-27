package com.Algorithm.BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
*
*
规定1和A对应、2和B对应、3和C对应...
那么一个数字字符串比如"111”就可以转化为:
"AAA"、"KA"和"AK"
给定一个只有数字字符组成的字符串str，返回有多少种转化结果

* */
public class N91_IntToString {
    public static void main(String[] args) {
        System.out.println(IntToString(new int[]{1, 1, 1}));
    }

    public static int IntToString(int[] arr) {
        return process(arr, 0, new LinkedList<>(), new HashMap<>());
    }

    public static int process(int[] arr, int location, List<Character> list, HashMap<Integer, Integer> map) {
        if (map.containsKey(location)) {
            return map.get(location);
        }
        if (location == arr.length) {
            return 1;
        }
        if (arr[location] == 0) {
            return 0;
        }
        int re = 0;
//        list.add((char) ('A' + arr[location] - 1));
        int re1 = process(arr, location + 1, list, map);
        re += re1;
//        list.remove(list.size() - 1);
        if (location + 1 < arr.length && arr[location] == 1) {
//            list.add((char)('A' + arr[location] * 10 + arr[location + 1] - 1));
            int re2 = process(arr, location + 2, list, map);
            re += re2;
//            list.remove(list.size() - 1);
        }
        if (location + 1 < arr.length && arr[location] == 2 && arr[location + 1] < 7) {
//            list.add((char)('A' + arr[location] * 10 + arr[location + 1] - 1));
            int re3 = process(arr, location + 2, list, map);
            re += re3;
//            list.remove(list.size() - 1);
        }
        map.put(location, re);
        return re;
    }
}
