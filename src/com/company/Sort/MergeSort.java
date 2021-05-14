package com.company.Sort;

public class MergeSort {
    static void merge(Comparable[] a,int start1,int end1){
        int start = start1;
        int end = end1;
        int mid = (start+end)/2+1;
        Comparable[] temp = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
//        show(temp);

        for (int i = start1; i <= end1; i++) {
            if (start > mid){
                a[i] = temp[mid++];
            }else if (mid > end){
                a[i] = temp[start++];
            }else if(less(temp[start],temp[mid])){
                a[i] = temp[start++];
            }else {
                a[i] = temp[mid++];
            }
        }
    }
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int start, int end){
        if (start >= end) return;
        int mid = (start+end)/2;
        sort(a,start,mid);
        sort(a,mid+1,end);
        merge(a,start,end);
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
        Comparable[] a = {7,45,3,44,4,35};
//        merge(a,0,a.length-1);
        Comparable[] c = {"e","f","a","q","z"};
        sort(a);
        System.out.println(issorted(a));
        show(a);
    }
}
