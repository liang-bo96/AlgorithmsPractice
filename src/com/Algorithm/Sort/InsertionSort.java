package com.Algorithm.Sort;

public class InsertionSort {
    public static void sort(Comparable[] a){
        int h = 1;
        while(h < a.length/3) h = 3*h+1;
        while(h>=1){
            for (int i = h; i < a.length; i++) {
                Comparable temp =  a[i];
                int j =i;
                while(j - h>=0 && less(temp,a[j-h])){
                    a[j] = a[j-h];
                    j=j-h;
                }
                a[j] = temp;
            }
            h=h/3;
            System.out.println(h);
            show(a);
        }

    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <0;
    }
    private static void exch(Comparable[] a ,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(Comparable[] a){
        for (Comparable aa: a) {
            System.out.print(aa+",");
        }
    }
    private static boolean issorted(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {
            if (a[i+1].compareTo(a[i])<0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Comparable[] a = {7,8,9,1,2,3,5,7,77,89,123,23,23,123,231};
        Comparable[] c = {"f","e","a","q","z"};
        sort(a);
//        System.out.println(issorted(a));
//        show(a);
    }
}
