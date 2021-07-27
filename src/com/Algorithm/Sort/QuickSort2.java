package com.Algorithm.Sort;

public class QuickSort2 extends QuickSort{
    @Override
    public void sort(Comparable[] a, int lo, int hi) {
        if (hi-lo<=1)return ;
        Comparable pirate = a[lo];
        int start = lo+1;
        int end = hi-1;
        while(true){
            while(less(a[start],pirate)){
                start ++;
            };
            while(less(pirate, a[end])){end--;};
            if(start < end)
                exch(a,start, end);
            else
                break;
        }
        if (!less(a[start],pirate)){
            exch(a,lo,start-1);
        }
        else if (less(a[end],pirate)){
            exch(a,lo,end);

        }else {
            exch(a,lo,end);

        }
//        exch(a,start,lo);
        sort(a,lo,start-1);
        sort(a,start+1,hi);
    }

    @Override
    public void sort(Comparable[] a) {
        this.sort(a,0,a.length-1);
    }

    public static void main(String[] args) {
        Comparable[] a = {200,0,2,1,1,0,5,4,88,999,9,9999,23,4,435,34,34,5345,3,45,345,35,345,35};
        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.sort(a);
        show(a);
    }
}
