package com.Algorithm.Sort;

public class BubbleSort extends SelectionSort{
    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i<a.length;i++){
            for(int j =0;j<a.length-i-1;j++){
                if(!less(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    public void InsertSort(Comparable[] a){
        for(int i = 1; i<a.length;i++){
            int j =i;
            Comparable tem = a[i];
            while(j-1>=0 && less(tem,a[j-1])){
                a[j] = a[j-1];
                j=j-1;
            }
            a[j] = tem;
        }
    }

    public void shelleSort(Comparable[] a){
        for(int p = a.length/2;p>0;p/=2){
            for(int i=p;i<a.length;i++){
                Comparable tem = a[i];
                int j = i;
                while(j-p>=0 && less(tem,a[j-p])){
                    a[j] = a[j-p];
                    j-=p;
                }
                a[j] = tem;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Comparable[] a = {7,8,9,1,2,3,5,7,77,89,123,23,23,123,231};
//        bubbleSort.sort(a);
//        bubbleSort.InsertSort(a);
        bubbleSort.shelleSort(a);
        show(a);

    }
}
