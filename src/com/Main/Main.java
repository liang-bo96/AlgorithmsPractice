package com.Main;

import java.util.*;

// 1 2 3 11 12 13 21
public class Main {
    static HashMap<Long, Long> map = new HashMap<>();
    static List<Long> list = new ArrayList<>();

    static {
        process(0, 10, new ArrayList<>(), new int[]{1, 2, 3});
        Collections.sort(list);
    }

    public static void process(int location, int des, List<String> l, int[] ref) {
        if (des == location) {
            list.add(change(l));
            return;
        }
        for (int i = 0; i < ref.length; i++) {
            l.add(String.valueOf(ref[i]));
            process(location + 1, des, l, ref);
            l.remove(l.size() - 1);
        }
        process(location + 1, des, l, ref);
    }

    public static Long change(List<String> l) {
        long re = 0;
        int k = 0;
        for (int i = l.size() - 1; i >= 0; i--) {
            re += Long.parseLong(l.get(i)) * Math.pow(10, k);
            k++;
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        for (int i = 0; i < len; i++) {
            long num = scan.nextLong();
            if (map.containsKey(num)) {
                System.out.println(map.get(num));
            }
            long result = help(num);
            map.put(num, result);
            System.out.println(result);
        }
    }

    public static long help(long num) {
        int left = 0;
        int right = list.size();
        while(left <= right){
            int mid = left/2 + right /2;
            if(list.get(mid) == num){
                return list.get(mid);
            }else if(list.get(mid) < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(left == 0){
            left++;
        }
        return list.get(left - 1);
    }
}
