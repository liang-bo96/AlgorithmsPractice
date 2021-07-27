package com.Algorithm.Sort;

public class Test11 extends SelectionSort{
    @Override
    public void sort(Comparable[] a) {
        super.sort(a);
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        Comparable[] a = {7,6,5,4,3,2,1};
        Comparable[] c = {"f","e","a","q","z"};
        test11.sort(a);
        System.out.println(issorted(a));
        show(a);
    }
}
