package com.company.Graph;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.Queue;

import java.util.LinkedList;

public class GraphDemo {

    private int T;
    private int E;
    public static LinkedList<Integer>[] lists = new LinkedList[13];


    public GraphDemo(int t) {
        T = t;
        for (int i = 0; i < T; i++) {
            lists[i] = new LinkedList<Integer>();
        }
    }

    public void insert(int[] a){
        int i = a[0];
        int j = a[1];
        lists[i].add(j);
        lists[j].add(i);
        E++;
    }

    public int getT() {
        return T;
    }

    public int getE() {
        return E;
    }
    public  void show(){
        for (int i = 0; i < 13; i++) {
            System.out.println(lists[i]);
        }
    }

    public void inil(){
        for (int i = 0; i < T; i++) {
            lists[i].add(-1);
        }
    }

    public void dfs(LinkedList<Integer> l){
        l.removeLast();
        for (int i :l) {
            if (lists[i].contains(-1)){
                System.out.println(i);
                dfs(lists[i]);
            }
        }

    }

    static Queue<Integer> queue = new edu.princeton.cs.algs4.Queue<Integer>();
    
    public void bfs(LinkedList<Integer> l){

        l.removeLast();
        
        while (!queue.isEmpty()){
            int symbol = queue.dequeue();
            l = lists[symbol];
//            l.removeLast();
            for (int i:l) {
                if (lists[i].contains(-1)){
                    System.out.println(i);
                    queue.enqueue(i);
                    lists[i].removeLast();
                }
            }
        }
    }


    public static void main(String[] args) {
        GraphDemo graphDemo = new GraphDemo(13);
        graphDemo.insert(new int[]{0,5});
        graphDemo.insert(new int[]{4,3});
        graphDemo.insert(new int[]{0,1});
        graphDemo.insert(new int[]{9,12});
        graphDemo.insert(new int[]{6,4});
        graphDemo.insert(new int[]{5,4});
        graphDemo.insert(new int[]{0,2});
        graphDemo.insert(new int[]{11,12});
        graphDemo.insert(new int[]{9,10});
        graphDemo.insert(new int[]{0,6});
        graphDemo.insert(new int[]{7,8});
        graphDemo.insert(new int[]{9,11});
        graphDemo.insert(new int[]{3,5});
        graphDemo.show();
        graphDemo.inil();
//        graphDemo.dfs(lists[0]);
        queue.enqueue(0);
//        graphDemo.bfs(lists[0]);
        System.out.println("----------------------");
        graphDemo.dfs(lists[0]);
    }

}
