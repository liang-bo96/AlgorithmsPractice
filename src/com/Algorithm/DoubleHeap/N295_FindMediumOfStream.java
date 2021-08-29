package com.Algorithm.DoubleHeap;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class N295_FindMediumOfStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {

    /**
     * initialize your data structure here.
     */
    static int size;
    static Queue<Integer> minQueue;
    static Queue<Integer> maxQueue;

    public MedianFinder() {
        size = 0;
        minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

//    public void addNum(int num) {
//        size++;
//        minQueue.add(num);
//        if(minQueue.size() - maxQueue.size() > 1){
//            maxQueue.add(minQueue.poll());
//        }
//        if(minQueue.peek() < maxQueue.peek()){
//            maxQueue.add(minQueue.poll());
//            minQueue.add(maxQueue.poll());
//        }
//    }
//
//    public double findMedian() {
//        if(size == 1){
//            return minQueue.peek();
//        }
//        if(size % 2 == 0){
//            System.out.println(minQueue.peek());
//            System.out.println(maxQueue.peek());
//            return  ((double)(minQueue.peek() + maxQueue.peek()) / 2);
//        }else {
//            return minQueue.peek();
//        }
//    }

    /**
     * 练习
     */
    public void addNum(int num) {
        size++;
        minQueue.add(num);
        if (minQueue.size() - maxQueue.size() > 1) {
            maxQueue.add(minQueue.poll());
        }
        //重要
        if (maxQueue.peek() != null && maxQueue.peek() > minQueue.peek()) {
            maxQueue.add(minQueue.poll());
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (double) (minQueue.peek() + maxQueue.peek()) / 2;
        } else {
            return minQueue.peek();
        }
    }
}

