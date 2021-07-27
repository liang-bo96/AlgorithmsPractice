package com.Algorithm.Casual;

import java.util.ArrayList;
import java.util.List;

public class Filetransfer {
    static List[] lists = new List[10];
    public Filetransfer() {
        for (int i = 0; i < 10; i++) {
            lists[i] = new ArrayList<Integer>();
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,2};
        int[] c = {3,4};
        int[] d = {5,4};
        int[] e = {5,6};
        int[] f = {7,8};
        ArrayList<int[]> ints = new ArrayList<>();
//        ints.add(a);
        ints.add(b);
        ints.add(c);
        ints.add(d);
        ints.add(e);
        ints.add(f);
        Filetransfer filetransfer = new Filetransfer();
        filetransfer.getin((ArrayList<Integer>) lists[0],a);
        for (int i = 0; i < 5; i++) {
            if (filetransfer.isin((ArrayList<Integer>) lists[0], ints.get(i))){
                filetransfer.getin((ArrayList<Integer>) lists[0], ints.get(i));
            }else {
                filetransfer.getin((ArrayList<Integer>) lists[1], ints.get(i));
            }
        }
        System.out.println(lists[0]);
        System.out.println(lists[1]);
        System.out.println(filetransfer.test((ArrayList<Integer>) lists[0], new int[]{1, 7}));
    }

    public void getin(ArrayList<Integer> list,int[] a){
        int i = a[0];
        int j = a[1];
        list.add(i);
        list.add(j);
    }
    public boolean isin(ArrayList<Integer> list,int[] a){
        int i = a[0];
        int j = a[1];
        if (list.contains(i) || list.contains(j)){
            return true;
        }
        return false;
    }

    public boolean test(ArrayList<Integer> list,int[] a){
        int i = a[0];
        int j = a[1];
        if (list.contains(i) && list.contains(j)){
            return true;
        }
        return false;
    }

}
