package com.company.heap;

import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {
        Heap heap = new Heap(6);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
//        heap.show();
        System.out.println(heap);
        heap.deletemax();
        heap.deletemax();
        System.out.println(heap);
        heap.deletemax();
        System.out.println(heap);
    }
}
class Heap{
    private int[] heap;
    private int size;

//    public void show(){
//        for ( int i: heap
//             ) {
//            System.out.println(i);
//        }
//    }

    @Override
    public String toString() {
        return "Heap{" +
                "heap=" + Arrays.toString(heap) +
                '}';
    }

    public Heap(int size) {
        this.size = size;
        heap = new int[size+1];
    }

    public void insert(int i){
        int j = 1;
        while (heap[j] != 0){
            j++;
        }
        heap[j] = i;
        swim(j);
    }

    private void swim(int j){
        while (heap[j]>heap[j/2] && j/2>0){
            exchange(j,j/2);
            j=j/2;
        }
    }

    private void exchange(int i,int j){
        int tem = heap[i];
        heap[i] = heap[j];
        heap[j] = tem;
    }

    public int getmax(){
        return heap[1];
    }

    public int deletemax(){
        int tem = heap[1];
        int j = size;
        while (heap[j] == 0){
            j--;
        }
        heap[1] = heap[j];
        heap[j] = 0;
        sink(1);
        return tem;
    }

    private void sink(int i){
        while (2*i+1<size){
            if (heap[2 * i] > heap[2 * i + 1]){
                exchange(i,2*i);
                i = 2 * i;
            }else {
                exchange(i,2 * i + 1);
                i = 2 * i + 1;
            }
            sink(i);
        }
    }
}

