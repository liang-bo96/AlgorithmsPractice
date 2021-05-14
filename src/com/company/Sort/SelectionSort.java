package com.company.Sort;

public class SelectionSort {
    public void sort(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            int record = i;
            for (int j =i+1;j<a.length;j++){
                if (less(a[j],a[record])){
                    record = j;
                }
            }
            exch(a,record,i);
        }
    }
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <0;
    }
    public static void exch(Comparable[] a ,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void show(Comparable[] a){
        for (Comparable aa: a) {
            System.out.print(aa+" ");
        }
    }
    public static boolean issorted(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {
            if (a[i+1].compareTo(a[i])<0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        Comparable[] c = {2,0,2,1,1,0};
        Comparable[] a = {"f","e","a","q","z"};
        selectionSort.sort(a);
        System.out.println(issorted(a));
        show(a);
    }
}
