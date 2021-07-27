package com.Algorithm.TargetingOffer;

import java.util.ArrayList;

public class N62 {
    public static void main(String[] args) {
        N62 n62 = new N62();
//        System.out.println(n62.lastRemaining(5, 3));
        System.out.println((-2)%50);
        int[] a = new int[0];
        System.out.println(a.length);
    }
    ArrayList<Integer> tem = new ArrayList<>();
        public int lastRemaining(int n, int m) {
//            int[] tem = new int[n];

            for(int i = 0; i< n;i++){
                tem.add(i);
            }
            return getLastNum(tem,m).get(0);
//            return tem.get(0);
        }

        public static ArrayList<Integer> getLastNum(ArrayList<Integer> tem,int m){
            if(tem.size() == 1) return tem;
            int re = m % tem.size();
            if(re == 3){
                re++;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = re;i < tem.size();i++){
                list.add(tem.get(i));
            }
            for(int i = 0;i < re-1;i++){
                list.add(tem.get(i));
            }
            return  getLastNum(list,m);
        }

}
