package com.Algorithm.Sort;

import java.util.PriorityQueue;

public class QuickSort extends SelectionSort{
    public static void main(String[] args) {
        Comparable[] a = {2,0,2,1,1,0,5,4,88,999,9,9999,23,4,435,34,34,5345,3,45,345,35,345,35};
        int[] b = new int[] {2,0,2,1,1,0,5,4,88,999,9,9999,23,4,435,34,34,5345,3,45,345,35,345,35};
        Comparable[] c = {"r","e","a","q","z"};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a,0,a.length-1);
//        quickSort.sort(b,0,b.length);
        show(a);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((v1, v2) ->v2-v1);
        maxheap.add(1);
        maxheap.add(2);
        maxheap.add(3);
        maxheap.add(4);
        maxheap.add(5);
        System.out.println(maxheap);
        System.out.println(11/10);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("2");
        System.out.println(stringBuilder);
    }
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public int partition(Comparable[] a,int low,int hi){
        Comparable tem = a[low];
        int start = low + 1;
        int end = hi;
        while(start < end){
            if (less(a[start],tem)){
                start++;
            }
            else if (less(tem,a[end])){
                end--;
            }else {
                exch(a,start,end);
            }
        }
        if (!less(a[start],tem)){
            exch(a,low,start-1);
            return start-1;
        }
        else if (less(a[end],tem)){
            exch(a,low,end);
            return end;
        }else {
            exch(a,low,start);
            return start;
        }
    }


    public void sort(Comparable[] a,int lo,int hi) {
        QuickSort quickSort = new QuickSort();
        if (lo >= hi) return;
        int j = quickSort.partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    public void sort(int[] a,int lo,int hi) {
        QuickSort quickSort = new QuickSort();
        if (lo >= hi) return;
        int j = quickSort.partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
}
