package com.JD;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.*;
/*
4 4
1 2
2 3 4
2 1 4
0
1 1
1 3
0 2
0 4

 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node_count = sc.nextInt();
        int ser_count = sc.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= node_count; i++) {
            int len = sc.nextInt();
            if(len == 0){
                map.put(i,new ArrayList<>());
            }
            for (int j = 0; j < len; j++) {
                if(map.get(i) == null){
                    map.put(i,new ArrayList<>());
                }
                map.get(i).add(sc.nextInt());
            }
        }
        int[][] request = new int[2][ser_count];
        for(int i = 0; i <ser_count; i++){
            request[0][i] = sc.nextInt();
            request[1][i] = sc.nextInt();
        }
        Graph graph = create(map);
        for(int i = 0; i < ser_count; i++){
            if(request[0][i] == 1){
                Node node = graph.nodes.get(request[1][i]);
                bfs(node);
                System.out.println(OnNum(graph));
            }else{
                Node node = graph.nodes.get(request[1][i]);
                bfs1(node);
                System.out.println(OnNum(graph));
            }
        }
    }
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            cur.ON = true;
            for(Node next : cur.nexts_on){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
    public static void bfs1(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            cur.ON = false;
            for(Node next : cur.nexts_off){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
    public static int OnNum(Graph graph){
        int count = 0;
        for(int i : graph.nodes.keySet()){
            if(graph.nodes.get(i).ON){
                count++;
            }
        }
        return count;
    }
    public static Graph create(HashMap<Integer,List<Integer>> map){
        Graph graph = new Graph();
        for(int i : map.keySet()){
            if(map.get(i).size() == 0){
                continue;
            }
            for(int to :map.get(i)){
                int weight = 1;
                if(!graph.nodes.containsKey(i)){
                    graph.nodes.put(i,new Node(i));
                }
                if(!graph.nodes.containsKey(to)){
                    graph.nodes.put(to,new Node(to));
                }
                Node from = graph.nodes.get(i);
                Node tonode = graph.nodes.get(to);
                Edge newEdge = new Edge(weight,from,tonode);
                Edge verEdge = new Edge(-1,tonode,from);
                from.nexts_on.add(tonode);
                tonode.nexts_off.add(from);
                from.out++;
                tonode.out++;
                from.in++;
                tonode.in++;
                from.edges.add(newEdge);
                tonode.edges.add(verEdge);
                graph.edges.add(newEdge);
                graph.edges.add(verEdge);
            }
        }
        return graph;

    }
}
class Node{
    public int value;
    public int distance = Integer.MAX_VALUE;
    public boolean ON;
    public int in;
    public int out;
    public ArrayList<Node> nexts_on;
    public ArrayList<Node> nexts_off;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts_on = new ArrayList<>();
        nexts_off = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
class Edge{
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
class Graph{
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
